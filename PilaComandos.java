package Conecta4.UndoRedo;

import java.util.LinkedList;
import java.util.List;

public class PilaComandos<T> {
    private final List<T> datos;

    public PilaComandos() {
        datos = new LinkedList<T>();
    }
    public void apilar (T elemento) {
        datos.add(0, elemento);
    }
    public T desapilar() {
        if (datos.size() > 0)
            return datos.remove(0);
        else
            return null;
    }

    public boolean isVacia() {
        return datos.size() == 0;
    }

    public void vaciar() {
        datos.clear();
    }
}