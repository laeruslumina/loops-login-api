package com.loops.loopsproject.controller;

import com.loops.loopsproject.models.entities.Invoice;
import com.loops.loopsproject.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody Invoice invoice){
        return invoiceService.create(invoice);
    }

    @GetMapping
    public List<Invoice> findAllInvoice(){return invoiceService.findAll();}

    @PutMapping
    public Invoice updateInvoice (@PathVariable Long id, @RequestBody Invoice invoice){
        return invoiceService.update(id, invoice);
    }

    @DeleteMapping
    public String deleteInvoice(@PathVariable Long id){
        invoiceService.delete(id);
        return "Invoice Deleted....";
    }


}
