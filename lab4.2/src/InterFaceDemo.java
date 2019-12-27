import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterFaceDemo extends Remote {
    String sapXep(String chuoi) throws RemoteException;
}
