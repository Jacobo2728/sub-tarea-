import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Empleado 
{
    private final String nombre;
    private final int edad;
    private final double salario;

    public Empleado(String nombre, int edad, double salario)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public int getEdad() 
    {
        return edad;
    }

    public double getSalario()
    {
        return salario;
    }
    
    public void imprimirInfo() 
    {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Salario: " + salario);
    }
}

class GestorEmpleados 
{
    private final List<Empleado> empleados;

    public GestorEmpleados() 
    {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado)
    {
        empleados.add(empleado);
        System.out.println("Empleado agregado: " + empleado.getNombre());
    }

    public void mostrarEmpleados() 
    {
        if (empleados.isEmpty())
        {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("Lista de empleados:");
            for (Empleado empleado : empleados) 
            {
                empleado.imprimirInfo();
            }
        }
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();

        while (true)
        {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) 
            {
                case 1 ->
                {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); 
                    Empleado nuevoEmpleado = new Empleado(nombre, edad, salario);
                    gestor.agregarEmpleado(nuevoEmpleado);
                }
                case 2 -> gestor.mostrarEmpleados();
                case 3 -> 
                {
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        }
    }
}

