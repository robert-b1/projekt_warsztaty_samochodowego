package doMain;

import java.time.LocalDate;

public class ChangeOileServise extends Service implements Price{

    private LocalDate date;

    public ChangeOileServise(Car car, String description) {
        super(car, description);
        date = LocalDate.now();
    }

    @Override
    public int price(int hours, int workers) {
        return 10_000;
    }

    @Override
    public String toString() {
        return "ChangeOileServise{" +
                "date=" + date +
                '}';
    }
}
