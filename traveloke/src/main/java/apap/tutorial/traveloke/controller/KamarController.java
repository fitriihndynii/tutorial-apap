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

        return "form-add-kamar";
    }

    @PostMapping("/kamar/add")
    private String addKamarSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        kamarService.addKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "add-kamar";
    }

//    @GetMapping("/kamar/change/{noKamar}")
//    public String changeKamarFormPage(
//            @PathVariable Long noKamar,
//            Model model
//    )
//    @GetMapping("/hotel/change/{idHotel}")
//    public String changeHotelFormPage(
//            @PathVariable Long idHotel,
//            Model model
//    ){
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//        model.addAttribute("hotel", hotel);
//        return "form-update-hotel";
//    }
//
//    @PostMapping("/hotel/change")
//    public String changeHotelFormSubmit(
//            @ModelAttribute HotelModel hotel,
//            Model model
//    ){
//        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
//        model.addAttribute("hotel", hotel);
//        return "update-hotel";
//    }
}
