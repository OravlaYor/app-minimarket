package com.platzi.Market.Persistence.CRUD;

import com.platzi.Market.Persistence.Entity.Compra;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdCliente(Integer idCliente);
}
