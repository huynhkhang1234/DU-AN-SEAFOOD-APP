/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.PrintBill;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;

import com.itextpdf.text.pdf.PdfWriter;
import com.system.DAO.DatBanDAO;
import com.system.DAO.DoAnDAO;
import com.system.DAO.DoUongDAO;
import com.system.DAO.DonHangChiTietDAO;
import com.system.DAO.DonHangDAO;
import com.system.DAO.HoaDonChiTietDAO;
import com.system.DAO.HoaDonDAO;
import com.system.DAO.NhanSuDAO;
import com.system.method.Format_Money;
import com.system.model.code.DatBan;
import com.system.model.code.DoAn;
import com.system.model.code.DoUong;
import com.system.model.code.DonHang;
import com.system.model.code.DonHangChiTiet;
import com.system.model.code.HoaDon;
import com.system.model.code.HoaDonChiTiet;
import com.system.model.code.NhanSu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tran Thi Hong Tham
 */
public class PrintBill {

    private static final DonHangDAO daoDH = new DonHangDAO();
    private static final DonHangChiTietDAO daoDHCT = new DonHangChiTietDAO();
    private static final DoAnDAO daoDA = new DoAnDAO();
    private static final DoUongDAO daoDU = new DoUongDAO();
    private static final HoaDonDAO daoHD = new HoaDonDAO();
    private static final HoaDonChiTietDAO daoHDCT = new HoaDonChiTietDAO();
    private static final DatBanDAO daoDB = new DatBanDAO();
    private static final NhanSuDAO daoNS = new NhanSuDAO();

    private static DonHang dh;
    private static List<DonHangChiTiet> listDHCT;
    private static int soBienLai = 1;

    private static final String HoaDonThanhToan = "\\HoaDonThanhToan.pdf";
    private static final String InChoBep = "\\HoaDonChoBep.pdf";

