package apap.tutorial.traveloke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="kamar")
public class KamarModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noKamar;

    @NotNull
    @Size(max=30)
    @Column(name="namaKamar", nullable = false)
    private String namaKamar;

    @NotNull
    @Column(name="tipe", nullable = false)
    private Integer tipe;

    @NotNull
    @Column(name="kapasitasKamar",nullable = false)
    private Integer kapasitasKamar;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "hotelId", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private HotelModel hotel;

    @OneToMany(mappedBy = "kamar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ReviewModel> listReview;

    public List<ReviewModel> getListReview() {
        return listReview;
    }

    public HotelModel getHotel() {
        return hotel;
    }

    public void setHotel(HotelModel hotel) {
        this.hotel = hotel;
    }

    public Integer getKapasitasKamar() {
        return kapasitasKamar;
    }

    public void setKapasitasKamar(Integer kapasitasKamar) {
        this.kapasitasKamar = kapasitasKamar;
    }

    public Integer getTipe() {
        return tipe;
    }

    public void setTipe(Integer tipe) {
        this.tipe = tipe;
    }

    public String getNamaKamar() {
        return namaKamar;
    }

    public void setNamaKamar(String namaKamar) {
        this.namaKamar = namaKamar;
    }

    public Long getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(Long noKamar) {
        this.noKamar = noKamar;
    }
}
