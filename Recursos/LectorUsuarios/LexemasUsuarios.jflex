package com.froi.generadorfiguras.analizadores.usuarios;

import java_cup.runtime.*;
import static com.froi.generadorfiguras.analizadores.usuarios.ParserUsuariosSym.*;

%%

%public
%class UsuariosLexer
%cup
%unicode
%line
%column
%{

%}

TerminacionLinea = [\r|\n|\r\n]
WS = [ \t\f]
Ignore = {TerminacionLinea} | [ \t\f]
NUMERO = [0-9]+
ALFANUMERICO = [a-zA-Z0-9]+

%%

<YYINITIAL> {
    "{"             {return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext());}
    "}"             {return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext());}
    ","             {return new Symbol(COMA, yyline+1, yycolumn+1, yytext());}
    ":"             {return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext());}
    ";"             {return new Symbol(PUNTO_COMA, yyline+1, yycolumn+1, yytext());}
    {NUMERO}        {return new Symbol(NUMERO, yyline+1, yycolumn+1, yytext());}
    {ALFANUMERICO}  {return new Symbol(ALFANUMERICO, yyline+1, yycolumn+1, yytext());}
    {Ignore}        {/*IGNORAR*/}
}
[^] {


}