function validaContribuinte(contribuinte){

    var temErro=0;

    if (
        contribuinte.substr(0,1) != '1' && // pessoa singular
        contribuinte.substr(0,1) != '2' && // pessoa singular
        contribuinte.substr(0,1) != '3' && // pessoa singular
        contribuinte.substr(0,2) != '45' && // pessoa singular não residente
        contribuinte.substr(0,1) != '5' && // pessoa colectiva
        contribuinte.substr(0,1) != '6' && // administração pública
        contribuinte.substr(0,2) != '70' && // herança indivisa
        contribuinte.substr(0,2) != '71' && // pessoa colectiva não residente
        contribuinte.substr(0,2) != '72' && // fundos de investimento
        contribuinte.substr(0,2) != '77' && // atribuição oficiosa
        contribuinte.substr(0,2) != '79' && // regime excepcional
        contribuinte.substr(0,1) != '8' && // empresário em nome individual (extinto)
        contribuinte.substr(0,2) != '90' && // condominios e sociedades irregulares
        contribuinte.substr(0,2) != '91' && // condominios e sociedades irregulares
        contribuinte.substr(0,2) != '98' && // não residentes
        contribuinte.substr(0,2) != '99' // sociedades civis

    ) { temErro=1;}
    var check1 = contribuinte.substr(0,1)*9;
    var check2 = contribuinte.substr(1,1)*8;
    var check3 = contribuinte.substr(2,1)*7;
    var check4 = contribuinte.substr(3,1)*6;
    var check5 = contribuinte.substr(4,1)*5;
    var check6 = contribuinte.substr(5,1)*4;
    var check7 = contribuinte.substr(6,1)*3;
    var check8 = contribuinte.substr(7,1)*2;
    
    var total= check1 + check2 + check3 + check4 + check5 + check6 + check7 + check8;
    var divisao= total / 11;
    var modulo11=total - parseInt(divisao)*11;
    if ( modulo11==1 || modulo11==0){ comparador=0; } // excepção
    else { comparador= 11-modulo11;}
    
    
    var ultimoDigito=contribuinte.substr(8,1)*1;
    if ( ultimoDigito != comparador ){ temErro=1;}
    
    if (temErro==1){ alert('O numero de contribuinte parece estar errado' ); }
}
