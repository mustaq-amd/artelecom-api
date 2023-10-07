package com.ar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ar.entity.Mobile;
import com.ar.service.MobileService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/mobiles")
@AllArgsConstructor
public class MobileController {
	
	private final MobileService mobileService;
	
	@GetMapping
	public List<Mobile> getAllMobiles(){
		return mobileService.fetchAllMobiles();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Mobile> addMobile(@RequestBody Mobile mobile){
		return new ResponseEntity<Mobile>(mobileService.addMobile(mobile),HttpStatus.CREATED);
		
	}

}
