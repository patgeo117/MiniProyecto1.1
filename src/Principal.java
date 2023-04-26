import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class Principal implements ActionListener {
    // Instancia de la clase
    MesasCafeteria mesasCafeteria = new MesasCafeteria();
    ProductosCafeterias productosCafeteria = new ProductosCafeterias();
    // Ventanas
    JFrame VenPricipal = new JFrame();

    // Iconos
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Iconos/LogoCafeP.png")));
    int numMesas = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Ingresa número de mesas a utilizar: ","Cafeteria", JOptionPane.QUESTION_MESSAGE, img, null, ""));

    // ComboBox
    JComboBox<String> mesasComboBox = new JComboBox<>() ;
    JComboBox<String> listProductComboBox;

    // JTextArea
    JTextArea Jinformacion = new JTextArea();

    // JTexField
    JTextField Jcantidad = new JTextField();

    // Label
    Label Lcantidad = new Label();

    //Botones
    JButton Bpedido= new JButton();
    JButton Bcobrar = new JButton();
    JButton Beliminar = new JButton();
    JButton Binformacion = new JButton();

    String[] pedidos = new String[numMesas]; // el número de pedidos sera igual al número de mesas



    public Principal() {

        // Configuración Ventana Principal
        VenPricipal.setLayout(null);
        VenPricipal.setSize(600, 450); // Tamaño de la ventana
        VenPricipal.setTitle("CAFETERIA"); // Título de la ventana
        VenPricipal.setLocationRelativeTo(null); // posición de la ventana en el centro
        VenPricipal.setResizable(false); // No cambiar de tamaño la ventana
        VenPricipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Cerrar ventana
        VenPricipal.setIconImage(img.getImage()); // se cambia el icono
        VenPricipal.getContentPane().setBackground(new Color(0xB2793B)); // se le cambia el color de fondo


        //If para cagar el JOption primero
        if(numMesas>0){
            VenPricipal.setVisible(true); // Se muestra la Ventana
        }
        else {
            System.exit(0); // por si ocurre algún error o interrupción se cierra el programa
        }

        // Se inician los componentes de la ventana
        IniciarComponetes();
    }
    private void IniciarComponetes(){
        //ComboBox Mesas
        mesasComboBox.setBounds(10,10,200,40); // Dimensiones
        for (int i = 1; i <= numMesas; i++) { //For para crear las mesas según la cantidad digitada
            mesasComboBox.addItem("Mesa " + i);
        }
        VenPricipal.add(mesasComboBox); // se agrega a la ventana

        //ComboBox Productos
        listProductComboBox = new JComboBox<>(); // Agregamos los productos al combobox
        listProductComboBox.addItem("Gaseosa");
        listProductComboBox.addItem("Jugo");
        listProductComboBox.addItem("Papas Fritas");
        listProductComboBox.setBounds(225,10,200,40 );
        VenPricipal.add(listProductComboBox); // se añade a la ventana

        //JTextArea
        Jinformacion.setBounds(10,65,400,300);
        Jinformacion.setEditable(false); // No se permite escribir
        VenPricipal.add(Jinformacion);

        //JTextField
        Jcantidad.setBounds(450,30,100,20);
        VenPricipal.add(Jcantidad);

        //Label
        Font font = new Font("Arial", Font.BOLD, 14); // se le coloca negrilla y se cambia el estilo
        Lcantidad.setFont(font); // se añaden los nuevos estilos al label
        Lcantidad.setText("CANTIDAD");
        Lcantidad.setBounds(462,10,100,20);
        VenPricipal.add(Lcantidad);

        //Botones
        Bpedido.setBounds(450,70,100,30);
        Bpedido.setText("PEDIDO");
        Bpedido.addActionListener(this);
        VenPricipal.add(Bpedido);

        Bcobrar.setBounds(450, 110, 100, 30);
        Bcobrar.setText("COBRAR");
        Bcobrar.addActionListener(this);
        VenPricipal.add(Bcobrar);

        Beliminar.setBounds(450,150,100,30);
        Beliminar.setText("ELIMINAR");
        Beliminar.addActionListener(this);
        VenPricipal.add(Beliminar);

        Binformacion.setBounds(425,315,150,50);
        Binformacion.setText("INFORMACIÓN");
        Binformacion.addActionListener(this);
        VenPricipal.add(Binformacion);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        JButton jb = (JButton) ae.getSource();
        // Obtener número del producto seleccionado
        int mesaSeleccionado = mesasComboBox.getSelectedIndex();

        String productoSeleccionado = (String) listProductComboBox.getSelectedItem();
        // Obtener cantidad de productos
        int cantidad = Integer.parseInt(Jcantidad.getText());


        if(jb == Bpedido){
            productosCafeteria.Mesa_Producto(productoSeleccionado, cantidad); // le mando los datos a un método de productos Cafeteria
            Jinformacion.setText( cantidad +" de "+productoSeleccionado +" para la mesa " + (mesaSeleccionado+1));
        }
    }
    public static void main(String[] args) {
            new Principal();
    }
}
