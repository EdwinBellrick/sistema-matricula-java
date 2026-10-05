package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class MenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuPrincipal frame = new MenuPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MenuPrincipal() {
        setTitle("Sistema de Registro y Matrícula de Alumnos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(760, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel(
                "SISTEMA DE REGISTRO Y MATRÍCULA DE ALUMNOS"
        );
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(0, 102, 153));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 0, 744, 70);
        getContentPane().add(lblTitulo);

        JLabel lblMantenimiento = new JLabel("MANTENIMIENTO");
        lblMantenimiento.setFont(new Font("Arial", Font.BOLD, 16));
        lblMantenimiento.setBounds(75, 100, 200, 25);
        getContentPane().add(lblMantenimiento);

        JButton btnAlumnos = new JButton("Alumnos");
        btnAlumnos.setFont(new Font("Arial", Font.PLAIN, 14));
        btnAlumnos.setBounds(75, 140, 220, 35);
        getContentPane().add(btnAlumnos);

        JButton btnCursos = new JButton("Cursos");
        btnCursos.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCursos.setBounds(75, 190, 220, 35);
        getContentPane().add(btnCursos);

        JLabel lblRegistro = new JLabel("REGISTRO");
        lblRegistro.setFont(new Font("Arial", Font.BOLD, 16));
        lblRegistro.setBounds(450, 100, 200, 25);
        getContentPane().add(lblRegistro);

        JButton btnMatriculas = new JButton("Matrículas");
        btnMatriculas.setFont(new Font("Arial", Font.PLAIN, 14));
        btnMatriculas.setBounds(450, 140, 220, 35);
        getContentPane().add(btnMatriculas);

        JButton btnRetiros = new JButton("Retiros");
        btnRetiros.setFont(new Font("Arial", Font.PLAIN, 14));
        btnRetiros.setBounds(450, 190, 220, 35);
        getContentPane().add(btnRetiros);

        JLabel lblConsultaReporte = new JLabel("CONSULTA Y REPORTE");
        lblConsultaReporte.setFont(new Font("Arial", Font.BOLD, 16));
        lblConsultaReporte.setBounds(270, 285, 230, 25);
        getContentPane().add(lblConsultaReporte);

        JButton btnConsultas = new JButton("Consultas");
        btnConsultas.setFont(new Font("Arial", Font.PLAIN, 14));
        btnConsultas.setBounds(160, 325, 190, 35);
        getContentPane().add(btnConsultas);

        JButton btnReportes = new JButton("Reportes");
        btnReportes.setFont(new Font("Arial", Font.PLAIN, 14));
        btnReportes.setBounds(395, 325, 190, 35);
        getContentPane().add(btnReportes);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Arial", Font.PLAIN, 14));
        btnSalir.setBounds(590, 400, 100, 30);
        getContentPane().add(btnSalir);

        btnAlumnos.addActionListener(e -> {
            AlumnoGUI ventana = new AlumnoGUI();
            ventana.setVisible(true);
        });

        btnCursos.addActionListener(e -> {
            CursoGUI ventana = new CursoGUI();
            ventana.setVisible(true);
        });

        btnMatriculas.addActionListener(e -> {
            MatriculaGUI ventana = new MatriculaGUI();
            ventana.setVisible(true);
        });

        btnRetiros.addActionListener(e -> {
            RetiroGUI ventana = new RetiroGUI();
            ventana.setVisible(true);
        });

        btnConsultas.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Módulo de consultas en desarrollo.",
                    "Consultas",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        btnReportes.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Módulo de reportes en desarrollo.",
                    "Reportes",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        btnSalir.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    "¿Desea salir del sistema?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }
}