package ve.edu.unet.nodosAST;

public class NodoAsignacion extends NodoBase {
	private String identificador;
	private NodoBase expresion;
	private boolean isArray = false;
	private NodoBase idxExpression = null;


	
	public NodoAsignacion(String identificador) {
		super();
		this.identificador = identificador;
		this.expresion = null;
	}
	
	public NodoAsignacion(String identificador, NodoBase expresion) {
		super();
		this.identificador = identificador;
		this.expresion = expresion;
	}

	public NodoAsignacion(String identificador, NodoBase expresion,boolean isArr,NodoBase idxExp) {
		super();
		this.identificador = identificador;
		this.expresion = expresion;
		this.isArray = isArr;
		this.idxExpression = idxExp;
	}

	public boolean getIsArray() {
		return isArray;
	}

	public NodoBase getIdxExpression() {
		return idxExpression;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public NodoBase getExpresion() {
		return expresion;
	}

	public void setExpresion(NodoBase expresion) {
		this.expresion = expresion;
	}
	
	
	
}
