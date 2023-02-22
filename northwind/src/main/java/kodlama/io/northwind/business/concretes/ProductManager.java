package kodlama.io.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.dataAccess.abstracts.ProductDao;
import kodlama.io.northwind.entities.concretes.Product;
@Service//projede servis görevi görecek
public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	@Autowired //spring arka planda buna karsılık gelebılecek bir tane sınıfı üretiyor
	//bır bagımlılık olusturur
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
		
		
		return this.productDao.findAll();
	}

}
