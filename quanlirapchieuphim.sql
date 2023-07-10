create database quanlirapchieuphim;
go

use quanlirapchieuphim
go

--
create table Movie (
	ID_Movie varchar (10) constraint ID_Movie primary key,
	Name nvarchar (100),
	Time int,
	AgeLimit int,
	OpeningDate date,
	Language nvarchar (50),
	Country nvarchar (100),
	Director nvarchar (100),
	Producer nvarchar (100),
	IsShowing bit,
	Content nvarchar (1000),
	TypeMovie varchar (10), 
	ImageLink varchar (10)
);
go

--
create table Room (
	ID_Room varchar (10) constraint ID_Room primary key,
	RowOfChair int,
	ColumOfChair int
	NumOfVIPChair int,
	NumOfCoupleChair int
);
go

--
create table TypeOfSeat(
	ID_TypeSeat varchar (10) constraint ID_TypeSeat primary key,
	NameTypeSeat varchar (10),
	Surcharge int,
);
go

--
create table Seat (
	ID_Seat varchar (10) constraint ID_Seat primary key,
	Colum int,
	Row int,
	Chosen bit,
	ID_Room varchar (10) constraint frID_RoomSeat foreign key references Room(ID_Room),
	Quantity int
);
go

--
create table ShowTime (
	ID_ShowTime varchar (10) constraint ID_ShowTime primary key,
	StartTime datetime,
	ID_Movie varchar (10) constraint frID_Movie foreign key references Movie(ID_Movie),
	ID_Room varchar (10) constraint frID_RoomShowTime foreign key references Room(ID_Room),
	TicketPrice int,
	IsDeleteST bit,
	MovieFormat varchar (10)
);
go

--
create table Staff (
	ID_Staff varchar (10) constraint ID_Staff primary key,
	FullName nvarchar (50),
	Password varchar (30),
	ID_Person varchar (12),
	PhoneNumber varchar (10),
	Email varchar (50),
	Address nvarchar (300), 
	StartDate date,
	Sex bit,
	IsWorking bit,
	NameTask nvarchar (50),
	IsDelete bit,
	BirthDate date,
	NumOfDayWorked int, 
	SalaryDay int,
	Account nvarchar (50)
);
go

--
create table TicketSale (
	ID_TicketSale varchar (10) constraint ID_TicketSale primary key,
	SaleDate datetime,
	Total int,
	ID_ShowTime varchar (10) constraint frID_ShowTimeTicketSale foreign key references ShowTime(ID_ShowTime),
	ID_Seat varchar (10) constraint frID_SeatTicketSale foreign key references Seat(ID_Seat),
	ID_Staff varchar (10) constraint frID_StaffTicketSale foreign key references Staff(ID_Staff)
);
go

--
create table Customer (
	ID_Customer varchar (10) constraint ID_Customer primary key,
	Name nvarchar (100),
	Password varchar(30),
	PhoneNumber varchar (10),
	Email varchar (50),
	DayOfBirth date,
	Sex bit,
	IsSavePw bit,
	ID_Person varchar (12),
	Address nvarchar (100),
	Account nvarchar (50),
	StartDate datetime,
	IsDelete bit
);
go

--
create table BookingTicket (
	ID_TicketSale varchar (10) constraint frID_TicketSaleBookingTicket foreign key references TicketSale(ID_TicketSale),
	ID_Customer varchar (10) constraint frID_CustomerBookingTicket foreign key references Customer(ID_Customer)
);
go

--
create table Bill (
	ID_Bill varchar (10) constraint ID_Bill primary key,
	SaleDate datetime,
	ID_Staff varchar (10) constraint frID_StaffBill foreign key references Staff(ID_Staff),
	ID_Customer varchar (10) constraint frID_CustomerBill foreign key references Customer(ID_Customer)
);
go

--
create table Food (
	ID_Food varchar (10) constraint ID_Food primary key,
	Name nvarchar (50),
	IsSaling bit,
	TypeFood nvarchar (100),
	ID_SizeFood nvarchar (100),
	UnitPrice int
);
go

--
create table DetailedFood (
	ID_DetailedFood varchar (10) constraint ID_DetailedFood primary key,
	IsSaling bit,
	Quantity int,
	ID_Food varchar (10) constraint frID_Food foreign key references Food(ID_Food)
);
go

create table DetailedBill (
	ID_DetailedBill varchar (10) constraint ID_DetailedBill primary key,
	Quantity int,
	Total int,
	ID_Bill varchar (10),
	ID_DetailedFood varchar (10) constraint frID_DetailedFoodDetailedBill foreign key references DetailedFood(ID_DetailedFood)
);
go

create table DetailTicketSale (
	ID_TicketSale varchar (10) constraint frID_TicketSale foreign key references TicketSale (ID_TicketSale), 
	ID_Seat varchar (10) constraint frID_Seat foreign key references Seat (ID_Seat),
	constraint ID_DetailTicketSale primary key (ID_TicketSale, ID_Seat)
);
go 


-- theemm dữ liệu vào phòng
insert into Room (ID_Room, RowOfChair, ColumOfChair)
values ('ROOM1', 9, 17),
	   ('ROOM2', 9, 17),
	   ('ROOM3', 5, 12),
	   ('ROOM4', 5, 12),
	   ('ROOM5', 5, 12);


insert into Staff ()
values ('STI10000', 'Nguyễn Trí Bảo', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('STI10001', 'Hồ Quốc Cường', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('STI10002', 'Ngô Tấn Đạt', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('STI10003', 'Phạm Tiến Đạt', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('STI10004', 'Nguyễn Quang Điền', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('STC10005', 'Hứa Vĩnh Đức', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('STC10006', 'Ngô Ngọc Giàu', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('FDS10007', 'Vương Huy Hoàng', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('FDS10008', 'Lê Nguyên Minh Huy', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('SSC10009', 'Biện Thành Hưng', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('SSC10010', 'Lê Tiến Hữu', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('SCS10011', 'Phạm Đăng Khoa', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('SCS10012', 'Nguyễn Hoài Lộc', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('SCS10013', 'Nguyễn Thành Lộc', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('SCS10014', 'Ngô Lê Huệ Ngân','123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('SCS10015', 'Nguyễn Hoàng Kiều Ngân', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('MRO10016', 'Tiền Minh Vy', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('MSC10017', 'Vũ Đức Tình', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET'),
	   ('MSM10018', 'Hồ Duy Phúc', '123ABCabc$$$', '079203000123', '0974341715', 'nvtd123@gmail.com', '23/7 Huỳnh Tấn Phát, Q7', '01/01/2023', 1, 1, 'CHECKTICKET');




insert into TypeOfSeat (ID_TypeSeat, NameTypeSeat, Surcharge)
values ('ECONOMY', 'Ghế thường', 0),
	   ('VIP', 'Ghế VIP', 30000),
	   ('COUPLE', 'Ghế đôi', 40000)