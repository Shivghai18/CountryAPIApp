package com.example.test1app;

import java.util.Locale;

public class CountryClass {
    private String countryName;
    private String languageName;

    public CountryClass(String cName,String lName)
    {
        countryName=cName;
        languageName=lName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getLanguageName() {
        return languageName;
    }
    public CountryClass()
    {}
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

}
