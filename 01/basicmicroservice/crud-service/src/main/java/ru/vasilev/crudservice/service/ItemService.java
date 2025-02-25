package ru.vasilev.crudservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.vasilev.crudservice.model.Item;
import ru.vasilev.crudservice.repository.ItemRepository;

@Service
public class ItemService {
	private ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public List<Item> findAll(){
		return itemRepository.findAll();
	}
	
	public Item findItemById(Long id) {
		return itemRepository.findById(id).orElse(null);
	}
	
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}
	
	public void deleteItem(Long id) {
		Item itemToDelete = itemRepository.findById(id).orElse(null);
		if(itemToDelete != null) {
			itemRepository.delete(itemToDelete);
		}
	}
}