package br.edu.univas.api.bill.vo;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Bill {
    
    @Generated
    private Long id;
    private Long amount;
    private String product;
    private String paymentMethod;
    private String customer;

}
