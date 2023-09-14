alter proc sp_HoaDonChiTiet
as begin
DECLARE @TongThanhTien FLOAT;
select  @TongThanhTien  = sum( SoLuong * GiaTien)
from DonHangChiTiet
	
--- lấy dữ liệu các đơn hàng có số là 1 ra hết gồm cả giá nhưng thiếu đi thành tiền chuhng nhé.
select  
hd.MaDonHang maDonHang,
hd.MaHoaDon, -- hoa don la khoa chinh 
dh.MaKhachHang maKhachHang,
dh.MaNhanVien maNhanVien,
dsdh.MaDoAn maDoAn,
dsdh.MaDoUong maDoUong,
dsdh.GiaTien,
dsdh.ThanhTien,
dsdh.GioVao gioVao,-- chua biet lay tu dau ra
dsdh.GioRa gioRa,-- luu o bang nao
@TongThanhTien  as 'Tổng thành tiền'
from 
 DonHangChiTiet dsdh
 join DonHang dh 
on dh.MaDonHang = dsdh.MaDonHang
join HoaDon hd
on hd.MaDonHang = dh.MaDonHang
	End
---

DECLARE @TongThanhTien FLOAT;
	--gán giá trị nó cho max lương
	SELECT top 1 @TongThanhTien = sum( SoLuong * GiaTien) 
	
	FROM DonHangChiTiet
	--where MaDonHang = 1
	--gọi ra và kết hợp điều kiện
	--SELECT top 1 @luongCaoNhat FROM DanhSachDonHang
	SELECT top 1  @TongThanhTien as tong ,TienNhan FROM DonHangChiTiet dsdh join 
	DonHang dh 
	on  dh.MaDonHang = dsdh.MaDonHang join	
	HoaDon hd 
	on hd.MaDonHang = dh.MaDonHang
---------------------------------------------



--- tạo proc hóa đơn  và lấy nó đi làm thông kê thanh toán.
alter proc sp_TongHopHoaDon
as begin
--DECLARE @TongTien money, @SoLuong int;
	--gán giá trị nó cho max lương
	--SELECT @TongTien = sum(TongThanhTien) FROM HoaDon 
	--SELECT @SoLuong = sum(SoLuong) FROM HoaDonChiTiet 

	--print 'TongTien = ' + CONVERT(varchar, @TongTien);
	--print 'SoLuong = ' + CONVERT(varchar, @SoLuong);

	SELECT hd.MaHoaDon, ns.HoVaTen, sum(TongThanhTien) as N'TongThanhTien' ,  sum(SoLuong) as 'SoLuong' FROM HoaDon hd
	join HoaDonChiTiet hdct on hd.MaHoaDon = hdct.MaHoaDon
	join NhanSu ns on ns.MaNhanVien = hd.MaNhanVien
	GROUP BY hd.MaHoaDon, ns.HoVaTen  --, sum(TongThanhTien),  sum(SoLuong), 
	

	SELECT hd.MaHoaDon, sum(TongThanhTien) as N'TongThanhTien' ,  sum(SoLuong) as 'SoLuong', hd.MaNhanVien 
	FROM HoaDon hd join HoaDonChiTiet hdct on hd.MaHoaDon = hdct.MaHoaDon
	GROUP BY hd.MaHoaDon, hd.MaNhanVien

	SELECT * FROM HoaDon hd join HoaDonChiTiet hdct on hd.MaHoaDon = hdct.MaHoaDon
	join NhanSu ns on ns.MaNhanVien = hd.MaNhanVien

	End

	execute sp_TongHopHoaDon

	select * from DonHang
	select * from DonHangChiTiet where MaDonHang = 1