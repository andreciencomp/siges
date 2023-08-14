package br.com.siges.enums;

public enum DayOfWeek {

    MONDAY("Segunda-Feira"),
    TUESDAY("Terça-Feira"),
    WEDNESDAY("Quarta-Feira"),
    THURSDAY("Quinta-Feira"),
    FRIDAY("Sexta-Feira"),
    SATURDAY("Sábado"),
    SUNDAY("Domingo");

    private final String value;
    DayOfWeek(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
