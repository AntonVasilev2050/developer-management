CREATE TABLE developers (
    developerId serial PRIMARY KEY,
    name varchar(50),
    specialty varchar(50),
    salary int
);

CREATE TABLE languages (
    languageId serial PRIMARY KEY,
    language varchar(30)
);

CREATE TABLE developers_languages (
    developerId int not null,
    languageId int not null,
    FOREIGN KEY (developerId) REFERENCES developers(developerId),
    FOREIGN KEY (languageId) REFERENCES languages(languageId)
);

INSERT INTO developers VALUES (1, 'Peter', 'C++', 2000),
                              (2, 'AsyaSmile', 'UI/UX', 3000),
                              (3, 'Dmitrii', 'Java', 4000);



INSERT INTO languages VALUES (1, 'Russian'),
                             (2, 'Belarus'),
                             (3, 'English');

INSERT INTO developers_languages VALUES (1, 1),
                                        (1, 3),
                                        (2, 1),
                                        (3, 1),
                                        (3, 2);
