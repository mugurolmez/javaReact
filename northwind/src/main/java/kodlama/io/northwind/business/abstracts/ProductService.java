package kodlama.io.northwind.business.abstracts;

import java.util.List;

import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import kodlama.io.northwind.entities.concretes.Product;

@Service
public interface ProductService {
	DataResult <List<Product>>getAll();
	DataResult <List<Product>>getAllSorted();
	DataResult <List<Product>>getAll(int pageNo,int pageSize);
	Result add(Product product);

	DataResult <Product> getByProductName(String productName);

	DataResult <Product> getByProductNameAndCategoryId(String productName,int categoryId);

	DataResult <List<Product>> getByProductNameOrCategory(String productName,int categoryId );

	DataResult <List<Product>> getByCategoryIn(List<Integer> categories);

	//contains içeriiyorsa
	DataResult <List<Product>> getByProductNameContains(String productName);

	//başlangıcı
	DataResult <List<Product>> getByProductNameStartsWith(String productName);

	DataResult <List<Product>> getByNameAndCategory(String productName, int categoryId);

	DataResult <List<ProductWithCategoryDto>> getProductWithCategoryDetails();

	}
