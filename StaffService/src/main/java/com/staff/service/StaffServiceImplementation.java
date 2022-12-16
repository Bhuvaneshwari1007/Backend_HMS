package com.staff.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staff.exception.StaffNotFoundException;
import com.staff.model.Staff;
import com.staff.repository.StaffRepository;

@Service
public class StaffServiceImplementation implements StaffService {

	@Autowired
	private StaffRepository staffRepository;

	Logger log = LoggerFactory.getLogger(StaffServiceImplementation.class);

	@Override
	public List<Staff> showAllStaffDetails() {
		log.info("Show All Staff Details Method Started");
		List<Staff> staff = staffRepository.findAll();
		log.debug("Staffs are {} ", staff);
		log.info("Show All Staff Details Method Ended");
		return staff;
	}

	@Override
	public Staff showStaffById(int id) throws StaffNotFoundException {
		log.info("Show Staff By Id Method Started");
		return staffRepository.findById(id)
				.orElseThrow(() -> new StaffNotFoundException("Staff with the id " + id + " Doesn't Exists"));

	}

	@Override
	public Staff addStaff(Staff staff) throws StaffNotFoundException {
		log.info("Add StaffDetails Method Started");
		Optional<Staff> s = staffRepository.findById(staff.getId());
		if (!s.isPresent()) {
			log.info("Add Staff Method Ended");
			return staffRepository.insert(staff);
		} else {
			return s.orElseThrow(() -> new StaffNotFoundException("Staff Already Exists"));
		}

	}

	@Override
	public Staff updateStaff(Staff staff) throws StaffNotFoundException {
		log.info("Update Staff Method Started");
		Optional<Staff> s = staffRepository.findById(staff.getId());
		if (!s.isPresent())
			return s.orElseThrow(
					() -> new StaffNotFoundException("Staff with the id " + staff.getId() + " Doesn't Exists"));
		log.info("Update Staff Method Ended");
		return staffRepository.save(staff);
	}

	@Override
	public String deleteStaff(int id) throws StaffNotFoundException {
		log.info("Delete Staff Method Started");
		Optional<Staff> staff = staffRepository.findById(id);
		if (!staff.isPresent()) {
			staff.orElseThrow(() -> new StaffNotFoundException("Staff with the id " + id + " Doesn't Exists"));
		} else {
			staffRepository.deleteById(id);
			log.debug("Deleted SuccessFully {}", staff);
			log.info("Delete Staff Method Ended");
		}
		return "Staff with the " + id + " Deleted Successfully!";
	}

}
