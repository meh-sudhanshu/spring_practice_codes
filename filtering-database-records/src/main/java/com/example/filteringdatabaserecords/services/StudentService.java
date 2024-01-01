package com.example.filteringdatabaserecords.services;


import com.example.filteringdatabaserecords.models.Student;
import com.example.filteringdatabaserecords.repositories.StudentRepository;
import com.example.filteringdatabaserecords.utils.ColumnFilters;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getFilteredEntities(List<ColumnFilters> includeFilters, List<ColumnFilters> excludeFilters) {
        Specification<Student> specification = buildSpecification(includeFilters, excludeFilters);
        return studentRepository.findAll(specification);
    }

    private Specification<Student> buildSpecification(List<ColumnFilters> includeFilters, List<ColumnFilters> excludeFilters) {
        return (root, query, criteriaBuilder) -> {
            Predicate includedPredicate = buildIncludedColumnsPredicate(root, criteriaBuilder, includeFilters);
            Predicate excludedPredicate = buildExcludedColumnsPredicate(root, criteriaBuilder, excludeFilters);

            return criteriaBuilder.and(includedPredicate, criteriaBuilder.not(excludedPredicate));
        };
    }

    private Predicate buildIncludedColumnsPredicate(Root<Student> root, CriteriaBuilder criteriaBuilder, List<ColumnFilters> includeFilters) {
        Predicate includedPredicate = criteriaBuilder.conjunction();

        for (ColumnFilters filter : includeFilters) {
            String columnName = filter.getColumnName();
            List<String> includedValues = filter.getValues();

            if (includedValues != null && !includedValues.isEmpty()) {
                includedPredicate = criteriaBuilder.and(
                        includedPredicate,
                        root.get(columnName).in(includedValues)
                );
            }
        }

        return includedPredicate;
    }
    private Predicate buildExcludedColumnsPredicate(Root<Student> root, CriteriaBuilder criteriaBuilder, List<ColumnFilters> excludeFilters) {
        Predicate excludedPredicate = criteriaBuilder.disjunction();

        for (ColumnFilters filter : excludeFilters) {
            String columnName = filter.getColumnName();
            List<String> excludedValues = filter.getValues();

            if (excludedValues != null && !excludedValues.isEmpty()) {
                excludedPredicate = criteriaBuilder.or(
                        excludedPredicate,
                        root.get(columnName).in(excludedValues)
                );
            }
        }

        return excludedPredicate;
    }
}
