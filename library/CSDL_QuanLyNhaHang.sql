use master
go

create database QuanLiNhaHangHaiSan
go

use QuanLiNhaHangHaiSan
go



-- bảng để cập nhật chức vụ
CREATE TABLE ChucVu(
	MaChucVu VARCHAR(10) not null , -- khóa chính,
	TenChucVu NVARCHAR(50),
	LuongCoBan MONEY
	PRIMARY key (MaChucVu)
)
GO

--------------------------

CREATE TABLE NhanSu(
	MaNhanVien VARCHAR(10) not null  ,--- khóa chính
	MaChucVu VARCHAR(10) ,-- khóa ngoại
	HoVaTen NVARCHAR(255),
	GioiTinh nvarchar(10),
	SDT VARCHAR(10),
	BacLuong float,
	NgaySinh date,
	Email VARCHAR(255),
	DiaChi NVARCHAR(255),
	Luong MONEY,
	Img varchar(255),
	TinhTrang BIT DEFAULT 1
	PRIMARY key (MaNhanVien)
)
GO

-- Bảng tài khoản
CREATE TABLE TaiKhoan(
	STT int identity not null,
	TenDangNhap VARCHAR(30),
	MatKhau VARCHAR(30),
	NgayTao DATE,
	MaNhanVien VARCHAR(10) not null,-- khoa ngoai
	MaChucVu VARCHAR(10) NOT NULL,-- mã chức vụ là dựa trên cái thông tin nhân viên bảng QuanLiNhanSu
	TinhTrang BIT DEFAULT 1
	PRIMARY key (STT)
)
GO

--------------------------------
create table LoaiThucDon(
	MaLoaiThucDon varchar(10),
	TenLoaiThucDon nvarchar(255),
	ThuocLoai nvarchar(255)
	PRIMARY key (MaLoaiThucDon)
)
go

------------------------------------------
CREATE TABLE DoAn(
	MaDoAn VARCHAR(10) not null ,--001
	TenDoAn NVARCHAR(255),
	GiaDoAn MONEY,
	GiaGoc MONEY,
	TinhTrang bit,-- tình trạng thức ăn còn kinh doanh hay không.
	Img nvarchar(255),
	MaLoaiThucDon VARCHAR(10) not null, -- Khóa ngoại nè
	PRIMARY key (MaDoAn)
)
GO

---------------------------------
CREATE TABLE DoUong(
	MaDoUong VARCHAR(10),
	TenDoUong NVARCHAR(255),
	GiaDoUong MONEY,
	GiaGoc MONEY,
	TinhTrang bit,-- tình trạng thức ăn hơi khó.
	img nvarchar(255),
	MaLoaiThucDon VARCHAR(10)
	PRIMARY key (MaDoUong)
)
GO

---------------------------------------
create Table DonHang(
	MaDonHang int identity primary key,
	MaNhanVien varchar(10), -- Khóa ngoại
	MaKhachHang varchar(10), -- Khoá ngoại
	GhiChu nvarchar(255),
	GioVao varchar(100),
	GioRa varchar(100),
	SoBan INT,
    TongTienThanhToan MONEY DEFAULT 0.0
)
go

-----------------------------------
create table DatBan(
	MaKhachHang varchar(10) primary key,
	TenKhachHang nvarchar(255),
	SoDienThoai varchar(13),
	SoBan int,
	NgayDen date,
	ThoiGian varchar(50),
	TienCoc money,
	GhiChu nvarchar(255),
	TinhTrang bit
)
go

---------------------------------------
create table DonHangChiTiet(
	STT int identity primary key,
	MaDonHang int, -- Khóa ngoại
	MaDoAn varchar(10),-- Khóa ngoại
	MaDoUong varchar(10),-- Khóa ngoại
	SoLuong int,
	GiaTien money,
	ThanhTien money
)
go

