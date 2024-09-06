package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.model.Product;
import com.cdac.repo.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {
		return repo.findAll(); //JPA/CRUD repository predefined method
	}
	
	public void save(Product product) //userdefined function
	{
		repo.save(product); //JPA/CRUD repository predefined method
	}
	
	public Product get(long id) {
		return repo.findById(id).get(); //JPA/CRUD repository predefined method
	}
	
	public void delete(long id) {
		repo.deleteById(id); //JPA/CRUD repository predefined method
	}
}
