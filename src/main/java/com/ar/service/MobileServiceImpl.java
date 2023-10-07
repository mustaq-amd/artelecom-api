package com.ar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ar.entity.Mobile;
import com.ar.exception.ResourceNotFoundException;
import com.ar.repository.MobileRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MobileServiceImpl implements MobileService {

	private final MobileRepository mobileRepository;

	@Override
	public List<Mobile> fetchAllMobiles() {
		return mobileRepository.findAll();

	}

	@Override
	public Mobile addMobile(Mobile mobile) {
		Mobile newMobile = new Mobile();
		newMobile.setBrand(mobile.getBrand());
		newMobile.setInternalMemory(mobile.getInternalMemory());
		newMobile.setModel(mobile.getModel());
		newMobile.setPrice(mobile.getPrice());
		newMobile.setIsAvailable(mobile.getIsAvailable());
		newMobile.setRam(mobile.getRam());
		newMobile.setType(mobile.getType());

		return mobileRepository.save(mobile);
	}

	@Override
	public Mobile updateMobile(Long id, Mobile mobile) {
		Mobile existingMobile = getMobileById(id);

		existingMobile.setBrand(mobile.getBrand());
		existingMobile.setInternalMemory(mobile.getInternalMemory());
		existingMobile.setModel(mobile.getModel());
		existingMobile.setPrice(mobile.getPrice());
		existingMobile.setIsAvailable(mobile.getIsAvailable());
		existingMobile.setRam(mobile.getRam());
		existingMobile.setType(mobile.getType());

		return mobileRepository.save(existingMobile);
	}

	@Override
	public void deleteMobile(Long id) {
		Mobile mobile = getMobileById(id);
		mobileRepository.delete(mobile);
	}

	@Override
	public Mobile getMobileById(Long id) {
		mobileRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Mobile is Not available with id : " + id));
		return null;
	}

}
