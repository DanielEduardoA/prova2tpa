package br.edu.univas.api.bill.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.edu.univas.api.bill.vo.Bill;

@Repository
public class BillRepository {

    private Map<Long, Bill> my_database = new HashMap<>();
    private Long id = 1l;

    public void create(Bill bill) {
        bill.setId(id);
        my_database.put(bill.getId(), bill);
        id++;
    }

    public Collection<Bill> listAllByCustomer(String customer) {
        return my_database.values().stream().filter(b -> b.getCustomer().equals(customer)).collect(Collectors.toList());
    }

    public Bill getById(Long id) {
        return my_database.get(id);
    }

    public void delete(Long id) {
        my_database.remove(id);
    }
}
