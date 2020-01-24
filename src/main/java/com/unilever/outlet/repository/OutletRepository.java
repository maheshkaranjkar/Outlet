package com.unilever.outlet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unilever.outlet.entity.Outlet;
@Repository
public interface OutletRepository extends JpaRepository<Outlet, Integer> {

}
