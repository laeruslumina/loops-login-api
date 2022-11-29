package com.loops.loopsproject.service;

import com.loops.loopsproject.models.entities.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice create(Invoice invoice);

    List<Invoice> findAll();

    String delete(Long id);

    Invoice update(Long id, Invoice invoice);
}
