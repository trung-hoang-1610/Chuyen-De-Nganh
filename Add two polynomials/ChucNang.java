
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ChucNang {
    DaThuc daThuc1 = new DaThuc();
    DaThuc daThuc2 = new DaThuc();

    public static void ghiDaThucVaoFile(DaThuc daThuc1, DaThuc daThuc2, DaThuc tongDaThuc, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName, true);

            HangTu hangTu1 = daThuc1.head;
            HangTu hangTu2 = daThuc2.head;
            HangTu hangTu3 = tongDaThuc.head;

            while (hangTu1 != null) {

                if (hangTu1 == daThuc1.head) {
                    writer.write("(");
                }
                if (hangTu1 != null) {
                    if (hangTu1.soMu == 0) {;
                        writer.write(hangTu1.heSo + "");
                    } else if (hangTu1.soMu == 1) {
                        writer.write(hangTu1.heSo + "x");
                    }else{
                        writer.write(hangTu1.heSo + "x^" + hangTu1.soMu);
                    }
                    
                    if (hangTu1.next != null) {
                        writer.write(" + ");
                    } else {
                        writer.write(") + ");
                    }
                    hangTu1 = hangTu1.next;
                }

            }

            while (hangTu2 != null) {
                if (hangTu2 == daThuc2.head) {
                    writer.write("(");
                }
                if (hangTu2 != null) {
                    if (hangTu2.soMu == 0) {;
                        writer.write(hangTu2.heSo + "");
                    } else if (hangTu2.soMu == 1) {
                        writer.write(hangTu2.heSo + "x");
                    }else{
                        writer.write(hangTu2.heSo + "x^" + hangTu2.soMu);
                    }
                    
                    if (hangTu2.next != null) {
                        writer.write(" + ");
                    } else {
                        writer.write(") = ");
                    }
                    hangTu2 = hangTu2.next;

                }

            }

            while (hangTu3 != null) {
                if (hangTu3 != null) {
                    if (hangTu3.soMu == 0) {;
                        writer.write(hangTu3.heSo + "");
                    } else if (hangTu3.soMu == 1) {
                        writer.write(hangTu3.heSo + "x");
                    }else{
                        writer.write(hangTu3.heSo + "x^" + hangTu3.soMu);
                    }

                    if (hangTu3.next != null) {
                        writer.write(" + ");
                    } else {
                        writer.write(".");
                    }
                    hangTu3 = hangTu3.next;
                }

            }

            writer.write(System.lineSeparator());

            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

    public static void docDaThucTuFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Phân tích và hiển thị định dạng từng dòng
                String[] parts = line.split(",");
                for (String part : parts) {
                    System.out.print(formatExpression(part) + "");
                }
                System.out.println(); // Xuống dòng sau mỗi dòng
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // DaThuc daThuc = new DaThuc();

        // try {
        // Scanner scanner = new Scanner(new File(fileName));
        // while (scanner.hasNextLine()) {
        // String line = scanner.nextLine();
        // String[] terms = line.split("\\s*\\+\\s*");
        // for (String term : terms) {
        // String[] parts = term.split("x\\^");
        // int heSo = Integer.parseInt(parts[0]);
        // int soMu = Integer.parseInt(parts[1]);
        // daThuc.themHangTu(heSo, soMu);
        // }
        // }
        // scanner.close();
        // } catch (FileNotFoundException e) {
        // System.out.println("File not found: " + fileName);
        // }

        // return daThuc;
    }

    private static String formatExpression(String expression) {
        // Xử lý và định dạng biểu thức ở đây
        return expression.trim();
    }

    public void nhapDaThuc() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao bac cua da thuc thu nhat: ");
        int bacDaThuc1 = scanner.nextInt();

        for (int i = bacDaThuc1; i >= 0; i--) {
            System.out.print("Nhap vao he so cua x^" + i + ": ");
            int heSo = scanner.nextInt();
            int soMu = (i);
            this.daThuc1.themHangTu(heSo, soMu);
        }

        System.out.print("Nhap vao bac cua da thuc thu hai: ");
        int bacDaThuc2 = scanner.nextInt();
        for (int i = bacDaThuc2; i >= 0; i--) {
            System.out.print("Nhap vao he so cua x^" + i + ": ");
            int heSo = scanner.nextInt();
            int soMu = (i);
            this.daThuc2.themHangTu(heSo, soMu);
        }

    
        // scanner.close();

    }

    public DaThuc tinhTongDaThuc() {

        // DaThuc tongHaiDaThuc =
        // docDaThucTuFile("Data//Dathuc1.txt").congHaiDaThuc(docDaThucTuFile("Data//DaThuc2.txt"));
        DaThuc tongHaiDaThuc = daThuc1.congHaiDaThuc(daThuc2);
        ghiDaThucVaoFile(daThuc1, daThuc2, tongHaiDaThuc, "Data//DaThuc.txt");
        clearCache();
        return tongHaiDaThuc;
    }

    public void clearCache() {
        daThuc1.head.next = null;
        daThuc1.head = null;

        daThuc2.head.next = null;
        daThuc2.head = null;
    }

    public void showDaThuc1() {
        System.out.print("Da thuc 1: ");
        daThuc1.show();
        System.out.println();
    }

    public void showDaThuc2() {
        System.out.print("Da thuc 2: ");
        daThuc2.show();
        System.out.println();
    }

    public void showTong2DaThuc() {

        showDaThuc1();
        showDaThuc2();

        System.out.print("Tong 2 da thuc: ");
        tinhTongDaThuc().show();
        System.out.println();
    }

    public void showDanhSachDaThuc() {
        docDaThucTuFile("Data//DaThuc.txt");
    }
}
