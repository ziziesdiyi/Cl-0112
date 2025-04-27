import java.util.Scanner;

public class JuegoBatalla {
    private Robot[] robots = new Robot[10];
    private int cantidad = 0;
    private Scanner scanner = new Scanner(System.in);
    private boolean simulacionActiva = true;
    private int contador = 0;
    public static void main(String[] args) {
        JuegoBatalla juego = new JuegoBatalla();
        juego.crearRobots();
        juego.iniciarBatalla();
    }
    // Constructor
    public JuegoBatalla() {
    }

    private int numeroContador(int min, int max) {
        contador++;
        int horaActual = (int)(System.currentTimeMillis() % 10000);
        int base = contador * 13 + horaActual;
        int rango = max - min + 1;
        int resultado = min + (base % rango);
        return resultado;
    }

    public void crearRobots() {
        System.out.println("Agregar Robots");
        System.out.print("Cuantos robots para la simulacion (maximo 10): ");
        int cantidadIngresada = scanner.nextInt();
        scanner.nextLine();
        
        if (cantidadIngresada < 1) {
            cantidad = 2;
            System.out.println("Se utilizaran 2 robots");
        } else if (cantidadIngresada > 10) {
            cantidad = 10;
            System.out.println("Se utilizaran 10 robots");
        } else {
            cantidad = cantidadIngresada;
        }

        for (int i = 0; i < cantidad; i++) {  
            System.out.println("\nRobot " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
    
            System.out.print("Puntos de vida (50-100): ");
            int vida = scanner.nextInt();
            scanner.nextLine();
            if (vida < 50) vida = 50;
            if (vida > 100) vida = 100;
    
            System.out.print("Puntos de ataque (10-20): ");
            int ataque = scanner.nextInt();
            scanner.nextLine();
            if (ataque < 10) ataque = 10;
            if (ataque > 20) ataque = 20;
    
            System.out.print("Puntos de defensa (0-10): ");
            int defensa = scanner.nextInt();
            scanner.nextLine();
            if (defensa < 0) defensa = 0;
            if (defensa > 10) defensa = 10;
    
            robots[i] = new Robot(nombre, vida, ataque, defensa);
        }
    }

    private void eliminarRobot(int indice) {
        for (int i = indice; i < cantidad - 1; i++) {
            robots[i] = robots[i + 1];
        }
        robots[cantidad - 1] = null;
        cantidad--;
    }

    private boolean verificarPausa() {
        System.out.println("Enter para continuar o escribir P para pausar:");
        String entrada = scanner.nextLine();
        if (entrada.equalsIgnoreCase("P")) {
            System.out.println("\nSimulacion pausada");
            mostrarEstado();
            System.out.println("1. Continuar");
            System.out.println("2. Terminar");
            System.out.print("Opcion: ");
            String opcion = scanner.nextLine();
            if (opcion.equals("1")) {
                return false;
            } else {
                simulacionActiva = false;
                return true;
            }
        }
        return false;
    }

    public void iniciarBatalla() {
        System.out.println("\nComienza la batalla!");
        int turno = 1;
    
        while (cantidad > 1 && simulacionActiva) {
            System.out.println("\nTurno " + turno);
    
            if (verificarPausa()) {
                continue;
            }
    
            for (int i = 0; i < cantidad; i++) {
                if (cantidad <= 1) {
                    break;
                }
    
                Robot atacante = robots[i];
                int objetivo;
                do {
                    objetivo = numeroContador(0, cantidad - 1);
                } while (objetivo == i);
    
                Robot atacado = robots[objetivo];
                atacante.atacar(atacado);
    
                if (!atacado.estaVivo()) {
                    System.out.println(atacado.getNombre() + " fue eliminado.");
                    eliminarRobot(objetivo);
                    if (objetivo < i) {
                        i--;
                    }
                }
            }
            turno++;
        }
    
        if (simulacionActiva) {
            mostrarGanador();
        } else {
            System.out.println("\nSimulacion detenida.");
            mostrarEstado();
        }
    }

    private void mostrarEstado() {
        System.out.println("\nEstado actual de los robots:");
        for (int i = 0; i < cantidad; i++) {
            Robot r = robots[i];
            System.out.println("Robot: " + r.getNombre() +
                " | Vida: " + r.getPuntosVida() +
                " | Ataque: " + r.getAtaque() +
                " | Defensa: " + r.getDefensa());
        }
    }

    private void mostrarGanador() {
        if (cantidad == 1) {
            Robot ganador = robots[0];
            System.out.println("\nEl ganador es " + ganador.getNombre() + "!");
            System.out.println("Vida restante: " + ganador.getPuntosVida());
        } else {
            System.out.println("\nNo hubo un ganador claro.");
        }
    }
}

  