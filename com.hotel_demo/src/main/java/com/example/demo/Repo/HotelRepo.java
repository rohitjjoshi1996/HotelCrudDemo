package com.example.demo.Repo;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer> {

	public Hotel getHotelByhotelId(int id);
	
	@Query(value = "select id from hotel where id =:?", nativeQuery = true)
	public Integer isHotelPresent(@Name("id") int id);

}
