package lotofacil;

import java.util.Random;
import java.util.Scanner;
import java.io.IOException;


public class Atividade_Lotofacil {

    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void menu() throws IOException {
        int escolha = -1;

        Scanner in = new Scanner(System.in);

        do {
            System.out.println("**** Menu Lotofácil ****");
            System.out.println("1 - Apostar de 0 a 100");
            System.out.println("2 - Apostar de A a Z");
            System.out.println("3 - Apostar em Par ou Ímpar");
            System.out.println("0 - Sair");
            System.out.println("************************************");
            System.out.print("Digite a opção desejada: ");

            escolha = in.nextInt();

            switch (escolha) {
                case 1:
                    apostaZeroCem();
                    break;
                case 2:
                    apostaAZ();
                    break;
                case 3:
                    apostaParImpar();
                    break;
                case 0:
                    System.out.println("Aposta encerrada com sucesso");
                    break;
                default:
                    System.out.println("A opção escolhida é inválido");
            }
        } while (escolha != 0);
    }

    private static void apostaZeroCem() {
        int aposta = 0;

        Scanner in = new Scanner(System.in);
        Random rdn = new Random();

        System.out.print("Escolha um número entre 0 e 100 para apostar: ");
        aposta = in.nextInt();

        int numeroSorteio = rdn.nextInt(101);

        if (numeroSorteio == aposta) {
            System.out.println("Você ganhou R$1000,00");
        } else if (aposta < 0 || aposta > 100) {
            System.out.println("Aposta inválida");
        } else {
            System.out.println("Que pena! O número sorteado foi: " + numeroSorteio);
        }
    }

    private static void apostaAZ() throws IOException {
        char letraDigitada;
        char letraNome = 'L';

        System.out.print("Escolha uma letra de A a Z para apostar: ");
        letraDigitada = (char) System.in.read();

        System.out.println("A letra escolhida é: " + letraDigitada);
        char letraDigitadaMaiusculo = Character.toUpperCase(letraDigitada);

        if (letraNome == letraDigitadaMaiusculo) {
            System.out.println("Você ganhou R$500,00");
        } else {
            System.out.println("Que pena! A letra sorteada foi: " + letraNome);
        }

    }

    private static void apostaParImpar() {
        int numeroParImpar = 0;
        Scanner in = new Scanner(System.in);

        System.out.print("Digite um número: ");
        numeroParImpar = in.nextInt();

        int resultado = numeroParImpar % 2;

        switch (resultado) {
            case 0:
                System.out.println("Você ganhou R$100,00");
                break;
            default:
                System.out.println("Que pena! O número digitado é ímpar e a premiação foi pra números pares.");
                break;
        }

    }
}
