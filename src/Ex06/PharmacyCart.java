package Ex06;

import java.util.*;

class Medicine {
    private String drugId;
    private String drugName;
    private double unitPrice;
    private int quantity;

    public Medicine(String drugId, String drugName, double unitPrice, int quantity) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getDrugId() {
        return drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return unitPrice * quantity;
    }
}

public class PharmacyCart {

    static Scanner scanner = new Scanner(System.in);
    static List<Medicine> cart = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== MENU KÊ ĐƠN THUỐC =====");
            System.out.println("1. Thêm thuốc vào đơn");
            System.out.println("2. Điều chỉnh số lượng");
            System.out.println("3. Xóa thuốc");
            System.out.println("4. In hóa đơn");
            System.out.println("5. Tìm thuốc giá < 50.000");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    updateQuantity();
                    break;
                case 3:
                    removeMedicine();
                    break;
                case 4:
                    printInvoice();
                    break;
                case 5:
                    findCheapMedicine();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);
    }

    // 1. Thêm thuốc
    public static void addMedicine() {
        System.out.print("Nhập mã thuốc: ");
        String id = scanner.nextLine();

        for (Medicine m : cart) {
            if (m.getDrugId().equals(id)) {
                System.out.print("Thuốc đã tồn tại. Nhập số lượng thêm: ");
                int qty = Integer.parseInt(scanner.nextLine());
                m.setQuantity(m.getQuantity() + qty);
                System.out.println("Đã cộng dồn số lượng.");
                return;
            }
        }

        System.out.print("Nhập tên thuốc: ");
        String name = scanner.nextLine();

        System.out.print("Nhập đơn giá: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        cart.add(new Medicine(id, name, price, quantity));
        System.out.println("Đã thêm thuốc vào đơn.");
    }

    // 2. Điều chỉnh số lượng
    public static void updateQuantity() {
        while (true) {
            System.out.print("Nhập mã thuốc cần điều chỉnh: ");
            String id = scanner.nextLine();

            for (Medicine m : cart) {
                if (m.getDrugId().equals(id)) {
                    System.out.print("Nhập số lượng mới: ");
                    int newQty = Integer.parseInt(scanner.nextLine());

                    if (newQty == 0) {
                        cart.remove(m);
                        System.out.println("Đã xóa thuốc khỏi đơn.");
                    } else {
                        m.setQuantity(newQty);
                        System.out.println("Cập nhật số lượng thành công.");
                    }
                    return;
                }
            }

            System.out.println("Không tìm thấy thuốc. Vui lòng nhập lại!");
        }
    }

    // 3. Xóa thuốc
    public static void removeMedicine() {
        System.out.print("Nhập mã thuốc cần xóa: ");
        String id = scanner.nextLine();

        Iterator<Medicine> iterator = cart.iterator();

        while (iterator.hasNext()) {
            Medicine m = iterator.next();
            if (m.getDrugId().equals(id)) {
                iterator.remove();
                System.out.println("Đã xóa thuốc.");
                return;
            }
        }

        System.out.println("ID thuốc không tồn tại.");
    }

    // 4. In hóa đơn
    public static void printInvoice() {
        if (cart.isEmpty()) {
            System.out.println("Đơn thuốc trống.");
            return;
        }

        double total = 0;

        System.out.println("\n===== HÓA ĐƠN =====");
        System.out.printf("%-10s %-20s %-10s %-10s %-15s\n",
                "Mã", "Tên", "Giá", "SL", "Thành tiền");

        for (Medicine m : cart) {
            double thanhTien = m.getTotalPrice();
            total += thanhTien;

            System.out.printf("%-10s %-20s %-10.0f %-10d %-15.0f\n",
                    m.getDrugId(),
                    m.getDrugName(),
                    m.getUnitPrice(),
                    m.getQuantity(),
                    thanhTien);
        }

        System.out.println("-----------------------------------------------");
        System.out.println("TỔNG TIỀN: " + total + " VNĐ");

        // Xóa danh sách sau khi in
        cart.clear();
        System.out.println("Đã hoàn tất đơn thuốc.");
    }

    // 5. Tìm thuốc giá rẻ
    public static void findCheapMedicine() {
        boolean found = false;

        for (Medicine m : cart) {
            if (m.getUnitPrice() < 50000) {
                System.out.println(m.getDrugId() + " - " + m.getDrugName()
                        + " - Giá: " + m.getUnitPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có thuốc nào dưới 50.000 VNĐ.");
        }
    }
}