package com.example.demo;

import com.example.demo.dao.Role_DAO;
import com.example.demo.dto.Role_DTO;
import com.example.demo.model.Role;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;


@WebMvcTest
class RoleServiceApplicationTests {

	@Autowired
	MockMvc mockMVC;

	@MockBean
	Role_DAO role_repository;


	@Test
	void contextLoads() throws Exception {
		when(role_repository.findAll()).thenReturn(Collections.emptyList());
		MvcResult mvcResult= mockMVC.perform(MockMvcRequestBuilders.get("/Roles/getAllRoles").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());
		verify(role_repository).findAll();
	}
}
