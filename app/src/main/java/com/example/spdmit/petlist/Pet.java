package com.example.spdmit.petlist;

/**
 * Created by spdmit on 28/11/2017.
 */

public class Pet {
    String species;
    int pic;

    public int getPic() {
        return pic;
    }

    String animalClass;

    public String getSpecies() {
        return species;
    }

    public Pet(String species, int pic, String animalClass) {
        this.species = species;
        this.pic = pic;
        this.animalClass = animalClass;
    }
}
