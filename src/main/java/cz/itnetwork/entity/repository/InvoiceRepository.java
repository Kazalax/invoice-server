package cz.itnetwork.entity.repository;

import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity,Long>, JpaSpecificationExecutor<InvoiceEntity> {

}
