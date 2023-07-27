package br.com.crud.controller;

import br.com.crud.dto.ProductDTO;
import br.com.crud.entity.Product;
import br.com.crud.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {
    @Inject
    ProductService productService;

    @GET
    public Response listProducts() {
        List<Product> products =  productService.listProduct();
        return Response.ok(products).build();
    }

    @POST
    public Response saveProduct(ProductDTO productDTO){
        Product product = productService.saveProduct(productDTO);
        return Response.ok(product).status(201).build();
    }

    @PUT
    @Path("{id}")
    public Response updateProduct(@PathParam("id") Long id, ProductDTO productDTO){
        productService.updateProduct(id,productDTO);
        return Response.status(204).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteProduct(@PathParam("id") Long id){
        productService.deleteProduct(id);
        return Response.status(204).build();
    }

}
