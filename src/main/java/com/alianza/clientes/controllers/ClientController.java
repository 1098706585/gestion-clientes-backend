package com.alianza.clientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alianza.clientes.dto.ClientesAlianza;
import com.alianza.clientes.services.ProductService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientController {

    @Autowired
    private ProductService service;

    @GetMapping("/insertar")
    public ResponseEntity<?> addProduct(int id,String name,Long phone,String email,String startDate,String endDate) {
        return service.saveProduct(id,name,phone,email,startDate,endDate);
    }

    @GetMapping
    public List<ClientesAlianza> findAllProducts() {
        return service.getProducts();
    }

    /*@GetMapping("{id}")
    public ClientesAlianza findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }*/
    
    @GetMapping("/buscar-por-id")
    public List<ClientesAlianza> findProductById(int id) {
        return service.getProductById(id);
    }

    @PutMapping
    public ClientesAlianza updateProduct(@RequestBody ClientesAlianza clientesAlianza) {
        return service.updateProduct(clientesAlianza);
    }

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}