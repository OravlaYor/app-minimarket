package com.platzi.Market.Persistence;

import com.platzi.Market.Domain.Product;
import com.platzi.Market.Domain.repository.ProductRepository;
import com.platzi.Market.Persistence.CRUD.ProductoCrudRepository;

import com.platzi.Market.Persistence.Entity.Producto;
import com.platzi.Market.Persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Repository
//@Component es generalizacion , indica que es un componente de spring , pero la buena practica es usar @Repository
//@Repository esun estereotipo de spring framewokr esto indica que la clase se encarga de  interacturar con la base de datos
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {

        Optional<List<Producto>> productos = productoCrudRepository.findBycantidadStockLessThanAndEstado(quantity,false);
        return productos.map(prod ->mapper.toProducts(prod));
    }

    @Override
    public Optional<List<Product>> getProduct(int productId) {

        return productoCrudRepository.findById(productId).map(producto -> Collections.singletonList(mapper.toProduct(producto)));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int ProductID) {
        productoCrudRepository.deleteById(ProductID);
    }


    public Producto update(Producto newProducto,int id){
        return productoCrudRepository.findById(id).map(
                producto -> {
                    producto.setIdProducto(newProducto.getIdProducto());
                    producto.setCodigoBarras(newProducto.getCodigoBarras());
                    producto.setCantidadStock(newProducto.getCantidadStock());
                    producto.setEstado(newProducto.getEstado());
                    producto.setNombre(newProducto.getNombre());
                    producto.setPrecioVenta(newProducto.getPrecioVenta());
                    producto.setIdProducto(newProducto.getIdProducto());
                    return productoCrudRepository.save(producto);
                }
        ).orElseThrow(()->new RuntimeException("no se encontro el producto con el id: "+id));
    }



}
