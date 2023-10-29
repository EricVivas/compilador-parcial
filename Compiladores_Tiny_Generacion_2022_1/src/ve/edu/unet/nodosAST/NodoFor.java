package ve.edu.unet.nodosAST;

public class NodoFor extends NodoBase {


	private NodoBase cuerpo;
	private NodoBase inicio;
	private NodoBase fin;
	private NodoBase incremento;

	public NodoFor(NodoBase cuerpo, NodoBase inicio, NodoBase fin, NodoBase incremento) {
		super();
		this.cuerpo = cuerpo;
		this.inicio = inicio;
		this.fin = fin;
		this.incremento = incremento;
	}

	public NodoFor() {
		super();
		this.cuerpo = null;
		this.inicio = null;
		this.fin = null;
		this.incremento = null;
	}

	public NodoBase getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(NodoBase cuerpo) {
		this.cuerpo = cuerpo;
	}

	public NodoBase getFin() {
		return fin;
	}

	public void setFin(NodoBase fin) {
		this.fin = fin;
	}

	public NodoBase getInicio() {
		return inicio;
	}

	public NodoBase getIncremento() {
		return incremento;
	}

	public void setInicio(NodoBase inicio) {
		this.inicio = inicio;
	}

	public void setIncremento(NodoBase incremento) {
		this.incremento = incremento;
	}
}
