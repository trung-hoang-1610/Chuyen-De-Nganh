import java.util.Scanner;

public class Menu {
    
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        boolean choose = true;

        ChucNang chucNang = new ChucNang();
        while (choose) {
            System.out.println("===== Menu =====");
            System.out.println("1. Nhap 2 da thuc can tinh");
            //System.out.println("2. Hien thi da thuc");
            System.out.println("3. Tinh tong 2 da thuc");
            System.out.println("4. Lich su tinh");
            System.out.println("0. Thoat");
           

            int chon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống sau nextInt()

            switch (chon) {
                case 1:
                    chucNang.nhapDaThuc();
                    break;
                case 2:
                    //chucNang.showDaThuc1();
                    //chucNang.showDaThuc2();
                    break;
                case 3:
                    chucNang.showTong2DaThuc();
                    break;
                case 4:
                    chucNang.showDanhSachDaThuc();
                case 0:
                    choose = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }

        scanner.close();
    }
}
