package com.pharmaplus.dao;

import java.util.List;

import com.pharmaplus.model.Supplier;

public interface SupplierDao {

	void save(Supplier supplier);

	void update(Supplier supplier);

	void delete(String id);

	Supplier get(String id);

	List<Supplier> getAllSuppliers();
}
