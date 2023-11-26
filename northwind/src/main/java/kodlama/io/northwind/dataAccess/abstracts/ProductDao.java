package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;
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
    @Query("Select new kodlama.io.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
    //select p.productId,p.productName, c.categoryName from Category c inner join product p
    //on c.categoryId=p.categoryId
}
