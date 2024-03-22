package com.testing.fonoapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.testing.fonoapi.domain.requests.CreateReqRequest;
import com.testing.fonoapi.repositories.RequirementRepository;
import com.testing.fonoapi.repositories.RequirementTypeRepository;
import jakarta.transaction.Transactional;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class RequirementControllerTest {
    public static final int TOTAL_REQ_TYPES = 2;
    private static final int TOTAL_REQUIREMENTS = 5;
    public static final int NEW_REQUIREMENT_REQ_ID = 6;
    public static final int NEW_REQUIREMENT_DEVICE_ID = 9;
    public static final String NEW_REQUIREMENT_REQ_TYPE = "BOOKING";
    public static final boolean NEW_REQUIREMENT_AVAILABLE = false;
    public static final int NEW_REQUIREMENT_USER_ID = 10;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RequirementRepository requirementRepository;
    @Autowired
    private RequirementTypeRepository requirementTypeRepository;

    @Test
    void fetchAllReqTypes() throws Exception{
        MvcResult result = mockMvc.perform(get("/api/v1/req/types")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn(); // Obtiene el resultado para su posterior análisis

        String contentAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Object> responseList = objectMapper.readValue(contentAsString, new TypeReference<>() {});
        assertThat(requirementTypeRepository.findAll()).hasSize(responseList.size());
        assertEquals(TOTAL_REQ_TYPES, responseList.size());
    }

    @Test
    void fetchAllReq() throws Exception{
        MvcResult result = mockMvc.perform(get("/api/v1/req")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn(); // Obtiene el resultado para su posterior análisis

        String contentAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Object> responseList = objectMapper.readValue(contentAsString, new TypeReference<>() {});
        assertThat(requirementRepository.findAll()).hasSize(responseList.size());
        assertEquals(TOTAL_REQUIREMENTS, responseList.size());
    }

    @Test
    @Transactional
    void addRequirementTest() throws Exception {
        CreateReqRequest createReqRequest = new CreateReqRequest("elena@example.com","BOOKING","Nokia 3310");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mockMvc.perform(post("/api/v1/req")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(createReqRequest))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.reqId" , is(NEW_REQUIREMENT_REQ_ID)))
                .andExpect(jsonPath("$.device.deviceId", is(NEW_REQUIREMENT_DEVICE_ID)))
                .andExpect(jsonPath("$.service", is(NEW_REQUIREMENT_REQ_TYPE)))
                .andExpect(jsonPath("$.available" , is(NEW_REQUIREMENT_AVAILABLE)))
                .andExpect(jsonPath("$.user.userId" , is(NEW_REQUIREMENT_USER_ID)));

        mockMvc.perform(delete("/api/v1/req/".concat(String.valueOf(NEW_REQUIREMENT_REQ_ID))))
                .andExpect(status().isNoContent());
        assertThat(requirementRepository.findAll()).hasSize(TOTAL_REQUIREMENTS);
    }
}
