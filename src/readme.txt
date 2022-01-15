CREATE TABLE developers (
    developerId serial PRIMARY KEY,
    name varchar(50),
    specialty varchar(50),
    salary int
);

CREATE TABLE locations (
    locationId serial PRIMARY KEY,
    country varchar(30),
    city varchar(30)
);

CREATE TABLE developers_locations (
    developerId int not null,
    locationId int not null,
    FOREIGN KEY (developerId) REFERENCES developers(developerId),
    FOREIGN KEY (locationId) REFERENCES locations(locationId)
);