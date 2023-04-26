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
        total += gaseosas * 3000;
        total += jugos * 8000;
        total += papasFritas * 2000;
        return total;
    }
}
