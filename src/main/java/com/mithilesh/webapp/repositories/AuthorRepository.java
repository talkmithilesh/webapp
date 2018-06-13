package com.mithilesh.webapp.repositories;

import com.mithilesh.webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