----------------------------
create table HoaDon(
	MaHoaDon int identity primary key,
	TongThanhTien money,
	TienNhan money,
	NgayBan date,
	SoBan int,
	GioVao varchar(100),
	GioRa varchar(100),
	GhiChu nvarchar(255),
	MaNhanVien VARCHAR(10), -- Khóa ngoại
	MaDonHang VARCHAR(50), -- Mã đơn hàng chỉ để hiển thị thôi, không phải khóa ngoại
	MaKhachHang VARCHAR(10), -- Khóa ngoaị
)
go

------------------------------------
create table HoaDonChiTiet(
	STT int identity primary key,
	MaHoaDon int, -- Khóa ngoại
	TenDoAnVaDoUong NVARCHAR(255), 
	SoLuong int,
	Gia money,
	ThanhTien MONEY
)
go

--------------------Khóa ngoại-------------------
ALTER TABLE NhanSu
ADD CONSTRAINT FK_NhanSu_ChucVu
FOREIGN KEY(MaChucVu) REFERENCES ChucVu(MaChucVu)
GO
--------------------------------------------------------------
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanSu] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanSu] ([MaNhanVien])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
--------------------------------------------------------------
ALTER TABLE DoAn
ADD CONSTRAINT FK_DoAn_LoaiThucDon
FOREIGN KEY(MaLoaiThucDon) REFERENCES LoaiThucDon(MaLoaiThucDon)
GO
--------------------------------------------------------------
ALTER TABLE DoUong
ADD CONSTRAINT FK_DoUong_LoaiThucDon
FOREIGN KEY(MaLoaiThucDon) REFERENCES LoaiThucDon(MaLoaiThucDon)
GO
--------------------------------------------------------------
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_NhanSu] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanSu] ([MaNhanVien])
ON UPDATE CASCADE
ON DELETE SET NULL
GO
ALTER TABLE DonHang
ADD CONSTRAINT FK_DonHang_DatBan
FOREIGN KEY(MaKhachHang) REFERENCES DatBan(MaKhachHang)
GO
--------------------------------------------------------------
-- Đặt bàn không có khóa ngoại
--------------------------------------------------------------
ALTER TABLE DonHangChiTiet
ADD CONSTRAINT FK_DonHangChiTiet_DoAn
FOREIGN KEY(MaDoAn) REFERENCES DoAn(MaDoAn)
GO
ALTER TABLE DonHangChiTiet
ADD CONSTRAINT FK_DonHangChiTiet_DoUong
FOREIGN KEY(MaDoUong) REFERENCES DoUong(MaDoUong)
GO
ALTER TABLE DonHangChiTiet
ADD CONSTRAINT FK_DonHangChiTiet_DonHang
FOREIGN KEY(MaDonHang) REFERENCES dbo.DonHang(MaDonHang)
GO
--------------------------------------------------------------
----------Bảng hóa đơn không có khóa ngoại----------------------
--------------------------------------------------------------
ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT FK_HoaDonChiTiet_HoaDon
FOREIGN KEY(MaHoaDon) REFERENCES HoaDon(MaHoaDon)
GO

INSERT dbo.ChucVu
	(		MaChucVu,	TenChucVu,		LuongCoBan	)
VALUES
	(   	'QL',	 N'Quản lý',	25000000		),
	(   	'TN',	N'Thu ngân',	12000000		),
	(   	'NV',	N'Nhân viên',	9000000		),
	(		'DB',	N'Đầu bếp',	10000000		),
	(   	'BV',	N'Bảo vệ',	7000000		)
