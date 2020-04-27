package com.sales.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Order;

/*
 * Interface contains methods for custom queries to the database.
 * updateDate sends a query to the database for the current order id and sets the date to the current date.
 * updateProducts takes away from product quantity according to how much quantity was ordered.
 */

@Repository
public interface OrderInterface extends CrudRepository<Order, Long> {
	@Transactional
	@Modifying
    @Query(value = "UPDATE orders o SET o.orddate = CURDATE() WHERE o.oid = :oid", nativeQuery = true)
    void updateDate(@Param("oid") Long oid);
	@Transactional
	@Modifying
    @Query(value = "UPDATE products p SET p.qtyinstock = (p.qtyinstock - :qty) WHERE p.pid = :pid", nativeQuery = true)
    void updateProducts(@Param("qty") int qty, @Param("pid") Long pid);
}
