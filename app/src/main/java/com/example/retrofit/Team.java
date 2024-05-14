package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("idTeam")
    private String idTeam;


    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strAlternate")
    private String strAlternate;

    @SerializedName("strTeamBadge")
    private String strTeamBadge;

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    @SerializedName("strStadium")
    private String strStadium;



    public String getStrTeam() {
        return strTeam;
    }



    public String getStrAlternate() {
        return strAlternate;
    }



    public String getStrTeamBadge() {
        return strTeamBadge;
    }






}
