package com.mindtree.Doctor.Test;

 
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.Doctor.Controller.DoctorController;
import com.mindtree.Doctor.Entity.Doctor;
import com.mindtree.Doctor.Repository.DoctorRepo;
import com.mindtree.Doctor.Service.DoctorService;

 
 
 
 

@WebMvcTest(DoctorController.class)
public class DoctorsTest {
	
	@MockBean
	  private DoctorRepo doctorRepo;
	  
	  @MockBean
	  private DoctorService doctorService;

	  @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;

	

	  @Test
	  void shouldReturnDoctor() throws Exception {
	    int id=3;
	    @SuppressWarnings("unused")
		String name="DR sravani";
	    Doctor doctor=new Doctor();

	    when(doctorRepo.findById((long) id)).thenReturn(Optional.of(doctor));
	    mockMvc.perform(get("/doctors/{id}", id)).andExpect(status().isOk())
	        .andDo(print());
	  }
	  @Test
	  void shouldCreateDoctor() throws Exception {
	    Doctor doctor=new Doctor();

	    mockMvc.perform(post("/doctors").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(doctor)))
	        .andExpect(status().isOk())
	        .andDo(print());
	  }
	  


	  @Test
	  void shouldReturnListOfDoctors() throws Exception {
	    List<Doctor> doctors = new ArrayList<>(
	        Arrays.asList(new Doctor(),
	            new Doctor(),
	            new Doctor()));

	    when(doctorRepo.findAll()).thenReturn(doctors);
	    mockMvc.perform(get("/doctors/"))
	        .andExpect(status().isOk())
	              .andDo(print());
	  }
}
