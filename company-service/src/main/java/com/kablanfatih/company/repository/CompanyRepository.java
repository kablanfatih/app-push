package com.kablanfatih.company.repository;

import com.kablanfatih.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String > {


}
