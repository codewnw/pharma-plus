package com.pharmaplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.pharmaplus.model.Supplier;

public class SupplierDaoImpl implements SupplierDao {

	@Override
	public void save(Supplier supplier) {
		System.out.println(getClass().getSimpleName() + " >> Inserting Supplier.");
		String INSERT_SUPPLIER_QUERY = "INSERT INTO PP_SUPPLIER VALUES(?, ?, ?, ?)";

		try (Connection con = DbUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_SUPPLIER_QUERY)) {
			pstmt.setInt(1, supplier.getId());
			pstmt.setString(2, supplier.getName());
			pstmt.setString(3, supplier.getShortname());
			pstmt.setInt(4, supplier.getActiveflag());
			

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		// TODO Auto-generated method stub
		return null;
	}

}
