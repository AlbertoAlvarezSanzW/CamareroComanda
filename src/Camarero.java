

public class Camarero extends Thread{
    // es inportante que siempre metamos dentro del try todo el override
    // cuidado con la posición de las llaves
    @Override
    public void run() {

        try {
            while (true){
                synchronized (Main.instrucciones) {
                    // inicialmente decimos que espere hasta que sincronice y luego empieza la ejecución
                    // hasta que no llegue el cliente, no puede empezar a trabajar
                    Main.instrucciones.wait();
                    prepararLaComanda();
                    // el notify es para que ejecute la siguiente instrucción
                    Main.instrucciones.notify();

                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();

        }

    }

    private void prepararLaComanda() throws InterruptedException {

        System.out.println("Camarero: Acaban de pedir los clientes para cenar");
        Main.instrucciones.add("Nachos");
        sleep(3000);
        Main.instrucciones.add("bebida");
        sleep(2000);
        Main.instrucciones.add("Nestea");
        sleep(4000);
        Main.instrucciones.add("Cesar");
        sleep(5000);
        Main.instrucciones.add("Brounie");
        sleep(6000);



    }

}
