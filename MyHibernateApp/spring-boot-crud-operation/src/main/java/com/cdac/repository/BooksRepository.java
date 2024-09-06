package com.cdac.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdac.model.Books;
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
