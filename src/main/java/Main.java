import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    //lock sin estatico
    static ReentrantLock lock = new ReentrantLock();
    static ArrayList<Jugador> listaJugadores = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            listaJugadores.add(new Jugador("nombre= " + i + " "));
        }

        for (int i = 0; i < listaJugadores.size(); i++) {
            listaJugadores.get(i).start();
        }

    }

}

class Jugador extends Thread {
    private String nombre;
    private boolean pis = true;

    Jugador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        //bloqueamos el baño
        Main.lock.lock();
        System.out.println("El jugador" + nombre + "ha entrado al baño");
        hacerPisEnbanio();
        System.out.println("El jugador" + nombre + "ha terminado con el baño");
        Main.lock.unlock();
    }

    public void hacerPis() {
        try {
            Thread.sleep(3000);
            pis = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void hacerPisEnbanio() {
        try {
            Thread.sleep(3000);
            pis = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


