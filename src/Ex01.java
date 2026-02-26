import java.util.ArrayList;
import java.util.Iterator;

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<>();
        numbers.add(36.5);
        numbers.add(40.2);
        numbers.add(37.0);
        numbers.add(12.5);
        numbers.add(39.8);
        numbers.add(99.9);
        numbers.add(36.8);

        Iterator<Double> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            Double nhietDo =  iterator.next();

            if (nhietDo < 34.0 || nhietDo > 42.0) {
                iterator.remove();
            }
        }
        double tong = 0;

        for(Double n: numbers) {
            tong += n;
        }

        double avg =  numbers.size() > 0 ? tong / numbers.size() : 0;
        System.out.println("Danh sach hop le: " + numbers);
        System.out.println("Nhiet do trung binh: " + avg);
    }
}
