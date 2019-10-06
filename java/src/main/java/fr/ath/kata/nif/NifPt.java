package fr.ath.kata.nif;

import javax.swing.*;

public class NifPt {

    public static void validaContribuinte(String contribuinte) {
        // algoritmo de validação do NIF de acordo com
        // http://pt.wikipedia.org/wiki/N%C3%BAmero_de_identifica%C3%A7%C3%A3o_fiscal

        int temErro = 0;

        if (!contribuinte.substring(0, 1).equals("1") && // pessoa singular
                        !contribuinte.substring(0, 1).equals("2") && // pessoa singular
                        !contribuinte.substring(0, 1).equals("3") && // pessoa singular
                        !contribuinte.substring(0, 2).equals("45") && // pessoa singular não residente
                        !contribuinte.substring(0, 1).equals("5") && // pessoa colectiva
                        !contribuinte.substring(0, 1).equals("6") && // administração pública
                        !contribuinte.substring(0, 2).equals("70") && // herança indivisa
                        !contribuinte.substring(0, 2).equals("71") && // pessoa colectiva não residente
                        !contribuinte.substring(0, 2).equals("72") && // fundos de investimento
                        !contribuinte.substring(0, 2).equals("77") && // atribuição oficiosa
                        !contribuinte.substring(0, 2).equals("79") && // regime excepcional
                        !contribuinte.substring(0, 1).equals("8") && // empresário em nome individual (extinto)
                        !contribuinte.substring(0, 2).equals("90") && // condominios e sociedades irregulares
                        !contribuinte.substring(0, 2).equals("91") && // condominios e sociedades irregulares
                        !contribuinte.substring(0, 2).equals("98") && // não residentes
                        !contribuinte.substring(0, 2).equals("99") // sociedades civis

        ) {
            temErro = 1;
        }
        int check1 = Integer.parseInt(contribuinte.substring(0, 1)) * 9;
        int check2 = Integer.parseInt(contribuinte.substring(1, 2)) * 8;
        int check3 = Integer.parseInt(contribuinte.substring(2, 3)) * 7;
        int check4 = Integer.parseInt(contribuinte.substring(3, 4)) * 6;
        int check5 = Integer.parseInt(contribuinte.substring(4, 5)) * 5;
        int check6 = Integer.parseInt(contribuinte.substring(5, 6)) * 4;
        int check7 = Integer.parseInt(contribuinte.substring(6, 7)) * 3;
        int check8 = Integer.parseInt(contribuinte.substring(7, 8)) * 2;

        int total = check1 + check2 + check3 + check4 + check5 + check6 + check7 + check8;
        int divisao = total / 11;
        int modulo11 = total - divisao * 11;
        int comparador;
        if (modulo11 == 1 || modulo11 == 0) {
            comparador = 0;
        } // excepção
        else {
            comparador = 11 - modulo11;
        }


        int ultimoDigito = Integer.parseInt(contribuinte.substring(8, 9)) * 1;
        if (ultimoDigito != comparador) {
            temErro = 1;
        }

        if (temErro == 1) {
            JOptionPane.showMessageDialog(null, "O numero de contribuinte parece estar errado", "Errado", JOptionPane.ERROR_MESSAGE);
        }

    }
}
