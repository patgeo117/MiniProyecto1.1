import javax.swing.*;
import java.util.Objects;

public class Principal {
    JFrame VenPricipal = new JFrame();
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Iconos/LogoCafeP.png")));
    int s = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Ingresa número de mesas a utilizar: ","Cafeteria", JOptionPane.QUESTION_MESSAGE, img, null, ""));
    JFrame VenReportes = new JFrame();
    JComboBox<String> mesas = new JComboBox<String>() ;
    JComboBox<String> listProduct;

    String[] productos = {"Gaseosa", "Juego", "Papas fritas", "Capuchinnos", "Americano"};


    public Principal(){


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
        else {
            System.exit(0);
        }

        IniciarComponetes();
    }
    private void IniciarComponetes(){
        //ComboBox
        mesas.setBounds(10,10,80,60);

        for (int i = 1; i <= s; i++) {
            mesas.addItem("Mesa " + i);
        }
        VenPricipal.add(mesas);

        //ComboBox
        listProduct = new JComboBox<>(productos);
        listProduct.setBounds(100,10,80,60 );
        VenPricipal.add(listProduct);

        //Botones
        //Labels
        //Paneles ETC


    }

    public static void main(String[] args) {
            new Principal();
    }
}
