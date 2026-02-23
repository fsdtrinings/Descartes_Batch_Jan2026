package com.abc.orm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CustomerProfile")
public class Profile 
{
	@Id
	private int profileid;
	
	
	private String nickName;
	private int age;
	private String dob;

}
