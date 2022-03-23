CREATE TABLE IF NOT EXISTS User (
  id                     VARCHAR(60)  DEFAULT RANDOM_UUID() PRIMARY KEY,
  login                   VARCHAR      NOT NULL,
  firstname               VARCHAR      NOT NULL,
  lastname                VARCHAR      NOT NULL,
  mail                    VARCHAR      NOT NULL,
  description             VARCHAR      NOT NULL
);