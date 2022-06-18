package io.codewithgx.springbootproject.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BirthDayServiceImpl.class)
class BirthDayServiceTest {

    @Autowired
    BirthDayService birthDayService;

    @Test
    void hetBirthDOW() {
        String dateOfBirth = birthDayService.getBirthDOW(LocalDate.of(1979, 7, 14));
        assertThat(dateOfBirth).isEqualTo("SATURDAY");
    }

    @Test
    void getChineseZodiac() {
        String dow = birthDayService.getChineseZodiac(LocalDate.of(1979, 7, 14));
        assertThat(dow).isEqualTo("Sheep");
    }

    @Test
    void getStarSign() {
        String dow = birthDayService.getStarSign(LocalDate.of(1979, 7, 14));
        assertThat(dow).isEqualTo("Cancer");
    }

    @Test
    void getValidBirthday() {
        LocalDate dow = birthDayService.getValidBirthday("1979-07-14");
        assertThat(dow).isEqualTo(LocalDate.of(1979, 7, 14));
    }
}