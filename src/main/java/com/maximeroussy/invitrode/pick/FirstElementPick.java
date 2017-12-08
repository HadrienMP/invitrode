package com.maximeroussy.invitrode.pick;

public class FirstElementPick implements Pick {
    // TODO HMP: 08/12/2017 contraindre aux listes non vides avec un objet
    @Override
    public String in(String[] strings) {
        return strings[0];
    }
}
