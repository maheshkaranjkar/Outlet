package com.unilever.outlet.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.unilever.outlet.entity.Outlet;
import com.unilever.outlet.service.OutletService;

@RestController
@RequestMapping("/outlet")
public class OutletController {
	
	@Autowired
	OutletService outletService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public List<Outlet> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		return outletService.uploadOutletDetails(file);
	}
	
}
