package com.sidratul.belajar.spring.security.produk;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdukController {
    @Autowired private ProdukDao pd;
    
    @RequestMapping("produk/daftar-produk")
    public ModelMap tampilDaftarProduk() throws SQLException{
        ModelMap mm = new ModelMap();
        List<Produk> lp = pd.tampilProduk();
        mm.addAttribute("daftarProduk",lp);
        return mm;
    }
}
