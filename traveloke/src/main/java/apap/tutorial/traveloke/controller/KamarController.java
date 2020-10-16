package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/kamar/add/{idHotel}")
    private String addKamarFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        KamarModel kamar = new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        kamar.setHotel(hotel);
        model.addAttribute("kamar", kamar);
        model.addAttribute("pageName", "Tambah Kamar");
        return "form-add-kamar";
    }

    @PostMapping("/kamar/add")
    private String addKamarSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        System.out.println("kamar = " + kamar);
        kamarService.addKamar(kamar);
        model.addAttribute("kamar", kamar);
        model.addAttribute("pageName", "Tambah Kamar");
        return "add-kamar";
    }

    @GetMapping("/kamar/change/{noKamar}")
    public String changeKamarFormPage(
            @PathVariable Long noKamar,
            Model model
    ){
        KamarModel kamar = kamarService.getKamarByNoKamar(noKamar);
        model.addAttribute("kamar", kamar);
        model.addAttribute("pageName", "Update Kamar");
        return "form-update-kamar";
    }

    @PostMapping("/kamar/change")
    public String changeKamarFormSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        KamarModel kamarUpdated = kamarService.updateKamar(kamar);
        model.addAttribute("kamar", kamar);
        model.addAttribute("pageName", "Update Kamar");
        return "update-kamar";
    }

    @GetMapping("/kamar/delete/{noKamar}")
    public String deleteWithPathVariable(
            @PathVariable(value="noKamar", required = true) Long noKamar,
            Model model
    ){
        KamarModel kamar = kamarService.getKamarByNoKamar(noKamar);
        kamarService.deleteKamar(kamar);
        model.addAttribute("kamar", kamar);
        model.addAttribute("pageName", "Hapus Kamar");
        return "delete-kamar";
    }

    @PostMapping(path = "/kamar/delete")
    public String deleteKamarFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        model.addAttribute("kamarCount", hotel.getListKamar().size());
        model.addAttribute("pageName", "Hapus Kamar");
        for(KamarModel kamar : hotel.getListKamar()){
            kamarService.deleteKamar(kamar);
        }

        return "delete-kamar";
    }
}
