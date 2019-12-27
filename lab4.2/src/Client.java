import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        Registry registry = LocateRegistry.getRegistry("localhost",5000);

        TinhToan tt =  new TinhToan();
        String chuoiRandom = tt.chuoiRandom();
        System.out.println("Chuoi random: "+ chuoiRandom);

            InterFaceDemo interFaceDemo = (InterFaceDemo) registry.lookup("tinhtoan");
            System.out.println("Chuoi chan le dan xen: " + interFaceDemo.sapXep(chuoiRandom));



    }
}
