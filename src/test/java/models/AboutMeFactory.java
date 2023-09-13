package models;

import com.github.javafaker.Faker;

public class AboutMeFactory {

    static Faker faker = new Faker();

    public static AboutMe get() {
        return AboutMe.builder()

                .enteredText(faker.country().countryCode2())
                .textLanguage(faker.chuckNorris().fact())

                .build();






    }
}