package com.example.test1.Repo1;

import com.example.test1.domenModel.Address;
import com.example.test1.domenModel.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    //public default Optional<Customer> findAddress(int address_id) {
        /*@Query("select * from sakila.Address a left join sakila.customer c on a.address_id=b.address_id")
        public  List<Customer> FindAllWithDescriptionQuery();*/

}