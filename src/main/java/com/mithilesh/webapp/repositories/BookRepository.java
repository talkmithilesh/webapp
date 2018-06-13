package com.mithilesh.webapp.repositories;

import com.mithilesh.webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
