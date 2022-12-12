package com.owner.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.owner.exception.StaffNotFoundException;
import com.owner.model.Staff;


@FeignClient(name="StaffService", url="http://localhost:9005/staff")
public interface StaffFeignClient {
	
	@GetMapping("/all")
	public ResponseEntity<List<Staff>> showAllStaff();

	@GetMapping("/{id}")
	public ResponseEntity<Staff> showById(@PathVariable("id") int id) throws StaffNotFoundException;

	@PostMapping("/addstaff")
	public ResponseEntity<Staff> addStaff(@RequestBody Staff staffDetails) throws StaffNotFoundException;
		
	
	@PutMapping("/updatestaff")
	public ResponseEntity<Staff> updateStaff(@RequestBody Staff staff) throws StaffNotFoundException;
	
	@DeleteMapping("/deletestaff/{id}")
	public ResponseEntity<String> deleteStaff(@PathVariable("id") int id) throws StaffNotFoundException;
	
}
