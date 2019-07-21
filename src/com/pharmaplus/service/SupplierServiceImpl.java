package com.pharmaplus.service;

import java.util.List;

import com.pharmaplus.dao.SupplierDao;
import com.pharmaplus.dao.SupplierDaoImpl;
import com.pharmaplus.model.Supplier;


public class SupplierServiceImpl implements SupplierService {

	private SupplierDao supplierDao;

	public SupplierServiceImpl() {
		supplierDao = new SupplierDaoImpl();
	}

	@Override
	public void save(Supplier supplier) {
		supplierDao.save(supplier);
	}

	@Override
	public void update(Supplier supplier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Supplier get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		return supplierDao.getAllSuppliers();
	}

}
