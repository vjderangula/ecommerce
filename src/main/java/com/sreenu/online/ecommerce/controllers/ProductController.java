package com.sreenu.online.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
	public Iterable list( ){
	 //   Iterable productList = productService.listAllProducts();
	    //return productList;
	    return null;
	}
	
	    @RequestMapping(value = "/list", method= RequestMethod.GET)
	    public Iterable list(ProductModel model){
	        Iterable productList = productService.listAllProducts();
	        return productList;
	    }
	    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET)
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
	        Product storedProduct = productService.getProductById(id);
	        storedProduct.setDescription(product.getDescription());
	        storedProduct.setImageUrl(product.getImageUrl());
	        storedProduct.setPrice(product.getPrice());
	        productService.saveProduct(storedProduct);
	        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
	    }
	    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity delete(@PathVariable Integer id){
	        productService.deleteProduct(id);
	        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
	    }
	}