    public static boolean printBill(DonHang dh) throws FileNotFoundException, DocumentException, IOException {
        File f = new File("");
        FileOutputStream fos = new FileOutputStream(f.getAbsoluteFile() + HoaDonThanhToan);
        //
        
        PrintBill.dh = dh;
        PrintBill.listDHCT = daoDHCT.selectByMaDonHang(dh.getMaDonHang());
        NhanSu ns = daoNS.selectByID(dh.getMaNhanVien());

        try {
            HoaDon hd = new HoaDon();
            HoaDon model = PrintBill.getForm(hd);
            daoHD.insert(model);

            HoaDonChiTiet hdct = new HoaDonChiTiet();
            List<HoaDonChiTiet> list = getForm(hdct);
            if (list != null) {
                for (HoaDonChiTiet item : list) {
                    daoHDCT.insert(item);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, fos);
            document.open();
            File dicrectory = new File("");
            document.add(Image.getInstance(dicrectory.getAbsolutePath() + "\\logos\\logo.png"));
          //
            Font fdc = new Font(BaseFont.createFont("/com/system/font/SVN-Times New Roman 2.ttf",
             BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            fdc.setSize(16);

           Paragraph dc = new Paragraph("Địa chỉ:Số 123 Đ.Nguyễn Văn Linh,P. Hưng Lợi, Q. Ninh Kiều, TP. Cần Thơ\n Hotline:0896413466", fdc);
            dc.setAlignment(Element.ALIGN_RIGHT);
            
              document.add(dc);

           Font fBienLai = new Font(BaseFont.createFont("/com/system/font/font-times-new-roman.ttf",
             BaseFont.IDENTITY_H, BaseFont.NOT_CACHED));
            fBienLai.setSize(30);
            Paragraph Bienlai = new Paragraph("Biên lai\n",fBienLai);
            Bienlai.setAlignment(Element.ALIGN_CENTER);
            document.add(Bienlai);
            //

             Font fThongTin = new Font(BaseFont.createFont("/com/system/font/SVN-Times New Roman 2.ttf",
             BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            fThongTin.setSize(18);
            if (dh.getSoBan() == 0) {
                Paragraph thongTin = new Paragraph("-------------------------------------------------------------------------------------\n"
                        + "Số biên lai:\t\t\t   BL08410" + soBienLai++ + "\n"
                        + "Hóa đơn:\t\t\t       HD-" + dh.getMaDonHang() + "\n"
                        + "Phục vụ bởi:\t\t\t   " + ns.getHoVaTen() + "\n" // chỗ này bỏ tên nhân viên ở trên vào
                        + "Giờ vào:\t\t\t       " + dh.getGioVao() + "\n" // set giờ vào
                        + "Giờ ra:\t\t\t        " + dh.getGioRa() +" \n" // set giờ ra
                        + "------------------------------------------------------------------------------------\n", fThongTin);
                thongTin.setAlignment(Element.ALIGN_LEFT);
                document.add(thongTin);
            } else {
                Paragraph thongTin = new Paragraph("-------------------------------------------------------------------------------------\n"
                        + "Số biên laii:\t\t\t   BL08410" + soBienLai++ + "\n"
                        + "Hóa đơn:\t\t\t       HD-" + dh.getMaDonHang() + "\n"
                        + "Số bàn:\t\t\t        " + dh.getSoBan() + "\n"
                        + "Phục vụ bởi:\t\t\t   " + ns.getHoVaTen()+ "\n" // chỗ này bỏ tên nhân viên ở trên vào
                        + "Giờ vào:\t\t\t       " + dh.getGioVao() + "\n" // set giờ vào
                        + "Giờ ra:\t\t\t        " + dh.getGioRa() + "\n" // set giờ ra
                        + "------------------------------------------------------------------------------------\n", fThongTin);
                thongTin.setAlignment(Element.ALIGN_LEFT);
                document.add(thongTin);
            }

            //------------------------------------------------Chỗ này là in ra số món ăn nè-------------------------------------------
            
            Font fMatHang = new Font(BaseFont.createFont("/com/system/font/font-times-new-roman.ttf",
             BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            fMatHang.setSize(18);
           
            Paragraph matHang = new Paragraph("Mặt hàng:               Giá                 Số lượng                Thành tiền", fMatHang);

            matHang.setAlignment(Element.ALIGN_LEFT);
            
            document.add(matHang);
            
            
             Font fNoiDung = new Font(BaseFont.createFont("/com/system/font/SVN-Times New Roman 2.ttf",
             BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            fNoiDung.setSize(18);

            List<DonHangChiTiet> list = daoDHCT.selectByMaDonHang(dh.getMaDonHang());
            for (DonHangChiTiet dhct : list) {
                String tenDoAn;
                if (dhct.getMaDoAn() != null || dhct.getMaDoUong() != null) {
                    if (dhct.getMaDoAn() == null) {
                        DoUong du = daoDU.selectByID(dhct.getMaDoUong());
                        tenDoAn = du.getTenDoUong();
                    } else {
                        DoAn da = daoDA.selectByID(dhct.getMaDoAn());
                        tenDoAn = da.getTenDoAn();
                    }
                    Paragraph noiDung = new Paragraph(tenDoAn + "          " + Format_Money.formatMoney(dhct.getGiaTien()).replace("VNĐ", "").trim() + "              " + dhct.getSoLuong() + "                          " 
                            + Format_Money.formatMoney(dhct.getThanhTien()).replace("VNĐ", "").trim() + "\n\n",
                            fNoiDung);
                    noiDung.setAlignment(Element.ALIGN_LEFT);
                    document.add(noiDung);
                }

            }

            Paragraph noiDung = new Paragraph("\nTổng                                                                            " + Format_Money.formatMoney(dh.getTongTienThanhToan()) + "\n",
                    fNoiDung);
            noiDung.setAlignment(Element.ALIGN_LEFT);
            document.add(noiDung);

            //
            List<DatBan> listDB = daoDB.selectBySoBan(dh.getSoBan());
            double tienCoc = 0;
            if (listDB != null) {
                for (DatBan db : listDB) {
                    if (db.getMaKhachHang().equalsIgnoreCase(dh.getMaKhachHang())) {
                        tienCoc = db.getTienCoc();
                    }
                }
            }
             Font fTong = new Font(BaseFont.createFont("/com/system/font/SVN-Times New Roman 2.ttf",
             BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                    fTong.setSize(18);
            Paragraph Tong = new Paragraph("-------------------------------------------------------------------------------------\n"
                    + "Tổng cộng                               " + Format_Money.formatMoney(dh.getTongTienThanhToan()) + "\n"
                    + "Giảm giá                                0 VND\n"
                    + "Tiền cọc                                " + Format_Money.formatMoney(tienCoc) + "\n"
                    + "Tiền nhận                               " + Format_Money.formatMoney(dh.getTongTienThanhToan()) + "\n", fTong);

            Tong.setAlignment(Element.ALIGN_LEFT);
            document.add(Tong);
            //
            
            
             Font fThanhToan = new Font(BaseFont.createFont("/com/system/font/SVN-Times New Roman 2.ttf",
             BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            fThanhToan.setSize(18);
            Paragraph Thanhtoan = new Paragraph("-------------------------------------------------------------------------------------\n"
                    + "Thanh toán: " + Format_Money.formatMoney(dh.getTongTienThanhToan() - tienCoc) + "\n"
                    + "Tiền thừa: 0 VND\n",
                    fThanhToan);
            Thanhtoan.setAlignment(Element.ALIGN_RIGHT);
            document.add(Thanhtoan);
            //
           Font fKet = new Font(BaseFont.createFont("/com/system/font/SVN-Times New Roman 2.ttf",
             BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            fKet.setSize(18);
            Paragraph ket = new Paragraph("------------------------------------------------------------------------------------"
                    + "\nCảm ơn & chúc quý khách một ngày tốt lành\n", fKet);
            ket.setAlignment(Element.ALIGN_CENTER);
            document.add(ket);

            document.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            document.close();
            return false;
        }
    }
    
    public static boolean printBillForKitchen(DonHang dh, String gioGoiMon) throws FileNotFoundException {
        File f = new File("");
        FileOutputStream fos = new FileOutputStream(f.getAbsoluteFile() + InChoBep);
        
        PrintBill.dh = dh;
        PrintBill.listDHCT = daoDHCT.selectByMaDonHang(dh.getMaDonHang());
        NhanSu ns = daoNS.selectByID(dh.getMaNhanVien());

        try {
            HoaDon hd = new HoaDon();
            HoaDon model = PrintBill.getForm(hd);
            daoHD.insert(model);

            HoaDonChiTiet hdct = new HoaDonChiTiet();
            List<HoaDonChiTiet> list = getForm(hdct);
            if (list != null) {
                for (HoaDonChiTiet item : list) {
                    daoHDCT.insert(item);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, fos);
            document.open();
               File dicrectory = new File("");
            document.add(Image.getInstance(dicrectory.getAbsolutePath() + "\\logos\\logo.png"));
           
           Font fBienLai = new Font(BaseFont.createFont("/com/system/font/font-times-new-roman.ttf",
             BaseFont.IDENTITY_H, BaseFont.NOT_CACHED));
            fBienLai.setSize(30);

            Paragraph Bienlai = new Paragraph("Biên lai nấu đồ ăn\n", fBienLai);
            Bienlai.setAlignment(Element.ALIGN_CENTER);
            document.add(Bienlai);
            //

          Font fThongTin = new Font(BaseFont.createFont("/com/system/font/SVN-Times New Roman 2.ttf",
             BaseFont.IDENTITY_H, BaseFont.NOT_CACHED));
            fThongTin.setSize(18);
            if (dh.getSoBan() == 0) {
                Paragraph thongTin = new Paragraph("-------------------------------------------------------------------------------------\n"
                        + " Số biên lai:\t\t\t   BL08410" + soBienLai++ + "\n"
                        + "Hóa đơn:\t\t\t        HD-" + dh.getMaDonHang() + "\n"
                        + "Người gọi món:\t\t\t   " + ns.getHoVaTen() + "\n" // chỗ này bỏ tên nhân viên ở trên vào
                        + "Giờ gọi món:\t\t\t       " + gioGoiMon + "\n" // set giờ 
                        + "------------------------------------------------------------------------------------\n", fThongTin);
                thongTin.setAlignment(Element.ALIGN_LEFT);
                document.add(thongTin);
            } else {
                Paragraph thongTin = new Paragraph("-------------------------------------------------------------------------------------\n"
                        + "Số biên lai:\t\t\t BL08410" + soBienLai++ + "\n"
                        + "Hóa đơn:\t\t\t HD-" + dh.getMaDonHang() + "\n"
                        + "Số bàn:\t\t\t " + dh.getSoBan() + "\n"
                       + "Người gọi món:\t\t\t " + ns.getHoVaTen() + "\n" // chỗ này bỏ tên nhân viên ở trên vào
                        + "Giờ gọi món:\t\t\t " + gioGoiMon + "\n" // set giờ 
                                //
                               
                       
                        + "------------------------------------------------------------------------------------\n", fThongTin);
                thongTin.setAlignment(Element.ALIGN_LEFT);
                document.add(thongTin);
            }

            //------------------------------------------------Chỗ này là in ra số món ăn nè-------------------------------------------
            
             Font fMatHang = new Font(BaseFont.createFont("/com/system/font/font-times-new-roman.ttf",
             BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            fMatHang.setSize(18);
            Paragraph matHang = new Paragraph("Mặt hàng                         Số lượng                     Ghi chú", fMatHang);

            matHang.setAlignment(Element.ALIGN_CENTER);
            document.add(matHang);
            //-----------------------------------------------------------------------------------------------------------------
            
            
           Font fNoiDung = new Font(BaseFont.createFont("/com/system/font/SVN-Times New Roman 2.ttf",
             BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                      fNoiDung.setSize(18);

            List<DonHangChiTiet> list = daoDHCT.selectByMaDonHang(dh.getMaDonHang());
            for (DonHangChiTiet dhct : list) {
                String tenDoAn;
                if (dhct.getMaDoAn() != null || dhct.getMaDoUong() != null) {
                    if (dhct.getMaDoAn() == null) {
                        DoUong du = daoDU.selectByID(dhct.getMaDoUong());
                        tenDoAn = du.getTenDoUong();
                    } else {
                        DoAn da = daoDA.selectByID(dhct.getMaDoAn());
                        tenDoAn = da.getTenDoAn();
                    }
                    Paragraph noiDung = new Paragraph("           "+tenDoAn + "                        " + dhct.getSoLuong() + "                        " + dh.getGhiChu(),
                            fNoiDung); 
                    noiDung.setAlignment(Element.ALIGN_LEFT);
                    document.add(noiDung);
                }

            }

           
              Font fKet = new Font(BaseFont.createFont("/com/system/font/SVN-Times New Roman 2.ttf",
             BaseFont.IDENTITY_H, BaseFont.EMBEDDED));                 
            fKet.setSize(18);
            Paragraph ket = new Paragraph("------------------------------------------------------------------------------------\n", fKet);
            ket.setAlignment(Element.ALIGN_CENTER);
            document.add(ket);

            document.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            document.close();
            return false;
        }
    }

    private static HoaDon getForm(HoaDon model) throws ParseException {

        model.setTongThanhTien(dh.getTongTienThanhToan());
        model.setTienNhan(dh.getTongTienThanhToan());
        SimpleDateFormat time = new SimpleDateFormat("dd-MM-yyyy");
        String ngay = time.format(new Date());
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(ngay);
        model.setNgayBan(date);
        model.setSoBan(dh.getSoBan());
        model.setGioVao(dh.getGioVao());
        model.setGioRa(dh.getGioRa());
        model.setGhiChu(dh.getGhiChu());
        model.setMaNhanVien(dh.getMaNhanVien());
        model.setMaDonHang(dh.getMaDonHang());
        model.setMaKhachHang(dh.getMaKhachHang());

        return model;
    }

    public static List<HoaDonChiTiet> getForm(HoaDonChiTiet model) throws ParseException {
        List<HoaDonChiTiet> list = new ArrayList<>();
        HoaDon hd = daoHD.selectByMDH(dh.getMaDonHang());
        if (listDHCT != null) {
            for (DonHangChiTiet dhct : listDHCT) {
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setMaHoaDon(hd.getMaHoaDon());
            if (dhct.getMaDoUong() == null || dhct.getMaDoUong().isEmpty()) {
                hdct.setTenDoAnVaDoUong(daoDA.selectByID(dhct.getMaDoAn()).getTenDoAn());
            } else {
                hdct.setTenDoAnVaDoUong(daoDU.selectByID(dhct.getMaDoAn()).getTenDoUong());
            }
            hdct.setSoLuong(dhct.getSoLuong());
            hdct.setGia(dhct.getGiaTien());
            hdct.setThanhTien(dhct.getThanhTien());
            list.add(hdct);
        }
        }
        return list;
    }

}
