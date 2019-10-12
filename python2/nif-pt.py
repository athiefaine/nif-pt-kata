# !/usr/bin/python

import Tkinter
import tkMessageBox

class NifPt(object):
  def validaContribuinte(self, contribuinte):
    temErro = 0;
    if (contribuinte[0:1] != "1"  # pessoa singular
            and contribuinte[0:1] != "2"  # pessoa singular
            and contribuinte[0:1] != "3"  # pessoa singular
            and contribuinte[0:2] != "45"  # pessoa singular nao residente
            and contribuinte[0:1] != "5"  # pessoa colectiva
            and contribuinte[0:1] != "6"  # administracao publica
            and contribuinte[0:2] != "70"  # heranca indivisa
            and contribuinte[0:2] != "71"  # pessoa colectiva nao residente
            and contribuinte[0:2] != "72"  # fundos de investimento
            and contribuinte[0:2] != "77"  # atribuicao oficiosa
            and contribuinte[0:2] != "79"  # regime excepcional
            and contribuinte[0:1] != "8"  # empresario em nome individual(extinto)
            and contribuinte[0:2] != "90"  # condominios e sociedades irregulares
            and contribuinte[0:2] != "91"  # condominios e sociedades irregulares
            and contribuinte[0:2] != "98"  # nao residentes
            and contribuinte[0:2] != "99"  # sociedades civis
    ):
      temErro = 1

    check1 = int(contribuinte[0:1]) * 9
    check2 = int(contribuinte[1:2]) * 8
    check3 = int(contribuinte[2:3]) * 7
    check4 = int(contribuinte[3:4]) * 6
    check5 = int(contribuinte[4:5]) * 5
    check6 = int(contribuinte[5:6]) * 4
    check7 = int(contribuinte[6:7]) * 3
    check8 = int(contribuinte[7:8]) * 2

    total = check1 + check2 + check3 + check4 + check5 + check6 + check7 + check8

    divisao = int(total / 11);
    modulo11 = total - divisao * 11

    if modulo11 == 1 or modulo11 == 0:
      comparador = 0  # excepcao
    else:
      comparador = 11 - modulo11

    ultimoDigito = int(contribuinte[8:9])

    if ultimoDigito != comparador:
      temErro = 1

    if temErro == 1:
      tkMessageBox.showerror(title="errado", message="O numero de contribuinte parece estar errado")

