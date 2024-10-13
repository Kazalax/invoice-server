package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.dto.mapper.InvoiceMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InvoiceServiceImpl implements InvoiceService  {
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

    public InvoiceDTO addInvoice(InvoiceDTO invoiceDTO) {
        InvoiceEntity invoice = invoiceMapper.toEntity(invoiceDTO);
        Long idSeller = invoiceDTO.getSeller().getId();
        PersonEntity seller = personRepository.getReferenceById(idSeller);

        Long idBuyer = invoiceDTO.getBuyer().getId();
        PersonEntity buyer = personRepository.getReferenceById(idBuyer);

        invoice.setSeller(seller);
        invoice.setBuyer(buyer);
        return invoiceMapper.toInvoiceDTO(invoice);
    }
}