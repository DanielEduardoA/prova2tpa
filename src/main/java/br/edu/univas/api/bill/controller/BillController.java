package br.edu.univas.api.bill.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.api.bill.service.BillRepository;
import br.edu.univas.api.bill.vo.Bill;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @Autowired
    private BillRepository repository;

    @PostMapping
    public ResponseEntity<Bill> createCustomer(@RequestBody Bill bill) {
        repository.create(bill);
        return ResponseEntity.ok(bill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bill> delete(@PathVariable Long id) {
        Bill bill = repository.getById(id);
        if (bill != null) {
            repository.delete(id);
            return ResponseEntity.ok(bill);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Bill>> listAll(@RequestParam String customer) {
        Collection<Bill> bills = repository.listAllByCustomer(customer);
        if (!bills.isEmpty()) {
            return ResponseEntity.ok(bills);
        }
        return ResponseEntity.notFound().build();
    }

}