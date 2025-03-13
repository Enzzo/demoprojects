package ru.vasilev.librarysystem.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import ru.vasilev.librarysystem.model.Book;
import ru.vasilev.librarysystem.restcontroller.BookRestController;
import ru.vasilev.librarysystem.service.BookService;

@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private BookService bookService;
	
	@Test
	public void shouldReturnListOfBooks() throws Exception{
		when(bookService.findAll()).thenReturn(Collections.singletonList(new Book()));
		mockMvc.perform(get("/v1/api/books"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray());
	}
}
