package com.rest.calls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:5173")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/save")
	public String saveProduct(@RequestBody Product product) {
		Product p = productService.addProduct(product);
		String Message = null;
		if (p != null) {
			Message = "Product Data Inserted Successfully...!";
		} else {
			Message = "Product Data Insert Failed";
		}
		return Message;
	}

	@DeleteMapping("/delete/{productId}")
	public void deleteProduct(@PathVariable Integer productId) {
		productService.deleteProduct(productId);
	}

	@GetMapping("/getOne/{productId}")
	public Product getOne(@PathVariable Integer productId) {
		Product product = productService.getOne(productId);
		return product;
	}

	@GetMapping("/getAll")
	public List<Product> getAll() {
		List<Product> products = productService.getAll();
		return products;
	}

	@PutMapping("/update/{productId}")
	public String update(@RequestBody Product product, @PathVariable Integer productId) {
		Product p = productService.updateProduct(product, productId);
		String Message = null;
		if (p != null) {
			Message = "Product Data Updated Successfully...!";
		} else {
			Message = "Product Data Updated Failed";
		}
		return Message;
	}
}

//POST : http://localhost:8080/save
//{
//    "productId":1001,
//    "productName":"Lenovo Yoga",
//    "productType":"Laptop",
//    "productCategory":"Electronics",
//    "productPrice":45000.00
//}

//{
//    "productId": 1002,
//    "productName": "LG Washing Machine",
//    "productType": "Washing Machine",
//    "productCategory": "Home Appliances",
//    "productPrice": 25000.0
//}

//{
//    "productId": 1003,
//    "productName": "HP Pavilion 360",
//    "productType": "Laptop",
//    "productCategory": "Electronics",
//    "productPrice": 60000.00
//}

//{
//    "productId": 1004,
//    "productName": "Neelkamal Been Bag",
//    "productType": "Sofs Set",
//    "productCategory": "Furniture",
//    "productPrice": 350.0
//}

//{
//    "productId":1005,
//    "productName":"US Polo Assn",
//    "productType":"T-Shirt",
//    "productCategory":"Clothing",
//    "productPrice":1200.00
//}

//{
//    "productId":1006,
//    "productName":"Dummy",
//    "productType":"Mummy",
//    "productCategory":"Tummy",
//    "productPrice":100.00
//}

//GET : http://localhost:8080/getOne/1001
//{
//    "productId": 1001,
//    "productName": "Lenovo Yoga",
//    "productType": "Laptop",
//    "productCategory": "Electronics",
//    "productPrice": 45000.0,
//    "discount": 6750.0,
//    "charges": {
//        "gst": 8100.0,
//        "deliveryCharges": 350.0
//    },
//    "finalPrice": 46700.0
//}

//GET : http://localhost:8080/getOne/1002
//{
//    "productId": 1002,
//    "productName": "LG Washing Machine",
//    "productType": "Washing Machine",
//    "productCategory": "Home Appliances",
//    "productPrice": 25000.0,
//    "discount": 5500.0,
//    "charges": {
//        "gst": 6000.0,
//        "deliveryCharges": 800.0
//    },
//    "finalPrice": 26300.0
//}

//GET : http://localhost:8080/getOne/1003
//{
//    "productId": 1003,
//    "productName": "HP Pavilion 360",
//    "productType": "Laptop",
//    "productCategory": "Electronics",
//    "productPrice": 60000.0,
//    "discount": 9000.0,
//    "charges": {
//        "gst": 10800.0,
//        "deliveryCharges": 350.0
//    },
//    "finalPrice": 62150.0
//}

//GET : http://localhost:8080/getOne/1004
//{
//    "productId": 1004,
//    "productName": "Neelkamal Been Bag",
//    "productType": "Sofs Set",
//    "productCategory": "Furniture",
//    "productPrice": 350.0,
//    "discount": 35.0,
//    "charges": {
//        "gst": 63.0,
//        "deliveryCharges": 300.0
//    },
//    "finalPrice": 678.0
//}

//GET : http://localhost:8080/getOne/1005
//{
//    "productId": 1005,
//    "productName": "US Polo Assn",
//    "productType": "T-Shirt",
//    "productCategory": "Clothing",
//    "productPrice": 1200.0,
//    "discount": 480.0,
//    "charges": {
//        "gst": 144.0,
//        "deliveryCharges": 0.0
//    },
//    "finalPrice": 864.0
//}

//PUT : http://localhost:8080/update/1004
//{
//"productId":1005,
//"productName":"US Polo Assn",
//"productType":"T-Shirt",
//"productCategory":"Clothing",
//"productPrice":1200.00
//}
//Product Data Updated Successfully...!

