package ve.edu.unet.nodosAST;

public class DeclaracionArray extends  NodoBase{

    private String identificador;
    private int size;

    public DeclaracionArray(String i,int s) {
        super();
        identificador = i;
        size = s;
    }

    public int getSize() {
        return size;
    }

    public String getIdentificador() {
        return identificador;
    }




}
