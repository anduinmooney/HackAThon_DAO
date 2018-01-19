SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS teams (
  id int PRIMARY KEY auto_increment,
  hackTeamName VARCHAR,
  hackTeamDescription VARCHAR,
);