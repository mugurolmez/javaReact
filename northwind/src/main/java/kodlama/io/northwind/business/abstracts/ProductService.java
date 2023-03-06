package kodlama.io.northwind.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.northwind.entities.concretes.Product;
@Service
public interface ProductService {
	List<Product> getAll();
	}
