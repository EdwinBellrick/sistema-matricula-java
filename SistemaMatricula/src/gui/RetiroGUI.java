package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RetiroGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtNumero;
    private JTextField txtMatricula;
    private JTextField txtFecha;
    private JTextField txtHora;

    public RetiroGUI() {
        setTitle("Registro de Retiros");
        setSize(850, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("REGISTRO DE RETIROS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(310, 20, 300, 30);
        getContentPane().add(lblTitulo);

        JLabel lblNumero = new JLabel("N.° Retiro:");
        lblNumero.setBounds(60, 80, 120, 25);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(190, 80, 220, 25);
        txtNumero.setEditable(false);
        getContentPane().add(txtNumero);

        JLabel lblMatricula = new JLabel("N.° Matrícula:");
        lblMatricula.setBounds(60, 120, 120, 25);
        getContentPane().add(lblMatricula);

        txtMatricula = new JTextField();
        txtMatricula.setBounds(190, 120, 220, 25);
        getContentPane().add(txtMatricula);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(470, 80, 120, 25);
        getContentPane().add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(600, 80, 170, 25);
        txtFecha.setEditable(false);
        getContentPane().add(txtFecha);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setBounds(470, 120, 120, 25);
        getContentPane().add(lblHora);

        txtHora = new JTextField();
        txtHora.setBounds(600, 120, 170, 25);
        txtHora.setEditable(false);
        getContentPane().add(txtHora);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(60, 190, 130, 30);
        getContentPane().add(btnAdicionar);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(210, 190, 130, 30);
        getContentPane().add(btnModificar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(360, 190, 130, 30);
        getContentPane().add(btnEliminar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(510, 190, 130, 30);
        getContentPane().add(btnLimpiar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(660, 190, 110, 30);
        getContentPane().add(btnSalir);

        String[] columnas = {
            "N.° Retiro", "N.° Matrícula", "Fecha", "Hora"
        };

        JTable tablaRetiros = new JTable(
                new DefaultTableModel(columnas, 0)
        );

        JScrollPane scrollPane = new JScrollPane(tablaRetiros);
        scrollPane.setBounds(60, 250, 710, 180);
        getContentPane().add(scrollPane);

        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnSalir.addActionListener(e -> dispose());
    }

    private void limpiarCampos() {
        txtNumero.setText("");
        txtMatricula.setText("");
        txtFecha.setText("");
        txtHora.setText("");
    }
}