import javax.swing.*;
import java.awt.*;

public class Principal {
    JFrame VenPricipal = new JFrame();
    ImageIcon img = new ImageIcon(getClass().getResource("/Iconos/LogoCafeP.png"));
    JFrame VenReportes = new JFrame();

    public Principal(){

        int s = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Ingresa número de mesas a utilizar: ","Cafeteria", JOptionPane.QUESTION_MESSAGE, img, null, ""));
        VenPricipal.setLayout(null);
        VenPricipal.setSize(600,600); // Tamaño de la ventana
        VenPricipal.setTitle("CAFETERIA"); // Titulo de la ventana
        VenPricipal.setLocationRelativeTo(null); // posicion de la ventana en el centro
        VenPricipal.setResizable(false); // No cambiar de tamaño la ventana
        VenPricipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Cerrar ventana
        VenPricipal.setIconImage(img.getImage());

        if(s>0){
            VenPricipal.setVisible(true); // Se muestra la Ventana
        }

        IniciarComponetes();
    }
    private void IniciarComponetes(){

        //Botones
        //Labels
        //Paneles ETC


    }

    public static void main(String[] args) {
            new Principal();
    }
}
