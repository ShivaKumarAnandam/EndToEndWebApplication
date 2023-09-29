package com.rest.calls;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	@Id
	private Integer productId;
	private String productName;
	private String productType;
	private String productCategory;
	private double productPrice;
	private double discount;
	@Embedded
	private Charges charges= new Charges(); // Initializes charges with a new instance
	private double finalPrice; 
}
