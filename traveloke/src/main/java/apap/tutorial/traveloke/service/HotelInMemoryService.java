package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelInMemoryService implements HotelService{
    private List<HotelModel> listHotel;
    private HotelModel hotelById;
    private HotelModel hotelUpdate;

    //Constructor
    public HotelInMemoryService(){
        listHotel = new ArrayList<>();
    }

    @Override
    public void addHotel(HotelModel hotel){
        listHotel.add(hotel);
    }

    @Override
    public List<HotelModel> getHotelList(){
        return listHotel;
    }

    @Override
    public HotelModel getHotelByIdHotel(String idHotel) {
        for(int i = 0; i<listHotel.size(); i++){
            if(listHotel.get(i).getIdHotel().equalsIgnoreCase(idHotel)){
                hotelById = listHotel.get(i);
            }
        }
        return hotelById;
    }

    @Override
    public boolean updateNoTelepon(String id, String noTelepon){
        boolean update = false;
        for(int i = 0; i<listHotel.size(); i++){
            if(listHotel.get(i).getIdHotel().equalsIgnoreCase(id)){
                hotelUpdate = listHotel.get(i);
                hotelUpdate.setNoTelepon(noTelepon);
                update = true;
            }
        }
        return update;
    }

    @Override
    public boolean deleteHotel(String idHotel){
        boolean hapus = false;
        for(int i = 0; i<listHotel.size(); i++){
            if(listHotel.get(i).getIdHotel().equalsIgnoreCase(idHotel)){
                listHotel.remove(i);
                hapus = true;
            }
        }
        return hapus;
    }
}
