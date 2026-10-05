package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MatriculaGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtNumero;
    private JTextField txtAlumno;
    private JTextField txtCurso;
    private JTextField txtFecha;
    private JTextField txtHora;

    public MatriculaGUI() {
        setTitle("Registro de Matrículas");
        setSize(850, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("REGISTRO DE MATRÍCULAS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(290, 20, 320, 30);
        getContentPane().add(lblTitulo);

        JLabel lblNumero = new JLabel("N.° Matrícula:");
        lblNumero.setBounds(60, 80, 120, 25);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(190, 80, 220, 25);
        txtNumero.setEditable(false);
        getContentPane().add(txtNumero);

        JLabel lblAlumno = new JLabel("Código alumno:");
        lblAlumno.setBounds(60, 120, 120, 25);
        getContentPane().add(lblAlumno);

        txtAlumno = new JTextField();
        txtAlumno.setBounds(190, 120, 220, 25);
        getContentPane().add(txtAlumno);

        JLabel lblCurso = new JLabel("Código curso:");
        lblCurso.setBounds(470, 80, 120, 25);
        getContentPane().add(lblCurso);

        txtCurso = new JTextField();
        txtCurso.setBounds(600, 80, 170, 25);
        getContentPane().add(txtCurso);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(470, 120, 120, 25);
        getContentPane().add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(600, 120, 170, 25);
        txtFecha.setEditable(false);
        getContentPane().add(txtFecha);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setBounds(470, 160, 120, 25);
        getContentPane().add(lblHora);

        txtHora = new JTextField();
        txtHora.setBounds(600, 160, 170, 25);
        txtHora.setEditable(false);
        getContentPane().add(txtHora);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(60, 210, 130, 30);
        getContentPane().add(btnAdicionar);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(210, 210, 130, 30);
        getContentPane().add(btnModificar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(360, 210, 130, 30);
        getContentPane().add(btnEliminar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(510, 210, 130, 30);
        getContentPane().add(btnLimpiar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(660, 210, 110, 30);
        getContentPane().add(btnSalir);

        String[] columnas = {
            "N.° Matrícula", "Alumno", "Curso", "Fecha", "Hora"
        };

        JTable tablaMatriculas = new JTable(
                new DefaultTableModel(columnas, 0)
        );

        JScrollPane scrollPane = new JScrollPane(tablaMatriculas);
        scrollPane.setBounds(60, 270, 710, 180);
        getContentPane().add(scrollPane);

        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnSalir.addActionListener(e -> dispose());
    }

    private void limpiarCampos() {
        txtNumero.setText("");
        txtAlumno.setText("");
        txtCurso.setText("");
        txtFecha.setText("");
        txtHora.setText("");
    }
}