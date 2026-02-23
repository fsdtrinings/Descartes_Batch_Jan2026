package com.abc.orm.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppOrder {

	@Id
	@SequenceGenerator(
			name = "orderSeq",
			sequenceName = "orderSeq",
			initialValue = 5000,
			allocationSize = 1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSeq")
	private int orderNumber;
	
	private String orderDate;
	private int orderValue;
	
	@ManyToOne  // manytoone have to manage the relationship
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Payment paymemtType;

	public AppOrder(int orderNumber, String orderDate, int orderValue) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.orderValue = orderValue;
	}
	
	public AppOrder( String orderDate, int orderValue) {
		super();
		this.orderDate = orderDate;
		this.orderValue = orderValue;
	}
	
	
	
	
	
}
