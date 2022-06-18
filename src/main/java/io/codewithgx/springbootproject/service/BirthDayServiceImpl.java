package io.codewithgx.springbootproject.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 17/06/2022
 */

@Service
public class BirthDayServiceImpl implements BirthDayService {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final Map<Integer, String> map;
    static {
        map = new HashMap<>();
        map.put(0, "Monkey");
        map.put(1, "Rooster");
        map.put(2, "Dog");
        map.put(3, "Pig");
        map.put(4, "Rat");
        map.put(5, "Ox");
        map.put(6, "Tiger");
        map.put(7, "Rabbit");
        map.put(8, "Dragon");
        map.put(9, "Snake");
        map.put(10, "Horse");
        map.put(11, "Sheep");
    }

    @Override
    public String getBirthDOW(final LocalDate birthDay) {
        return birthDay.getDayOfWeek().toString();
    }

    @Override
    public String getChineseZodiac(final LocalDate birthDay) {
        int year = birthDay.getYear();
        return map.getOrDefault(year % 12, "");
    }

    @Override
    public String getStarSign(final LocalDate birthDay) {
        int day = birthDay.getDayOfMonth();
        int month = birthDay.getMonthValue();

        if ((month == 12 && day >= 22) || (month == 1 && day < 20))
            return "Capricorn";
        else if ((month == 1 && day >= 20) || (month == 2 && day < 19))
            return "Aquarius";
        else if ((month == 2 && day >= 19) || (month == 3 && day < 21))
            return "Pisces";
        else if (month == 3 && day >= 21 || month == 4 && day < 20)
            return "Aries";
        else if (month == 4 && day >= 20 || month == 5 && day < 21)
            return "taurus";
        else if (month == 5 && day >= 21 || month == 6 && day < 21)
            return "Gemini";
        else if (month == 6 && day >= 21 || month == 7 && day < 23)
            return "Cancer";
        else if (month == 7 && day >= 23 || month == 8 && day < 23)
            return "Leo";
        else if (month == 8 && day >= 23 || month == 9 && day < 23)
            return "Virgo";
        else if (month == 9 && day >= 23 || month == 10 && day < 23)
            return "Libra";
        else if (month == 10 && day >= 23 || month == 11 && day < 22)
            return "Scorpio";
        else return "Sagittarius";
    }

    @Override
    public LocalDate getValidBirthday(final String birthdayString) {
        if (birthdayString == null) {
            throw new RuntimeException("birthday is null");
        }
        try {
            return LocalDate.parse(birthdayString, FORMATTER);
        } catch (Exception e) {
            throw new RuntimeException("Must include valid birthday in yyyy-MM-dd format");
        }
    }
}
