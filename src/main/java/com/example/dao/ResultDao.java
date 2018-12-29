package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.example.config.BuildFactory;
import com.example.model.Property;
import com.example.model.SearchQuery;
import com.example.service.ResultService;

public class ResultDao {

	public static List<SearchQuery> getListOfQuery() {
		Session session = BuildFactory.getSessionFactory().openSession();
		List<SearchQuery> list = session.createCriteria(SearchQuery.class).list();
		session.close();
		return list;
	}

	public static List<Property> getValidResult(SearchQuery query) {

		int minBedroom = 0;
		int maxBedroom = 0;
		int minBathroom = 0;
		int maxBathroom = 0;
		double minBudget = 0;
		double maxBudget = 0;

		if (query.getMinBudget() != 0 && query.getMaxBudget() != 0) {
			minBudget = query.getMinBudget() - 25 * (query.getMinBudget()) / 100;
			maxBudget = query.getMaxBudget() + 25 * (query.getMaxBudget()) / 100;
		} else if (query.getMinBudget() != 0) {
			minBudget = query.getMinBudget() - 25 * (query.getMinBudget()) / 100;
			maxBudget = query.getMinBudget() + 25 * (query.getMinBudget()) / 100;
		} else {
			minBudget = query.getMaxBudget() - 25 * (query.getMaxBudget()) / 100;
			maxBudget = query.getMaxBudget() + 25 * (query.getMaxBudget()) / 100;
		}

		if (query.getMinBathroom() != 0 && query.getMaxBathroom() != 0) {
			minBathroom = query.getMinBathroom() - 25 * (query.getMinBathroom()) / 100;
			maxBathroom = query.getMaxBathroom() + 25 * (query.getMaxBathroom()) / 100;
		} else if (query.getMinBathroom() != 0) {
			minBathroom = query.getMinBathroom() - 25 * (query.getMinBathroom()) / 100;
			maxBathroom = query.getMinBathroom() + 25 * (query.getMinBathroom()) / 100;
		} else {
			minBathroom = query.getMaxBathroom() - 25 * (query.getMaxBathroom()) / 100;
			maxBathroom = query.getMaxBathroom() + 25 * (query.getMaxBathroom()) / 100;
		}

		if (query.getMinBedroom() != 0 && query.getMaxBedroom() != 0) {
			minBedroom = query.getMinBedroom() - 25 * (query.getMinBedroom()) / 100;
			maxBedroom = query.getMaxBedroom() + 25 * (query.getMaxBedroom()) / 100;
		} else if (query.getMinBedroom() != 0) {
			minBedroom = query.getMinBedroom() - 25 * (query.getMinBedroom()) / 100;
			maxBedroom = query.getMinBedroom() + 25 * (query.getMinBedroom()) / 100;
		} else {
			minBedroom = query.getMaxBedroom() - 25 * (query.getMaxBedroom()) / 100;
			maxBedroom = query.getMaxBedroom() + 25 * (query.getMaxBedroom()) / 100;
		}

		Session session = BuildFactory.getSessionFactory().openSession();
		String sql = "from com.example.model.Property where price BETWEEN " + minBudget + " AND " + maxBudget
				+ " AND bedroom BETWEEN " + minBedroom + " AND " + maxBedroom + " AND bathroom BETWEEN " + minBathroom
				+ " AND " + maxBathroom;

		List<Property> properties = (List<Property>) session.createQuery(sql).list();
		List<Property> validResult = new ArrayList<Property>();
		for (Property property : properties) {
			double distanceInMile = ResultService.calculateDistanceInMile(query.getLatitude(), query.getLongitude(),
					property.getLatitude(), property.getLongitude());
			if (distanceInMile < 10)
				validResult.add(property);
		}
		return validResult;
	}

}
