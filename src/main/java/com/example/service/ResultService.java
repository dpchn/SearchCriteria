package com.example.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.dao.ResultDao;
import com.example.model.Property;
import com.example.model.SearchQuery;

public class ResultService {

	
	/**
	 * Method to get result
	 * 
	 * @return
	 */
	public static JSONArray getResultList() {
		List<SearchQuery> listOfQuery = ResultDao.getListOfQuery();
		JSONArray listOfSearchResultWithPercentage = new JSONArray();
		System.out.println("------Matching properties----------------");
		for (SearchQuery query : listOfQuery) {
			List<Property> properties = ResultDao.getValidResult(query);
			for (Property property : properties) {
				double distancePercentage = calculateDistancePercentage(query, property);
				double bathPercentage = calculateBathroomPercentage(query, property);
				double bedPercentage = calculateBedroomPercentage(query, property);
				double budgetPercentage = calculateBudgetPercentage(query, property);
				
				
				
				double total = distancePercentage + bathPercentage + bedPercentage + budgetPercentage;
				
				total = Math.round(total * 100.0) / 100.0;
				JSONObject matchedProperty = new JSONObject();
				matchedProperty.put("id", property.getId());
				matchedProperty.put("price", property.getPrice());
				matchedProperty.put("latitude", property.getLatitude());
				matchedProperty.put("longitude", property.getLongitude());
				matchedProperty.put("no_of_bedroom", property.getBedroom());
				matchedProperty.put("no_of_bathroom", property.getBathroom());
				matchedProperty.put("percentage", total);
				listOfSearchResultWithPercentage.put(matchedProperty);
				System.out.println("id : "+property.getId());
				System.out.println("price : "+ property.getPrice());
				System.out.println("latitude : "+ property.getLatitude());
				System.out.println("longitude : "+ property.getLongitude());
				System.out.println("no_of_bedroom : "+ property.getBedroom());
				System.out.println("no_of_bathroom : "+ property.getBathroom());
				System.out.println("matching percentage : "+ total+"%");
				System.out.println("-----------------------");
			}
		}
		return listOfSearchResultWithPercentage;
	}

	//////////////////////////////////////////////////////////////////////
	/**
	 * Method used for custom data entered by user
	 * 
	 * @return
	 */
	public static JSONArray getResultList(SearchQuery query) {
		JSONArray listOfSearchResultWithPercentage = new JSONArray();
		List<Property> properties = ResultDao.getValidResult(query);
		for (Property property : properties) {
			double distancePercentage = calculateDistancePercentage(query, property);
			double bathPercentage = calculateBathroomPercentage(query, property);
			double bedPercentage = calculateBathroomPercentage(query, property);
			double budgetPercentage = calculateBudgetPercentage(query, property);
			System.out.println(distancePercentage);
			System.out.println(bathPercentage);
			System.out.println(bedPercentage);
			System.out.println(budgetPercentage);
			double total = distancePercentage + bathPercentage + bedPercentage + budgetPercentage;
			JSONObject matchedProperty = new JSONObject();
			matchedProperty.put("id", property.getId());
			matchedProperty.put("price", property.getPrice());
			matchedProperty.put("latitude", property.getLatitude());
			matchedProperty.put("longitude", property.getLongitude());
			matchedProperty.put("no_of_bedroom", property.getBedroom());
			matchedProperty.put("no_of_bathroom", property.getBathroom());
			matchedProperty.put("percentage", total);
			listOfSearchResultWithPercentage.put(matchedProperty);
		}
		return listOfSearchResultWithPercentage;
	}

	/////////////////////////////////////////////////////
	/**
	 * Method to calculate Bathroom Percentage
	 * 
	 * @param query
	 * @param property
	 * @return
	 */
	public static double calculateBathroomPercentage(SearchQuery query, Property property) {

		if (query.getMaxBathroom() > -1 && query.getMinBathroom() > -1) {
			if (property.getBathroom() >= query.getMinBathroom() && property.getBathroom() <= query.getMaxBathroom())
				return 20;
			else {
				int diff = 0;
				if (property.getBathroom() > query.getMaxBathroom()) {
					diff = property.getBathroom() - query.getMaxBathroom();
				} else
					diff = query.getMinBathroom() - property.getBathroom();
				diff = Math.abs(diff);
				double percantage = 20 - 20 * (diff) / 2;
				return percantage;
			}
		} else {
			int diff = 0;
			if (query.getMaxBathroom() > -1) {
				diff = property.getBathroom() - query.getMaxBathroom();
			} else
				diff = property.getBedroom() - query.getMinBathroom();
			double percantage = 20 - 20 * (diff) / 2;
			return percantage;
		}
	}

