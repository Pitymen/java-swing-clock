package com.pitymen.swingclock;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TelaRelogio extends JFrame {

    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private ImageIcon icon;
    private JLabel lblIcone;
    private JLabel lblHora;
    private JButton btnHora;

    public TelaRelogio() {
        configurarJanela();
        criarComponentes();
        posicionarComponentes();
        configurarEventos();
        atualizarHora();
        exibir();
    }

    private void configurarJanela() {
        setTitle("Relógio");
        setSize(620, 360);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    private void criarComponentes() {
        icon = new ImageIcon(TelaRelogio.class.getResource("/imagens/calendario.png"));
        lblIcone = new JLabel(icon);

        lblHora = new JLabel("Clique no botão");
        lblHora.setFont(lblHora.getFont().deriveFont(28f));
        lblHora.setHorizontalAlignment(SwingConstants.CENTER);

        btnHora = new JButton("Clique aqui");

    }

    private void posicionarComponentes() {
        lblIcone.setBounds(30, 30, icon.getIconWidth(), icon.getIconHeight());
        btnHora.setBounds(30, 170, icon.getIconWidth(), 40);
        lblHora.setBounds(230, 80, 370, 60);

        add(lblIcone);
        add(lblHora);
        add(btnHora);
    }

    private void configurarEventos() {
        btnHora.addActionListener(e -> atualizarHora()); // Quando clicar no botão, chama o método atualizarHora
    }

    private void atualizarHora() {
        lblHora.setText(LocalDateTime.now().format(fmt));
    }

    private void exibir() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaRelogio::new);
    }
}
