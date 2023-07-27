package com.system.utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;

public class XImage {

    public static Image getAppIcon() {
        URL url = XImage.class.getResource("/com/system/image/NhanSu/AnhNhanVien.png");
        return new ImageIcon(url).getImage();
    }

    public static void save(File src) {
        File dst = new File("AnhNhanSu", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdir();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath()); 
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static void save(String folder, File src) {
        File dst = new File(folder, src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdir();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath()); 
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
 
/// đọc hình ảnh từ file

    public static ImageIcon read(String fileName) {
        // tạo đường dẫn lấy từ file logo của thư mục chứa ảnh.
        File path = new File("AnhNhanSu", fileName);             
        //tạo ra 1 đối tượng icon của img từ đường dẫn của file truyền lên
        ImageIcon icon = new ImageIcon(path.getAbsolutePath());
        // set kích thước cho ảnh của cái icon nè 
        Image img = resize(icon.getImage(), 200, 180); // 100 , 100 là chỉnh kích thước theo ý nha. cái đầu là width cái thứ 2 là height.
        // trả về hình ảnh trong srouce của logo
        return new ImageIcon(img); // trả về icon có trong thư mục logo
        
    }

    public static ImageIcon readImgDefau(String fileName) {
        // tạo đường dẫn lấy từ file logo của thư mục chứa ảnh.
        File path = new File("AnhMacDinh", fileName);             
        //tạo ra 1 đối tượng icon của img từ đường dẫn của file truyền lên
        ImageIcon icon = new ImageIcon(path.getAbsolutePath());
        // set kích thước cho ảnh của cái icon nè 
        Image img = resize(icon.getImage(), 200, 180); // 100 , 100 là chỉnh kích thước theo ý nha. cái đầu là width cái thứ 2 là height.
        // trả về hình ảnh trong srouce của logo
        return new ImageIcon(img); // trả về icon có trong thư mục logo
        
    }
    
    // hàm để chúng ta resize( chỉnh kích thước ảnh ) theo ý muốn 
    public static Image resize(Image originalImage, int targetWith, int targetHeight) {
        // lấy cái hình ảnh với kích thước .
        Image resultingImage = originalImage.getScaledInstance(targetWith, targetHeight, Image.SCALE_SMOOTH);
        return resultingImage;
    }
    
    public static ImageIcon readNotPath(String pathNew, String fileName) {
        // tạo đường dẫn lấy từ file logo của thư mục chứa ảnh.
        File path = new File(pathNew, fileName);             
        //tạo ra 1 đối tượng icon của img từ đường dẫn của file truyền lên
        ImageIcon icon = new ImageIcon(path.getAbsolutePath());
        // trả về hình ảnh trong srouce của logo
        return icon; // trả về icon có trong thư mục logo
        
    }
    
    public static ImageIcon readNotPath(String pathNew, String fileName, boolean resize) {
        // tạo đường dẫn lấy từ file logo của thư mục chứa ảnh.
        File path = new File(pathNew, fileName);             
        //tạo ra 1 đối tượng icon của img từ đường dẫn của file truyền lên
        ImageIcon icon = new ImageIcon(path.getAbsolutePath());
        
        Image img = resize(icon.getImage(), 200, 180);
        // trả về hình ảnh trong srouce của logo
        return new ImageIcon(img); // trả về icon có trong thư mục logo
        
    }

}
