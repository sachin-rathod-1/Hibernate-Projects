package com.cdac.MySpringBootAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdac.MySpringBootAPI.Model.Books;

public interface BooksRepository extends CrudRepository<Books, Integer> {

}
