package com.pharmaplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pharmaplus.model.Supplier;
import com.pharmaplus.model.User;

public class SupplierDaoImpl implements SupplierDao {

	@Override
	public void save(Supplier supplier) {
		System.out.println(getClass().getSimpleName() + " >> Inserting Supplier.");
		String INSERT_SUPPLIER_QUERY = "INSERT INTO PP_SUPPLIER VALUES(?, ?, ?)";

		try (Connection con = DbUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_SUPPLIER_QUERY)) {
			pstmt.setString(1, supplier.getEmail());
			pstmt.setString(2, supplier.getName());
			pstmt.setString(3, supplier.getMobile());

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
		List<Supplier> suppliers = new ArrayList<>();
		String ALL_SUPPLIER_QUERY = "SELECT * FROM PP_SUPPLIER";
		try (Connection con = DbUtil.getConnection(); Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(ALL_SUPPLIER_QUERY);
			while (rs.next()) {
				Supplier supplier = userRecordToSupplierEntityMaper(rs);
				suppliers.add(supplier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return suppliers;
	}

	private Supplier userRecordToSupplierEntityMaper(ResultSet rs) throws SQLException {
		String email = rs.getString("EMAIL");
		String name = rs.getString("NAME");
		String mobile = rs.getString("MOBILE");

		Supplier supplier = new Supplier();
		supplier.setEmail(email);
		supplier.setName(name);
		supplier.setMobile(mobile);
		return supplier;
	}
}
