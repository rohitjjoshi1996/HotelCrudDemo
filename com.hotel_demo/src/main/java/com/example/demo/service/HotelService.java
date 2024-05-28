package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.Hotel;
import com.example.demo.Repo.HotelRepo;

@Component
public class HotelService {
	@Autowired
	private HotelRepo hotelRepo;

	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = hotelRepo.findAll();
		return hotels;
	}

	public String saveHotel(Hotel hotel, String result) {
		try {
			Hotel save = hotelRepo.save(hotel);
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
		return result.equals("save") ? "Data Saved Successfuly" : "Data updated Successfuly";
	}

	public Hotel getHotelByhotelId(int id) {
//		int result = hotelRepo.isHotelPresent(id);
//		if(result > 1) {
			Hotel hotel = hotelRepo.getHotelByhotelId(id);
			return hotel;
//		} else {
//			return 
//		}
		
	}

	public void deleteHotel(int id) {
		hotelRepo.deleteById(id);
	}

}
