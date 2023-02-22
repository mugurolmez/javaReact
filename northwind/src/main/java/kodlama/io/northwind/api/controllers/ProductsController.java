package kodlama.io.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.entities.concretes.Product;

@RestController//restten gelen bir controllersin
@RequestMapping("/api/products")//gelen ıstegi bu kontrolerle karsılayacak
public class ProductsController {//products cogul kullanım isimlendirme kuralı
	
	private ProductService productService;
	@Autowired//ioc denen yapılanırma için kullanılıyor
	public ProductsController(ProductService productService) {
	super();
	this.productService = productService;
}

	@GetMapping("/getall")//veriyi ver HTTP Requestleri/get isteği gondereceğim
	public List<Product> getAll(){
		
		return this.productService.getAll();
		
	}
}
