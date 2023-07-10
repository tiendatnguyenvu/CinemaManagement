create database quanlirapchieuphim;

use quanlirapchieuphim
go

create table Movie (
	ID_Movie varchar (10) constraint ID_Movie primary key,
	Name nvarchar (100),
	Time int,
	AgeLimit int,
	OpeningDate date,
	Language nvarchar (50),
	country nvarchar (100),
	director nvarchar (100),
	content nvarchar (500),
	imageLink varchar (100),
);
go

create table TypeOfSeat (
	ID_TypeSeat varchar (10) constraint ID_TypeSeat primary key,
	TypeSeat nvarchar (20),
	Surcharge int
);
go

create table Room (
	ID_Room varchar (10) constraint ID_Room primary key,
	RowOfChair int,
	ColumOfChair int
);
go

create table Seat (
	ID_Seat varchar (10) constraint ID_Seat primary key,
	Colum int,
	Row int,
	Chosen bit,
	ID_Room varchar (10) constraint frID_RoomSeat foreign key references Room(ID_Room),
	ID_TypeSeat varchar (10) constraint frID_TypeSeat foreign key references TypeOfSeat(ID_TypeSeat)
);
go

create table MovieFormat (
	ID_MovieFormat varchar (10) constraint ID_MovieFormat primary key,
	NameFormat nvarchar (10),
	Surcharge int
);
go

create table ShowTime (
	ID_ShowTime varchar (10) constraint ID_ShowTime primary key,
	StartTime time,
	EndTime time,
	Date date,
	ID_Movie varchar (10) constraint frID_MovieShowTime foreign key references Movie(ID_Movie),
	ID_Room varchar (10) constraint frID_RoomShowTime foreign key references Room(ID_Room),
	ID_MovieFormat varchar (10) constraint frID_MovieFormatShowTime foreign key references MovieFormat(ID_MovieFormat)
);
go

create table TicketPrice (
	ID_TicketPrice varchar (10) constraint ID_TicketPrice primary key,
	NameTicketPrice nvarchar (20),
	UnitPrice int
);
go

create table Task (
	ID_Task varchar (10) constraint ID_Task primary key,
	Name nvarchar (30)
);
go

create table Staff (
	ID_Staff varchar (10) constraint ID_Staff primary key,
	Name nvarchar (50),
	Password varchar (30),
	ID_Person varchar (12),
	PhoneNumber varchar (10),
	Email varchar (50),
	Address nvarchar (300), 
	StartDate date,
	Sex bit,
	IsWorking bit,
	DayWorking int,
	SalaryDate int,
	ID_Task varchar (10) constraint frID_TaskStaff foreign key references Task(ID_Task)
);
go

create table TicketSale (
	ID_TicketSale varchar (10) constraint ID_TicketSale primary key,
	SaleDate datetime,
	Total int,
	ID_ShowTime varchar (10) constraint frID_ShowTimeTicketSale foreign key references ShowTime(ID_ShowTime),
	ID_Seat varchar (10) constraint frID_SeatTicketSale foreign key references Seat(ID_Seat),
	ID_Staff varchar (10) constraint frID_StaffTicketSale foreign key references Staff(ID_Staff),
	ID_TicketPrice varchar (10) constraint frID_TicketPriceTicketSale foreign key references TicketPrice(ID_TicketPrice)
);
go

create table Customer (
	ID_Customer varchar (10) constraint ID_Customer primary key,
	Name nvarchar (100),
	Password varchar(30),
	PhoneNumber varchar (10),
	Email varchar (50),
	DayOfBirth date,
	Sex bit,
	IsSavepw bit,
	ID_Person varchar (12),
	Address nvarchar (300),
	Account nvarchar (50),
	StartDate datetime,
	isDelete bit
);
go

create table BookingTicket (
	ID_TicketSale varchar (10) constraint frID_TicketSaleBookingTicket foreign key references TicketSale(ID_TicketSale),
	ID_Customer varchar (10) constraint frID_CustomerBookingTicket foreign key references Customer(ID_Customer)
);
go

create table Bill (
	ID_Bill varchar (10) constraint ID_Bill primary key,
	SaleDate date,
	ID_Staff varchar (10) constraint frID_StaffBill foreign key references Staff(ID_Staff),
	ID_Customer varchar (10) constraint frID_CustomerBill foreign key references Customer(ID_Customer)
);
go

create table SizeOfFood (
	ID_SizeFood varchar (10) constraint ID_SizeFood primary key,
	Name nvarchar (50),
);
go

create table TypeOfFood (
	ID_TypeFood varchar (10) constraint ID_TypeFood primary key,
	Name nvarchar (50)
);
go

create table Food (
	ID_Food varchar (10) constraint ID_Food primary key,
	Name nvarchar (50),
	IsSaling bit,
	ID_TypeFood varchar (10) constraint frID_TypeFood foreign key references TypeOfFood(ID_TypeFood),
	ID_SizeFood varchar (10) constraint frID_SizeFood foreign key references SizeOfFood(ID_SizeFood)
);
go

create table DetailedFood (
	ID_DetailedFood varchar (10) constraint ID_DetailedFood primary key,
	UnitPrice int,
	Quantity int,
	IsSaling bit,
	ID_Food varchar (10) constraint frID_FoodDetailedFood foreign key references Food(ID_Food)
);
go

create table DetailedBill (
	ID_DetailedBill varchar (10) constraint ID_DetailedBill primary key,
	Quantity int,
	Total int,
	ID_Bill varchar (10) constraint frID_BillDetailedBill foreign key references Bill(ID_Bill),
	ID_DetailedFood varchar (10) constraint frID_DetailedFoodDetailedBill foreign key references DetailedFood(ID_DetailedFood)
);
go

alter table Customer
add ID_Person varchar (12),
	Address nvarchar (300),
	Account nvarchar (50)

alter table Movie 
add imageLink varchar (100) 

ALTER TABLE movie
DROP CONSTRAINT FrID_TypeMovieMovie

DROP TABLE TypeOfMovie

ALTER TABLE SHOWTIME
DROP COLUMN EndTime

DROP TABLE MovieFormat

alter table showtime
drop column ID_MovieFormat

alter table showTime
add movieFormat varchar(10)

alter table showtime
drop column ID_ShowTime

INSERT INTO ShowTime values ('1', '2022-12-22 7:30', '2', '3', '3D');

ALTER TABLE ShowTime
ADD isDeleteST bit

ALTER TABLE TicketSale
DROP COLUMN ID_TicketPrice

ALTER TABLE ShowTime
ADD ticketPrice int