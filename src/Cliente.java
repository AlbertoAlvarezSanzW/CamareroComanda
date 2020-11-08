

public class Cliente extends Thread{


    @Override
    public void run() {
        try{
            while(true){
                synchronized (Main.instrucciones){
                    if (!Main.instrucciones.isEmpty()){
                        System.out.println("Cliente: voy a consumir:"+Main.instrucciones.get(0));
                        Main.instrucciones.remove(0);
                        sleep(3000);
                    }else{
                        System.out.println("Cliente: voy a esperar a que traigan la comida");
                        Main.instrucciones.notify();
                        Main.instrucciones.wait();
                    }
                }
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
