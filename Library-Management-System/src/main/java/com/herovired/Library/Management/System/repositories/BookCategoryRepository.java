package com.herovired.Library.Management.System.repositories;

import com.herovired.Library.Management.System.models.BookCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookCategoryRepository extends CrudRepository<BookCategory,Long> {

    BookCategory findByCategoryType(String categoryType);

    BookCategory findByCategoryId(int categoryId);

}
