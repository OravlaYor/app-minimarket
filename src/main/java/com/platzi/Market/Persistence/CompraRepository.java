package com.platzi.Market.Persistence;

import com.platzi.Market.Domain.Purchase;
import com.platzi.Market.Domain.repository.PurchaseRepository;
import com.platzi.Market.Persistence.CRUD.CompraCrudRepository;
import com.platzi.Market.Persistence.Entity.Compra;
import com.platzi.Market.Persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPruchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(Integer.valueOf(clientId))
                .map(compras -> mapper.toPruchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}

