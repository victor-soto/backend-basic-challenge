package com.victorsoto.athena.repositories;

import com.victorsoto.athena.entities.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

  @Query("SELECT er FROM ExchangeRate er WHERE er.sourceCurrency = :sourceCurrency AND er.targetCurrency = :targetCurrency")
  Optional<ExchangeRate> findBySourceAndTargetAmount(@Param("sourceCurrency") String sourceCurrency,
                                                     @Param("targetCurrency") String targetCurrency);

}
