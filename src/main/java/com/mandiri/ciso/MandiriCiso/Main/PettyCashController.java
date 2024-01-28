package com.mandiri.ciso.MandiriCiso.Main;

import com.mandiri.ciso.MandiriCiso.Model.PettyCash;
import com.mandiri.ciso.MandiriCiso.Service.PettyCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PettyCashController {

    private final PettyCashService pettyCashService;

    @Autowired
    public PettyCashController(PettyCashService pettyCashService) {
        this.pettyCashService = pettyCashService;
    }


    @GetMapping("/pettycash")
    public String pettyash(Model model, Authentication user) {
        System.out.println(user);
        model.addAttribute("name", user.getName());
        model.addAttribute("pettyCashList", pettyCashService.getList());
        model.addAttribute("userRole", user.getAuthorities().toString());

        return "pettycash";
    }

    @PostMapping("/pettycash")
    public String pettyashPost(PettyCash pettyCash, RedirectAttributes redirectAttributes, String datez) throws ParseException {

        String pattern = "yyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(datez);

        System.out.println(date);

        pettyCashService.newPettyCash(new PettyCash(
                pettyCash.getTransaksi(),
                pettyCash.getJenis_transaksi(),
                pettyCash.getNominal(),
                date
        ));
        redirectAttributes.addFlashAttribute("success", "Berhasil menambahkan petty cash baru!");
        return "redirect:/pettycash";
    }
}
