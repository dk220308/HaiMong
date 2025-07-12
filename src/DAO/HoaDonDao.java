/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.HoaDon;
import Service.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XPS
 */
public class HoaDonDao {
    
    public int themHD(HoaDon hd) {
    String sql = "INSERT INTO HoaDon (MaHD, MaKH, MaNV, NgayLap, TrangThai, TongTien) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection con = DBConnect.getConnection();
         PreparedStatement pstm = con.prepareStatement(sql)) {

        pstm.setInt(1, hd.getMaHD());
        pstm.setInt(2, hd.getMaKH());
        pstm.setInt(3, hd.getMaNV());
        pstm.setDate(4, hd.getNgayLap());
        pstm.setString(5, hd.getTrangThai());
        pstm.setDouble(6, hd.getTongTien());    

        return pstm.executeUpdate(); // Trả về 1 nếu thành công
    } catch (Exception ex) {
        ex.printStackTrace(); // Bắt buộc in lỗi
        return 0;
    }
}


    public Object[] getRow(HoaDon hd) {
        String mahd = hd.getMahd();
        String manv = hd.getManv();
        String tenkh = hd.getTenkh();
        String sdt = hd.getSdt();
        String trangThai = hd.getTrangThai();
        String ngayTao = hd.getNgayTao();
        float tongTien = hd.getTongTien();
        float tienTra = hd.getTienTra();
        float tienThua = hd.getTienThua();
        String thanhToan = hd.getThanhToan();
        String giaoHang = hd.getGiaoHang();
        String ghichu = hd.getGhiChu();

        Object[] row = new Object[]{mahd, manv, tenkh, sdt, trangThai, ngayTao, tongTien, tienTra, tienThua, thanhToan, giaoHang, ghichu};
        return row;
    }

    public List<HoaDon> getAll() {
        List<HoaDon> listHD = new ArrayList<>();
        String sql = "select * from HoaDon";
        try {
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String mahd = rs.getString(1);
                String manv = rs.getString(2);
                String tenkh = rs.getString(3);
                String sdt = rs.getString(4);
                String trangThai = rs.getString(5);
                String ngayTao = rs.getString(6);
                float tongTien = rs.getFloat(7);
                float tienTra = rs.getFloat(8);
                float tienThua = rs.getFloat(9);
                String thanhToan = rs.getString(10);
                String giaoHang = rs.getString(11);
                String ghichu = rs.getString(12);
                HoaDon hd = new HoaDon(mahd, manv, tenkh, sdt, trangThai, ngayTao, tongTien, tienTra, tienThua, thanhToan, giaoHang, ghichu);
                listHD.add(hd);
            }
        } catch (Exception ex) {
        }

        return listHD;
    }
}
