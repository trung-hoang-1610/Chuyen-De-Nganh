

public class DaThuc {
    HangTu head  = new HangTu();

    public DaThuc(){
        head = null;
    }

    public void themHangTu(int heSo, int soMu){

        
        HangTu hangTuMoi = new HangTu(heSo, soMu);

        if(head == null || soMu > head.soMu ){
            hangTuMoi.next = head;
            head = hangTuMoi;
        } else{
            HangTu hangTuHienTai = new HangTu();
            hangTuHienTai = head;
            while(hangTuHienTai.next != null && hangTuHienTai.next.soMu >= soMu){
                hangTuHienTai = hangTuHienTai.next;
            }
            hangTuMoi.next = hangTuHienTai.next;
            hangTuHienTai.next = hangTuMoi;
        }
    }

    public DaThuc congHaiDaThuc(DaThuc other){

        DaThuc TongHaiDaThuc = new DaThuc();
        HangTu DaThuc1 = this.head;
        HangTu DaThuc2 = other.head;

        while(DaThuc1 != null && DaThuc2!= null){                       
            if(DaThuc1.soMu == DaThuc2.soMu){
                TongHaiDaThuc.themHangTu(DaThuc1.heSo + DaThuc2.heSo, DaThuc1.soMu);
                DaThuc1 = DaThuc1.next;
                DaThuc2 = DaThuc2.next;
            } else if(DaThuc1.soMu > DaThuc2.soMu){
                TongHaiDaThuc.themHangTu(DaThuc1.heSo, DaThuc1.soMu);
                DaThuc1 = DaThuc1.next;
            }else{
                TongHaiDaThuc.themHangTu(DaThuc2.heSo, DaThuc2.soMu);
                DaThuc2 = DaThuc2.next;
            }
        }

        while(DaThuc1 != null){
            TongHaiDaThuc.themHangTu(DaThuc1.heSo, DaThuc1.soMu);
            DaThuc1 = DaThuc1.next;
        }

        while(DaThuc2 != null){
            TongHaiDaThuc.themHangTu(DaThuc2.heSo, DaThuc2.soMu);
                DaThuc2 = DaThuc2.next;
        }
        return TongHaiDaThuc;
    }

    public void show(){

        HangTu newNode = new HangTu();
        newNode  = head;

        while(newNode != null){
            if(newNode.soMu == 0){
                System.out.print(newNode.heSo);
            }else if(newNode.soMu == 1){
                System.out.print(newNode.heSo + "x");
            }else{
                System.out.print(newNode.heSo + "x^" + newNode.soMu);
            }
            
            if(newNode.next != null){
                System.out.print(" + ");
            }
            newNode = newNode.next;
        }

        //System.out.println();
    }
}
