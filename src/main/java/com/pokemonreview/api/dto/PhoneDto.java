package com.pokemonreview.api.dto;

import com.pokemonreview.api.models.Phone;
import lombok.Builder;

@Builder
public class PhoneDto {
    private String number;
    private String citycode;
    private String countrycode;

    public PhoneDto(String number, String citycode, String countrycode) {
        this.number = number;
        this.citycode = citycode;
        this.countrycode = countrycode;
    }

    public PhoneDto(Phone phone) {
        this.number = phone.getNumber();
        this.citycode = phone.getCitycode();
        this.countrycode = phone.getCountrycode();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
}
