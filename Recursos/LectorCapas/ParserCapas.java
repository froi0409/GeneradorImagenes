
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.froi.generadorfiguras.analizadores.capas;

import com.froi.generadorfiguras.estructuras.ArbolAVL;
import com.froi.generadorfiguras.estructuras.MatrizDispersa;
import com.froi.generadorfiguras.nodos.NodoAVL;
import com.froi.generadorfiguras.tokens.TokenMatriz;
import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class ParserCapas extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return ParserCapasSym.class;
}

  /** Default constructor. */
  @Deprecated
  public ParserCapas() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public ParserCapas(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ParserCapas(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\011\000\002\002\004\000\002\002\005\000\002\002" +
    "\002\000\002\005\005\000\002\006\004\000\002\006\002" +
    "\000\002\007\010\000\002\003\003\000\002\003\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\022\000\010\002\uffff\004\uffff\005\uffff\001\002\000" +
    "\010\002\010\004\007\005\005\001\002\000\004\006\ufff9" +
    "\001\002\000\004\006\012\001\002\000\004\006\ufffa\001" +
    "\002\000\004\002\001\001\002\000\010\002\000\004\000" +
    "\005\000\001\002\000\006\005\013\007\ufffc\001\002\000" +
    "\004\011\020\001\002\000\004\007\017\001\002\000\006" +
    "\005\013\007\ufffc\001\002\000\004\007\ufffd\001\002\000" +
    "\010\002\ufffe\004\ufffe\005\ufffe\001\002\000\004\005\021" +
    "\001\002\000\004\011\022\001\002\000\004\012\023\001" +
    "\002\000\004\010\024\001\002\000\006\005\ufffb\007\ufffb" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\022\000\004\002\003\001\001\000\004\003\005\001" +
    "\001\000\002\001\001\000\004\005\010\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\006" +
    "\013\007\014\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\006\015\007\014\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ParserCapas$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ParserCapas$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$ParserCapas$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    private ArbolAVL arbolCapas;

    public ParserCapas(CapasLexer lexer, ArbolAVL arbolCapas) {
        super(lexer);
        this.arbolCapas = arbolCapas;
    }
    public void report_error(String message, Object info) {
        System.out.println("reporterror");
    }
    public void report_fatal_error(String message, Object info) {
        System.out.println("reportfatal " + info);
    }
    @Override
    public void syntax_error(Symbol s) {
        System.out.println("linea: " + s.left + "   columna: " + s.right);
    }
    protected int error_sync_size() {
        return 1;
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$ParserCapas$actions {
  private final ParserCapas parser;

  /** Constructor */
  CUP$ParserCapas$actions(ParserCapas parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$ParserCapas$do_action_part00000000(
    int                        CUP$ParserCapas$act_num,
    java_cup.runtime.lr_parser CUP$ParserCapas$parser,
    java.util.Stack            CUP$ParserCapas$stack,
    int                        CUP$ParserCapas$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ParserCapas$result;

      /* select the action based on the action number */
      switch (CUP$ParserCapas$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).value;
		RESULT = start_val;
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)), ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ParserCapas$parser.done_parsing();
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // inicio ::= inicio identificador inicio_opciones 
            {
              Object RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).value;
		int matrizleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).left;
		int matrizright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).right;
		MatrizDispersa matriz = (MatrizDispersa)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.peek()).value;
		
                NodoAVL nuevoNodo = new NodoAVL(id.toString(), matriz);
                arbolCapas.insertar(nuevoNodo);
            
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-2)), ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // inicio ::= 
            {
              Object RESULT =null;

              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // inicio_opciones ::= LLAVE_A datos LLAVE_C 
            {
              MatrizDispersa RESULT =null;
		int datosleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).left;
		int datosright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).right;
		MatrizDispersa datos = (MatrizDispersa)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).value;
		
                        RESULT = datos;
                    
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("inicio_opciones",3, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-2)), ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // datos ::= datos_opciones datos 
            {
              MatrizDispersa RESULT =null;
		int tokenMleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).left;
		int tokenMright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).right;
		TokenMatriz tokenM = (TokenMatriz)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).value;
		int matrizleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).left;
		int matrizright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).right;
		MatrizDispersa matriz = (MatrizDispersa)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.peek()).value;
		
                System.out.println("Token obtenido: " + tokenM.getFila() + " , " + tokenM.getColumna() + " , " + tokenM.getColor());
                matriz.insertar(tokenM.getFila(), tokenM.getColumna(), tokenM.getColor());
                RESULT = matriz;
            
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("datos",4, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)), ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // datos ::= 
            {
              MatrizDispersa RESULT =null;
		RESULT = new MatrizDispersa();
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("datos",4, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // datos_opciones ::= NUMERO COMA NUMERO COMA COLOR PUNTO_COMA 
            {
              TokenMatriz RESULT =null;
		int filaleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-5)).left;
		int filaright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-5)).right;
		Object fila = (Object)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-5)).value;
		int columnaleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-3)).left;
		int columnaright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-3)).right;
		Object columna = (Object)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-3)).value;
		int colorleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).left;
		int colorright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).right;
		Object color = (Object)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-1)).value;
		
    RESULT = new TokenMatriz(Integer.parseInt(fila.toString()), Integer.parseInt(columna.toString()), color.toString());

              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("datos_opciones",5, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.elementAt(CUP$ParserCapas$top-5)), ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // identificador ::= ALFANUMERICO 
            {
              Object RESULT =null;
		int paramleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).left;
		int paramright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).right;
		Object param = (Object)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.peek()).value;
		RESULT = param;
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("identificador",1, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // identificador ::= NUMERO 
            {
              Object RESULT =null;
		int paramleft = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).left;
		int paramright = ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()).right;
		Object param = (Object)((java_cup.runtime.Symbol) CUP$ParserCapas$stack.peek()).value;
		RESULT = param;
              CUP$ParserCapas$result = parser.getSymbolFactory().newSymbol("identificador",1, ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserCapas$stack.peek()), RESULT);
            }
          return CUP$ParserCapas$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$ParserCapas$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$ParserCapas$do_action(
    int                        CUP$ParserCapas$act_num,
    java_cup.runtime.lr_parser CUP$ParserCapas$parser,
    java.util.Stack            CUP$ParserCapas$stack,
    int                        CUP$ParserCapas$top)
    throws java.lang.Exception
    {
              return CUP$ParserCapas$do_action_part00000000(
                               CUP$ParserCapas$act_num,
                               CUP$ParserCapas$parser,
                               CUP$ParserCapas$stack,
                               CUP$ParserCapas$top);
    }
}

}
