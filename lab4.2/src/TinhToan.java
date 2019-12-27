import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class TinhToan extends UnicastRemoteObject implements InterFaceDemo {

    protected TinhToan() throws RemoteException {
        super();
    }

// thuật toán tổng quát sắp xếp lẻ trước chẵn sau, giảm dần
    @Override
    public String sapXep(String chuoi) {
        String chuoiMoi = "";

        ArrayList<Integer> arrNum1 = new ArrayList<>();
        arrNum1 = arNum(chuoi);
        ArrayList<Integer> arrNum = new ArrayList<>();
        arrNum = danxen(arrNum1);

        for (int i = 0; i < arrNum.size(); i++) {
            chuoiMoi = chuoiMoi + arrNum.get(i) + ", ";
        }
        return chuoiMoi;
    }

//thuật toán phân tích chuỗi số tring thành mảng số
    private ArrayList<Integer> arNum(String chuoi) {
        ArrayList<Integer> arrNum = new ArrayList<>();
        String chuoi1 = chuoi.trim();
        while (chuoi1.length() > 0) {
            int indexSpace = chuoi1.indexOf(" ");
            if (indexSpace == -1) {
                arrNum.add(Integer.parseInt(chuoi1));
                return arrNum;
            } else {
                String so = chuoi1.substring(0, indexSpace);
                arrNum.add(Integer.parseInt(so));
                chuoi1 = chuoi1.substring(indexSpace + 1, chuoi1.length());
            }
        }
        return arrNum;
    }


//thuật toán chính sắp xếp mảng lẻ trước chẵn sau, giảm dần
    private ArrayList<Integer> danxen(ArrayList<Integer> arrNum) {
        ArrayList<Integer> arrChan = new ArrayList<>();
        ArrayList<Integer> arrLe = new ArrayList<>();
        for (int i = 0; i < arrNum.size(); i++) {
            if (arrNum.get(i) % 2 == 0) {
                arrChan.add(arrNum.get(i));
            } else {
                arrLe.add(arrNum.get(i));
            }
        }

        ArrayList<Integer> newArr = new ArrayList<>();

        for (int i = 0; i < arrChan.size() -1; i++) {
            for (int j = i+1; j < arrChan.size(); j++) {
                if (arrChan.get(i) <= arrChan.get(j)){
                    int tg = arrChan.get(i);
                    arrChan.set(i, arrChan.get(j));
                    arrChan.set(j, tg);
                }
            }
        }

        for (int i = 0; i < arrLe.size() -1; i++) {
            for (int j = i+1; j < arrLe.size(); j++) {
                if (arrLe.get(i) <= arrLe.get(j)){
                    int tg = arrLe.get(j);
                    arrLe.set(j, arrLe.get(i));
                    arrLe.set(i, tg);
                }
            }
        }

        for (int i = 0; i < arrLe.size(); i++) {
            newArr.add(arrLe.get(i));
        }
        for (int i = 0; i < arrChan.size(); i++) {
            newArr.add(arrChan.get(i));
        }
        return newArr;
    }

    // =================================================================================================================


//thuật toán sinh chuỗi số random phục vụ cho client
    public String chuoiRandom(){
        String chuoirandom = "";
        Random random = new Random();
        ArrayList<Integer> arr = new ArrayList();
        while (arr.size()<10){
            arr.add(random.nextInt(10));
        }

        for (int i = 0; i < arr.size(); i++) {
            chuoirandom = chuoirandom + " " + arr.get(i);
        }
        return chuoirandom;
    }
}
