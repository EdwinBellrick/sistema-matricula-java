package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CursoGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtCodigo;
    private JTextField txtAsignatura;
    private JTextField txtCiclo;
    private JTextField txtCreditos;
    private JTextField txtHoras;

    public CursoGUI() {
        setTitle("Mantenimiento de Cursos");
        setSize(850, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("MANTENIMIENTO DE CURSOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(280, 20, 350, 30);
        getContentPane().add(lblTitulo);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(60, 80, 100, 25);
        getContentPane().add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(180, 80, 220, 25);
        getContentPane().add(txtCodigo);

        JLabel lblAsignatura = new JLabel("Asignatura:");
        lblAsignatura.setBounds(60, 120, 100, 25);
        getContentPane().add(lblAsignatura);

        txtAsignatura = new JTextField();
        txtAsignatura.setBounds(180, 120, 220, 25);
        getContentPane().add(txtAsignatura);

        JLabel lblCiclo = new JLabel("Ciclo:");
        lblCiclo.setBounds(460, 80, 100, 25);
        getContentPane().add(lblCiclo);

        txtCiclo = new JTextField();
        txtCiclo.setBounds(580, 80, 180, 25);
        getContentPane().add(txtCiclo);

        JLabel lblCreditos = new JLabel("Créditos:");
        lblCreditos.setBounds(460, 120, 100, 25);
        getContentPane().add(lblCreditos);

        txtCreditos = new JTextField();
        txtCreditos.setBounds(580, 120, 180, 25);
        getContentPane().add(txtCreditos);

        JLabel lblHoras = new JLabel("Horas:");
        lblHoras.setBounds(460, 160, 100, 25);
        getContentPane().add(lblHoras);

        txtHoras = new JTextField();
        txtHoras.setBounds(580, 160, 180, 25);
        getContentPane().add(txtHoras);

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
        btnSalir.setBounds(660, 210, 100, 30);
        getContentPane().add(btnSalir);

        String[] columnas = {
            "Código", "Asignatura", "Ciclo", "Créditos", "Horas"
        };

        JTable tablaCursos = new JTable(
                new DefaultTableModel(columnas, 0)
        );

        JScrollPane scrollPane = new JScrollPane(tablaCursos);
        scrollPane.setBounds(60, 270, 700, 180);
        getContentPane().add(scrollPane);

        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnSalir.addActionListener(e -> dispose());
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtAsignatura.setText("");
        txtCiclo.setText("");
        txtCreditos.setText("");
        txtHoras.setText("");
    }
}