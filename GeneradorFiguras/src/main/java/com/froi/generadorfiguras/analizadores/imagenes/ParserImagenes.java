
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.froi.generadorfiguras.analizadores.imagenes;

import com.froi.generadorfiguras.estructuras.ArbolAVL;
import com.froi.generadorfiguras.estructuras.ListaDoblementeEnlazada;
import com.froi.generadorfiguras.estructuras.ListaEnlazadaDobleCircular;
import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class ParserImagenes extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return ParserImagenesSym.class;
}

  /** Default constructor. */
  @Deprecated
  public ParserImagenes() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public ParserImagenes(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ParserImagenes(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\011\000\002\002\004\000\002\002\004\000\002\002" +
    "\002\000\002\003\006\000\002\005\005\000\002\005\004" +
    "\000\002\005\002\000\002\004\003\000\002\004\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\016\000\010\002\uffff\007\004\010\007\001\002\000" +
    "\014\004\ufff9\005\ufff9\006\ufff9\007\ufff9\010\ufff9\001\002" +
    "\000\004\004\013\001\002\000\010\002\uffff\007\004\010" +
    "\007\001\002\000\014\004\ufffa\005\ufffa\006\ufffa\007\ufffa" +
    "\010\ufffa\001\002\000\004\002\011\001\002\000\004\002" +
    "\001\001\002\000\004\002\000\001\002\000\012\005\ufffb" +
    "\006\ufffb\007\ufffb\010\ufffb\001\002\000\012\005\017\006" +
    "\015\007\004\010\007\001\002\000\006\007\004\010\007" +
    "\001\002\000\012\005\ufffc\006\ufffc\007\ufffc\010\ufffc\001" +
    "\002\000\010\002\ufffe\007\ufffe\010\ufffe\001\002\000\012" +
    "\005\ufffd\006\ufffd\007\ufffd\010\ufffd\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\016\000\010\002\007\003\005\004\004\001\001\000" +
    "\002\001\001\000\002\001\001\000\010\002\011\003\005" +
    "\004\004\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\005\013\001\001" +
    "\000\004\004\015\001\001\000\004\004\017\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ParserImagenes$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ParserImagenes$actions(this);
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
    return action_obj.CUP$ParserImagenes$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    private ListaEnlazadaDobleCircular listaImagenes;
    private ArbolAVL arbolCapas;

    public ParserImagenes(ImagenesLexer lexer, ListaEnlazadaDobleCircular listaImagenes, ArbolAVL arbolCapas) {
        super(lexer);
        this.listaImagenes = listaImagenes;
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
class CUP$ParserImagenes$actions {
  private final ParserImagenes parser;

  /** Constructor */
  CUP$ParserImagenes$actions(ParserImagenes parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$ParserImagenes$do_action_part00000000(
    int                        CUP$ParserImagenes$act_num,
    java_cup.runtime.lr_parser CUP$ParserImagenes$parser,
    java.util.Stack            CUP$ParserImagenes$stack,
    int                        CUP$ParserImagenes$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ParserImagenes$result;

      /* select the action based on the action number */
      switch (CUP$ParserImagenes$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-1)).value;
		RESULT = start_val;
              CUP$ParserImagenes$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-1)), ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ParserImagenes$parser.done_parsing();
          return CUP$ParserImagenes$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // inicio ::= inicio_p inicio 
            {
              Object RESULT =null;

              CUP$ParserImagenes$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-1)), ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()), RESULT);
            }
          return CUP$ParserImagenes$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // inicio ::= 
            {
              Object RESULT =null;

              CUP$ParserImagenes$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()), RESULT);
            }
          return CUP$ParserImagenes$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // inicio_p ::= identificador LLAVE_A capas LLAVE_C 
            {
              Object RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-3)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-3)).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-3)).value;
		int listaleft = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-1)).left;
		int listaright = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-1)).right;
		ListaDoblementeEnlazada lista = (ListaDoblementeEnlazada)((java_cup.runtime.Symbol) CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-1)).value;
		
                    try {
                        listaImagenes.insertar(id.toString(), lista);
                        System.out.println("Se insertó la imagen: " + id.toString() + " y su lista es:");
                                            
                    } catch(RuntimeException e) {
                        System.out.println("Error de imagen duplicada: " + e.getMessage());
                    }
                
              CUP$ParserImagenes$result = parser.getSymbolFactory().newSymbol("inicio_p",1, ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-3)), ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()), RESULT);
            }
          return CUP$ParserImagenes$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // capas ::= capas COMA identificador 
            {
              ListaDoblementeEnlazada RESULT =null;
		int listaleft = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-2)).left;
		int listaright = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-2)).right;
		ListaDoblementeEnlazada lista = (ListaDoblementeEnlazada)((java_cup.runtime.Symbol) CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-2)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$ParserImagenes$stack.peek()).value;
		
                try {
                    lista.insertar(arbolCapas.buscar(id.toString()));
                    System.out.println("Se encontró la capa: " + id.toString());
                } catch(Exception e) {
                    System.out.println("Error al buscar nodo");
                }
                RESULT = lista;
            
              CUP$ParserImagenes$result = parser.getSymbolFactory().newSymbol("capas",3, ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-2)), ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()), RESULT);
            }
          return CUP$ParserImagenes$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // capas ::= capas identificador 
            {
              ListaDoblementeEnlazada RESULT =null;
		int listaleft = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-1)).left;
		int listaright = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-1)).right;
		ListaDoblementeEnlazada lista = (ListaDoblementeEnlazada)((java_cup.runtime.Symbol) CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-1)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$ParserImagenes$stack.peek()).value;
		
                try {
                    lista.insertar(arbolCapas.buscar(id.toString()));
                    System.out.println("Se encontró la capa: " + id.toString());
                } catch(Exception e) {
                    System.out.println("Error al buscar nodo");
                }
                RESULT = lista;
            
              CUP$ParserImagenes$result = parser.getSymbolFactory().newSymbol("capas",3, ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.elementAt(CUP$ParserImagenes$top-1)), ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()), RESULT);
            }
          return CUP$ParserImagenes$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // capas ::= 
            {
              ListaDoblementeEnlazada RESULT =null;
		RESULT = new ListaDoblementeEnlazada();
              CUP$ParserImagenes$result = parser.getSymbolFactory().newSymbol("capas",3, ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()), RESULT);
            }
          return CUP$ParserImagenes$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // identificador ::= ALFANUMERICO 
            {
              Object RESULT =null;
		int paramleft = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()).left;
		int paramright = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()).right;
		Object param = (Object)((java_cup.runtime.Symbol) CUP$ParserImagenes$stack.peek()).value;
		RESULT=param;
              CUP$ParserImagenes$result = parser.getSymbolFactory().newSymbol("identificador",2, ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()), RESULT);
            }
          return CUP$ParserImagenes$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // identificador ::= NUMERO 
            {
              Object RESULT =null;
		int paramleft = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()).left;
		int paramright = ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()).right;
		Object param = (Object)((java_cup.runtime.Symbol) CUP$ParserImagenes$stack.peek()).value;
		RESULT=param;
              CUP$ParserImagenes$result = parser.getSymbolFactory().newSymbol("identificador",2, ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserImagenes$stack.peek()), RESULT);
            }
          return CUP$ParserImagenes$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$ParserImagenes$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$ParserImagenes$do_action(
    int                        CUP$ParserImagenes$act_num,
    java_cup.runtime.lr_parser CUP$ParserImagenes$parser,
    java.util.Stack            CUP$ParserImagenes$stack,
    int                        CUP$ParserImagenes$top)
    throws java.lang.Exception
    {
              return CUP$ParserImagenes$do_action_part00000000(
                               CUP$ParserImagenes$act_num,
                               CUP$ParserImagenes$parser,
                               CUP$ParserImagenes$stack,
                               CUP$ParserImagenes$top);
    }
}

}