package com.example.app;

import java.util.Scanner;

import com.example.model.SearchQuery;
import com.example.service.ResultService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. for custoom data enter for testing");
		System.out.println("2. Use db data for testing");
		System.out.println("Enter your choice : ");
		int ch = scanner.nextInt();
		switch (ch) {
		case 1:
			System.out.println(ResultService.getResultList());
			break;
		case 2:
			System.out.println("Enter latitude : ");
			double latitude = scanner.nextDouble();
			System.out.println("Enter longitude : ");
			double longitude = scanner.nextDouble();
			System.out.println("Enter minBudget : ");
			double minBudget = scanner.nextDouble();
			System.out.println("Enter maxBudget : ");
			double maxBudget = scanner.nextDouble();

			System.out.println("Enter min bedroom : ");
			int minBedroom = scanner.nextInt();
			System.out.println("Enter maxBedroom : ");
			int maxBedroom = scanner.nextInt();
			System.out.println("Enter minBathroom : ");
			int minBathroom = scanner.nextInt();
			System.out.println("Enter maxBathroom : ");
			int maxBathroom = scanner.nextInt();

			SearchQuery query = new SearchQuery();
			query.setMinBudget(minBudget);
			query.setMaxBudget(maxBudget);
			query.setLatitude(latitude);
			query.setLongitude(longitude);
			query.setMaxBathroom(maxBathroom);
			query.setMinBathroom(minBathroom);
			query.setMinBedroom(minBedroom);
			query.setMaxBedroom(maxBedroom);

			System.out.println(ResultService.getResultList(query));
		}
	}
}
