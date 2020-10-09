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
        int action = 2; //update
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if(hotel == null){
            model.addAttribute("action", action);
            return "notfound-error";
        }
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
        int action = 1; //view
        boolean adaKamar;
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if(hotel == null){
            model.addAttribute("action", action);
            return "notfound-error";
        }else if(hotel.getListKamar().isEmpty()){
            adaKamar = false;
        }else{
            adaKamar = true;
        }
        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
        model.addAttribute("hotel", hotel);
        model.addAttribute("listKamar", listKamar);
        model.addAttribute("adaKamar", adaKamar);
        return "view-hotel";
    }

    @RequestMapping("/hotel/viewall")
    public String viewAllHotel(Model model){
        List<HotelModel> listHotel = hotelService.getHotelListDesc();
        model.addAttribute("listHotel", listHotel);
        return "viewall-hotel";
    }

    @RequestMapping("/hotel/delete/{idHotel}")
    public String deleteHotel(
            @PathVariable Long idHotel,
            Model model
    ){
        int action = 3; //delete
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if(hotel == null){
            model.addAttribute("action", action);
            return "notfound-error";
        }
        if(hotelService.deleteHotel(idHotel)){
            return "delete-hotel";
        }else{
            return "delete-error";
        }
    }
//    @Autowired
//    private HotelService hotelService;

//    // Routing URL yang diinginkan
//    @RequestMapping("/hotel/add")
//    public String addHotel(
//            // Request parameter yang ingin dibawa
//            @RequestParam(value = "idHotel", required = true) String idHotel,
//            @RequestParam(value = "namaHotel", required = true) String namaHotel,
//            @RequestParam(value = "alamat", required = true) String alamat,
//            @RequestParam(value = "noTelepon", required = true) String noTelepon,
//            Model model
//    ){
//        // Membuat objek HotelModel
//        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);
//
//        // Memanggil service addHotel
//        hotelService.addHotel(hotel);
//
//        // Add variabel id hotel ke 'idHotel' untuk dirender pada thymeleaf
//        model.addAttribute("idHotel", idHotel);
//
//        // Return view template yang digunakan
//        return "add-hotel";
//    }
//
//    @RequestMapping("/hotel/viewall")
//    public String listHotel(Model model){
//
//        // Mendapatkan semua HotelModel
//        List<HotelModel> listHotel = hotelService.getHotelList();
//
//        // Add variabel semua HotelModel ke 'listHotel' untuk dirender pada thymeleaf
//        model.addAttribute("listHotel", listHotel);
//
//        // Return view template yang diinginkan
//        return "viewall-hotel";
//    }
//
//    @RequestMapping("/hotel/view")
//    public String detailHotel(
//            @RequestParam(value = "idHotel") Long idHotel,
//            Model model){
//        // Mendapatkan HotelModel sesuai dengan idHotel
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//
//        // Add variabel HotelModel ke 'hotel' untuk dirender pada thymeleaf
//        model.addAttribute("hotel",hotel);
//
//        return "view-hotel";
//    }
//
//    @RequestMapping("/hotel/view/id-hotel/{idHotel}")
//    public String detailHotel2(
//            @PathVariable(value = "idHotel") String idHotel,
//            Model model){
//
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//
//        model.addAttribute("hotel", hotel);
//
//        return "view-hotel";
//    }
//
//    @RequestMapping("/hotel/update/id-hotel/{idHotel}/no-telepon/{noTelepon}")
//    public String updateNoTelepon(
//            @PathVariable(value = "idHotel") String idHotel,
//            @PathVariable(value = "noTelepon") String noTelepon,
//            Model model){
//
//        if(hotelService.updateNoTelepon(idHotel, noTelepon)){
//            return "updateTelepon-hotel";
//        }else{
//            return "error";
//        }
//    }
//
//    @RequestMapping("/hotel/delete/id-hotel/{idHotel}")
//    public String deleteHotel(
//            @PathVariable(value = "idHotel") String idHotel,
//            Model model){
//
//        if(hotelService.deleteHotel(idHotel)){
//            return "delete-hotel";
//        }else{
//            return "error";
//        }
//    }

}
