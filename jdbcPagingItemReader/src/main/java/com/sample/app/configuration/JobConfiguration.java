package com.sample.app.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.writer.ResultWriter;
import org.hibernate.id.IncrementGenerator;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.sample.app.entity.Employee;
import com.smaple.app.mappers.EmployeeRowMapper;

@Configuration
@EnableBatchProcessing
public class JobConfiguration{


	ArrayList<Object> result = new ArrayList<>();


	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private DataSource dataSource;

	@Bean
	public JdbcPagingItemReader<Employee> jdbcPagingItemReader() {
		JdbcPagingItemReader<Employee> pagingItemReader = new JdbcPagingItemReader<>();

		pagingItemReader.setDataSource(dataSource);
		pagingItemReader.setFetchSize(3);
		pagingItemReader.setRowMapper(new EmployeeRowMapper());

		MySqlPagingQueryProvider mySqlPagingQueryProvider = new MySqlPagingQueryProvider();
		mySqlPagingQueryProvider.setSelectClause("id, first_name, last_name");
		mySqlPagingQueryProvider.setFromClause("FROM employee");

		Map<String, Order> orderByKeys = new HashMap<>();
		orderByKeys.put("first_name", Order.ASCENDING);

		mySqlPagingQueryProvider.setSortKeys(orderByKeys);

		pagingItemReader.setQueryProvider(mySqlPagingQueryProvider);
		return pagingItemReader;
	}

	@Bean
	public ItemWriter<? super Object> itemWriter() {
		return ems -> {
			System.out.println("\nWriting chunk to console---------------------------------------------");
			for (Object emp : ems) {
				result.add(emp);
				//System.out.println(emp);
			}
			ResultWriter.writeToFile(result);
		};
	}

	@Bean
	public Step step1() {
		return this.stepBuilderFactory.get("step1").chunk(3).reader(jdbcPagingItemReader()).writer(itemWriter())
				.build();
	}

	@Bean
	public Job myJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return jobBuilderFactory.get("my-job01").start(step1()).incrementer(new RunIdIncrementer()).build();
	}



//	@Override
//	public void beforeJob(JobExecution jobExecution) {
//		this.flag+=1;
//	}

//	@Override
//	public void afterJob(JobExecution jobExecution) {
//
//	}

}