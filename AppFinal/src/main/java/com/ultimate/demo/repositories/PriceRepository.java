package com.ultimate.demo.repositories;

import com.ultimate.demo.model.Pricereduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Pricereduction, Long> {

}
