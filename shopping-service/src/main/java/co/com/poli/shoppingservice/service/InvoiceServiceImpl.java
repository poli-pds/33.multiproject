package co.com.poli.shoppingservice.service;

import co.com.poli.shoppingservice.persistence.entity.Invoice;
import co.com.poli.shoppingservice.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public void delete(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public Invoice findByNumberInvoice(String numberInvoice) {
        Invoice invoice = invoiceRepository.findByNumberInvoice(numberInvoice);
        return invoice;
    }
}