package Ex03;

import java.util.ArrayList;
import java.util.List;

import static Ex03.QuanLyBenhNhan.findCommonPatients;

public class Ex03 {
    public static void main(String[] args) {
        List<Integer> khoaNoiID = new ArrayList<>();
        khoaNoiID.add(101);
        khoaNoiID.add(102);
        khoaNoiID.add(105);

        List<Integer> khoaNgoaiID = new ArrayList<>();
        khoaNgoaiID.add(102);
        khoaNgoaiID.add(105);
        khoaNgoaiID.add(108);

        List<Integer> benhNhanChung = findCommonPatients(khoaNoiID, khoaNgoaiID);

        System.out.println("Benh nhan chung (ID): " + benhNhanChung);

        List<String> khoaNoiBHYT = new ArrayList<>();
        khoaNoiBHYT.add("DN01");
        khoaNoiBHYT.add("DN02");
        khoaNoiBHYT.add("DN03");

        List<String> khoaNgoaiBHYT = new ArrayList<>();
        khoaNgoaiBHYT.add("DN02");
        khoaNgoaiBHYT.add("DN04");

        List<String> benhNhanChungBHYT = findCommonPatients(khoaNoiBHYT, khoaNgoaiBHYT);

        System.out.println("Danh sach benh nhan chung (BHYT): " + benhNhanChungBHYT);

    }
}
