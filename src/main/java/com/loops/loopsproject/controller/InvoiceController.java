package com.loops.loopsproject.controller;

import com.loops.loopsproject.models.entities.Invoice;
import com.loops.loopsproject.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InvoiceController {
    @Autowired
    private final InvoiceService invoiceService;
    @PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody Invoice invoice){
        return invoiceService.create(invoice);
    }

    @GetMapping("/invoice")
    public List<Invoice> findAllInvoice(){return invoiceService.findAll();}

    @PutMapping("/invoice")
    public Invoice updateInvoice (@PathVariable Long id, @RequestBody Invoice invoice){
        return invoiceService.update(id, invoice);
    }

    @DeleteMapping("/invoice")
    public String deleteInvoice(@PathVariable Long id){
        invoiceService.delete(id);
        return "Invoice Deleted....";
    }
}
