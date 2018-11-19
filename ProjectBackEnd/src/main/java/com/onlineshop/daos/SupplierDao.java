package com.onlineshop.daos;

import java.util.List;

import com.onlineshop.models.Supplier;

public interface SupplierDao {

	public boolean addSupplier(Supplier sObj);
	public boolean deleteSupplier(Supplier supplierObj);
	public boolean updateSupplier(Supplier supplier );
	public Supplier getSupplierById(int supplierId);
	public List<Supplier> getAllSuppliers();
}
