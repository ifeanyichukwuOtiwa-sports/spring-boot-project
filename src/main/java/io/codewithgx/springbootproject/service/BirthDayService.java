package io.codewithgx.springbootproject.service;

import java.time.LocalDate;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 17/06/2022
 */

public interface BirthDayService {
    String getBirthDOW(LocalDate birthDay);
    String getChineseZodiac(LocalDate birthDay);
    String getStarSign(LocalDate birthDay);

    LocalDate getValidBirthday(String birthdayString);
}
