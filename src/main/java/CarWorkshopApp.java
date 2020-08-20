import doMain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarWorkshopApp {
        //tworzenie poszczególnych list
    static Scanner scanner = new Scanner(System.in);
    static List<Car> cars = new ArrayList<>();
    static List<Client> clients = new ArrayList<>();
    static List<Service> services = new ArrayList<>();

    static void printMenu(){
        for (Menu item : Menu.values()){
            System.out.println(item.getKey() + " " + item.getMessage());
        }
    }
        //metoda dodająca samochód
    static void addCar(){
        System.out.println("Wpisz dane auta");
        System.out.println("Model");
        String model = scanner.nextLine();
        System.out.println("Numer rejestracyjny: ");
        String regNum = scanner.nextLine();
        System.out.println("Podaj numer właściciela: ");
        int clientNumber = scanner.nextInt();
        Car car  = new Car(model, regNum, clients.get(clientNumber));
        cars.add(car);
    }
        //metoda dodająca klijenta
    static void addClient(){
        System.out.println("Wpisz dane Klijenta");
        System.out.println("Imię i nazwisko: ");
        String name = scanner.nextLine();
        System.out.println("Numer telefonu: ");
        String mobile = scanner.nextLine();
        Client client = new Client(name, mobile);
        clients.add(client);
    }
        //metoda dodająca usługę
    static void addService(){
        System.out.println("Wpisz dane usługi");
        System.out.println("Podaj numer samochodu: ");
        int carNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Wpisz opis usługi: ");
        String desc = scanner.nextLine();
        services.add(new ChangeOileServise(cars.get(carNumber), desc));
    }
        //metoda drukująca podaną przez nas listę
    static <T> void printAll(List<T> list){
        for (T item : list){
            System.out.println(item);
        }
    }

    public static void main(String[] args) {

        try{//wczytywanie istniejącego pliku
            File file = new File("c:\\temp\\clients.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            bufferedReader .close();
        }catch (FileNotFoundException e){//sprawdzenie czy plik istnieje
            System.out.println("Brak pliku");
        }catch (IOException e){//sprawdzenie czy plik nie jest uszkodzony
            System.out.println("Nie można wczytać pliku");
        }

        System.out.println("Hello");
        Menu menuOption = Menu.ADD_CAR;
        while (true){
            printMenu();
            if (!scanner.hasNextInt()){//scanner pobierze tylko liczbę jeśli ktoś wpisza litery i lićzbę
                scanner.nextLine();//następnie przeskakuje tą wartość i przechodzi dalej, bo pętla nie zakończy się
                continue;
            }
            int item = scanner.nextInt();
            scanner.nextLine();
            menuOption = Menu.intOf(item);
            if (menuOption == null){
                continue;
            }
            switch (menuOption){
                case ADD_CAR:
                    addCar();
                    break;
                case ADD_CLEINT:
                    addClient();
                    break;
                case ADD_SERVICE:
                    addService();
                    break;
                case PRINT_INVOCE:
                    break;
                case PRINT_CARS:
                    printAll(cars);
                    break;
                case PRINT_CLIENTS:
                    printAll(clients);
                    break;
                case PRINT_SERVICIES:
                    printAll(services);
                    break;
                case EXIT:
                    try{
                        ClientIO.save("c\\temp\\clients.txt", clients);
                    }catch (IOException e){
                        System.out.println("Zapis nie powiódł się");
                    }
                    return;
            }
        }
    }
}
