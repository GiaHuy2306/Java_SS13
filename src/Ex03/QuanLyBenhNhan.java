package Ex03;

import java.util.ArrayList;
import java.util.List;

public class QuanLyBenhNhan<T> {
    public static<T> List<T> findCommonPatients(List<T> listA, List<T> listB ) {
        List<T> result = new ArrayList<T>();

        for (T item : listA) {
            if (listB.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
