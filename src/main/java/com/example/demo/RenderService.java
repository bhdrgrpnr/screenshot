package com.example.demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class RenderService {


    private static String AlphaNumericString = "abcdefghijklmnoprstvywqxuz0123456789";


    public Response render(String url)  {

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver;
        driver = new ChromeDriver(options);
        driver.get(url);
        System.out.println("title is : " + driver.getTitle());

        String fileName = generateRandom(8) + ".jpg";
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File("/var/www/html/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.close();

        return new Response("http://159.89.27.130/" + fileName, file.getTotalSpace());
    }

    private String generateRandom(int n)
    {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

}
