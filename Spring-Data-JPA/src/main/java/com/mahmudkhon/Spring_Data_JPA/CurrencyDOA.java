package com.mahmudkhon.Spring_Data_JPA;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;


public interface CurrencyDOA extends CrudRepository<Currency, BigDecimal> {

}
