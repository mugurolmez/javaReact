package kodlama.io.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);

    List<Product> getByProductNameOrCategory(String productName,int categoryId );

    List<Product> getByCategoryIn(List<Integer> categories);

    //contains içeriiyorsa
    List<Product> getByProductNameContains(String ProductName);

                                //başlangıcı
    List<Product> getByProductNameStartsWith(String ProductName);


    //query yazarken nesnelere göre yazıyoruz verı tabanına gore degıl
    //: parametre demek
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

}
