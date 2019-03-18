import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProductImpl extends UnicastRemoteObject implements Product {
    private static final long serialVersionUID = 1L;
    private Point a;
    private Point b;

    public ProductImpl() throws RemoteException{

    }

    @Override
    public double getLengthBetweenPoints(Point a, Point b) throws RemoteException {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2.0D) + Math.pow(b.getY() - a.getY(), 2.0D));
    }

    @Override
    public double getCircumFerence(Point a, Point b) throws RemoteException {
        return 6.283185307179586D * this.getLengthBetweenPoints(a, b);
    }

    @Override
    public double getCircleArea(Point a, Point b) throws RemoteException {
        return 3.141592653589793D * Math.pow(this.getLengthBetweenPoints(a, b), 2.0D);
    }

    @Override
    public double getCircumFerenceDiameter(Point a, Point b) throws RemoteException {
        return 3.141592653589793D * this.getLengthBetweenPoints(a, b);
    }

    @Override
    public double getCircleAreaDiameter(Point a, Point b) throws RemoteException {
        return 3.141592653589793D * Math.pow(this.getLengthBetweenPoints(a, b), 2.0D) / 4.0D;
    }

    public Point getB() {
        return b;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public void setB(Point b) {
        this.b = b;
    }
}
