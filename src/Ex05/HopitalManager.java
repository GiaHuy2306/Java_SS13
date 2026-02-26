package Ex05;

import java.util.*;

class Patient {
    private String id;
    private String fullName;
    private int age;
    private String diagnosis;

    public Patient(String id, String fullName, int age, String diagnosis) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Tên: " + fullName +
                ", Tuổi: " + age +
                ", Chẩn đoán: " + diagnosis;
    }
}

public class HopitalManager {
    static Scanner sc = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("MENU");
            System.out.println("1. Tiếp nhận bệnh nhân: Nhập thông tin. ID không được trùng.");
            System.out.println("2. Cập nhật chẩn đoán: Nhập ID, tìm bệnh nhân và sửa lại thông tin chẩn đoán bệnh.");
            System.out.println("3. Xuất viện: Nhập ID và xóa bệnh nhân khỏi danh sách theo dõi.");
            System.out.println("4. Sắp xếp danh sách");
            System.out.println("5. Hien thi danh sach benh nhan");
            System.out.println("6. Thoat");

            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    updateDianosisPatient();
                    break;
                case 3:
                    removePatient();
                    break;
                case 4:
                    sortPatients();
                    break;
                case 5:
                    displayPatients();
                    break;
                case 6:
                    System.out.println("Da thoat");
                    break;
            }
        } while (choice != 6);
    }

    public static void addPatient() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                System.out.println("ID da ton tai");
                return;
            }
        }

        System.out.print("Full name: ");
        String fullName = sc.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Diagnosis: ");
        String diagnosis = sc.nextLine();

        patients.add(new Patient(id, fullName, age, diagnosis));
        System.out.println("Them thanh cong");
    }

    public static void updateDianosisPatient() {
        System.out.print("ID can cap nhat: ");
        String id = sc.nextLine();

        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                System.out.print("Chan doan moi: ");
                String newDiagnosis = sc.nextLine();
                patient.setDiagnosis(newDiagnosis);
                System.out.println("Cap nhat thanh cong");
                return;
            }
        }
        System.out.println("Khong tim thay benh nhan");
    }

    public static void removePatient() {
        System.out.print("ID benh nhan xuat vien: ");
        String id = sc.nextLine();

        Iterator<Patient> iterator = patients.iterator();

        while (iterator.hasNext()) {
            Patient patient = iterator.next();
            if (patient.getId().equals(id)) {
                iterator.remove();
                System.out.println("Xuat vien thanh cong");
                return;
            }
        }
        System.out.println("Khong tim thay benh nhan");
    }

    public static void sortPatients() {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {

                if (p2.getAge() != p1.getAge()) {
                    return p2.getAge() - p1.getAge();
                }

                return p1.getFullName().compareToIgnoreCase(p2.getFullName());
            }
        });

        System.out.println("Da sap xep danh sach");
    }

    public static void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        for (Patient p : patients) {
            System.out.println(p);
        }
    }
}
