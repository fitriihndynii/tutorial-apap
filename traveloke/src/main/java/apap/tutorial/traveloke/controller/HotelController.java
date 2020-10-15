package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @GetMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel", new HotelModel());
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(
            @ModelAttribute HotelModel hotel,
            Model model){
        hotelService.addHotel(hotel);
        model.addAttribute("idHotel", hotel.getId());
        return "add-hotel";
    }

    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
//        int action = 2; //update
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//        if(hotel == null){
//            model.addAttribute("action", action);
//            return "notfound-error";
//        }
        model.addAttribute("hotel", hotel);
        return "form-update-hotel";
    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel", hotelUpdated);
        return "update-hotel";
    }

    @GetMapping("/hotel/view")
    public String viewDetailHotel(
            @RequestParam(value = "idHotel") Long idHotel,
            Model model
    ){
//        int action = 1; //view
//        boolean adaKamar;
//        if(hotel == null){
//            model.addAttribute("action", action);
//            return "notfound-error";
//        }else if(hotel.getListKamar().isEmpty()){
//            adaKamar = false;
//        }else{
//            adaKamar = true;
//        }
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
        boolean hasKamar = listKamar.size() > 0;
        model.addAttribute("hasKamar", hasKamar);
        model.addAttribute("hotel", hotel);
        model.addAttribute("listKamar", listKamar);
        return "view-hotel";
    }

    @RequestMapping("/hotel/view/{idHotel}")
    public String viewDetailHotelWithPath(
            @PathVariable Long idHotel,
            Model model
    ){
        HotelModel hotels = hotelService.getHotelByIdHotel(idHotel);
        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
        boolean hasKamar = listKamar.size() > 0;
        model.addAttribute("hasKamar", hasKamar);
        model.addAttribute("hotel", hotels);
        model.addAttribute("listKamar", listKamar);
        return "view-hotel";
    }

    @RequestMapping("/hotel/viewall")
    public String viewAllHotel(Model model){
        List<HotelModel> listHotel = hotelService.getHotelList();
        model.addAttribute("listHotel", listHotel);
        return "viewall-hotel";
    }

    @RequestMapping("/hotel/view-all")
    public String listHotelDesc(Model model){

        // Mendapatkan semua HotelModel
        List<HotelModel> listHotel = hotelService.getHotelListOrderByIdDesc();

        // Add variabel semua HotelModel ke 'listHotel' untuk dirender pada thymeleaf
        model.addAttribute( "listHotel", listHotel);

        // Return view template yang diinginkan
        return "viewall-hotel";
    }

    @RequestMapping("/hotel/delete/{idHotel}")
    public String deleteHotel(
            @PathVariable Long idHotel,
            Model model
    ){
//        int action = 3; //delete
//        if(hotel == null){
//            model.addAttribute("action", action);
//            return "notfound-error";
//        }
//        if(hotelService.deleteHotel(idHotel)){
//            return "delete-hotel";
//        }else{
//            return "delete-error";
//        }
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
        model.addAttribute("hotel", hotel);

        if(listKamar.size() == 0){
            hotelService.deleteHotel(hotel);
            return "delete-hotel";
        }
        else{
            return "error-delete-hotel";
        }
    }

}
