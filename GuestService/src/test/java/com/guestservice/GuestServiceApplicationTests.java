package com.guestservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.guestservice.exception.GuestNotFoundException;
import com.guestservice.model.GuestDetails;
import com.guestservice.repository.GuestDetailsRepository;
import com.guestservice.service.GuestDetailsService;

@SpringBootTest
class GuestServiceApplicationTests {
	
	@Autowired
	private GuestDetailsService service;
	
	@MockBean
	private GuestDetailsRepository guestRepository;
	
	@Test
	public void ShowAllGuestTest() throws GuestNotFoundException {
		List<GuestDetails>guest = new ArrayList<>();
		GuestDetails g = new GuestDetails();
	
		g.setGuestId(1);
		g.setName("Prawin");
		g.setContact("7890123763");
		g.setGender("Male");
		g.setEmail("prawin@16");
		g.setAddress("Bose nagar, Chennai");
		
		guest.add(g);
		when(guestRepository.findAll()).thenReturn(guest);
		assertEquals(1, service.showAllGuestDetails().size());
	}	
	
	@Test
	public void ShowGuestByIdTest() throws GuestNotFoundException {
		
		GuestDetails g = new GuestDetails();
		
		g.setGuestId(1);
		g.setName("Prawin");
		g.setContact("7890123763");
		g.setGender("Male");
		g.setEmail("prawin@16");
		g.setAddress("Bose nagar, Chennai");
		
	       Optional<GuestDetails> guest = Optional.of(g);
	       when(guestRepository.findById(1)).thenReturn(guest);
			assertEquals(g, service.showGuestById(1));
		}	
	
	@Test
	public void addGuestTest() throws GuestNotFoundException {
		
		GuestDetails g = new GuestDetails();
		
		g.setGuestId(1);
		g.setName("Prawin");
		g.setContact("7890123763");
		g.setGender("Male");
		g.setEmail("prawin@16");
		g.setAddress("Bose nagar, Chennai");
		
		when(guestRepository.insert(g)).thenReturn(g);
		assertEquals(g, service.addGuestDetails(g));
	}
	   
	@Test
	public void updateGuestTest() throws GuestNotFoundException {
		
		GuestDetails g1 = new GuestDetails();
		GuestDetails g2 = new GuestDetails();
		
		g1.setGuestId(1);
		g1.setName("Prawin");
		g1.setContact("7890123763");
		g1.setGender("Male");
		g1.setEmail("prawin@16");
		g1.setAddress("Bose nagar, Chennai");

		g2.setGuestId(1);
		g2.setName("Prawin");
		g2.setContact("7890123763");
		g2.setGender("Male");
		g2.setEmail("prawin@16");
		g2.setAddress("Bose nagar, Tuticorin");
		
	       Optional<GuestDetails> guest = Optional.of(g1);
	       when(guestRepository.findById(1)).thenReturn(guest);
	       when(guestRepository.save(g2)).thenReturn(g2);
			assertEquals(g2, service.updateGuestDetails(g2));
	}
	
	@Test
	public void deleteGuestTest() throws GuestNotFoundException {
		
		GuestDetails g = new GuestDetails();
		
		g.setGuestId(1);
		g.setName("Prawin");
		g.setContact("7890123763");
		g.setGender("Male");
		g.setEmail("prawin@16");
		g.setAddress("Bose nagar, Chennai");
		
	       Optional<GuestDetails> guest = Optional.of(g);
	       when(guestRepository.findById(1)).thenReturn(guest);
			assertEquals("Guest with the 1 Deleted Successfully!", service.deleteGuestDetails(1));
		}	

	}
	