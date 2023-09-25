package lotofacil;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.io.IOException;



public class InterfaceLotofacil extends JFrame {
    // Atributos
    private JPanel painel = new JPanel();
    private JButton jButtonApostaZeroCem = new JButton("Apostar de 0 a 100");
    private JButton jButtonApostaAZ = new JButton("Apostar de A a Z");
    private JButton jButtonApostaParImpar = new JButton("Apostar par ou ímpar");
    private JLabel jLabelMensagem = new JLabel("Exemplo de Simples Janela");

    // Construtor
    public InterfaceLotofacil() {
        this.setTitle("Lotofácil - Interface Gráfica");
        this.setSize(400, 200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255, 255, 255));

        //Aposta 1
        jButtonApostaZeroCem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100");

                if (aposta != null && !aposta.isEmpty()) {
                    int numeroApostado = Integer.parseInt(aposta);

                    Random rdn = new Random();
                    int numeroSorteado = rdn.nextInt(101);

                    if (numeroApostado == numeroSorteado) {
                        JOptionPane.showMessageDialog(null, "Você ganhou R$1000,00");
                    } else if (numeroApostado < 0 || numeroApostado > 100) {
                        JOptionPane.showMessageDialog(null, "Aposta inválida");
                    } else {
                        JOptionPane.showMessageDialog(null, "Que pena! O número sorteado foi: " + numeroSorteado);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                }
            }
        });

        // Aposta 2
        jButtonApostaAZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta = JOptionPane.showInputDialog(null, "Digite uma letra de A a Z");

                if (aposta != null && aposta.length() == 1) {
                    char letraApostada = (char) Character.toUpperCase(Integer.parseInt(aposta));
                    char letraSorteada = 'L';

                    if (letraApostada == letraSorteada) {
                        JOptionPane.showMessageDialog(null, "Você ganhou R$500,00");
                    } else {
                        JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraSorteada);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insira uma letra válida de A a Z.");
                }
            }
        });

        // Aposta 3
        jButtonApostaParImpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta = JOptionPane.showInputDialog(null, "Digite um número par a sua aposta");

                if (aposta != null && !aposta.isEmpty()) {
                    int numeroApostado = Integer.parseInt(aposta);

                    int resultado = numeroApostado % 2;

                    if (resultado == 0) {
                        JOptionPane.showMessageDialog(null, "Você ganhou R$100,00");
                    } else {
                        JOptionPane.showMessageDialog(null, "Que pena! O número digitado é ímpar e a premiação foi para números pares.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                }
            }
        });

        painel.add(jButtonApostaZeroCem);
        painel.add(jButtonApostaAZ);
        painel.add(jButtonApostaParImpar);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela
    }

    public static void main(String[] args) throws IOException {
        new InterfaceLotofacil();
    }
}


