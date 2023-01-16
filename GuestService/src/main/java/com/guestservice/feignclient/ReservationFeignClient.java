package com.guestservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "ReservationService", url = "http://localhost:9004/reservation")

public interface ReservationFeignClient {
	
	@GetMapping("/roomprice/{roomType}")
	public String getPrice(@PathVariable("roomType") String roomType,@RequestHeader("Authorization") String token);

}
