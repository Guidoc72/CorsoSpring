package com.example.service;

import com.example.model.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
