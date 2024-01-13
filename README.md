# AmadeusCaseStudy
Amadeus Travel To Future Program Case Study

4 Modules have been developed. 
These are:
-FlightAddScheduler
-FlightSearchAPIService
-RepositoryLib
-ServiceLib

**Some Importand Notes:**
- Server port is 50550
- Localhost postgresql database has been selected. "amadeus_flightsearchappdb_dev" database name is used. If there is no local postgresql, settings should be changed under properties file. 
- JPA has been used for database management. 
- Some mock data is provied for creating Airports under resources directory with 'airports.sql' file. But that should be run one time. Because, the table primary key is 3 char String id and all mock airports are real. 
- Instead of third party API service, i have developed random flight generator anside this service and that provides mock flight according to airports in database. Scheduler creates logs to standart output for received flights. Therefore, Scheduler App can add real flights using FlighSearchAPI itself.
- Scheduler is set to 1 am and it adds 1000 flights for next 10 days.


**User Names are passwords:**
-User Name: admin Password: password
-User Name: baris Password: 12345
-User Name: ber Password: 54321
