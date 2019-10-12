using System;

namespace main
{
    public static class NifPt
    {
        public static void ValidaContribuinte(string contribuinte)
        {
            // algoritmo de validação do NIF de acordo com
            // http://pt.wikipedia.org/wiki/N%C3%BAmero_de_identifica%C3%A7%C3%A3o_fiscal

            int temErro = 0;

            if (!contribuinte.Substring(0, 1).Equals("1") && // pessoa singular
                            !contribuinte.Substring(0, 1).Equals("2") && // pessoa singular
                            !contribuinte.Substring(0, 1).Equals("3") && // pessoa singular
                            !contribuinte.Substring(0, 2).Equals("45") && // pessoa singular não residente
                            !contribuinte.Substring(0, 1).Equals("5") && // pessoa colectiva
                            !contribuinte.Substring(0, 1).Equals("6") && // administração pública
                            !contribuinte.Substring(0, 2).Equals("70") && // herança indivisa
                            !contribuinte.Substring(0, 2).Equals("71") && // pessoa colectiva não residente
                            !contribuinte.Substring(0, 2).Equals("72") && // fundos de investimento
                            !contribuinte.Substring(0, 2).Equals("77") && // atribuição oficiosa
                            !contribuinte.Substring(0, 2).Equals("79") && // regime excepcional
                            !contribuinte.Substring(0, 1).Equals("8") && // empresário em nome individual (extinto)
                            !contribuinte.Substring(0, 2).Equals("90") && // condominios e sociedades irregulares
                            !contribuinte.Substring(0, 2).Equals("91") && // condominios e sociedades irregulares
                            !contribuinte.Substring(0, 2).Equals("98") && // não residentes
                            !contribuinte.Substring(0, 2).Equals("99") // sociedades civis

            ) { temErro = 1;}
            int check1 = int.Parse(contribuinte.Substring(0, 1)) * 9;
            int check2 = int.Parse(contribuinte.Substring(1, 1)) * 8;
            int check3 = int.Parse(contribuinte.Substring(2, 1)) * 7;
            int check4 = int.Parse(contribuinte.Substring(3, 1)) * 6;
            int check5 = int.Parse(contribuinte.Substring(4, 1)) * 5;
            int check6 = int.Parse(contribuinte.Substring(5, 1)) * 4;
            int check7 = int.Parse(contribuinte.Substring(6, 1)) * 3;
            int check8 = int.Parse(contribuinte.Substring(7, 1)) * 2;

            int total = check1 + check2 + check3 + check4 + check5 + check6 + check7 + check8;
            int divisao = total / 11;
            int modulo11 = total - divisao * 11;
            int comparador;
            if (modulo11 == 1 || modulo11 == 0)
            {
                comparador = 0;
            } // excepção
            else
            {
                comparador = 11 - modulo11;
            }


            int ultimoDigito = int.Parse(contribuinte.Substring(8, 1)) * 1;
            if (ultimoDigito != comparador)
            {
                temErro = 1;
            }

            if (temErro == 1)
            {
                Console.WriteLine("O numero de contribuinte parece estar errado");
            }

        }
    }
}