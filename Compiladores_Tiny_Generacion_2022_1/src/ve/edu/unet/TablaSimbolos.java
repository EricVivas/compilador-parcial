package ve.edu.unet;

import ve.edu.unet.nodosAST.*;

import java.util.*;




public class TablaSimbolos {
	private HashMap<String, RegistroSimbolo> tabla;
	private int direccion;  //Contador de las localidades de memoria asignadas a la tabla
	
	public TablaSimbolos() {
		super();
		tabla = new HashMap<String, RegistroSimbolo>();
		direccion=0;
	}

	public void cargarTabla(NodoBase raiz){
		while (raiz != null) {
	    if (raiz instanceof NodoIdentificador){
	    	InsertarSimbolo(((NodoIdentificador)raiz).getNombre(),-1);
	    	//TODO: A�adir el numero de linea y localidad de memoria correcta
	    }

	    /* Hago el recorrido recursivo */
	    if (raiz instanceof  NodoIf){
	    	cargarTabla(((NodoIf)raiz).getPrueba());
	    	cargarTabla(((NodoIf)raiz).getParteThen());
	    	if(((NodoIf)raiz).getParteElse()!=null){
	    		cargarTabla(((NodoIf)raiz).getParteElse());
	    	}
	    }
	    else if (raiz instanceof  NodoRepeat){
	    	cargarTabla(((NodoRepeat)raiz).getCuerpo());
	    	cargarTabla(((NodoRepeat)raiz).getPrueba());
	    } else if (raiz instanceof  NodoFor){
			cargarTabla(((NodoFor)raiz).getCuerpo());
			cargarTabla(((NodoFor)raiz).getInicio());
			cargarTabla(((NodoFor)raiz).getFin());
			cargarTabla(((NodoFor)raiz).getIncremento());
		} else if (raiz instanceof  NodoLeer){
			NodoLeer n = (NodoLeer)raiz;
			InsertarSimbolo(n.getIdentificador(),-1);
		} else if (raiz instanceof  NodoAsignacion) {
			String id = ((NodoAsignacion) raiz).getIdentificador();
			InsertarSimbolo(id,-1);
			System.out.println(id);
			cargarTabla(((NodoAsignacion)raiz).getExpresion());

		} else if (raiz instanceof DeclaracionArray) {
			DeclaracionArray arrDecl = (DeclaracionArray)raiz;
			InsertarSimbolo(arrDecl.getIdentificador(), -1,arrDecl.getSize());
		} else if (raiz instanceof  NodoEscribir) {
			cargarTabla(((NodoEscribir) raiz).getExpresion());
		} else if (raiz instanceof NodoOperacion){
	    	cargarTabla(((NodoOperacion)raiz).getOpIzquierdo());
	    	cargarTabla(((NodoOperacion)raiz).getOpDerecho());
	    }
	    raiz = raiz.getHermanoDerecha();
	  }
	}
	
	//true es nuevo no existe se insertara, false ya existe NO se vuelve a insertar 
	public boolean InsertarSimbolo(String identificador, int numLinea){
		RegistroSimbolo simbolo;
		if(tabla.containsKey(identificador)){
			return false;
		}else{
			simbolo= new RegistroSimbolo(identificador,numLinea,direccion++);
			tabla.put(identificador,simbolo);
			return true;			
		}
	}

	public boolean InsertarSimbolo(String identificador, int numLinea,int size){
		RegistroSimbolo simbolo;
		if(tabla.containsKey(identificador)){
			return false;
		}
		simbolo= new RegistroSimbolo(identificador,numLinea,direccion);
		tabla.put(identificador,simbolo);
		direccion += size;
		return true;
	}

	
	public RegistroSimbolo BuscarSimbolo(String identificador){
		RegistroSimbolo simbolo=(RegistroSimbolo)tabla.get(identificador);
		return simbolo;
	}
	
	public void ImprimirClaves(){
		System.out.println("*** Tabla de Simbolos ***");
		for( Iterator <String>it = tabla.keySet().iterator(); it.hasNext();) { 
            String s = (String)it.next();
	    	System.out.println("Consegui Key: "+s+" con direccion: " + BuscarSimbolo(s).getDireccionMemoria());
		}
	}

	public int getDireccion(String Clave){
		return BuscarSimbolo(Clave).getDireccionMemoria();
	}
	
	/*
	 * TODO:
	 * 1. Crear lista con las lineas de codigo donde la variable es usada.
	 * */
}
