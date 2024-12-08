CREATE TABLE household (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           eircode VARCHAR(8) UNIQUE NOT NULL,
                           number_of_occupants INT NOT NULL,
                           max_number_of_occupants INT NOT NULL,
                           owner_occupied BIT NOT NULL
);

CREATE TABLE pets (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      animal_type VARCHAR(255) NOT NULL,
                      breed VARCHAR(255) NOT NULL,
                      household_id BIGINT NOT NULL,
                      age INT NOT NULL,
                      FOREIGN KEY (household_id) REFERENCES household(id) ON DELETE CASCADE
);