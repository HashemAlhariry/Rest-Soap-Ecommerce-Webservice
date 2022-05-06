package backend.network.soap;

import backend.dto.ProductDto;
import backend.repos.entities.ProductEntity;
import backend.repos.utils.Mapper;
import backend.services.inter.ProductService;
import backend.services.ServicesFactoryMethod;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;


import java.util.List;

@WebService
public class ProductSoapResource {

    private ProductService productService = ServicesFactoryMethod.getProductServiceImpl();

    @WebMethod
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
    @WebMethod
    public String addProduct(ProductDto productDto){

        ProductEntity productEntity = Mapper.productDtoToProductEntity(productDto);
        productService.saveProduct(productEntity);
        return "Product Created Successfully";
    }

    @WebMethod
    public String updateProduct(ProductDto productDto){

        ProductEntity productEntity = Mapper.productDtoToProductEntity(productDto);
        productService.updateProduct(productEntity);
        return "Product updated Successfully";
    }

    @WebMethod
    public ProductEntity getProduct(int id) {
        return   productService.getProductById(id);
    }

    @WebMethod
    public String deleteProduct(int id) {
        ProductEntity productEntity = getProduct(id);
        if(productEntity!=null)
            productService.deleteProduct(productEntity);

        return "Deleted Successfully";
    }
}
