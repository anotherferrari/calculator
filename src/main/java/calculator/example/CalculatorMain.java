package calculator.example;

import calculator.example.operations.Division;
import calculator.example.operations.Multiplication;
import calculator.example.operations.Subtract;
import calculator.example.operations.Sum;
import calculator.example.utils.ConsoleColors;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CalculatorMain {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à calculadora simples!");
        while (true) {
            showMenu();

            System.out.println(ConsoleColors.CYAN_BOLD + "Escolha a operação: (+, -, *, /, q para sair)" + ConsoleColors.RESET);
            char operator = scanner.next().charAt(0);

            if (operator == 'q') {
                System.out.println("Obrigado por usar a calculadora. Adeus!");
                break;
            }

            System.out.println("Por favor, insira o primeiro número:");
            double num1 = scanner.nextDouble();

            System.out.println("Por favor, insira o segundo número:");
            double num2 = scanner.nextDouble();

            calculateEquation(num1, num2, operator);
        }

        scanner.close();

    }

    public static void showMenu() {
        System.out.println(ConsoleColors.BLUE + "Operações disponíveis:" + ConsoleColors.RESET);
        System.out.println("+ : " + ConsoleColors.WHITE + "Adição"+ ConsoleColors.RESET);
        System.out.println("- : " + ConsoleColors.WHITE + "Subtração"+ ConsoleColors.RESET);
        System.out.println("* : "+ ConsoleColors.WHITE +  "Multiplicação"+ ConsoleColors.RESET);
        System.out.println("/ : "+ ConsoleColors.WHITE +  "Divisão"+ ConsoleColors.RESET);
        System.out.println("q : " + ConsoleColors.RED + "Sair da calculadora"+ ConsoleColors.RESET);
    }

    public static void calculateEquation(double num1, double num2, char operator) {
        double result = 0;

        switch (operator) {
            case '+':
                result = Sum.SumF(num1, num2);
                break;
            case '-':
                result = Subtract.SubtractF(num1, num2);
                break;
            case '*':
                result = Multiplication.MultiplicationF(num1, num2);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println( "Erro: Divisão por zero não é permitida.");
                    return;
                }
                result = Division.DivisionF(num1, num2);
                break;
            default:
                System.out.println("Operador inválido.");
                return;
        }

        System.out.println("O resultado é: " + result);
    }
}