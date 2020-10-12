package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarService {
    void addKamar(KamarModel kamar);

    List<KamarModel> findAllKamarByIdHotel(Long idHotel);

    KamarModel getKamarByNoKamar(Long noKamar);

    KamarModel updateKamar(KamarModel kamar);

    KamarModel deleteKamar(Long noKamar);

    KamarModel getKamarByNamaKamarDanTipe(String namaKamar, Integer tipe);

}