//PUT : http://localhost:8080/update/1005
//{
//    "productId": 1004,
//    "productName": "Neelkamal Been Bag",
//    "productType": "Sofs Set",
//    "productCategory": "Furniture",
//    "productPrice": 350.0
//}
//Product Data Updated Successfully...!

// GET : http://localhost:8080/getAll
//[
// {
//     "productId": 1001,
//     "productName": "Lenovo Yoga",
//     "productType": "Laptop",
//     "productCategory": "Electronics",
//     "productPrice": 45000.0,
//     "discount": 6750.0,
//     "charges": {
//         "gst": 8100.0,
//         "deliveryCharges": 350.0
//     },
//     "finalPrice": 46700.0
// },
// {
//     "productId": 1002,
//     "productName": "LG Washing Machine",
//     "productType": "Washing Machine",
//     "productCategory": "Home Appliances",
//     "productPrice": 25000.0,
//     "discount": 5500.0,
//     "charges": {
//         "gst": 6000.0,
//         "deliveryCharges": 800.0
//     },
//     "finalPrice": 26300.0
// },
// {
//     "productId": 1003,
//     "productName": "HP Pavilion 360",
//     "productType": "Laptop",
//     "productCategory": "Electronics",
//     "productPrice": 60000.0,
//     "discount": 9000.0,
//     "charges": {
//         "gst": 10800.0,
//         "deliveryCharges": 350.0
//     },
//     "finalPrice": 62150.0
// },
// {
//     "productId": 1004,
//     "productName": "US Polo Assn",
//     "productType": "T-Shirt",
//     "productCategory": "Clothing",
//     "productPrice": 1200.0,
//     "discount": 35.0,
//     "charges": {
//         "gst": 63.0,
//         "deliveryCharges": 300.0
//     },
//     "finalPrice": 678.0
// },
// {
//     "productId": 1005,
//     "productName": "Neelkamal Been Bag",
//     "productType": "Sofs Set",
//     "productCategory": "Furniture",
//     "productPrice": 350.0,
//     "discount": 480.0,
//     "charges": {
//         "gst": 144.0,
//         "deliveryCharges": 0.0
//     },
//     "finalPrice": 864.0
// },
// {
//     "productId": 1006,
//     "productName": "Dummy",
//     "productType": "Mummy",
//     "productCategory": "Tummy",
//     "productPrice": 100.0,
//     "discount": 0.0,
//     "charges": {
//         "gst": 0.0,
//         "deliveryCharges": 0.0
//     },
//     "finalPrice": 0.0
// }
//]

// DELETE : http://localhost:8080/delete/1006

//GET : http://localhost:8080/getAll
//[
// {
//     "productId": 1001,
//     "productName": "Lenovo Yoga",
//     "productType": "Laptop",
//     "productCategory": "Electronics",
//     "productPrice": 45000.0,
//     "discount": 6750.0,
//     "charges": {
//         "gst": 8100.0,
//         "deliveryCharges": 350.0
//     },
//     "finalPrice": 46700.0
// },
// {
//     "productId": 1002,
//     "productName": "LG Washing Machine",
//     "productType": "Washing Machine",
//     "productCategory": "Home Appliances",
//     "productPrice": 25000.0,
//     "discount": 5500.0,
//     "charges": {
//         "gst": 6000.0,
//         "deliveryCharges": 800.0
//     },
//     "finalPrice": 26300.0
// },
// {
//     "productId": 1003,
//     "productName": "HP Pavilion 360",
//     "productType": "Laptop",
//     "productCategory": "Electronics",
//     "productPrice": 60000.0,
//     "discount": 9000.0,
//     "charges": {
//         "gst": 10800.0,
//         "deliveryCharges": 350.0
//     },
//     "finalPrice": 62150.0
// },
// {
//     "productId": 1004,
//     "productName": "US Polo Assn",
//     "productType": "T-Shirt",
//     "productCategory": "Clothing",
//     "productPrice": 1200.0,
//     "discount": 35.0,
//     "charges": {
//         "gst": 63.0,
//         "deliveryCharges": 300.0
//     },
//     "finalPrice": 678.0
// },
// {
//     "productId": 1005,
//     "productName": "Neelkamal Been Bag",
//     "productType": "Sofs Set",
//     "productCategory": "Furniture",
//     "productPrice": 350.0,
//     "discount": 480.0,
//     "charges": {
//         "gst": 144.0,
//         "deliveryCharges": 0.0
//     },
//     "finalPrice": 864.0
// }
//]