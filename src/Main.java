import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Gasto {
    private String descripcion;
    private double coste;
    private String categoria;

    public Gasto(String descripcion, double coste, String categoria) {
        this.descripcion = descripcion;
        this.coste = coste;
        this.categoria = categoria;
    }

    public double getCoste() {
        return coste;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return descripcion + " (" + categoria + "): $" + coste;
    }
}

class ControlGastos {
    private ArrayList<Gasto> gastos;

    public ControlGastos() {
        gastos = new ArrayList<>();
    }

    public void añadirGasto(String descripcion, double coste, String categoria) {
        Gasto gasto = new Gasto(descripcion, coste, categoria);
        gastos.add(gasto);
    }

    public void mostrarGastos() {
        if (gastos.isEmpty()) {
            System.out.println("No hay gastos registrados.");
            return;
        }
        System.out.println("Gastos registrados:");
        for (Gasto gasto : gastos) {
            System.out.println(gasto);
        }
    }

    public void calcularTotalGastos() {
        double total = 0;
        for (Gasto gasto : gastos) {
            total += gasto.getCoste();
        }
        System.out.println("Total de gastos: $" + total);
    }

    public void verGastosPorCategoria() {
        HashMap<String, Double> categoriaTotales = new HashMap<>();
        for (Gasto gasto : gastos) {
            String categoria = gasto.getCategoria();
            double coste = gasto.getCoste();
            categoriaTotales.put(categoria, categoriaTotales.getOrDefault(categoria, 0.0) + coste);
        }

        System.out.println("Gastos por categoría:");
        for (String categoria : categoriaTotales.keySet()) {
            System.out.println(categoria + ": $" + categoriaTotales.get(categoria));
        }
    }
}

//tienes que poner el nombre del archivo sobre el que estás trabajando, en mi casa es Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControlGastos controlGastos = new ControlGastos();

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Añadir gasto");
            System.out.println("2. Ver todos los gastos");
            System.out.println("3. Calcular total de gastos");
            System.out.println("4. Ver gastos por categoría");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            if (opcion == 1) {
                System.out.print("Descripción del gasto: ");
                String descripcion = scanner.nextLine();
                System.out.print("Coste: ");
                double coste = scanner.nextDouble();
                scanner.nextLine(); // Consumir la nueva línea
                System.out.print("Categoría del gasto: ");
                String categoria = scanner.nextLine();
                controlGastos.añadirGasto(descripcion, coste, categoria);
                System.out.println("Gasto añadido correctamente.\n");
            } else if (opcion == 2) {
                controlGastos.mostrarGastos();
            } else if (opcion == 3) {
                controlGastos.calcularTotalGastos();
            } else if (opcion == 4) {
                controlGastos.verGastosPorCategoria();
            } else if (opcion == 5) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida.\n");
            }
        }
        scanner.close();
    }
}
