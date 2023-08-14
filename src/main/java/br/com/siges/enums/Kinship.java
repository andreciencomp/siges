package br.com.siges.enums;

public enum Kinship {

    MOTHER("Mãe"),
    FATHER("Pai");

    private final String value;
    Kinship(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
