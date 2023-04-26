public class ProductosCafeterias {
    int gaseosas;
    int jugos;
    int papasFritas;

    public void Mesa_Producto(String producto, int cantidad){
        switch (producto){ // swith para que dependiendo del producto agrgarle su determinada cantidad
            case "Gaeeosa":
                gaseosas += cantidad;
            break;
        }
    }

    public double calcularTotal() {
        double total = 0;
        total += gaseosas * 2.0;
        total += jugos * 1.5;
        total += papasFritas * 3.0;
        return total;
    }
}
