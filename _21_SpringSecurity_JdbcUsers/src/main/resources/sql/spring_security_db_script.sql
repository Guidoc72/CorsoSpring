Create database if not exists Spring_security_test;
use Spring_security_test;

-- Questo che segue è il codice per creare un DB utenti di default di Spring Security 6.2
-- Link per download: https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/jdbc.html
create table if not exists users(
	username varchar(50) not null primary key,
	password varchar(500) not null,
	enabled boolean not null
);

create table if not exists authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);