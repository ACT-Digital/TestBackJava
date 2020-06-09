package com.altran.santander.challenge.repository;

import com.altran.santander.challenge.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    /** Query to automatically search a category based on last payment descriptions */
    @Query(value = "select category from payment where description like lower(concat( '%', :description, '%')) and id_customer = :id limit 1", nativeQuery = true)
    String categoryAutoSearch(@Param("description") String description, @Param("id") Integer id);

    /** Query to find all payments ordering by most recent */
    List<Payment> findAllByOrderByDateDesc();

    /** Query to find all payments searching by date */
    List<Payment> findAllByDate(Calendar date);

    /** Query to check if exist any payment on the parameter date */
    boolean existsPaymentByDate(Calendar date);

    /** Query to check if payment id exists */
    boolean existsPaymentById(Integer id);

}
