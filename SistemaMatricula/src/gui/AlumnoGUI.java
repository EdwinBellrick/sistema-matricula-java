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

import Arreglos.ArregloAlumnos;
import Clase.Alumno;

public class AlumnoGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtCodigo;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtDni;
    private JTextField txtEdad;
    private JTextField txtCelular;
    private JTextField txtEstado;

    private JTable tablaAlumnos;
    private DefaultTableModel modelo;

    private ArregloAlumnos arregloAlumnos;

    public AlumnoGUI() {
        arregloAlumnos = new ArregloAlumnos();

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

        modelo = new DefaultTableModel(columnas, 0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tablaAlumnos = new JTable(modelo);

        JScrollPane scrollPane = new JScrollPane(tablaAlumnos);
        scrollPane.setBounds(40, 310, 710, 190);
        getContentPane().add(scrollPane);

        btnAdicionar.addActionListener(e -> adicionarAlumno());
        btnModificar.addActionListener(e -> modificarAlumno());
        btnEliminar.addActionListener(e -> eliminarAlumno());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnSalir.addActionListener(e -> dispose());

        tablaAlumnos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                mostrarAlumnoSeleccionado();
            }
        });

        limpiarCampos();
        listarAlumnos();
    }

    private void adicionarAlumno() {
        try {
            String nombres = txtNombres.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            String dni = txtDni.getText().trim();
            String textoEdad = txtEdad.getText().trim();
            String textoCelular = txtCelular.getText().trim();

            if (nombres.isEmpty() || apellidos.isEmpty() || dni.isEmpty()
                    || textoEdad.isEmpty() || textoCelular.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Complete todos los campos.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!dni.matches("\\d{8}")) {
                JOptionPane.showMessageDialog(this,
                        "El DNI debe tener exactamente 8 dígitos.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (arregloAlumnos.buscarPorDni(dni) != null) {
                JOptionPane.showMessageDialog(this,
                        "El DNI ingresado ya está registrado.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int edad = Integer.parseInt(textoEdad);
            int celular = Integer.parseInt(textoCelular);

            if (edad <= 0) {
                JOptionPane.showMessageDialog(this,
                        "La edad debe ser mayor a cero.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int codigo = arregloAlumnos.generarCodigo();

            Alumno alumno = new Alumno(
                    codigo,
                    nombres,
                    apellidos,
                    dni,
                    edad,
                    celular,
                    0
            );

            arregloAlumnos.adicionar(alumno);

            JOptionPane.showMessageDialog(this,
                    "Alumno registrado correctamente.\nCódigo generado: " + codigo);

            listarAlumnos();
            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Edad y celular deben contener solo números.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void listarAlumnos() {
        modelo.setRowCount(0);

        for (int i = 0; i < arregloAlumnos.tamaño(); i++) {
            Alumno alumno = arregloAlumnos.obtener(i);

            modelo.addRow(new Object[] {
                    alumno.getCodAlumno(),
                    alumno.getNombres(),
                    alumno.getApellidos(),
                    alumno.getDni(),
                    alumno.getEdad(),
                    alumno.getCelular(),
                    textoEstado(alumno.getEstado())
            });
        }
    }

    private void mostrarAlumnoSeleccionado() {
        int fila = tablaAlumnos.getSelectedRow();

        if (fila == -1) {
            return;
        }

        Alumno alumno = arregloAlumnos.obtener(fila);

        txtCodigo.setText(String.valueOf(alumno.getCodAlumno()));
        txtNombres.setText(alumno.getNombres());
        txtApellidos.setText(alumno.getApellidos());
        txtDni.setText(alumno.getDni());
        txtEdad.setText(String.valueOf(alumno.getEdad()));
        txtCelular.setText(String.valueOf(alumno.getCelular()));
        txtEstado.setText(textoEstado(alumno.getEstado()));

        txtDni.setEditable(false);
    }

    private void modificarAlumno() {
        try {
            int fila = tablaAlumnos.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this,
                        "Seleccione un alumno de la tabla.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            String nombres = txtNombres.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            String textoEdad = txtEdad.getText().trim();
            String textoCelular = txtCelular.getText().trim();

            if (nombres.isEmpty() || apellidos.isEmpty()
                    || textoEdad.isEmpty() || textoCelular.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Complete los campos editables.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int edad = Integer.parseInt(textoEdad);
            int celular = Integer.parseInt(textoCelular);

            if (edad <= 0) {
                JOptionPane.showMessageDialog(this,
                        "La edad debe ser mayor a cero.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            Alumno alumno = arregloAlumnos.obtener(fila);

            alumno.setNombres(nombres);
            alumno.setApellidos(apellidos);
            alumno.setEdad(edad);
            alumno.setCelular(celular);

            JOptionPane.showMessageDialog(this,
                    "Alumno modificado correctamente.");

            listarAlumnos();
            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Edad y celular deben contener solo números.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminarAlumno() {
        int fila = tablaAlumnos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un alumno de la tabla.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Alumno alumno = arregloAlumnos.obtener(fila);

        if (alumno.getEstado() != 0) {
            JOptionPane.showMessageDialog(this,
                    "Solo se puede eliminar a un alumno con estado Registrado.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar al alumno "
                        + alumno.getNombres() + " " + alumno.getApellidos() + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            arregloAlumnos.eliminar(alumno);

            JOptionPane.showMessageDialog(this,
                    "Alumno eliminado correctamente.");

            listarAlumnos();
            limpiarCampos();
        }
    }

    private String textoEstado(int estado) {
        if (estado == 0) {
            return "Registrado";
        }

        if (estado == 1) {
            return "Matriculado";
        }

        if (estado == 2) {
            return "Retirado";
        }

        return "Desconocido";
    }

    private void limpiarCampos() {
        txtCodigo.setText(String.valueOf(arregloAlumnos.generarCodigo()));
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDni.setText("");
        txtEdad.setText("");
        txtCelular.setText("");
        txtEstado.setText("Registrado");

        txtDni.setEditable(true);
        tablaAlumnos.clearSelection();

        txtNombres.requestFocus();
    }
}