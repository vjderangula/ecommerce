package com.sreenu.online.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sreenu.online.ecommerce.model.Product;
import com.sreenu.online.ecommerce.model.ProductModel;
import com.sreenu.online.ecommerce.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/product")
@Api(value="Ecommerce", description = "ECommerce Product API")
//@PreAuthorize("hasAnyAuthority('ROLE:ECOMMERCE_USER', 'ROLE:ECOMMERCE_TESTER)") --> SPRING SECURITY JAR NEEDED
public class ProductController {

	 @Autowired
	 private ProductService productService;
	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@GetMapping(value = "/list", produces = "application/json")
	public Iterable list( ){
	 //   Iterable productList = productService.listAllProducts();
	    //return productList;
	    return null;
	}
	
	@Operation(summary =" find the list of products")
	@GetMapping(value = "/list")
	    public Iterable list(ProductModel model){
	        Iterable productList = productService.listAllProducts();
	        return productList;
	    }
	@GetMapping(value = "/show/{id}")
	    public Product showProduct(@PathVariable Integer id, ProductModel model){
	       Product product = productService.getProductById(id);
	        return product;
	    }
	    @RequestMapping(value = "/add", method = RequestMethod.POST)
	    public ResponseEntity saveProduct(@RequestBody Product product){
	        productService.saveProduct(product);
	        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
	    }
	    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product){
	    	
	    	try {
	    		
	        Product storedProduct = productService.getProductById(id);
	        storedProduct.setDescription(product.getDescription());
	        storedProduct.setImageUrl(product.getImageUrl());
	        storedProduct.setPrice(product.getPrice());
	        productService.saveProduct(storedProduct);}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    		e.getMessage();
	    	}
	        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
	    }
	    @DeleteMapping(value="/delete/{id}")
	    public ResponseEntity delete(@PathVariable Integer id){
	        productService.deleteProduct(id);
	        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
	    }
	}

