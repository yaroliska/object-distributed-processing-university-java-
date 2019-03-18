import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public Server() {
    }

    public static void main(String... args) throws Exception {
        try {
            //создаем удаленный RMI объект
            Product service = new ProductImpl();
            //определяем имя удаленного RMI объекта
            String serviceName = "Product";
            System.out.println("Initializing " + serviceName);

            //регистрируем этот объект
            Registry registry = LocateRegistry.createRegistry(1099);//create
            registry.rebind(serviceName, service);

            System.out.println("Start " + serviceName);
        } catch (RemoteException e) {
            System.err.println("RemoteException : " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Exception : " + e.getMessage());
            System.exit(2);
        }
    }
}
