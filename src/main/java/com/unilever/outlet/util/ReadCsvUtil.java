package com.unilever.outlet.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.unilever.outlet.entity.Outlet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReadCsvUtil {
	/**
	 * Util method to read csv file and return unique list of outlets
	 * @param file
	 * @return List <Outlet>
	 */
	public List<Outlet> getOutlets(MultipartFile file) {
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			CsvToBean<Outlet> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Outlet.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Outlet> outlets = csvToBean.parse();
            List<Outlet> distinctOutlets = outlets.stream().distinct().collect(Collectors.toList());
            return distinctOutlets;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
