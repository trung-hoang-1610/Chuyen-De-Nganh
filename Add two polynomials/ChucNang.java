import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class ChucNang {
    public static void ghiDaThucVaoFile(DaThuc daThuc, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            
            HangTu hangTuHienTai = daThuc.head;
            
            while (hangTuHienTai != null) {
                writer.write(hangTuHienTai.heSo + "x^" + hangTuHienTai.soMu);
                if (hangTuHienTai.next != null) {
                    writer.write(" + ");
                }else{
                    writer.write(", ");
                }
                hangTuHienTai = hangTuHienTai.next;

            }

            writer.write(System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

    public static DaThuc docDaThucTuFile(String fileName) {
        DaThuc daThuc = new DaThuc();

        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();   
                String[] terms = line.split("\\s*\\+\\s*");
                for (String term : terms) {
                    String[] parts = term.split("x\\^");
                    int heSo = Integer.parseInt(parts[0]);
                    int soMu = Integer.parseInt(parts[1]);
                    daThuc.themHangTu(heSo, soMu);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }

        return daThuc;
    }

    public void themDaThuc(){
        Scanner scanner = new Scanner(System.in);

        DaThuc daThuc1 = new DaThuc();
        System.out.print("Nhập vào số lượng phần tử của đa thức thứ nhất: ");
        int toanTu1 = scanner.nextInt();

        for(int i = 0; i<toanTu1; i++){
            System.out.print("Nhập vào lần lượt hệ số và số mũ của phẩn tủ thứ " + i+1 + ": " );
            int heSo = scanner.nextInt();
            int soMu = scanner.nextInt();
            daThuc1.themHangTu(heSo, soMu);
        }
        ghiDaThucVaoFile(daThuc1, "Data//DaThuc1.txt");

        

        DaThuc daThuc2 = new DaThuc();
        System.out.print("Nhập vào số lượng phần tử của đa thức thứ hai: ");
        int toanTu2 = scanner.nextInt();

        for(int i = 0; i<toanTu2; i++){
            System.out.print("Nhập vào lần lượt hệ số và số mũ của phẩn tủ thứ " + i+1 + ": " );
            int heSo = scanner.nextInt();
            int soMu = scanner.nextInt();
            daThuc2.themHangTu(heSo, soMu);

        }
        ghiDaThucVaoFile(daThuc2, "Data//DaThuc2.txt");
        scanner.close();
    }

    public DaThuc tinhTongDaThuc(){

        DaThuc tongHaiDaThuc = docDaThucTuFile("Data//Dathuc1.txt").congHaiDaThuc(docDaThucTuFile("Data//DaThuc2.txt"));

        return tongHaiDaThuc;
    }

    public void showDaThuc1(){
        System.out.print("Da thuc 1: " );
        docDaThucTuFile("Data//DaThuc1.txt").show();
        System.out.println();
    }

    public void showDaThuc2(){
        System.out.print("Da thuc 2: ");
        docDaThucTuFile("Data//DaThuc2.txt").show();
        System.out.println();
    }

    public void showTong2DaThuc(){
        System.out.print("Tong 2 da thuc: ");
        tinhTongDaThuc().show();
    }
}