	/**
	 * Method to calculate Bedroom Percentage
	 * 
	 * @param query
	 * @param property
	 * @return
	 */
	public static double calculateBedroomPercentage(SearchQuery query, Property property) {

		if (query.getMaxBedroom() > -1 && query.getMinBedroom() > -1) {
			if (property.getBedroom() >= query.getMinBedroom() && property.getBedroom() <= query.getMaxBedroom())
				return 20;
			else {
				int diff = 0;
				if (property.getBedroom() > query.getMaxBedroom()) {
					diff = property.getBedroom() - query.getMaxBedroom();
				} else
					diff = query.getMinBedroom() - property.getBedroom();
				diff = Math.abs(diff);
				double percantage = 20 - 20 * (diff) / 2;
				return percantage;
			}
		} else {
			int diff = 0;
			if (query.getMaxBedroom() >= 0) {
				diff = property.getBedroom() - query.getMaxBedroom();
			} else
				diff = property.getBedroom() - query.getMinBedroom();
			diff = Math.abs(diff);
			double percantage = 20 - 20 * (diff) / 2;
			return percantage;
		}
	}

	/**
	 * Method to calculate Distance percentage
	 * 
	 * @param query
	 * @param property
	 * @return
	 */
	public static double calculateDistancePercentage(SearchQuery query, Property property) {

		double longitude = property.getLongitude();
		double latitude = property.getLatitude();
		double userLng = query.getLongitude();
		double userLat = query.getLatitude();

		double distanceBetweenPropertyAndUser = calculateDistanceInMile(userLat, userLng, latitude, longitude);

		if (distanceBetweenPropertyAndUser <= 2)
			return 30;
		else {
			double diff = distanceBetweenPropertyAndUser - 2;
			return 30 - (diff) * 30 / 9;
		}
	}

	/**
	 * Method to calculate distance between two points using lat lang
	 * 
	 * @param userLat
	 * @param userLng
	 * @param venueLat
	 * @param venueLng
	 * @return
	 */
	public static double calculateDistanceInMile(double userLat, double userLng, double venueLat, double venueLng) {
		final double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
		double latDistance = Math.toRadians(userLat - venueLat);
		double lngDistance = Math.toRadians(userLng - venueLng);

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(userLat))
				* Math.cos(Math.toRadians(venueLat)) * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c)); // Converted into mile
	}

	/**
	 * Method to calculate percentage of budget
	 * 
	 * @param query
	 * @param property
	 * @return
	 */
	public static double calculateBudgetPercentage(SearchQuery query, Property property) {

		double propertyPrice = property.getPrice();
		if (query.getMinBudget() > -1 && query.getMaxBudget() > -1) {
			if (propertyPrice >= query.getMinBudget() && propertyPrice <= query.getMaxBudget())
				return 30;
			else {
				double diff = 0;
				double twentyFivePercentOfBudget = 0;
				if (propertyPrice > query.getMaxBudget()) {
					diff = propertyPrice - query.getMaxBudget();
					twentyFivePercentOfBudget = 25 * query.getMaxBudget() / 100;
				} else {
					diff = query.getMinBudget() - propertyPrice;
					twentyFivePercentOfBudget = 25 * query.getMinBudget() / 100;
				}
				return 30 - diff * 30 / twentyFivePercentOfBudget;
			}
		} else {
			double budget = 0;
			double twentyFivePercentOfBudget = 0;
			if (query.getMinBudget() >= 0)
				budget = query.getMinBudget();
			else
				budget = query.getMaxBudget();
			double min = budget - 10 * budget / 100;
			double max = budget + 10 * budget / 100;
			if (propertyPrice >= min && propertyPrice <= max)
				return 30;
			else {
				double diff = 0;
				if (propertyPrice > max) {
					diff = propertyPrice - max;
					twentyFivePercentOfBudget = 25 * max / 100;
				} else {
					diff = propertyPrice;
					twentyFivePercentOfBudget = 25 * min / 100;
				}
				return 30 - diff * 30 / twentyFivePercentOfBudget;
			}
		}

	}

}
