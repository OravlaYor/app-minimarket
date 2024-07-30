package com.platzi.Market.Persistence.CRUD;

import com.platzi.Market.Persistence.Entity.Cliente;
import com.platzi.Market.Persistence.Entity.Producto;

import com.sun.jdi.event.StepEvent;
import org.springframework.data.repository.CrudRepository;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface ProductoCrudRepository extends CrudRepository<Producto , Integer> {
    //@Query(value = "SELECT *FROM productos WHERE id_categoria= ?", nativeQuery = true)
    //List<Producto> getCategoriaPorOrden;
    // se puede utilizar como mencionaron ,para darle legibilidad al codigo y no tener mucha palabra por gusto
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findBycantidadStockLessThanAndEstado(int cantidadStock,boolean Estado);
    //Stream<Cliente> findByIdid(int id);

    //implementa estas nota de abajo
    //Optional<List<Producto>> findByPrecioVentaAndNombre(BigDecimal precioVenta,String nombre);

    //Optional<List<Producto>> findByIdNameAndPrecioVenta(int name, BigDecimal precio);




}
