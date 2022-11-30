package com.loops.loopsproject.models.repository;

import com.loops.loopsproject.models.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
