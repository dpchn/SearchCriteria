# SearchCriteria



Design Algorithm 

# getResultList(Query query)

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



# fetchValidData(Query query)

    1. minBudget = query.budget - 25% of query.budget
    2. maxBudget = query.budget + 25% of query.budget
    3. minBedroom = query.bedroom - 2
    4. maxBedroom = query.bedroom + 2
    5. minBathroom = query.bathroom -2
    6. maxBathroom = query.bathroom +2
    7. Sql = SELECT * from [table_name] WHERE query.budget BETWEEN minBudget AND maxBudget AND query.bedroom BETWEEN minBedroom AND maxBedroom AND Query.bathroom BETWEEN minBathroom AND maxBathroom
    8. List<Property> properties = processQuery(sql)
    9. List<Property> validList = new ArrayList<>()
    10. for i = 0  to length(properties) :  
          a. Find distance between two points (query.location and property.location)
          b. If distance <= 10:
              Add properties.get(i) to validList
           Got Step 10                                         
    11. Return validList


# calculateDistancePercentage(Query query, Property property)

    1. longitude = property.longitude
    2. latitude = property.latitud
    3. Convert longitude and latitude of property and querylocation in miles 
    4. distanceBetweenPropertyLocationAndQueryLocatoin = Squareroot( (property.x - longitutde.x)^2 +(property.y -                 latitude.y)^2)
    5. If ldistanceBetweenPropertyLocationAndQueryLocatoin <= 2 then:
          Return 30  
    6. Else :
         a. distanceBetweenPropertyLocationAndQueryLocatoinc = Calculate distance between property.location and query.location
         b. diffDistance = distanceBetweenPropertyLocationAndQueryLocatoinc - 2
         c. percentage  = 30 - (diffDistance) * 30/9
         d. Return percentage




# calculateBudgetPercentage(Query query, Property property)

    1. If query have min and max value of budget then :
        a. If property.price within min and max of budget then :
              Return 30
        b. Else :
            percentage  = 30 - diff * 30 / (Calculate 25% of min or max budget)
            Return percentage
    2. Else :
        a. If property.price within (10% of query.budget + query.budget) and (query.budget - 10% of query.budget) then :
            Return 30
        b. Else :
            i. minBudget  = budget - calculate 10% of budget
            ii. maxBudget  = budget + calculate 10% of budget
            percentage  = 30 - diff * 30 / (Calculate 25% of minBudget or maxBudget)
            Return percentage
            
           

# calculateBedroomPercentage(Query query, Property property)

    1. If query have min and max value of bedroom then :
         a. If property.bedroom within min and max of bedroom then :
              Return 20
         b. Else :
              percentage  = 20 - 20 * ( |query.bedroom - property.bedroom| ) / 2
              Return percentage
    2. Else :
      percentage  = 20 - 20 * ( |query.bedroom - property.bedroom| ) / 2
      Return percentage









# calculateBathroomPercentage(Query query, Property property)

    1. If query have min and max value of bathroom then :
        a. If property.bathroom within min and max of bathroom then :
              Return 20
        b. Else :
            percentage  = 20 - 20 * ( |query.bathroom - property.bathroom| ) / 2
            Return percentage
    2. Else :
        percentage  = 20 - 20 * ( |query.bathroom - property.bathroom| ) / 2
        Return percentage


## Refer this below link for more understanding
https://drive.google.com/file/d/1--8zbfxcbQ1hMX8UO0H_XP7fhrbB79N1/view?usp=sharing




### How to run projet
1. clone project
2. Build project using maven
3. Import db data in your local machine, make sure you have mysql
4. Configure credential of mysql in hibernate.config.xml

