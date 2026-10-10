package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloCursos;
import Clase.Curso;

public class CursoGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtCodigo;
    private JTextField txtAsignatura;
    private JTextField txtCiclo;
    private JTextField txtCreditos;
    private JTextField txtHoras;

    private JTable tablaCursos;
    private DefaultTableModel modelo;

    private ArregloCursos arregloCursos;

    public CursoGUI() {
        arregloCursos = new ArregloCursos();

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

        modelo = new DefaultTableModel(columnas, 0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tablaCursos = new JTable(modelo);

        JScrollPane scrollPane = new JScrollPane(tablaCursos);
        scrollPane.setBounds(60, 270, 700, 180);
        getContentPane().add(scrollPane);

        btnAdicionar.addActionListener(e -> adicionarCurso());
        btnModificar.addActionListener(e -> modificarCurso());
        btnEliminar.addActionListener(e -> eliminarCurso());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnSalir.addActionListener(e -> dispose());

        tablaCursos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                mostrarCursoSeleccionado();
            }
        });

        listarCursos();
    }

    private void adicionarCurso() {
        try {
            String textoCodigo = txtCodigo.getText().trim();
            String asignatura = txtAsignatura.getText().trim();
            String textoCiclo = txtCiclo.getText().trim();
            String textoCreditos = txtCreditos.getText().trim();
            String textoHoras = txtHoras.getText().trim();

            if (textoCodigo.isEmpty() || asignatura.isEmpty() || textoCiclo.isEmpty()
                    || textoCreditos.isEmpty() || textoHoras.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Complete todos los campos.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!textoCodigo.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(this,
                        "El código debe tener exactamente 4 dígitos.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int codigo = Integer.parseInt(textoCodigo);
            int ciclo = Integer.parseInt(textoCiclo);
            int creditos = Integer.parseInt(textoCreditos);
            int horas = Integer.parseInt(textoHoras);

            if (arregloCursos.buscarPorCodigo(codigo) != null) {
                JOptionPane.showMessageDialog(this,
                        "El código del curso ya está registrado.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (ciclo < 0 || ciclo > 5) {
                JOptionPane.showMessageDialog(this,
                        "El ciclo debe estar entre 0 y 5.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (creditos <= 0 || horas <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Créditos y horas deben ser mayores a cero.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            Curso curso = new Curso(codigo, asignatura, ciclo, creditos, horas);

            arregloCursos.adicionar(curso);

            JOptionPane.showMessageDialog(this,
                    "Curso registrado correctamente.");

            listarCursos();
            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Código, ciclo, créditos y horas deben contener solo números.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void listarCursos() {
        modelo.setRowCount(0);

        for (int i = 0; i < arregloCursos.tamaño(); i++) {
            Curso curso = arregloCursos.obtener(i);

            modelo.addRow(new Object[] {
                    curso.getCodCurso(),
                    curso.getAsignatura(),
                    nombreCiclo(curso.getCiclo()),
                    curso.getCreditos(),
                    curso.getHoras()
            });
        }
    }

    private void mostrarCursoSeleccionado() {
        int fila = tablaCursos.getSelectedRow();

        if (fila == -1) {
            return;
        }

        Curso curso = arregloCursos.obtener(fila);

        txtCodigo.setText(String.valueOf(curso.getCodCurso()));
        txtAsignatura.setText(curso.getAsignatura());
        txtCiclo.setText(String.valueOf(curso.getCiclo()));
        txtCreditos.setText(String.valueOf(curso.getCreditos()));
        txtHoras.setText(String.valueOf(curso.getHoras()));

        txtCodigo.setEditable(false);
    }

    private void modificarCurso() {
        try {
            int fila = tablaCursos.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this,
                        "Seleccione un curso de la tabla.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            String asignatura = txtAsignatura.getText().trim();
            String textoCiclo = txtCiclo.getText().trim();
            String textoCreditos = txtCreditos.getText().trim();
            String textoHoras = txtHoras.getText().trim();

            if (asignatura.isEmpty() || textoCiclo.isEmpty()
                    || textoCreditos.isEmpty() || textoHoras.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Complete todos los campos editables.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int ciclo = Integer.parseInt(textoCiclo);
            int creditos = Integer.parseInt(textoCreditos);
            int horas = Integer.parseInt(textoHoras);

            if (ciclo < 0 || ciclo > 5) {
                JOptionPane.showMessageDialog(this,
                        "El ciclo debe estar entre 0 y 5.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (creditos <= 0 || horas <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Créditos y horas deben ser mayores a cero.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            Curso curso = arregloCursos.obtener(fila);

            curso.setAsignatura(asignatura);
            curso.setCiclo(ciclo);
            curso.setCreditos(creditos);
            curso.setHoras(horas);

            JOptionPane.showMessageDialog(this,
                    "Curso modificado correctamente.");

            listarCursos();
            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Ciclo, créditos y horas deben contener solo números.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminarCurso() {
        int fila = tablaCursos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un curso de la tabla.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Curso curso = arregloCursos.obtener(fila);

        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar el curso "
                        + curso.getCodCurso() + " - " + curso.getAsignatura() + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            arregloCursos.eliminar(curso);

            JOptionPane.showMessageDialog(this,
                    "Curso eliminado correctamente.");

            listarCursos();
            limpiarCampos();
        }
    }

    private String nombreCiclo(int ciclo) {
        switch (ciclo) {
            case 0:
                return "1.° ciclo";
            case 1:
                return "2.° ciclo";
            case 2:
                return "3.° ciclo";
            case 3:
                return "4.° ciclo";
            case 4:
                return "5.° ciclo";
            case 5:
                return "6.° ciclo";
            default:
                return "No definido";
        }
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtAsignatura.setText("");
        txtCiclo.setText("");
        txtCreditos.setText("");
        txtHoras.setText("");

        txtCodigo.setEditable(true);
        tablaCursos.clearSelection();

        txtCodigo.requestFocus();
    }
}