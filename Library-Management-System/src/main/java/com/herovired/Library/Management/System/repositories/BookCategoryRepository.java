package com.herovired.Library.Management.System.repositories;

import com.herovired.Library.Management.System.models.BookCategory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookCategoryRepository extends CrudRepository<BookCategory,Long> {

    BookCategory findByCategoryType(String categoryType);

    BookCategory findByCategoryId(int categoryId);

    List<BookCategory> findAll(Sort sort);

    Page<BookCategory> findAll(Pageable pageable);

}
