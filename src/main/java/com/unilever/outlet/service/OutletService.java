package com.unilever.outlet.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.unilever.outlet.Dao.OutletDao;
import com.unilever.outlet.entity.Outlet;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OutletService {
	@Autowired
	OutletDao outletDao;
	
	public List <Outlet> uploadOutletDetails(MultipartFile file) {
		
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			CsvToBean<Outlet> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Outlet.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Outlet> outlets = csvToBean.parse();
            log.info("outlets ::" +outlets);
            List<Outlet> distinctOutlets = outlets.stream().distinct().collect(Collectors.toList());
            outletDao.uploadOutletDetails(distinctOutlets);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		//outletDao.uploadOutletDetails(outlets);
	}
}
