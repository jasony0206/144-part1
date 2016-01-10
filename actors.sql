-- Create Actors table --
CREATE TABLE Actors (Name varchar(20), Movie varchar(80), Year int, Role varchar(40));

-- Load actors.csv into Actors table --
LOAD DATA LOCAL INFILE '~/data/actors.csv' INTO TABLE Actors FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"';

-- Query for "Give me the names of all the actors in the movie 'Die Another Day'." --
select Name from Actors where Movie = 'Die Another Day';

-- Drop Actors table --
DROP TABLE Actors;