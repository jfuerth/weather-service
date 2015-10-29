package net.bluecow.example.weather;

import net.bluecow.example.weather.wsdl.GetCityForecastByZIPResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(WeatherClient weatherClient) {
        return args -> {
            String zipCode = "12345";
            if (args.length > 0) {
                zipCode = args[0];
            }
            GetCityForecastByZIPResponse response = weatherClient.getCityForecastByZip(zipCode);
            weatherClient.printResponse(response);
        };
    }
}
