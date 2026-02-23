package com.abc.orm.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // custom :- sequence , works best for Oracle , DB2 , Postgres SQl , Durby
	private int productCode;
	private String productName;
	private String category;
	private int cost;
	
	@ManyToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE}, mappedBy = "productList")
	@ToString.Exclude
	private List<Vendor> allvendors;

	public Product(String productName, String category, int cost) {
		super();
		this.productName = productName;
		this.category = category;
		this.cost = cost;
	}
	
	
	

}





















