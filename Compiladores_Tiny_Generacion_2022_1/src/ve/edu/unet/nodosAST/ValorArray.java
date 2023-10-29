package ve.edu.unet.nodosAST;

public class ValorArray extends NodoBase{

    private NodoBase idxExpresion;
    private String identificador;

    public ValorArray(String id,NodoBase idxExp) {
        super();
        identificador = id;
        idxExpresion = idxExp;
    }

    public NodoBase getIdxExpresion() {
        return  idxExpresion;
    }

    public String getIdentificador() {
        return identificador;
    }
}
