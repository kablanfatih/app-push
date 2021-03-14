package com.kablanfatih.company.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kablanfatih.company.service.CompanyService;
import com.kablanfatih.company.util.TPage;
import com.kablanfatih.servicecommon.contract.CompanyDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class CompanyControllerTest {

    private final static String CONTENT_TYPE = "application/json";

    @InjectMocks
    CompanyController controller;
    @Mock
    private CompanyService service;
    @Mock
    private CompanyDto companyDto;
    @Mock
    private CompanyDto companyDto2;
    @Mock
    private ObjectMapper objectMapper;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
        objectMapper = new ObjectMapper();
        companyDto = CompanyDto.builder().name("Test").address("ist").appId("123d").build();
        companyDto2 = CompanyDto.builder().name("Test2").address("İzmir").appId("appId2").build();
    }

    @Test
    public void saveTest() throws Exception {

        mockMvc.perform(post("/api/company")
                .contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsString(companyDto))).andExpect(status().isOk());

        ArgumentCaptor<CompanyDto> captor = ArgumentCaptor.forClass(CompanyDto.class);
        verify(service, times(1)).save(captor.capture());
        assertThat(captor.getValue().getName()).isEqualTo("Test");
        assertThat(captor.getValue().getAddress()).isEqualTo("ist");
    }

    @Test
    public void getByIdTest() throws Exception {

        when(service.getById(1L)).thenReturn(companyDto);
        MvcResult mvcResult = mockMvc.perform(get("/api/company/1").accept(CONTENT_TYPE)).andReturn();

        String resBody = mvcResult.getResponse().getContentAsString();
        verify(service, times(1)).getById(1L);
        assertThat(objectMapper.writeValueAsString(companyDto))
                .isEqualToIgnoringWhitespace(resBody);
        System.out.println(objectMapper.writeValueAsString(companyDto));
    }

    @Test
    public void getAllByPaginationTest() throws Exception {
        PageRequest pageRequest = PageRequest.of(1, 10);
        List<CompanyDto> data = Arrays.asList(companyDto, companyDto2);
        Page<CompanyDto> page = new PageImpl<>(data);
        TPage<CompanyDto> pages1 = new TPage<>();
        pages1.setStat(page, data);
        when(service.getAllPageable(pageRequest)).thenReturn(pages1);

        mockMvc.perform(get("/api/company?page=1&size=10"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.totalPages", is(1)))
                .andExpect(jsonPath("$.totalElements", is(2)))
                .andExpect(jsonPath("$.content[0].name", is("Test")))
                .andExpect(jsonPath("$.content[1].name", is("Test2")));
    }

    @Test
    public void updateTest() throws Exception {

        when(service.update(1L, companyDto2)).thenReturn(companyDto2);
        mockMvc.perform(put("/api/company/1").contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsString(companyDto2))).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Test2")))
                .andExpect(jsonPath("$.address", is("İzmir")))
                .andExpect(jsonPath("$.appId", is("appId2")));

    }

    @Test
    public void deleteTest() throws Exception {

        when(service.delete(1L)).thenReturn(Boolean.TRUE);
        MvcResult mvcResult = mockMvc.perform(delete("/api/company/1").contentType(CONTENT_TYPE))
                .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("true");

    }
}