GO
---------------------------------------------------------------
INSERT dbo.NhanSu
(	MaNhanVien,	MaChucVu,	HoVaTen,	GioiTinh,	SDT,	BacLuong,	NgaySinh,	Email,	DiaChi,	Luong,	Img		)
VALUES
	(   'QL01',		'QL',    N'Nguyễn Văn Hồng Phi',    N'Nam',		'011111111',   1,    '2003-12-14',    '',     N'Trà Vinh',     25000000,     NULL     ),
	(   'QL02',		'QL',    N'Trần Văn B',    N'Nam',		'011111112',   1,    '2002-09-12',    '',     N'Hậu Giang',     25000000,     NULL     ),
	(   'QL03',		'QL',    N'Nguyễn Văn C',    N'Nam',		'011111113',   1,    '2001-07-15',    '',     N'Hậu Giang',     25000000,     NULL     ),
	(   'TN01',		'TN',    N'Vũ Hoàng D',    N'Nữ',		'022222221',   1,    '2000-01-12',    '',     N'Đồng Tháp',     12000000,     NULL     ),
	(   'TN02',		'TN',    N'Trần Thị E',    N'Nữ',		'0222222222',   1,    '2002-06-18',    '',     N'Cà Mau',    12000000,     NULL     ),
	(   'TN03',		'TN',  N'Phạm Thị Hoàng F',    N'Nữ',		'0333333331',   1,    '2003-04-08',    '',     N'Cần Thơ',     12000000,     NULL     ),
	(   'NV01',		'NV',    N'Vương Văn G',    N'Nam',		'0333333332',   1,    '2004-10-20',    '',     N'Trà Vinh',     9000000,      NULL     ),
	(   'NV02',		'NV',    N'Hoàng Thị Hồng H',    N'Nữ',		'0333333333',   1,    '2003-11-17',    '',     N'Đồng Tháp',     9000000,     NULL     )
GO
-----------------------------------------------------------------------------------
INSERT dbo.TaiKhoan
	(	TenDangNhap,	MatKhau,	NgayTao,	MaNhanVien,	MaChucVu	)
VALUES
	(   'ql001',		'123',		'03-12-2022',		'QL01',		'QL'    ),
	(   'tn001',		'123',		'03-12-2022',		'TN01',		'TN'    )
GO

-----------------------------------------------------------------------------------

INSERT dbo.LoaiThucDon
	(	MaLoaiThucDon,		TenLoaiThucDon,		ThuocLoai	)
VALUES
	(   'MKV',		N'Món khai vị',		N'Thức ăn'		),
	(   'MC',		N'Món chính',		N'Thức ăn'		),
	(   'MTM',		N'Món tráng miệng',		N'Thức ăn'		),
	(   'DUCG',		N'Đồ uống có ga',		N'Thức uống'		),
	(   'DUK',		N'Đồ uống khác',		N'Thức uống'		)
GO

-----------------------------------------------------------------------------------
INSERT dbo.DoAn
	(	MaDoAn,		TenDoAn,	GiaDoAn,	GiaGoc,	  TinhTrang,	Img,	MaLoaiThucDon	)
VALUES
	(   'DA-001',   N'Bánh tôm',  110000, 100000, 1,  N'BanhTom_110.000.jpg',  'MKV'    ),
	(   'DA-002',   N'Bánh khọt tôm thịt',  120000, 10000, 1,  N'BanhKhotTomThit_120.000.jpg',  'MKV'    ),
	(   'DA-003',   N'Bạch tuộc nướng',  488000, 400000, 1,  N'BachTuocDaiDuongNuong_488.000.png',  'MKV'    ),
	(   'DA-004',   N'Cua đồng rang muối',  110000, 10000, 1,  N'CuaDongRangMuoi_110.000.jpg',  'MKV'    ),
	(   'DA-005',   N'Cá bóng nướng',  288000, 250000, 1,  N'CaBongNuong_288.000.png',  'MKV'    ),
	(   'DA-006',   N'Đậu trứng hấp',  130000, 100000, 1,  N'DauTrungHap_130.000.jpg',  'MKV'    ),
	(   'DA-007',   N'Đồ ăn 004',  150000, 130000, 1,  N'',  'MC'    ),
	(   'DA-008',   N'Đồ ăn 005',  180000, 170000, 1,  N'',  'MTM'    ),
	(   'DA-009',   N'Đồ ăn 006',  180000, 170000, 1,  N'',  'MTM'    )
GO
-----------------------------------------------------------------------------------
INSERT dbo.DoUong
	(	MaDoUong,		TenDoUong,	GiaDoUong,	GiaGoc,	  TinhTrang,	Img,	MaLoaiThucDon	)
