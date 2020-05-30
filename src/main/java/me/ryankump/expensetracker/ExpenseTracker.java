package me.ryankump.expensetracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpenseTracker {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ExpenseTracker.class, args);
	}

	public static void fetchData() throws IOException {
		final String GAINS_URL = "https://www.reddit.com/r/AskReddit/";
		
		URL url = new URL(GAINS_URL);
		
		URLConnection urlConnection = url.openConnection();
		
		InputStreamReader inputStream = new InputStreamReader(urlConnection.getInputStream());
		
		BufferedReader bufferedReader = new BufferedReader(inputStream);
		
		String line = bufferedReader.readLine();
		
		while(line != null) {
			System.out.println(line);
			line = bufferedReader.readLine();
		}
		
		
	}
	
}
