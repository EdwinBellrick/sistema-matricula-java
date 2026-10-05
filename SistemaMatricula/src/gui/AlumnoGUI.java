package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AlumnoGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtCodigo;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtDni;
    private JTextField txtEdad;
    private JTextField txtCelular;
    private JTextField txtEstado;

    public AlumnoGUI() {
        setTitle("Mantenimiento de Alumnos");
        setSize(850, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("MANTENIMIENTO DE ALUMNOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(270, 20, 350, 30);
        getContentPane().add(lblTitulo);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(40, 80, 100, 25);
        getContentPane().add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 80, 220, 25);
        txtCodigo.setEditable(false);
        getContentPane().add(txtCodigo);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(40, 120, 100, 25);
        getContentPane().add(lblNombres);

        txtNombres = new JTextField();
        txtNombres.setBounds(150, 120, 220, 25);
        getContentPane().add(txtNombres);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(40, 160, 100, 25);
        getContentPane().add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(150, 160, 220, 25);
        getContentPane().add(txtApellidos);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(440, 80, 100, 25);
        getContentPane().add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(550, 80, 220, 25);
        getContentPane().add(txtDni);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(440, 120, 100, 25);
        getContentPane().add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(550, 120, 220, 25);
        getContentPane().add(txtEdad);

        JLabel lblCelular = new JLabel("Celular:");
        lblCelular.setBounds(440, 160, 100, 25);
        getContentPane().add(lblCelular);

        txtCelular = new JTextField();
        txtCelular.setBounds(550, 160, 220, 25);
        getContentPane().add(txtCelular);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(440, 200, 100, 25);
        getContentPane().add(lblEstado);

        txtEstado = new JTextField();
        txtEstado.setBounds(550, 200, 220, 25);
        txtEstado.setEditable(false);
        getContentPane().add(txtEstado);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(40, 240, 130, 30);
        getContentPane().add(btnAdicionar);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(185, 240, 130, 30);
        getContentPane().add(btnModificar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(330, 240, 130, 30);
        getContentPane().add(btnEliminar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(475, 240, 130, 30);
        getContentPane().add(btnLimpiar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(620, 240, 130, 30);
        getContentPane().add(btnSalir);

        String[] columnas = {
            "Código", "Nombres", "Apellidos",
            "DNI", "Edad", "Celular", "Estado"
        };

        JTable tablaAlumnos = new JTable(
                new DefaultTableModel(columnas, 0)
        );

        JScrollPane scrollPane = new JScrollPane(tablaAlumnos);
        scrollPane.setBounds(40, 310, 710, 190);
        getContentPane().add(scrollPane);

        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnSalir.addActionListener(e -> dispose());
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDni.setText("");
        txtEdad.setText("");
        txtCelular.setText("");
        txtEstado.setText("");
    }
}