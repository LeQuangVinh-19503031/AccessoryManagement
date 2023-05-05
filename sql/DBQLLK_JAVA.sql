use master
go

create database QLLK
go

USE QLLK
go

create table KhachHang(
	MaKH varchar(10) primary key,
	TenKH nvarchar(100) not null,
	DiaChiKH nvarchar(200),
	SdtKH nvarchar(15) not null,
	Email nvarchar(50)
)
go

create table PhongBan(
	MaPB varchar(10) primary key,
	TenPB nvarchar(100) not null
)
go

create table NhanVien(
	MaNV varchar(10) primary key,
	TenNV nvarchar(100) not null,
	MaPB varchar(10) constraint fk_NV_PB foreign key references PhongBan(MaPB) not null,
	MaQL varchar(10) constraint fk_NV_NV foreign key references NhanVien(MaNV) not null,
	NgayVaoLam Date constraint ck_ngayVaoLam check (NgayVaoLam < getdate()),
	NgaySinh Date constraint ck_NS CHECK ( NgaySinh < Getdate()) Default (Getdate()) not null,
	GioiTinh nvarchar(5) not null,
	luongCB money check (luongCB > 0),
	SdtNV varchar(15),
	Email varchar(50),
	CCCD char(9),
	TaiKhoan varchar(30),
	Matkhau varchar(30)
)

go

create table NhaCungCap(
	MaNCC varchar(10) primary key,
	TenNCC nvarchar(200) not null,
	DiaChi nvarchar(200) not null,
	Sdt varchar(15) not null,
	Email varchar(50) not null
)
go

create table LoaiLinhKien(
	MaLLK varchar(10) primary key,
	TenLLK nvarchar(50) not null
)
go

create table LinhKien(
	MaLK varchar(10) primary key,
	TenLK nvarchar(200) not null,
	MaLLK varchar(10) REFERENCES LoaiLinhKien(MaLLK) ON DELETE CASCADE ON UPDATE CASCADE not null,
	MaNCC varchar(10) REFERENCES NhaCungCap(MaNCC) ON DELETE CASCADE ON UPDATE CASCADE not null,
	DonViTinh nvarchar(20),
	GiaNhap money CHECK (GiaNhap>0) not null,
	GiaBan money CHECK (GiaBan>0) not null,
	SLTon int CHECK (SLTon>=0),
	MoTa nvarchar(500)
)
go

create table DonHang(
	MaHD varchar(10) primary key,
	MaKH varchar(10) not null REFERENCES KhachHang(MaKH) ON DELETE CASCADE ON UPDATE CASCADE,
	MaNV varchar(10) not null REFERENCES NhanVien(MaNV) ON DELETE CASCADE ON UPDATE CASCADE,
	NgayDatHang Date check (NgayDatHang <= Getdate()) Default(getdate()),
	NgayGiaoHang Date check (NgayGiaoHang > getDate()),
	DiaChiGiaoHang nvarchar(100)
)
go

create table ChiTietDonHang(
	MaHD varchar(10) not null REFERENCES DonHang(MaHD) ON DELETE CASCADE ON UPDATE CASCADE,
	MaLK varchar(10) not null REFERENCES LinhKien(MaLK) ON DELETE CASCADE ON UPDATE CASCADE,
	GiaBan Money constraint ck_GiaBan Check (GiaBan > 0),
	SoLuong Smallint default 1,
	GiamGia int constraint ck_GiamGia check (GiamGia between 0 and 100 ),
	ThanhTien Money constraint ck_SauKhiGiamGia Check (ThanhTien > 0) default 0
	constraint pk_DDH_LK primary key(MaHD, MaLK)
)

/*

use master
go
drop database QLLK


delete From NhanVien
*/

