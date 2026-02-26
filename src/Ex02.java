import java.util.ArrayList;
import java.util.Collections;

public class Ex02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        list.add("Paracetamol");
        list.add("Ibuprofen");
        list.add("Panadol");
        list.add("Paracetamol");
        list.add("Aspirin");
        list.add("Ibuprofen");

        for(String s: list){
            if(!list2.contains(s)){
                list2.add(s);
            }
        }

        Collections.sort(list2);
        System.out.println("Danh sach thuoc moi: " + list2);
    }
}
