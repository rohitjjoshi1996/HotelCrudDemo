package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Hotel;
import com.example.demo.service.HotelService;

@RestController
public class HotelController {

	@Autowired
	private HotelService hotelservice;

	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getHotels() {
		List<Hotel> allHotels = hotelservice.getAllHotels();
		if (allHotels.size() > 0) {
			return new ResponseEntity(allHotels, HttpStatus.OK);
		} else {
			return new ResponseEntity(allHotels, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/savehotel")
	public ResponseEntity<String> saveHotel(@RequestBody Hotel hotel) {
		String result = hotelservice.saveHotel(hotel, "saved");
		return new ResponseEntity(result, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updatehotel")
	public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel) {
		String result = hotelservice.saveHotel(hotel, "updated");
		return new ResponseEntity(result, HttpStatus.ACCEPTED);
	}

	@GetMapping("/hotel/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("id") int id) {
		Hotel hotel = hotelservice.getHotelByhotelId(id);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}

	@DeleteMapping("/deletehotel/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable("id") int id) {
		hotelservice.deleteHotel(id);
		return new ResponseEntity("hotel deleted", HttpStatus.OK);
	}

}
