# fujitsu2023_recr
Fujitsu Estonia 2023 recruitment exercise.

## Used stack
The project is being built on Maven+Spring stack, code
syntax level is Java v17. H2 database engine is being used.
It is highly suggested that the default configuration
(especially for the database) is being changed (located 
in **application.yml** file in service folder).

## Current state
The project creates an H2 database and
fetches weather data from the weather service of Estonian
Environment Agency.

The Weather data gets fetched from
https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php.
The cron job is scheduled to pull the latest weather data
at the 15th minute of every hour.

It is possible to get data from the API server. When
sending a GET-request to address http://localhost:8080/api/v1/weather,
the list of latest weather data pulls is being shown. The amount
of shown weather observations shown is determined by
the amount of weather stations in the database. In most
cases it should ensure that the latest observations from
all the stations we have inserted are being listed.
