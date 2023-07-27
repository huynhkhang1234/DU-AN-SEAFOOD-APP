//package com.poly.Test_donHang;
//
//import com.system.DAO.DonHangChiTietDAO;
//import com.system.DAO.DonHangDAO;
//import com.system.DAO.HoaDonChiTietDAO;
//import com.system.model.code.DonHang;
//import com.system.model.code.DonHangChiTiet;
//import com.system.model.code.HoaDonChiTiet;
//
//import java.util.List;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//
//
//public class donHang {
//	
//	DonHang dh = new DonHang();
//	DonHangChiTiet dhct = new DonHangChiTiet();
//	HoaDonChiTiet hd = new HoaDonChiTiet();
//	
//	HoaDonChiTietDAO daoct = new HoaDonChiTietDAO();
//	DonHangDAO dao = new DonHangDAO();
//	DonHangChiTietDAO daodhct = new DonHangChiTietDAO();
//	
//	private String expected, actual;
//		@Test
//	public void themDonHangTaiBan() {
//		expected = "Thêm đơn hàng thành công tại bàn";
//		try {
//			
//			dh.setMaNhanVien("QL01");
//			dh.setMaKhachHang("KH002");
//			dh.setGhiChu("thêm đơn hàng 1");			
//			dh.setGioVao("8:25");
//			dh.setGioRa("9:25");
//			dh.setSoBan(1);
//			dao.insert(dh);
//			actual = "Thêm đơn hàng thành công tại bàn";
//			System.out.println("Thêm đơn hàng thành công tại bàn");
//		} catch (Exception e) {
//			actual = "Thêm đơn hàng thất bại tại bàn";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	@Test
//	public void ThemMonAnSoLuongKhongAm() {
//		System.out.println();
//		System.out.println();
//		expected = "Thêm đơn hàng thành công số lượng không âm tại bàn";
//		try {			
//			dhct.setMaDonHang(31);
//			dhct.setMaDoAn("DA-001");
//			dhct.setMaDoUong("DU-001");
//			dhct.setSoLuong(1);
//			dhct.setGiaTien(18000);
//			dhct.setThanhTien(18000);			
//			daodhct.insert(dhct);
//			actual = "Thêm đơn hàng thành công số lượng không âm tại bàn";
//			System.out.println("Thêm đơn hàng thành công số lượng không âm tại bàn");
//		} catch (Exception e) {
//			actual = "Thêm đơn hàng thất bại số lượng không âm tại bàn";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	@Test
//	public void XoaDonHangTaiBan() {
//		System.out.println();
//		System.out.println();
//		expected = "Xóa đơn hàng thành công tại bàn";
//		try {
//			dh.setMaDonHang(31);
//			dh.setMaNhanVien("QL01");
//			dh.setMaKhachHang("KH002");
//			dh.setGhiChu("");			
//			dh.setGioVao("");
//			dh.setGioRa("");
//			dh.setSoBan(0);
//			dao.update(dh);
//			actual = "Xóa đơn hàng thành công tại bàn";
//			System.out.println("Xóa đơn hàng thành công tại bàn");
//		} catch (Exception e) {
//			actual = "Xóa đơn hàng thất bại tại bàn";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	@Test
//	public void XemDanhSachMonAnTaiBan() {
//		System.out.println();
//		System.out.println();
//		expected = "Xem danh sách món ăn tại bàn";
//		try {			
//		List<DonHangChiTiet> dh =  daodhct.selectAll();
//			for (DonHangChiTiet dhctt : dh) {
//				System.out.print(dhctt.getMaDoAn() +" ,");
//			}
//			actual = "Xem danh sách món ăn tại bàn";
//			System.out.println();
//			System.out.println("Xem danh sách món ăn tại bàn");
//		} catch (Exception e) {
//			actual = "Xem danh sách món ăn tại bàn thất bại";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	@Test
//	public void XemDanhSachDoUongTaiBan() {
//		System.out.println();
//		System.out.println();
//		expected = "Xem danh sách đồ uống tại bàn";
//		try {			
//		List<DonHangChiTiet> dh =  daodhct.selectAll();
//			for (DonHangChiTiet dhctt : dh) {
//				System.out.print(dhctt.getMaDoUong() +" ,");
//			}
//			actual = "Xem danh sách đồ uống tại bàn";
//			System.out.println();
//			System.out.println("Xem danh sách đồ uống tại bàn");
//		} catch (Exception e) {
//			actual = "Xem danh sách đồ uống tại bàn thất bại";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	
//	@Test
//	public void XemDanhSachSoLuongDungTaiBan() {
//		System.out.println();
//		System.out.println();
//		expected = "Xem danh sách số lượng dùng tại bàn";
//		try {			
//		List<DonHang> dh1 =  dao.selectAll();
//		System.out.println("Số bàn hiện có trong danh sách là: ");
//			for (DonHang donHang : dh1) {
//				
//				System.out.print(donHang.getSoBan()+" ,");
//			}
//			actual = "Xem danh sách số lượng dùng tại bàn";			
//		} catch (Exception e) {
//			actual = "Xem danh sách đồ uống tại bàn thất bại";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	@Test
//	public void XemDanhSachSoLuongMaDonHangTaiBan() {
//		System.out.println();
//		System.out.println();
//		expected = "Xem danh sách số lượng mã đơn hàng tại bàn";
//		try {			
//		List<DonHang> dh1 =  dao.selectAll();
//		System.out.println("Mã đơn hàng của số bàn có trong danh sách là: ");
//			for (DonHang donHang : dh1) {
//				
//				System.out.print(donHang.getMaDonHang()+" ,");
//			}
//			actual = "Xem danh sách số lượng mã đơn hàng tại bàn";			
//		} catch (Exception e) {
//			actual = "Xem danh sách số lượng mã đơn hàng tại bàn thất bại";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	@Test
//	public void XemDanhSachSoLuongMaNhanVien() {
//		System.out.println();
//		System.out.println();
//		expected = "Xem danh sách số lượng mã nhân viên có trong đơn hàng";
//		try {			
//		List<DonHang> dh1 =  dao.selectAll();
//		System.out.println("Số lượng mã nhân viên có trong danh sách là: ");
//			for (DonHang donHang : dh1) {
//				
//				System.out.print(donHang.getMaNhanVien()+" ,");
//			}
//			actual = "Xem danh sách số lượng mã nhân viên có trong đơn hàng";			
//		} catch (Exception e) {
//			actual = "Xem danh sách số lượng mã nhân viên có trong đơn hàng thất bại";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	
//	@Test
//	public void XemDanhSachSoLuongMaKhachHang() {
//		System.out.println();
//		System.out.println();
//		expected = "Xem danh sách số lượng mã khách hàng có trong đơn hàng";
//		try {			
//		List<DonHang> dh1 =  dao.selectAll();
//		System.out.println();
//		System.out.println("Số lượng mã khách hàng có trong danh sách là: ");
//			for (DonHang donHang : dh1) {
//				
//				System.out.print(donHang.getMaKhachHang()+" ,");
//			}
//			actual = "Xem danh sách số lượng mã khách hàng có trong đơn hàng";			
//		} catch (Exception e) {
//			actual = "Xem danh sách số lượng mã khách hàng có trong đơn hàng thất bại";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	@Test
//	public void tongTienThanhToanDonHang() {
//		System.out.println();
//		System.out.println();
//		expected = "Tổng tiền thành toán trong đơn hàng";
//		double sumMoney = 0;
//		try {			
//		List<DonHang> dh1 =  dao.selectAll();
//		System.out.println();
//		System.out.println("Số lượng mã khách hàng có trong danh sách là: ");
//			for (DonHang donHang : dh1) {
//				sumMoney+=donHang.getTongTienThanhToan();
//				System.out.print(donHang.getTongTienThanhToan()+" ,");
//			}
//			System.out.println("Tổng tiền thành toán của đơn hàng: " + sumMoney);
//			actual = "Tổng tiền thành toán trong đơn hàng";			
//		} catch (Exception e) {
//			actual = "Tổng tiền thành toán trong đơn hàng thất bại";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	@Test
//	public void TongSoBantrongDonHang() {
//		System.out.println();
//		System.out.println();
//		expected = "Tổng số bàn hiện có  trong tổng đơn hàng";
//		double sumMoney = 0;
//		try {			
//		List<DonHang> dh1 =  dao.selectAll();		
//		System.out.println("Số bàn có trong danh sách đơn hàng: ");
//			for (DonHang donHang : dh1) {
//				sumMoney++;
//				System.out.print(donHang.getSoBan()+" ,");
//			}
//			System.out.println();
//			System.out.println("Tổng số bàn hiện có trong tất cả  đơn hàng: " + sumMoney);
//			
//			actual = "Tổng số bàn hiện có  trong tổng đơn hàng";			
//		} catch (Exception e) {
//			actual = "Tổng số bàn hiện có  trong tổng đơn hàng thất bại";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	// hoa đơn chi tiết
//	@Test
//	public void DanhSachTenMonAnVaTenUong() {
//		System.out.println();
//		System.out.println();
//		expected = "Xem danh sách tên món ăn và đồ uống";
//		try {			
//		List<HoaDonChiTiet> dh1 =  daoct.selectAll();		
//		System.out.println("Xem danh sách tên món ăn và đồ uống: ");
//		for (HoaDonChiTiet hoaDonChiTiet : dh1) {
//			System.out.print(hoaDonChiTiet.getTenDoAnVaDoUong() + " ,");
//		}
//			actual = "Xem danh sách tên món ăn và đồ uống";			
//		} catch (Exception e) {
//			actual = "Xem danh sách tên món ăn và đồ uống thất bại";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	@Test
//	public void XemTongThanhTien() {
//		System.out.println();
//		System.out.println();
//		double sumMoney = 0;
//		expected = "Xem tổng thành tiền món ăn trong hóa đơn chi tiết";
//		try {			
//		List<HoaDonChiTiet> dh1 =  daoct.selectAll();
//		System.out.println();
//		System.out.println("Xem tổng thành tiền : ");
//		for (HoaDonChiTiet hoaDonChiTiet : dh1) {
//			sumMoney += hoaDonChiTiet.getThanhTien();
//			System.out.print(hoaDonChiTiet.getThanhTien()+ " ,");
//		}
//		System.out.println("Tổng thành tiền các món: " + sumMoney);
//			actual = "Xem tổng thành tiền món ăn trong hóa đơn chi tiết";			
//		} catch (Exception e) {
//			actual = "Xem danh sách tên món ăn và đồ uống thất bại";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(expected, actual);		
//	}
//	
//}
