create database Restaurant;
use Restaurant

-- tạo bảng 
create table category
(
	Category_id nvarchar(50) NOT NULL primary key,
	Category_name nvarchar(50)
);

create table product
(
	Product_id nvarchar(50) NOT NULL primary key,
	image_product nvarchar(MAX),
	Name_product nvarchar(50),
	Category_id nvarchar(50) foreign key references category(Category_id),
	price int,
	quantity int

);

create table roleDetail
(
	RoleID nvarchar(50) NOT NULL primary key,
	Name_Role nvarchar(50),
);

create table account
(
	accID nvarchar(50) NOT NULL primary key,
	Username nvarchar(50),
	Pass nvarchar(50),
	FullName nvarchar(50),
	RoleID nvarchar(50) foreign key references roleDetail(RoleID),
);


-- insert dữ liệu vào bảng
-- insert category
insert into category values ('C1', 'Asian Food')
insert into category values('C2', 'Italian Food')


-- insert product
insert into product values ('P0001', 'https://upload.wikimedia.org/wikipedia/commons/5/53/Pho-Beef-Noodles-2008.jpg','Pho bo','C1',50000, 1)
insert into product values ('P0002', 'https://media.istockphoto.com/photos/gnocchi-with-parmesan-picture-id894986620?k=20&m=894986620&s=612x612&w=0&h=gQRBZ91ucpEaMjEuIvQb9Asyzr150bvqQfSPs_wlPX8=','Gnocchi','C2',65000,1)
insert into product values ('P0003', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Bun-Bo-Hue-from-Huong-Giang-2011.jpg/1200px-Bun-Bo-Hue-from-Huong-Giang-2011.jpg','Bun bo Hue','C1',43000,1)
insert into product values ('P0004', 'https://upload.wikimedia.org/wikipedia/commons/4/40/Italian_Risotto.png','Risotto','C2',50000,1)
insert into product values ('P0005', 'https://www.thespruceeats.com/thmb/-YUYSXc4T2H4P8o2JBApzJ3F5rw=/2069x2069/smart/filters:no_upscale()/white-and-red-sauce-lasagna-recipe-995925-hero-1-fb2c2142b39042069f0c50310047256d.jpg','Lasagna','C2',50000,1)
insert into product values ('P0006', 'https://cdn.daynauan.info.vn/wp-content/uploads/2019/05/com-tam-la-mon-an-binh-dan.jpg','Com Tam','C1',45000,1)

--insert Role
insert into roleDetail values('R01', 'Admin')
insert into roleDetail values('R02', 'User')

insert into account values ('A01','admin', 'admin', 'Cocou','R01')
insert into account values ('A02','vudnk', '12345', 'Dang Nguyen Khanh Vu','R01')
insert into account values ('A03','NVA', '12345', 'Nguyen Van A','R02')
insert into account values ('A04','NVB', '12345', 'Nguyen Van B','R02')
insert into account values ('A05','QuanDD', '12345', 'Dang Dinh Quan','R01')


select * from category
select top 5 * from product order by Product_id DESC

select * from account where Username='admin' and Pass='admin'
select * from roleDetail