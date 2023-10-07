package com.ar.service;

import java.util.List;

import com.ar.entity.Mobile;

public interface MobileService {

	List<Mobile> fetchAllMobiles();

	Mobile addMobile(Mobile mobile);

	Mobile updateMobile(Long id, Mobile mobile);

	void deleteMobile(Long id);
	
	Mobile getMobileById(Long id);

}
