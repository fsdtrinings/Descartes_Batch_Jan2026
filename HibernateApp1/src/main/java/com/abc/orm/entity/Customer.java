package com.abc.orm.entity;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "DekCustomers")
public class Customer {
	
	@Id
	@SequenceGenerator(
			name = "customerSeq",
			sequenceName = "customerSeq",
			initialValue = 4000,
			allocationSize = 1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSeq")
	private int cid;
	
	@Column(name = "customer_fullname")
	private String customerName;
	

	private String email;
	
	@Column( nullable = false)
	private long phoneNumber;
	
	
	
	// ------------  day 2 -----------------------------
	
	
	@Embedded
	@Column(nullable = false)
	@ToString.Exclude
	private Address houseAddress;
	
	
	@Embedded
	@AttributeOverrides(
			{
				@AttributeOverride(name="houseDetails",column = @Column(name="OfficeAddress")),
				@AttributeOverride(name="city",column = @Column(name="Officecity")),
				@AttributeOverride(name="country",column = @Column(name="Officecountry")),
				@AttributeOverride(name="pincode",column = @Column(name="Officepincode")),
			}
			)
	@ToString.Exclude
	private Address officeAddress;
	

	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "profileNumber" )
	@ToString.Exclude
	private Profile profile;
	
	
	
	
	@ElementCollection
	@Column(name = "Customer_Id")
	@ToString.Exclude
	List<Invoice> invoice;
	
	
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@ToString.Exclude
	List<AppOrder> allOrders;
	
	
	
	/// ---------------------  customize constructors ---------------------
	
	public Customer(String customerName, long phoneNumber) {
		super();
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
	}
																			//  dumpInfo : property deleted xyz 
	public Customer(int cid, String customerName, String email, long phoneNumber, String dumoInfo) {
		super();
		this.cid = cid;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	

}//end class




















