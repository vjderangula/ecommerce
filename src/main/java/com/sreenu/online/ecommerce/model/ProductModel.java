package com.sreenu.online.ecommerce.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;


import io.swagger.annotations.ApiModelProperty;
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
public class ProductModel {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @ApiModelProperty(notes = "The database generated ProductModel ID")
	    private Integer modelId;
	    @Version
	    @ApiModelProperty(notes = "The auto-generated version of the ProductModel")
	    private Integer version;
	    @ApiModelProperty(notes = "The application-specific ProductModel ID")
	    private String productModelId;
	

}
