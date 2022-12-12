package com.inventory.service;

import java.util.List;

import com.inventory.exception.InventoryNotFoundException;
import com.inventory.model.Inventory;

public interface InventoryService {
	public List<Inventory> showAllInventoryDetails() throws InventoryNotFoundException;
	public Inventory showInventoryById(int id) throws InventoryNotFoundException;;
	public Inventory addInventory(Inventory inventory) throws InventoryNotFoundException;
	public Inventory updateInventory(Inventory inventory) throws InventoryNotFoundException;
	public String deleteInventory(int id) throws InventoryNotFoundException;
}

