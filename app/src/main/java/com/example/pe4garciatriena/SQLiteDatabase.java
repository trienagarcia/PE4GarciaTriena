package com.example.pe4garciatriena;

public class SQLiteDatabase {
    String bCountry;
    String bGold;
    String bSilver;
    String bBronze;

    public SQLiteDatabase(String bCountry, String bGold, String bSilver, String bBronze) {
        this.bCountry = bCountry;
        this.bGold = bGold;
        this.bSilver = bSilver;
        this.bBronze = bBronze;
    }

    public String getbCountry() {
        return bCountry;
    }

    public String getbGold() {
        return bGold;
    }

    public String getbSilver() {
        return bSilver;
    }

    public String getbBronze() {
        return bBronze;
    }



}
