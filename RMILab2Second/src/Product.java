import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Product extends Remote {

    double getLengthBetweenPoints(Point a, Point b) throws RemoteException;
    double getCircumFerence(Point a, Point b) throws  RemoteException;
    double getCircleArea(Point a, Point b) throws RemoteException;
    double getCircumFerenceDiameter(Point a, Point b) throws RemoteException;
    double getCircleAreaDiameter(Point a, Point b) throws RemoteException;

}
