package com.example.spdmit.petlist;

/**
 * Created by spdmit on 28/11/2017.
 */

public class PetCollection {
    private Pet[] pets;

    public PetCollection() {
        pets = new Pet[6];
        pets[0] = new Pet("Dog", R.drawable.dog, "Mammal");
        pets[1] = new Pet("Cat", R.drawable.cat, "Mammal");
        pets[2] = new Pet("Hamster", R.drawable.hamster, "Mammal");
        pets[3] = new Pet("Chinchilla", R.drawable.chinchilla, "Mammal");
        pets[4] = new Pet("Turtle", R.drawable.turtle, "Reptile");
        pets[5] = new Pet("Iguana", R.drawable.iguana, "Reptile");
    }

    public String[] getAllPets(){
        String[] str = new String[pets.length];
        for (int i = 0; i < pets.length; i++) {
            str[i] = pets[i].getSpecies();
        }
        return str;
    }

    public Pet getPetAt(int i){
        return pets[i];
    }

    public static void main(String[]a){
        PetCollection petlist = new PetCollection();

        String[] list = petlist.getAllPets();
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]);
        }

    }
}
