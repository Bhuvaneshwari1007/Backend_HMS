package com.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.inventory.exception.InventoryNotFoundException;
import com.inventory.model.Inventory;
import com.inventory.repository.InventoryRepository;
import com.inventory.service.InventoryService;


@SpringBootTest
class InventoryServiceApplicationTests {
	
	@Autowired
	private InventoryService service;
	
	@MockBean
	private InventoryRepository inventoryRepository;
	
	@Test
	public void ShowAllInventoryTest() throws InventoryNotFoundException {
		List<Inventory>inventory = new ArrayList<>();
		Inventory i = new Inventory();
		
		i.setInventoryCode(1);
		i.setInventoryType("cutleries");
		i.setInventoryName("Spoons");
		i.setInventoryQuantity(100);
		
		inventory.add(i);
		when(inventoryRepository.findAll()).thenReturn(inventory);
		assertEquals(1, service.showAllInventoryDetails().size());
	}
	
	@Test
	public void ShowInventoryByIdTest() throws InventoryNotFoundException {
		
		Inventory i = new Inventory();
		
		i.setInventoryCode(1);
		i.setInventoryType("cutleries");
		i.setInventoryName("Spoons");
		i.setInventoryQuantity(100);
	
		
	       Optional<Inventory> inventory = Optional.of(i);
	       
	       when(inventoryRepository.findById(1)).thenReturn(inventory);
	        assertEquals(i, service.showInventoryById(1));
	    }
	
	@Test
	public void addInventoryTest() throws InventoryNotFoundException {
		
		Inventory i = new Inventory();
		
		i.setInventoryCode(1);
		i.setInventoryType("cutleries");
		i.setInventoryName("Spoons");
		i.setInventoryQuantity(100);
		
		when(inventoryRepository.insert(i)).thenReturn(i);
		assertEquals(i, service.addInventory(i));
	}
	

	@Test
	public void updateInventoryTest() throws InventoryNotFoundException {
		Inventory i1 = new Inventory();
		Inventory i2 = new Inventory();

		i1.setInventoryCode(1);
		i1.setInventoryType("cutleries");
		i1.setInventoryName("Spoons");
		i1.setInventoryQuantity(100);
		
		i2.setInventoryCode(1);
		i2.setInventoryType("cutleries");
		i2.setInventoryName("Forks");
		i2.setInventoryQuantity(100);
		
	       Optional<Inventory> inventory = Optional.of(i1);
	       when(inventoryRepository.findById(1)).thenReturn(inventory);
	       when(inventoryRepository.save(i2)).thenReturn(i2);
	        assertEquals(i2, service.updateInventory(i2));
	}
	
	@Test
	public void deleteInventoryTest() throws InventoryNotFoundException {
		
		Inventory i = new Inventory();
		
		i.setInventoryCode(1);
		i.setInventoryType("cutleries");
		i.setInventoryName("Spoons");
		i.setInventoryQuantity(100);
		
	       Optional<Inventory> inventory = Optional.of(i);
	       when(inventoryRepository.findById(1)).thenReturn(inventory);
			assertEquals("Inventory with the 1 Deleted Successfully!", service.deleteInventory(1));
	}	
}

