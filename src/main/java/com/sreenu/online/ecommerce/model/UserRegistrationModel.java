package com.sreenu.online.ecommerce.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;/*
												import jakarta.persistence.Entity;
												import jakarta.persistence.GeneratedValue;
												import jakarta.persistence.GenerationType;
												import jakarta.persistence.Id;
												import jakarta.persistence.Table;*/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "userregistrationmodel")
public class UserRegistrationModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated UserRegistrationModel ID")
	public Integer id;
	
	@ApiModelProperty(notes = "UserRegistrationModel firstName")
	public String firstName;
	
	@ApiModelProperty(notes = "UserRegistrationModel lastName")
	public String lastName;
	
	@ApiModelProperty(notes = "UserRegistrationModel email")
	public String email;
	
	@ApiModelProperty(notes = "UserRegistrationModel password")
	public String password;
	
	@ApiModelProperty(notes = "UserRegistrationModel confirmpassword")
	public String confirmpassword;
	
	/*
	 * @ApiModelProperty(notes = "UserRegistrationModel address") public String
	 * address;
	 */
	
	

}
