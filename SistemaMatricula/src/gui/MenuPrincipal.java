package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuPrincipal {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal window = new MenuPrincipal();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MenuPrincipal() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Sistema de Registro y Matrícula de Alumnos");
        frame.setBounds(100, 100, 700, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel(
                "SISTEMA DE REGISTRO Y MATRÍCULA DE ALUMNOS"
        );
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(60, 30, 560, 30);
        frame.getContentPane().add(lblTitulo);

        JLabel lblMantenimiento = new JLabel(
                "Mantenimiento: Alumnos y Cursos"
        );
        lblMantenimiento.setFont(new Font("Arial", Font.PLAIN, 15));
        lblMantenimiento.setBounds(90, 110, 400, 25);
        frame.getContentPane().add(lblMantenimiento);

        JLabel lblRegistro = new JLabel(
                "Registro: Matrículas y Retiros"
        );
        lblRegistro.setFont(new Font("Arial", Font.PLAIN, 15));
        lblRegistro.setBounds(90, 160, 400, 25);
        frame.getContentPane().add(lblRegistro);

        JLabel lblConsulta = new JLabel(
                "Consulta: Alumnos, Cursos, Matrículas y Retiros"
        );
        lblConsulta.setFont(new Font("Arial", Font.PLAIN, 15));
        lblConsulta.setBounds(90, 210, 450, 25);
        frame.getContentPane().add(lblConsulta);

        JLabel lblReporte = new JLabel(
                "Reporte: Pendientes, Vigentes y Matriculados por Curso"
        );
        lblReporte.setFont(new Font("Arial", Font.PLAIN, 15));
        lblReporte.setBounds(90, 260, 500, 25);
        frame.getContentPane().add(lblReporte);

        JLabel lblEstado = new JLabel(
                "Avance inicial: clases y diseño de interfaces"
        );
        lblEstado.setFont(new Font("Arial", Font.ITALIC, 13));
        lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
        lblEstado.setBounds(90, 340, 500, 25);
        frame.getContentPane().add(lblEstado);
    }
}