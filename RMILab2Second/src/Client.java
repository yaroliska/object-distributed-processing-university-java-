import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    private String SERVICE_PATH = "rmi://localhost/Product";

    public Client(){
        try{
            // URL удаленного объекта
            String objectName = this.SERVICE_PATH;

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите координаты первой точки через пробел");
            String line = keyboard.readLine();
            int x = Integer.parseInt(line.split(" ")[0]);
            int y = Integer.parseInt(line.split(" ")[1]);
            Point a = new Point((double)x, (double)y);
            System.out.println("Введите координаты второй точки через пробел");
            line = keyboard.readLine();
            x = Integer.parseInt(line.split(" ")[0]);
            y = Integer.parseInt(line.split(" ")[1]);
            Point b = new Point((double)x, (double)y);

            //поиск удаленного объекта
            Product product = (Product) Naming.lookup(objectName);


            System.out.println("Расстояние между 2 точками= " + product.getLengthBetweenPoints(a, b));
            System.out.println("длина окружности, радиус = " + product.getCircumFerence(a, b));
            System.out.println("площадь круга, радиус = " + product.getCircleArea(a, b));
            System.out.println("длина окружности, диаметр = " + product.getCircumFerenceDiameter(a, b));
            System.out.println("площадь круга, диаметр = " + product.getCircleAreaDiameter(a, b));

        }
        catch (NotBoundException var9) {
            System.err.println("NotBoundException : " + var9.getMessage());
        } catch (RemoteException var10) {
            var10.printStackTrace();
        } catch (MalformedURLException var11) {
            var11.printStackTrace();
        } catch (IOException var12) {
            var12.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Client();
        System.exit(0);
    }
}
