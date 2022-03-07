package com.dbc.poo.enums;

import com.dbc.poo.enums.Gender;

import java.util.*;


public enum Pref {
    MEN(Collections.singletonList(Gender.MALE)),
    WOMEN(Collections.singletonList(Gender.FEMALE)),
    BOTH(Arrays.asList(Gender.MALE, Gender.FEMALE));

    private final List<Gender> genderPref;

    Pref(List<Gender> genderPref) {
        this.genderPref = genderPref;
    }

    public List<Gender> getGenderPref() {
        return genderPref;
    }

    public boolean isCompatible(Gender gender) {
        return genderPref.contains(gender);
    }
}
