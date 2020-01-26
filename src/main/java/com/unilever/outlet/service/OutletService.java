package com.unilever.outlet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unilever.outlet.Dao.OutletDao;
import com.unilever.outlet.entity.Outlet;
import com.unilever.outlet.util.ReadCsvUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OutletService {
	@Autowired
	OutletDao outletDao;
	
	@Autowired
	ReadCsvUtil csvUtil;
	/**
	 * Service to update outlet details into database
	 * @param outlets
	 * @return List <Outlets>
	 */
	public List <Outlet> uploadOutletDetails(List<Outlet> outlets) {
		log.info("Service for upload outlet details");
			return outletDao.uploadOutletDetails(outlets);		
	}
}
