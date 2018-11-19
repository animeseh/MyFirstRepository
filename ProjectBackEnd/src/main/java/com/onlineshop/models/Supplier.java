package com.onlineshop.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="SupplierTable")
public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int supplierId;
	private String supplierName;
	private String supplierAddress;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="supplier",cascade=CascadeType.ALL)
	private Set<Product> products=new HashSet<Product>();
	
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	
	
	
	
	
}
