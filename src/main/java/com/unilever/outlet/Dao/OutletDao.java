package com.unilever.outlet.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unilever.outlet.entity.Outlet;
import com.unilever.outlet.repository.OutletRepository;

@Component
public class OutletDao {
	@Autowired
	OutletRepository outletRepository;
	/**
	 * Dao method to call outlet repository to save/oupdate Outlet details
	 * @param outlets
	 * @return List <Outlet>
	 */
	public List<Outlet> uploadOutletDetails(List<Outlet> outlets) {
			List<Outlet> createdOutlets = outletRepository.saveAll(outlets);
			return createdOutlets;			
	}
	
}
