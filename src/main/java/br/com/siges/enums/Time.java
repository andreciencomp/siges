package br.com.siges.enums;

public enum Time {
    MORNING_FIRST(0),
    MORNING_SECOND(1),
    MORNING_THIRD(2),
    MORNING_FOURTH(3),
    MORNING_FIFTH(4),
    MORNING_SIXTH(5),
    MORNING_SEVENTH(6),
    AFTERNOON_FIRST(7),
    AFTERNOON_SECOND(8),
    AFTERNOON_THIRD(9),
    AFTERNOON_FOURTH(10),
    AFTERNOON_FIFTH(11),
    AFTERNOON_SIXTH(12),
    AFTERNOON_SEVENTH(13);

    private final int value;
    Time(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

   /* public String toString(){
        switch (value){
            case 1:
                return "Manhã - Primeiro Horário";
            case 2:
                return "Manhã - Segundo Horário";
            case 3:
                return "Manhã - Terceiro Horário";
            case 4:
                return "Manhã - Quarto Horário";
            case 5:
                return "Manhã - Quinto Horário";
            case 6:
                return "Manhã - Sexto Horário";
            case 7:
                return "Manhã - Sétimo Horário";
            case 8:
                return "Tarde - Primeiro Horário";
            case 9:
                return "Tarde - Segundo Horário";
            case 10:
                return "Tarde - Terceiro Horário";
            case 11:
                return "Tarde - Quarto Horário";
            case 12:
                return "Tarde - Quinto Horário";
            case 13:
                return "Tarde - Sexto Horário";
            case 14:
                return "Tarde - Sétimo Horário";
            default:
                return "HORÁRIO INDEFINIDO";

        }
    }*/

}
