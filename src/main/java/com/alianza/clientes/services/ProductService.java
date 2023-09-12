package com.alianza.clientes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alianza.clientes.dto.ClientesAlianza;
import com.alianza.clientes.repository.ClientRepository;

@Service
public class ProductService {
    @Autowired
    private ClientRepository repository;

    public ResponseEntity<?> saveProduct(int id,String name,Long phone,String email,String startDate,String endDate) {
        return repository.save(id,name,phone,email,startDate,endDate);
    }

    public List<ClientesAlianza> getProducts() {
        return repository.getAllProducts();
    }

    public List<ClientesAlianza> getProductById(int id) {
        return repository.findById(id);
    }

    public String deleteProduct(int id) {
        repository.delete(id);
        return "product removed !! " + id;
    }

    public ClientesAlianza updateProduct(ClientesAlianza clientesAlianza) {
       return repository.update(clientesAlianza);
    }
}
