package nLayeredDemo;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.business.concretes.ProductManager;
import nLayeredDemo.core.JLoggerManagerAdapter;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.concretes.AbcProductDao;
import nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import nLayeredDemo.entities.concretes.Product;
import nLayeredDemo.jlogger.jloggerManager;

public class Main {

	public static void main(String[] args) {
		//todo spring ioc ile çözülecek
		ProductService productService=new ProductManager(new AbcProductDao(),new JLoggerManagerAdapter());
		Product product=new Product(1,2,"Elma",12,50);
		productService.add(product);
		
	}

}
