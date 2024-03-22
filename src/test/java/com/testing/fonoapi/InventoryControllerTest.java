package com.testing.fonoapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.fonoapi.repositories.InventoryRepository;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class InventoryControllerTest {
    public static final int TOTAL_DEVICES = 9;
    public static final int TOTAL_INVENTORY = 9;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    void fetchAllDevices() throws Exception{
        MvcResult result = mockMvc.perform(get("/api/v1/inventory/devices")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn(); // Obtiene el resultado para su posterior análisis

        String contentAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Object> responseList = objectMapper.readValue(contentAsString, new TypeReference<>() {});
        assertThat(inventoryRepository.findAll()).hasSize(responseList.size());
        assertEquals(TOTAL_DEVICES, responseList.size());
    }

    @Test
    void fetchAllInventory() throws Exception{
        MvcResult result = mockMvc.perform(get("/api/v1/inventory")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn(); // Obtiene el resultado para su posterior análisis

        String contentAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Object> responseList = objectMapper.readValue(contentAsString, new TypeReference<>() {});
        assertThat(inventoryRepository.findAll()).hasSize(responseList.size());
        assertEquals(TOTAL_INVENTORY, responseList.size());
    }
}
