package backend.network.rest;

import backend.dto.ProductDto;
import backend.repos.entities.ProductEntity;
import backend.repos.utils.Mapper;
import backend.services.inter.ProductService;
import backend.services.ServicesFactoryMethod;

import jakarta.ws.rs.*;

import java.util.List;

@Path("products")
public class ProductRestResource {

    private ProductService productService = ServicesFactoryMethod.getProductServiceImpl();

    @GET
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @POST
    public String addProduct(ProductDto productDto){

        ProductEntity productEntity = Mapper.productDtoToProductEntity(productDto);
        productService.saveProduct(productEntity);
        return "Product Created Successfully";
    }

    @PUT
    @Path("{id}")
    public String updateProduct(ProductDto productDto , @PathParam("id") int id){

        ProductEntity productEntity = Mapper.productDtoToProductEntity(productDto);
        productEntity.setId(id);
        productService.updateProduct(productEntity);
        return "Product Updated Successfully";
    }

    @GET
    @Path("{id}")
    public ProductEntity getProduct(@PathParam("id") int id) {
      return   productService.getProductById(id);
    }

    @DELETE
    @Path("{id}")
    public String deleteProduct(@PathParam("id") int id) {
        ProductEntity productEntity = getProduct(id);
        if(productEntity!=null)
            productService.deleteProduct(productEntity);

        return "Deleted Successfully";
    }

}
