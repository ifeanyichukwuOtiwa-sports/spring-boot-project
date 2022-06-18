package io.codewithgx.springbootproject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import io.codewithgx.springbootproject.controller.BirthDayController;


@AutoConfigureMockMvc
@WebMvcTest
@ContextConfiguration(classes = {BirthDayController.class, BirthDayServiceImpl.class})
class BirthDayServiceIntegrationTest {
    String bd1 = LocalDate.of(1979, 7, 14).format(DateTimeFormatter.ISO_DATE);
    String bd2 = LocalDate.of(2018, 1, 23).format(DateTimeFormatter.ISO_DATE);
    String bd3 = LocalDate.of(1972, 3, 17).format(DateTimeFormatter.ISO_DATE);
    String bd4 = LocalDate.of(1945, 12, 2).format(DateTimeFormatter.ISO_DATE);
    String bd5 = LocalDate.of(2003, 8, 4).format(DateTimeFormatter.ISO_DATE);


    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetBirthDayDOW_should_return_a_valid_day() throws Exception {
        testDOW(bd1, "SATURDAY");
    }


    private void testDOW(final String birthday, final String dayOfWeek) throws Exception {
        String url = "/birthday/dayOfWeek";
        MvcResult result = getMvcResult(url, birthday);

        String resultDOW = result.getResponse().getContentAsString();
        assertThat(resultDOW).isNotNull();
        assertThat(resultDOW).isEqualTo(dayOfWeek);
    }

    private MvcResult getMvcResult(final String url, final String birthday) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .content(birthday)
                        .contentType(MediaType.TEXT_PLAIN)
                        .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andReturn();
    }
}