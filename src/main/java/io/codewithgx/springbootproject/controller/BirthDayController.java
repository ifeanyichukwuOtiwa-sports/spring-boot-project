package io.codewithgx.springbootproject.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codewithgx.springbootproject.service.BirthDayService;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 17/06/2022
 */

@RestController
@RequestMapping("/birthday")
public class BirthDayController {
    public final BirthDayService birthDayService;

    public BirthDayController(final BirthDayService birthDayService) {
        this.birthDayService = birthDayService;
    }

    @PostMapping("/dayOfWeek")
    public String getDayOfWeek(@RequestBody String birthdayString) {
        LocalDate birthday = birthDayService.getValidBirthday(birthdayString);
        return birthDayService.getBirthDOW(birthday);
    }

    @PostMapping("/chineseZodiac")
    public String getChineseZodiac(@RequestBody String birthdayString) {
        LocalDate birthday = birthDayService.getValidBirthday(birthdayString);
        return birthDayService.getChineseZodiac(birthday);
    }

    @PostMapping("/starSign")
    public String getStarSign(@RequestBody String birthdayString) {
        LocalDate birthday = birthDayService.getValidBirthday(birthdayString);
        return birthDayService.getStarSign(birthday);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
