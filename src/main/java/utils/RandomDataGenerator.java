package utils;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

    public static Faker faker = new Faker();

    public static String getRandomDataFor(RandomDataTypeNames dataTypesNames) {
        return switch (dataTypesNames) {
            case FIRSTNAME -> faker.name().firstName();
            case LASTNAME -> faker.name().lastName();
            case FULLNAME -> faker.name().fullName();
            case COUNTRY -> faker.address().country();
            case CITYNAME -> faker.address().cityName();
            default -> "Data type name not available";
        };
    }

    public static String getRandomNumber(int count) {
        return faker.number().digits(count);
    }

    public static int getRandomNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    public static String getRandomAlphabets(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public static String getRandomWebsiteName() {
        return "https://" + RandomDataGenerator.getRandomAlphabets(10) + ".com";
    }
}
