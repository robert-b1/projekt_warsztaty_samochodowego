public enum Menu {

    ADD_CLEINT(1, "Wpisz Klijenta"),
    ADD_CAR(2, "Wpisz auto"),
    ADD_SERVICE(3, "Wpisz usługę"),
    PRINT_INVOCE(4, "Drukuj fakturę"),
    PRINT_CARS(5, "Podaj numer samochodu"),
    PRINT_CLIENTS(7, "Podaj numer klijenta"),
    PRINT_SERVICIES(7, "Wyświetl wykonane usługi"),
    EXIT(0, "Wyjście");

    private int key;
    private String message;


    Menu(int key, String massage) {
        this.key = key;
        this.message = massage;
    }

    public String getMessage(){
        return message;
    }

    public int getKey(){
        return key;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "key=" + key +
                ", message='" + message + '\'' +
                '}';
    }

    static public Menu intOf(int key){
        for (Menu item:Menu.values()){
            if (item.key == key){
                return item;
            }
        }
        return null;
    }




}
