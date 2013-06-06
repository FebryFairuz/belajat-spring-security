package com.sidratul.belajar.spring.security.produk;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProdukDao {
    @Autowired private DataSource dataSource;
    
    public void simpanProduk(Produk p) throws SQLException{
        Connection c = dataSource.getConnection();
        String sqlSimpan = "INSERT INTO `produk`(`kodeProduk`, `nama`, `harga`, `terakhirUpdate`) VALUES (?,?,?,?)";
        PreparedStatement psSimpan = c.prepareStatement(sqlSimpan);
        psSimpan.setString(1, p.getKodeProduk());
        psSimpan.setString(2, p.getNama());
        psSimpan.setBigDecimal(3, p.getHarga());
        psSimpan.setDate(4, new java.sql.Date(p.getTerakhirUpdate().getTime()));
        psSimpan.executeUpdate();
        c.close();
    }
    
    public List<Produk> tampilProduk() throws SQLException{
        List<Produk> lp = new ArrayList<Produk>();
        Connection c = dataSource.getConnection();
        String sqlTampil = "SELECT * FROM produk";
        PreparedStatement psTampil = c.prepareStatement(sqlTampil);
        ResultSet rs = psTampil.executeQuery();
        while(rs.next()){
            Produk p = new Produk();
            p.setId(rs.getInt("id"));
            p.setKodeProduk(rs.getString("kodeProduk"));
            p.setNama(rs.getString("nama"));
            p.setHarga(rs.getBigDecimal("harga"));
            p.setTerakhirUpadate(rs.getDate("terakhirUpdate"));
            lp.add(p);
        }
        c.close();
        return lp;
    }
}