package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    //Method untuk menambah hotel
    void addHotel(HotelModel hotel);

    //Method untuk mendapatkan daftar Hotel yang telah tersimpan
    List<HotelModel> getHotelList();

    //Method untuk mendapatkan data sebuah hotel berdasarkan id hotel
    HotelModel getHotelByIdHotel(Long idHotel);

    // Method untuk update hotel
    HotelModel updateHotel(HotelModel hotel);

    List<HotelModel> getHotelListDesc();
//    boolean updateNoTelepon(String id, String noTelepon);
//
//    boolean deleteHotel(String idHotel);
}
