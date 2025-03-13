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

import ru.vasilev.librarysystem.model.Author;
import ru.vasilev.librarysystem.restcontroller.AuthorRestController;
import ru.vasilev.librarysystem.service.AuthorService;

@WebMvcTest(AuthorRestController.class)
public class AuthorRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private AuthorService authorService;
	
	@Test
	public void shouldReturnListOfAuthors() throws Exception{
		when(authorService.findAll()).thenReturn(Collections.singletonList(new Author()));
		mockMvc.perform(get("/v1/api/authors"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray());
	}
}
