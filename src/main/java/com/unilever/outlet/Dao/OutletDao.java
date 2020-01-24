package com.unilever.outlet.Dao;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unilever.outlet.entity.Outlet;
import com.unilever.outlet.repository.OutletRepository;

@Component
public class OutletDao {
	@Autowired
	OutletRepository outletRepository;
	
	public void uploadOutletDetails(List<Outlet> outlets) {
		outletRepository.saveAll(outlets);
	}
	
}
