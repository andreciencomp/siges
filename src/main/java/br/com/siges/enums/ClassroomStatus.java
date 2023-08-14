package br.com.siges.enums;

public enum ClassroomStatus {
    OPEN("ABERTA"),
    CLOSED("FECHADA"),
    CONSOLIDATED("CONSOLIDADA");

    private final String value;

    ClassroomStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
