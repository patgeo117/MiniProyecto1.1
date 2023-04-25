import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Principal implements ActionListener {
    // Instancia de la clase
    CafeteriaR cafeteriaR = new CafeteriaR();

    // Ventans
    JFrame VenPricipal = new JFrame();
    JFrame VenReportes = new JFrame();

    // Iconos
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Iconos/LogoCafeP.png")));
    int s = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Ingresa número de mesas a utilizar: ","Cafeteria", JOptionPane.QUESTION_MESSAGE, img, null, ""));

    // ComboBox
    JComboBox<String> mesas = new JComboBox<String>() ;
    JComboBox<String> listProduct;

    // JTextArea
    JTextArea informacion = new JTextArea();

    //Botones
    JButton Bpedido= new JButton();
    JButton Bcobrar = new JButton();
    JButton Beliminar = new JButton();
    JButton Binformacion = new JButton();

    public Principal(){
        // Confi Ventana Principal
        VenPricipal.setLayout(null);
        VenPricipal.setSize(600,450); // Tamaño de la ventana
        VenPricipal.setTitle("CAFETERIA"); // Titulo de la ventana
        VenPricipal.setLocationRelativeTo(null); // posicion de la ventana en el centro
        VenPricipal.setResizable(false); // No cambiar de tamaño la ventana
        VenPricipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Cerrar ventana
        VenPricipal.setIconImage(img.getImage());
        VenPricipal.getContentPane().setBackground(new Color(0xB2793B));


        //If para cagar el JOption primero
        if(s>0){
            VenPricipal.setVisible(true); // Se muestra la Ventana
        }
        else {
            System.exit(0);
        }

        // Se inician los componentes de la ventana
        IniciarComponetes();
    }
    private void IniciarComponetes(){
        //ComboBox Mesas
        mesas.setBounds(10,10,200,40);
        for (int i = 1; i <= s; i++) {
            mesas.addItem("Mesa " + i);
        }
        VenPricipal.add(mesas);

        //ComboBox Productos
        listProduct = new JComboBox<>(cafeteriaR.productos); // Agregamos los productos al combobox
        listProduct.setBounds(225,10,200,40 );
        VenPricipal.add(listProduct);

        //JTextArea
        informacion.setBounds(10,65,400,300);
        VenPricipal.add(informacion);

        //Botones
        Bpedido.setBounds(450,20,100,30);
        Bpedido.setText("PEDIDO");
        Bpedido.addActionListener(this);
        VenPricipal.add(Bpedido);

        Bcobrar.setBounds(450, 60, 100, 30);
        Bcobrar.setText("COBRAR");
        Bcobrar.addActionListener(this);
        VenPricipal.add(Bcobrar);

        Beliminar.setBounds(450,100,100,30);
        Beliminar.setText("ELIMINAR");
        Beliminar.addActionListener(this);
        VenPricipal.add(Beliminar);

        Binformacion.setBounds(425,315,150,50);
        Binformacion.setText("INFORMACION");
        Binformacion.addActionListener(this);
        VenPricipal.add(Binformacion);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton jb = (JButton) ae.getSource();


    }
    public static void main(String[] args) {
            new Principal();
    }
}
