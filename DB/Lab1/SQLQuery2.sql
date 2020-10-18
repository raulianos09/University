use master;

if exists(select * from sys.databases where [name] = 'Railroads')
begin
	print 'DB found';
	drop database Railroads;
end
else
begin
	print 'DB does not exist';
end

go
create database Railroads;

go

use Railroads;

--> create table Train
create table Train
(
	trainId		int primary key			not null,
	color		varchar(30)				not null,
	company		varchar(30)				not null,
	seatsNumber	int						not null,
	

);

--> create table Route
create table Route
(
	routeId			int primary key				not null,
	routeLength		int					not null,
	stationA		varchar(30)			not null,
	stationB		varchar(30)			not null,

	
);

--> create table Personnel
create table Personnel
(
	cnp			int primary key			not null,
	lastName	varchar(30)		not null,
	firstName	varchar(30)		not null,
	job			varchar(30)		not null,


);

--> create table Station
create Table Station
(
	stationId			int primary key			not null,
	stationName			varchar(30)			not null,
	city				varchar(30)			not null,
	country				varchar(30)			not null,

);

--> create table Traveler
create table Traveler
(
	cnp			int primary key			not null,
	lastName	varchar(30)		not null,
	firstName	varchar(30)		not null,
);

--> create table Ticket
create table Ticket
(
	ticketId		int primary key					not null,
	price			numeric			not null,

);

--> create table Seat
create table Seat
(
	seatId		int primary key			not null,
);

-->create table Works_On
create table Works_On
(
	cnp int references Personnel(cnp),
	trainId int references Train(trainId),
	startingDate		date		not null,

	primary key (cnp,trainId)
);

-->create table Travels_By
create table Travels_By
(
	cnp int references Traveler(cnp),
	trainId int references Train(trainId),
	startingTime time not null,

	primary key(cnp,trainId)
);

-->create table Has_Ticket
create table Has_Ticket
(
cnp int references Traveler(cnp),
ticketId int references Ticket(ticketId),

primary key(cnp, ticketId)
);



-->Populate Train Table
INSERT INTO Train VALUES (1,'blue','CFR',137)
INSERT INTO Train VALUES (2,'red','CFR',265)
INSERT INTO Train VALUES (3,'green','CFR',576)
INSERT INTO Train VALUES (4,'yellow','CFR',324)
INSERT INTO Train VALUES (5,'magenta','CFR',189)

select * from Train

-->Populate Train Table
INSERT INTO Route VALUES (1,1000,'A','B')
INSERT INTO Route VALUES (2,2000,'B','C')
INSERT INTO Route VALUES (3,3000,'D','E')
INSERT INTO Route VALUES (4,4000,'F','E')
INSERT INTO Route VALUES (5,5000,'B','G')

select * from Route

-->Populate Personnel Table
INSERT INTO Personnel VALUES (1,'A','B','Y')
INSERT INTO Personnel VALUES (2,'B','C','Y')
INSERT INTO Personnel VALUES (3,'D','E','Y')
INSERT INTO Personnel VALUES (4,'F','E','Y')
INSERT INTO Personnel VALUES (5,'B','G','Y')

select * from Route Personnel


-->Populate Traveler Table
INSERT INTO Traveler VALUES (1,'A','B')
INSERT INTO Traveler VALUES (2,'B','C')
INSERT INTO Traveler VALUES (3,'D','E')
INSERT INTO Traveler VALUES (4,'F','E')
INSERT INTO Traveler VALUES (5,'B','G')

select * from Route Traveler

-->Populate Ticket Table
INSERT INTO Ticket VALUES (1,10)
INSERT INTO Ticket VALUES (2,20)
INSERT INTO Ticket VALUES (3,30)
INSERT INTO Ticket VALUES (4,40)
INSERT INTO Ticket VALUES (5,50)

select * from Ticket


-->Populate Seat Table
INSERT INTO Seat VALUES (1)
INSERT INTO Seat VALUES (2)
INSERT INTO Seat VALUES (3)
INSERT INTO Seat VALUES (4)
INSERT INTO Seat VALUES (5)

select * from Seat

-->Populate Works_On Table
INSERT INTO Works_On VALUES (1,1,'10/15/2020')
INSERT INTO Works_On VALUES (2,2,'10/15/2020')
INSERT INTO Works_On VALUES (3,3,'10/15/2020')
INSERT INTO Works_On VALUES (4,4,'10/15/2020')
INSERT INTO Works_On VALUES (5,5,'10/15/2020')

select * from Works_On

-->Populate Travels_By Table
INSERT INTO Travels_By VALUES (1,1,'10:15:32')
INSERT INTO Travels_By VALUES (2,2,'10:15:32')
INSERT INTO Travels_By VALUES (3,3,'10:15:32')
INSERT INTO Travels_By VALUES (4,4,'10:15:32')
INSERT INTO Travels_By VALUES (5,5,'10:15:32')

select * from Travels_By


-->Populate Has_Ticket Table
INSERT INTO Has_Ticket VALUES (1,1)
INSERT INTO Has_Ticket VALUES (2,2)
INSERT INTO Has_Ticket VALUES (3,3)
INSERT INTO Has_Ticket VALUES (4,4)
INSERT INTO Has_Ticket VALUES (5,5)

select * from Has_Ticket
