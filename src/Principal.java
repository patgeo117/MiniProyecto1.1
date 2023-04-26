import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Principal implements ActionListener {
    // Instancia de la clase
    MesasCafeteria mesasCafeteria = new MesasCafeteria();
    ProductosCafeterias productosCafeteria = new ProductosCafeterias();
    // Ventanas
    JFrame VenPricipal = new JFrame();

    // Iconos
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Iconos/LogoCafeP.png")));
    int s = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Ingresa número de mesas a utilizar: ","Cafeteria", JOptionPane.QUESTION_MESSAGE, img, null, ""));

    // ComboBox
    JComboBox mesas = new JComboBox() ;
    JComboBox listProduct;

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
        if(s>0){
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
        mesas.setBounds(10,10,200,40); // Dimensiones
        for (int i = 1; i <= s; i++) { //For para crear las mesas según la cantidad digitada
            mesas.addItem("Mesa " + i);
        }
        VenPricipal.add(mesas);

        //ComboBox Productos
        listProduct = new JComboBox<>(cafeteriaR.productos); // Agregamos los productos al combobox
        listProduct.setBounds(225,10,200,40 );
        VenPricipal.add(listProduct); // se añade a la ventana

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
        // Obtener número del producto seleccionado
        int productoSeleccionado = listProduct.getSelectedIndex();

        // Se le pasan el index al metodo para despues evaluarlo
        productosCafeteria.Mesa_Producto(productoSeleccionado);

        // Obtener cantidad de productos
        int cantidad = (int) Integer.parseInt(Jcantidad.getText());

        // Obtenemos el nombre del item selccionado

        if(ae.getSource()== Bpedido){
            String nameProducto = (String) listProduct.getSelectedItem();
            String nameMesa = (String)mesas.getSelectedItem();
            mesasCafeteria.mesas[0] = nameMesa;

            Jinformacion.setText(" " + mesasCafeteria.mesas + " -- " + nameProducto + " -- " + cantidad + "  " );

        }
    }
    public static void main(String[] args) {
            new Principal();
    }
}