VALUES
	(   'DU-001',   N'Đồ uống: 7UP',  100000,  90000,  1,  N'7up.jpg',  'DUCG'    ),
	(   'DU-002',   N'CocaCola',  100000,  90000,  1,  N'coca.jpg',  'DUCG'    ),
	(   'DU-003',   N'Mirinda Soda Kem',  150000, 130000, 1,  N'mirinda.jpg',  'DUCG'    ),
	(   'DU-004',   N'Nước ép bưởi',  150000, 130000, 1,  N'nước ép bưởi.jpg',  'DUK'    ),
	(   'DU-005',   N'Nước ép chuối',  180000, 170000, 1,  N'nước ép chuối.jpg',  'DUK'    ),
	(   'Du-006',   N'Nước ép lựu',  180000, 170000, 1,  N'nước ép lựu.jpg',  'DUK'    )
GO
-----------------------------------------------------------------------------------
SELECT * FROM dbo.DoUong
INSERT dbo.DonHang
	(	MaNhanVien,		MaKhachHang,	GhiChu,		SoBan	)
VALUES
	(   NULL,   NULL,  N'', 1    ),
	(   NULL,   NULL,  N'', 2    ),
	(   NULL,   NULL,  N'', 3   ),
	(   NULL,   NULL,  N'', 4    ),
	(   NULL,   NULL,  N'', 5    ),
	(   NULL,   NULL,  N'', 6    ),
	(   NULL,   NULL,  N'', 7    ),
	(   NULL,   NULL,  N'', 9    ),
	(   NULL,   NULL,  N'', 10    ),
	(   NULL,   NULL,  N'', 11   ),
	(   NULL,   NULL,  N'', 12    ),
	(   NULL,   NULL,  N'', 13    ),
	(   NULL,   NULL,  N'', 14    ),
	(	NULL,   NULL,  N'', 15    ),
	(   NULL,   NULL,  N'', 16    ),
	(   NULL,   NULL,  N'', 17    ),
	(   NULL,   NULL,  N'', 18    ),
	(   NULL,   NULL,  N'', 19   ),
	(   NULL,   NULL,  N'', 20    ),
	(   NULL,   NULL,  N'', 21    ),
	(   NULL,   NULL,  N'', 22    ),
	(   NULL,   NULL,  N'', 23    ),
	(   NULL,   NULL,  N'', 24    ),
	(   NULL,   NULL,  N'', 25    ),
	(   NULL,   NULL,  N'', 26   ),
	(   NULL,   NULL,  N'', 27    ),
	(   NULL,   NULL,  N'', 28    ),
	(   NULL,   NULL,  N'', 29    ),
	(   NULL,   NULL,  N'', 30    )
GO

INSERT dbo.HoaDon
	(	TongThanhTien,	TienNhan,   NgayBan,   SoBan,	GioVao,		GioRa,	GhiChu,		MaNhanVien,		MaDonHang,		MaKhachHang	)
