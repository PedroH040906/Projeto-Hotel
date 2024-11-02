package service;

import domain.Customers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.CustomersRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomersService {

    private CustomersRepository customersRepository;

    public void addCustomer(CustomersDTO customerDTO) {
        Customers customer = new Customers();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setAddress(customerDTO.getAddress());
        customer.setCpf(customerDTO.getCpf());
        customersRepository.save(customer);
    }

    public void updateCustomer(CustomersDTO customerDTO) {
        Customers customer = customersRepository.findById(customerDTO.getId()).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setAddress(customerDTO.getAddress());
        customer.setCpf(customerDTO.getCpf());
        customersRepository.save(customer);
    }

    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }

    public Customers getCustomerById(Long id) {
        return customersRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public void deleteCustomer(Long id) {
        customersRepository.deleteById(id);
    }


}