insert into LoaiLinhKien values ('TN', 'Tai Nghe')
insert into LoaiLinhKien values ('SDP', N'Sạc Dự Phòng')
insert into LoaiLinhKien values ('TCS', N'Túi Chống Sốc')
insert into LoaiLinhKien values ('USB', N'USB')
insert into LoaiLinhKien values ('L', N'Loa')
insert into LoaiLinhKien values ('BPC', N'Bàn Phím Cơ')
insert into LoaiLinhKien values ('MH', N'Màn Hình')
insert into LoaiLinhKien values ('CH', N'Chuột')
Select * FROM LoaiLinhKien
go

insert into NhaCungCap values ('DELL', 'DELL', '23 Nguyen Thi Huynh Street, Ward 8, Phu Nhuan District Ho Chi Minh', '+8428-38424342','nthanhson@digipro.vn')
insert into NhaCungCap values ('LENOVO', 'LENOVO', N'138-142 Hai Bà Trưng, Phường Đa Kao, Q1, TP.HCM', '+8438243504','acercare.vn@acer.com')
insert into NhaCungCap values ('E-DRA', 'E-DRA', N'138-142 Hai Bà Trưng, Phường Đa Kao, Q1, TP.HCM', '+8438243504','acercare.vn@acer.com')
insert into NhaCungCap values ('OPPO', 'OPPO', N'138-142 Hai Bà Trưng, Phường Đa Kao, Q1, TP.HCM', '1800 6067','pr.vn@realme.com')
insert into NhaCungCap values ('AKKO', 'AKKO', N'138-142 Hai Bà Trưng, Phường Đa Kao, Q1, TP.HCM', '1800 6067','pr.vn@realme.com')
Select * FROM NhaCungCap
go
/*
DELETE FROM LINHKIEN
*/
insert into LinhKien values ('LK01', N'Chuột Không dây Bluetooth Silent Rapoo M650 Lucky Cat', 'CH', 'DELL', N'Cái', 300000, 400000, 100, N'Miêu tả sản phẩm')
insert into LinhKien values ('LK02', N'Bàn Phím Có Dây Gaming MSI Vigor GK30 US', 'BPC', 'AKKO', N'Cái', 600000, 870000, 100, N'Miêu tả sản phẩm')
insert into LinhKien values ('LK03', N'Bàn phím AKKO 3087 RF Ocean Star', 'BPC', N'E-DRA', N'Cái', 600000, 749000,100, N'Miêu tả sản phẩm')
Select * FROM LinhKien
go

insert into PhongBan values ('KTHUAT', N'Phòng Kỹ Thuật')
insert into PhongBan values ('KDOANH', N'Phòng Kinh Doanh')
insert into PhongBan values ('NSU', N'Phòng Nhân Sự')
insert into PhongBan values ('KTOAN', N'Phòng Kế Toán')
insert into PhongBan values ('VCHUYEN', N'Phòng Vận Chuyển')
select * from PhongBan

go

insert into NhanVien values ('NV01', N'LÊ QUANG VINH', 'NSU', 'NV01', '04-21-2019', '03-17-2001', 'Nam', 6000000, '01234123', 'lea26462', '123456789', 'NVNS01', 'NVNS01')
insert into NhanVien values ('NV02', N'PHẠM CHÍ XUÂN', 'KDOANH', 'NV01', '04-21-2019', '11-19-2001', 'Nam', 12000000, '01234123', 'chixuan123', '123456789', 'NVNS02', 'NVNS02')
Select * FROM NhanVien

go

insert into KhachHang values ('KH01', N'VINH', N'GÒ VẤP, TP.HCM', '012391234', 'lea26423')
insert into KhachHang values ('KH02', N'XUÂN', N'GÒ VẤP, TP.HCM', '012391234', 'XuanXuan26423')
Select * FROM KhachHang
go

insert into DonHang values ('DH01', 'KH01', 'NV02', getDate(), '05-17-2023', 'IUH')
insert into DonHang values ('DH02', 'KH02', 'NV02', getDate(), '05-17-2023', 'IUH')
Select * FROM DonHang
go

insert into ChiTietDonHang values ('DH01', 'LK01', 1000000, 1, 10, 900000)
select * from ChiTietDonHang
/*
DELETE FROM DONDATHANG

*/