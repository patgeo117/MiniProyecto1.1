import javax.swing.*;
public class Principal {
    JFrame VenPricipal = new JFrame();
    JFrame VenReportes = new JFrame();

    public Principal(){

        VenPricipal.setLayout(null);
        VenPricipal.setSize(600,600); // Tamaño de la ventana
        VenPricipal.setTitle("CAFETERIA"); // Titulo de la ventana
        VenPricipal.setLocationRelativeTo(null); // posicion de la ventana en el centro
        VenPricipal.setResizable(false); // No cambiar de tamaño la ventana
        VenPricipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Cerrar ventana
        VenPricipal.setVisible(true); // Se muestra la Ventana

        IniciarComponetes();
    }
    private void IniciarComponetes(){

        //Botones
        //Labels
        //Paneles ETC


    }

    public static void main(String[] args) {
        int s = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa número de mesas a utilizar: ","Cafeteria", JOptionPane.PLAIN_MESSAGE));

        if (s>0){
            new Principal();
        }

    }
}
