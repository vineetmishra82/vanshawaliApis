package com.kpts.vanshawali.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpts.vanshawali.models.Admin;
import com.kpts.vanshawali.models.Vyakti;
import com.kpts.vanshawali.repositories.AdminRepo;
import com.kpts.vanshawali.repositories.VyaktiRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServiceData {
	
	private static Logger logger = LoggerFactory.getLogger(ServiceData.class);
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	VyaktiRepo vyaktiRepo;
	
	
	public boolean adminLogin(String userId, String password) {

		List<Admin> admins = adminRepo.findAll();

		for (Admin admin : admins) {

			if (admin.getUserId().equals(userId) && admin.getPassword().equals(password))

				return true;
		}

		return false;
	}
	
	public List<Vyakti> getEntireVanshawali()
	{
		return vyaktiRepo.findAll();
	}
	
	public boolean addVyakti(Vyakti vyakti)
	{
		try {
			vyakti.setVyaktiId((String.valueOf(vyaktiRepo.findAll().size()+1)));
			vyakti.setDeletable(true);
			vyaktiRepo.save(vyakti);
			return true;
		}
		catch(Exception ex)
		{
			log.info(ex.getLocalizedMessage());
			return false;
		}
	}
	
	public boolean updateVyakti(String id, Vyakti updateVyakti)
	{
		Vyakti vyaktiAsPerId = null;
		
		for (Vyakti vyakti : vyaktiRepo.findAll()) {
			
			if(vyakti.getVyaktiId().equals(id))
			{
				vyaktiAsPerId = vyakti;
				break;
			}
		}
		
		try {
			vyaktiRepo.findAll().remove(vyaktiAsPerId);
			vyaktiRepo.findAll().add(updateVyakti);
			vyaktiRepo.save(updateVyakti);
			return true;
		}catch(Exception ex)
		{
			log.info(ex.getLocalizedMessage());
			return false;
		}
	}
	
	public boolean removeVyakti(String id)
	{
		Vyakti vyaktiAsPerId = null;
		try {
			for (Vyakti vyakti : vyaktiRepo.findAll()) {
				
				if(vyakti.getVyaktiId().equals(id) && vyakti.isDeletable())
				{
					vyaktiAsPerId = vyakti;
					break;
				}
			}
			
			if(!vyaktiAsPerId.equals(null))
			{
				vyaktiRepo.delete(vyaktiAsPerId);
				return true;
			}
			
			return false;
			
		}catch(Exception ex)
		{
			log.info(ex.getLocalizedMessage());
			return false;
		}
		
		
	}

}
