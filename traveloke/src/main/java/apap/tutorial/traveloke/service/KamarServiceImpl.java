package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.KamarDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KamarServiceImpl implements KamarService{

    @Autowired
    KamarDb kamarDb;

    @Override
    public void addKamar(KamarModel kamar){
        kamarDb.save(kamar);
    }

    @Override
    public List<KamarModel> findAllKamarByIdHotel(Long idHotel){
        return kamarDb.findAllByHotelId(idHotel);
    }

    @Override
    public KamarModel getKamarByNoKamar(Long noKamar){
        return kamarDb.findByNoKamar(noKamar).get();
    }

    @Override
    public KamarModel updateKamar(KamarModel kamar){
        KamarModel kamarUpdate = kamarDb.findByNoKamar(kamar.getNoKamar()).get();

        try{
            kamarUpdate.setNamaKamar(kamar.getNamaKamar());
            kamarUpdate.setKapasitasKamar(kamar.getKapasitasKamar());
            kamarUpdate.setTipe(kamar.getTipe());
            kamarDb.save(kamarUpdate);
            return kamarUpdate;
        } catch (NullPointerException nullException){
            return null;
        }
    }

    @Override
    public void deleteKamar(KamarModel kamar){
        kamarDb.delete(kamar);
    }
}
