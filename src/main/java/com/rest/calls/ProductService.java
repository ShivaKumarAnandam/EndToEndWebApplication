package com.rest.calls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public Product addProduct(Product product) {
		double productPrice = product.getProductPrice();
		double discount = 0.00;
		double gst = 0.00;
		double deliveryCharges = 0.00;
		double finalPrice = 0.00;

		switch (product.getProductCategory()) {
		
			case "Electronics":		discount = productPrice * 0.15;
									gst = productPrice * 0.18;
									deliveryCharges = 350;
									finalPrice = (productPrice - discount) + gst + deliveryCharges;
						
									break;
	
			case "Home Appliances":	discount = productPrice * 0.22;
									gst = productPrice * 0.24;
									deliveryCharges = 800;
									finalPrice = (productPrice - discount) + gst + deliveryCharges;
						
									break;
	
			case "Clothing":		discount = productPrice * 0.4;
									gst = productPrice * 0.12;
									finalPrice = (productPrice - discount) + gst + deliveryCharges;
						
									break;
	
			case "Furniture":		discount = productPrice * 0.1;
									gst = productPrice * 0.18;
									deliveryCharges = 300;
									finalPrice = (productPrice - discount) + gst + deliveryCharges;
									break;
		}
		
		product.setDiscount(discount);
		product.getCharges().setGst(gst);
		product.getCharges().setDeliveryCharges(deliveryCharges);
		product.setFinalPrice(finalPrice);
		Product p = productRepo.save(product);
		return p;
	}

	public Product updateProduct(Product product, Integer productId) {

		double productPrice = product.getProductPrice();
		double discount = product.getDiscount();
		double gst = product.getCharges().getGst();
		double deliveryCharges = product.getCharges().getDeliveryCharges();
		double finalPrice = product.getFinalPrice();

		switch (product.getProductCategory()) {
		
			case "Electronics":		discount = productPrice * 0.15;
									gst = productPrice * 0.18;
									deliveryCharges = 350;
									finalPrice = (productPrice - discount) + gst + deliveryCharges;
						
									break;
	
			case "Home Appliances":	discount = productPrice * 0.22;
									gst = productPrice * 0.24;
									deliveryCharges = 800;
									finalPrice = (productPrice - discount) + gst + deliveryCharges;
						
									break;
	
			case "Clothing":		discount = productPrice * 0.4;
									gst = productPrice * 0.12;
									finalPrice = (productPrice - discount) + gst + deliveryCharges;
						
									break;
	
			case "Furniture":		discount = productPrice * 0.1;
									gst = productPrice * 0.18;
									deliveryCharges = 300;
									finalPrice = (productPrice - discount) + gst + deliveryCharges;
									break;
		}

		Product p = productRepo.findById(productId).get();
		p.setProductName(product.getProductName());
		p.setProductType(product.getProductType());
		p.setProductCategory(product.getProductCategory());
		p.setProductPrice(product.getProductPrice());
		p.setDiscount(discount);
		p.getCharges().setGst(gst);
		p.getCharges().setDeliveryCharges(deliveryCharges);
		p.setFinalPrice(finalPrice);
		return productRepo.save(p);
	}

	public void deleteProduct(int productId) {
		productRepo.deleteById(productId);
	}

	public List<Product> getAll() {
		List<Product> products = productRepo.findAll();
		return products;
	}

	public Product getOne(int productId) {
		Product product = productRepo.findById(productId).get();
		return product;
	}
}