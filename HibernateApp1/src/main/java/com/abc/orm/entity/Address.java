package com.abc.orm.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Address {

	private String houseDetails;
	private String city;
	private String country;
	private long pincode;
}
