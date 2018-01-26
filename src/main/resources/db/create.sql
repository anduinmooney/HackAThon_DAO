SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS members (
    id int PRIMARY KEY auto_increment,
    hackMemberName VARCHAR,
    hackMemberId INTEGER
);

CREATE TABLE IF NOT EXISTS teams (
  id int PRIMARY KEY auto_increment,
  hackTeamName VARCHAR,
  hackTeamDescription VARCHAR
);