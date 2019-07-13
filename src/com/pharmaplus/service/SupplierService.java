package com.pharmaplus.service;

import java.util.List;

import com.pharmaplus.model.Supplier;

public interface SupplierService {

	void save(Supplier supplier);

	void update(Supplier supplier);

	void delete(String id);

	Supplier get(String id);

	List<Supplier> getAllSuppliers();
}
