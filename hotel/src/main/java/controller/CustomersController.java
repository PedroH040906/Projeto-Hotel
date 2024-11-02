package controller;

import domain.Customers;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CustomersDTO;
import service.CustomersService;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomersController {

    private final CustomersService customersService;

    // Endpoint para adicionar um novo cliente
    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody CustomersDTO customerDTO) {
        customersService.addCustomer(customerDTO);
        return ResponseEntity.ok("Customer added successfully");
    }

    // Endpoint para atualizar um cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody CustomersDTO customerDTO) {
        customerDTO.setId(id);
        customersService.updateCustomer(customerDTO);
        return ResponseEntity.ok("Customer updated successfully");
    }

    // Endpoint para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() {
        List<Customers> customers = customersService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    // Endpoint para obter um cliente específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Long id) {
        Customers customer = customersService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    // Endpoint para deletar um cliente pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customersService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
