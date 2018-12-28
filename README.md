# SearchCriteria



Design Algorithm 

getResultList(Query query){

  START
     1. List<Property> data = ProperfetchValidData(query)
     2 . List<Map<String, Object >> result = new ArrayList()
     3.  For i = 0 to length(data) :
         a. distancePercentage = calculateDistancePercentage(query, data.get(i))
         b. budgetPercentage = calculateBudgetPercentage(query, data.get(i))
         c. bedroomPercentage = calculateBedroomPercentage(query, data.get(i))
         d. bathroomPercentage = calculateBathroomPercentage(query, data.get(i))
         e. totalPercentage = distancePercentage + budgetPercentage + bedroomPercentage + bathroomPercentage
         f. If totalPercentage >=40 :
            Add that property with percentage in result
         Got step 3 again
      Return result
  END
}


fetchValidData(Query query){

  START
    1. minBudget = query.budget - 25% of query.budget
    2. maxBudget = query.budget + 25% of query.budget
    3. minBedroom = query.bedroom - 2
    4. maxBedroom = query.bedroom + 2
    5. minBathroom = query.bathroom -2
    6. maxBathroom = query.bathroom +2
    7. Sql = SELECT * from [table_name] WHERE query.budget BETWEEN minBudget AND maxBudget AND query.bedroom BETWEEN                minBedroom AND maxBedroom AND Query.bathroom BETWEEN minBathroom AND maxBathroom
    8. List<Property> properties = processQuery(sql)
    9. List<Property> validList = new ArrayList<>()
    10. for i = 0  to length(properties) :
          a. Longitude1 = query.Longitude
          b. Latitude1 = query.Latitude
          c. Longitude2 = properties.get(i).Longitude
          d. Latitude2 = properties.get(i).Latitude
          e. Convert all longitude and latitude in x and y coordinates
          f. Find distance between two points  distance = SquareRoot( (x2 - x1)^2 + (y2 - y1)^2 )
          g. Convert distance in mile distance = distance * 0.621371
          h. If distance <= 10:
              Add properties.get(i) to validList
           Got Step 10                                         
    11. Return validList
  END
}


calculateDistancePercentage(Query query, Property property){

  START
    1. longitude = property.longitude
    2. latitude = property.latitud
    3. Convert longitude and latitude of property and querylocation in miles 
    4. distanceBetweenPropertyLocationAndQueryLocatoin = Squareroot( (property.x - longitutde.x)^2 +(property.y -                 latitude.y)^2)
    5. If ldistanceBetweenPropertyLocationAndQueryLocatoin <= 2 then:
          Return 30  
    6. Else :
         a. distanceBetweenPropertyLocationAndQueryLocatoinc = Squareroot( (property.y - latitude value in y
            coordinate)^2 +(property.x - longitutde value in x coordinate)^2)
         b. diffDistance = distanceBetweenPropertyLocationAndQueryLocatoinc - 2
         c. percentage  = 30 - (diffDistance) * 30/9Click Here to see Picture
         d. Return percentage
  END
}



calculateBudgetPercentage(Query query, Property property){

  START
    1. If query have min and max value of budget then :
        a. If property.price within min and max of budget then :
              Return 30
        b. Else :
            percentage  = [FORMULAE REQUIRE FOR calculate percentage]
            Return percentage
    2. Else :
        a. If property.price within (10% of query.budget + query.budget) and (query.budget - 10% of query.budget) then :
            Return 30
        b. Else :
            percentage  = [FORMULAE REQUIRE FOR calculate percentage]
            Return percentage
  END
}


calculateBedroomPercentage(Query query, Property property){

  START
    1. If query have min and max value of bedroom then :
         a. If property.bedroom within min and max of bedroom then :
              Return 20
         b. Else :
              percentage  = 20 - 20 * ( |query.bedroom - property.bedroom| ) / 2
              Return percentage
    2. Else :
      percentage  = 20 - 20 * ( |query.bedroom - property.bedroom| ) / 2
      Return percentage
  END
}








calculateBathroomPercentage(Query query, Property property){

  START
    1. If query have min and max value of bathroom then :
        a. If property.bathroom within min and max of bathroom then :
              Return 20
        b. Else :
            percentage  = 20 - 20 * ( |query.bathroom - property.bathroom| ) / 2
            Return percentage
    2. Else :
        percentage  = 20 - 20 * ( |query.bathroom - property.bathroom| ) / 2
        Return percentage
  END
}



Note :
x and y is coordinates 
        	WHERE 	
                Longitutde -> x
                latitude - > y
Please ask if any query you have

