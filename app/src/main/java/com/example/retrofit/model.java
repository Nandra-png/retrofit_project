package com.example.retrofit;
import com.google.gson.annotations.SerializedName;

public class model {
    @SerializedName("idTeam")
    private String idTeam;

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strAlternate")
    private String strAlternate;

    @SerializedName("strStadium")
    private String strStadium;

    // tambahkan field lainnya sesuai kebutuhan

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrAlternate() {
        return strAlternate;
    }

    public void setStrAlternate(String strAlternate) {
        this.strAlternate = strAlternate;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    // tambahkan getter dan setter lainnya sesuai kebutuhan
}
