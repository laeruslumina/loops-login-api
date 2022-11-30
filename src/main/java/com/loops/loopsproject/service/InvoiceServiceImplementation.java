package com.loops.loopsproject.service;

import com.loops.loopsproject.models.entities.Invoice;
import com.loops.loopsproject.models.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImplementation implements InvoiceService{

    private final InvoiceRepository invoiceRepository;

    private BigDecimal getTotalPrice(Invoice invoice){
        if (invoice.getBasePrice().intValue() > 10000 ){ //bikin auto generate validation
            invoice.setDiscount(BigDecimal.valueOf(10000));
        }
        return invoice.getBasePrice().subtract(invoice.getDiscount());
    }

    @Override
    public Invoice create(Invoice invoice) {
        BigDecimal totalPrice = getTotalPrice(invoice);
        invoice.setTotalPrice(totalPrice);

        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        invoiceRepository.deleteById(id);
        return "Deleted...";
    }

    @Override
    public Invoice update(Long id, Invoice invoice) {
        Invoice original = invoiceRepository.findById(id).
                orElseThrow(()-> new EntityNotFoundException("Invoice not found"));

                if (invoice.getProductName() != null){
                    original.setProductName(invoice.getProductName());
                }

                if (invoice.getBasePrice() != null){
                    original.setBasePrice(invoice.getBasePrice());
                }

                if (invoice.getDiscount() != null){
                    original.setDiscount(invoice.getDiscount());
                }
        return invoiceRepository.save(original);
    }
}
