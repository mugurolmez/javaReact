package kodlama.io.northwind.api.controllers;

import java.util.List;

import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;

@RestController //restten gelen bir controllersin
@RequestMapping("/api/products")//gelen ıstegi bu kontrolerle karsılayacak

public class ProductsController {//products cogul kullanım isimlendirme kuralı
	@Autowired
	private ProductService productService;

	public ProductsController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/getall")//veriyi ver HTTP Requestleri/get isteği gondereceğim
	public DataResult <List<Product>> getAll(){
        return this.productService.getAll() ;
		
	}
	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		return this.productService.add(product);

	}

	@GetMapping("/getByProductName")//requrstparam isteği parametrelere bak orda product name olacak ordan atama
		public DataResult<Product> getByProductName(@RequestParam String productName){
		return  this.productService.getByProductName(productName);
	}

	@GetMapping("/getByProductNameAndCategoryId")
		public DataResult <Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName,categoryId);

	}
	@GetMapping("/getByProductNameContains")
	public DataResult <List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);

	}
	@GetMapping("/getAllByPage")
	public DataResult <List<Product>>getAll(int pageNo,int pageSize){
		return  this.productService.getAll(pageNo,pageSize);
	}
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
}
