package com.loops.loopsproject.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @NotEmpty
    private String transactionReferenceType;

    @NotEmpty
    private String productName;

    @NotEmpty
    private BigDecimal basePrice;

    private BigDecimal discount;

    private BigDecimal totalPrice;


}
