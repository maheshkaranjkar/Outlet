package com.unilever.outlet.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.unilever.outlet.entity.Outlet;
import com.unilever.outlet.service.OutletService;
import com.unilever.outlet.util.ReadCsvUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/outlet")
public class OutletController {

	@Autowired
	ReadCsvUtil csvUtil;

	@Autowired
	OutletService outletService;
	/**
	 * Rest end point to upload csv file containing outlet details
	 * @param file
	 * @return String
	 * @exception TransactionSystemException,JpaSystemException
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		log.info("File type" + fileType);
		if (fileType.equalsIgnoreCase("CSV")) {
			try {
				List<Outlet> outlets = csvUtil.getOutlets(file);
				if (outlets == null || outlets.isEmpty()) {
					return ResponseEntity.status(400).body(
							"Please upload csv file in proper format e.g \"id\",\"lastName\",\"location\", \"outletName\", \"OutletType\" ");
				} else {
					outletService.uploadOutletDetails(outlets);
					return ResponseEntity.ok().body("Outlet information uploaded sucessfuly");
				}
			} catch (TransactionSystemException e) {
				return ResponseEntity.status(400).body("Field can not be null or blank please check csv file");
			} catch (JpaSystemException e) {
				return ResponseEntity.status(400).body("Field can not be null or blank please check csv file");
			} catch (Exception e) {
				return ResponseEntity.status(500).body("Somthing Went wrong please try after some time");
			}
		} else {
			return ResponseEntity.badRequest().body("Only CSV files allowed");
		}

	}

}