VALUES
	(   150000,      150000,      '2022-12-08',   1,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   200000,      200000,      '2022-12-08',   2,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   170000,      170000,      '2022-03-08',   3,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   180000,      180000,      '2022-04-08',   4,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2021-01-08',   5,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2021-02-08',   6,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2021-03-08',   7,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2021-04-08',   8,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2021-05-08',   9,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         )
GO

INSERT dbo.HoaDon
	(	TongThanhTien,	TienNhan,   NgayBan,   SoBan,	GioVao,		GioRa,	GhiChu,		MaNhanVien,		MaDonHang,		MaKhachHang	)
VALUES
	(   150000,      150000,      '2022-12-17',   1,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-12-17',   2,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-12-17',   3,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   200000,      200000,      '2022-12-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   200000,      200000,      '2022-12-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   200000,      200000,      '2022-12-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   170000,      170000,      '2022-11-08',   3,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   170000,      170000,      '2022-11-08',   4,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   170000,      170000,      '2022-11-08',   5,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   170000,      170000,      '2022-11-08',   6,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   180000,      180000,      '2022-11-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   180000,      180000,      '2022-11-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   180000,      180000,      '2022-11-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-10-08',   5,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-10-08',   6,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-10-08',   7,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-10-08',   8,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-10-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-10-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-10-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-09-08',   7,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-09-08',   8,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-09-08',   9,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-09-08',   10,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-09-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-09-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-09-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-09-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-08-08',   9,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-08-08',   10,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-08-08',   11,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-08-08',   12,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-08-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-08-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         ),
	(   150000,      150000,      '2022-08-08',   0,         '09-12-2022 13:00',        '09-12-2022 14:00',        N'Đã thanh toán',       NULL,        NULL,        NULL         )
GO

INSERT dbo.HoaDonChiTiet
	(	MaHoaDon,	TenDoAnVaDoUong,	SoLuong,	Gia,	ThanhTien	)
VALUES
	(   1,    N'Bánh tôm',	1,		150000,	150000	),
	(   2,    N'Bánh tôm',	1,		200000,	200000	),
	(   3,    N'Bánh tôm',	1,		170000,	170000	),
	(   4,    N'Bánh tôm',	1,		180000,	180000	),
	(   5,    N'Bánh tôm',	1,		150000,	150000	),
	(   6,    N'Bánh tôm',	1,		150000,	150000	),
	(   7,    N'Bánh tôm',	1,		150000,	150000	),
	(   8,    N'Bánh tôm',	1,		150000,	150000	),
	(   9,    N'Bánh tôm',	1,		150000,	150000	),
	(   10,    N'Bánh tôm',	1,		150000,	150000	),
	(   11,    N'Bánh tôm',	1,		150000,	150000	),
	(   12,    N'Bánh tôm',	1,		150000,	150000	),
	(   13,    N'Bánh tôm',	1,		150000,	150000	),
	(   14,    N'Bánh tôm',	1,		150000,	150000	),
	(   15,    N'Bánh tôm',	1,		150000,	150000	),
	(   16,    N'Bánh tôm',	1,		150000,	150000	),
	(   17,    N'Bánh tôm',	1,		150000,	150000	),
	(   18,    N'Bánh tôm',	1,		150000,	150000	),
	(   19,    N'Bánh tôm',	1,		150000,	150000	),
	(   20,    N'Bánh tôm',	1,		150000,	150000	),
	(   21,    N'Bánh tôm',	1,		150000,	150000	),
	(   22,    N'Bánh tôm',	1,		150000,	150000	),
	(   23,    N'Bánh tôm',	1,		150000,	150000	),
	(   24,    N'Bánh tôm',	1,		150000,	150000	),
	(   25,    N'Bánh tôm',	1,		150000,	150000	),
	(   26,    N'Bánh tôm',	1,		150000,	150000	),
	(   27,    N'Bánh tôm',	1,		150000,	150000	),
	(   28,    N'Bánh tôm',	1,		150000,	150000	),
	(   29,    N'Bánh tôm',	1,		150000,	150000	),
	(   30,    N'Bánh tôm',	1,		150000,	150000	),
	(   31,    N'Bánh tôm',	1,		150000,	150000	),
	(   32,    N'Bánh tôm',	1,		150000,	150000	),
	(   33,    N'Bánh tôm',	1,		150000,	150000	),
	(   34,    N'Bánh tôm',	1,		150000,	150000	),
	(   35,    N'Bánh tôm',	1,		150000,	150000	),
	(   36,    N'Bánh tôm',	1,		150000,	150000	),
	(   37,    N'Bánh tôm',	1,		150000,	150000	),
	(   38,    N'Bánh tôm',	1,		150000,	150000	),
	(   39,    N'Bánh tôm',	1,		150000,	150000	),
	(   40,    N'Bánh tôm',	1,		150000,	150000	),
	(   41,    N'Bánh tôm',	1,		150000,	150000	),
	(   42,    N'Bánh tôm',	1,		150000,	150000	),
	(   43,    N'Bánh tôm',	1,		150000,	150000	),
	(   44,    N'Bánh tôm',	1,		150000,	150000	)
GO


------------------------ Tạo Trigger --------------------------
CREATE TRIGGER tr_TuDongTaoTaiKhoan ON dbo.NhanSu
FOR INSERT AS
BEGIN
    DECLARE @MaNhanVien VARCHAR(10), @MaChucVu VARCHAR(10);
	SELECT @MaNhanVien = Inserted.MaNhanVien, @MaChucVu = Inserted.MaChucVu FROM Inserted

	INSERT dbo.TaiKhoan
		(	TenDangNhap,	MatKhau,	NgayTao,	MaNhanVien,	MaChucVu	)
	VALUES
		(   @MaNhanVien,		'123',		NULL,		@MaNhanVien,		@MaChucVu    )
END
GO
----------------------------------
CREATE TRIGGER tr_TuDongTaoDonHang ON dbo.DatBan
FOR INSERT AS
BEGIN
    DECLARE @MaKhachHang VARCHAR(10), @GhiChu NVARCHAR(255), @SoBan INT, @TienCoc money;

	SELECT @MaKhachHang = Inserted.MaKhachHang, @GhiChu = Inserted.GhiChu, @SoBan = Inserted.SoBan, @TienCoc = Inserted.TienCoc FROM Inserted

	UPDATE dbo.DonHang SET MaKhachHang = @MaKhachHang, GhiChu = @GhiChu, TongTienThanhToan = -@TienCoc
	WHERE SoBan = @SoBan
    
END
GO
-----------------------------------
CREATE TRIGGER tr_TuDongTaoDonHangChiTiet ON dbo.DonHang
FOR INSERT AS 
BEGIN
    DECLARE @MaDonHang INT;
	SELECT @MaDonHang = Inserted.MaDonHang FROM Inserted

	INSERT dbo.DonHangChiTiet
		(	 MaDonHang		)
	VALUES
		(	@MaDonHang	)
END
GO
------------------------------------
CREATE TRIGGER tr_XoaDonHangThiXoaLuonDonHangChiTiet ON dbo.DonHang
FOR DELETE AS
BEGIN
	DECLARE @MaDonHang INT;
	SELECT @MaDonHang = Deleted.MaDonHang FROM Deleted

	DELETE FROM dbo.DonHangChiTiet 
	WHERE MaDonHang = @MaDonHang
END
GO

-------------------Store Produce------------------
CREATE PROC sp_ThongKeHoaDonChiTiet
@thang int, @nam int
AS 
BEGIN
        SELECT hd.MaHoaDon, hd.MaNhanVien, hd.MaKhachHang, hd.SoBan, hd.NgayBan, hd.GioVao, 
				hd.GioRa,hdct.TenDoAnVaDoUong, hdct.SoLuong, hdct.ThanhTien,
				hd.TongThanhTien, hd.GhiChu, hd.MaDonHang
		FROM dbo.HoaDon hd JOIN dbo.HoaDonChiTiet hdct ON hdct.MaHoaDon = hd.MaHoaDon
		WHERE CONVERT(VARCHAR, MONTH(NgayBan)) LIKE @thang AND CONVERT(VARCHAR, YEAR(NgayBan)) LIKE @nam
END
GO

CREATE PROC sp_TongHopHoaDon
@thang int, @nam int
AS 
BEGIN
		SELECT hd.SoBan, COUNT(*) AS 'SoLuongHoaDon', hd.NgayBan, SUM(hd.TongThanhTien) AS 'TongTien'
	    FROM dbo.HoaDon hd 
		WHERE CONVERT(VARCHAR, MONTH(NgayBan)) LIKE @thang AND CONVERT(VARCHAR, YEAR(NgayBan)) LIKE @nam
		GROUP BY hd.NgayBan, hd.SoBan
		ORDER BY hd.NgayBan DESC
END
GO