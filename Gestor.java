package Conecta4.UndoRedo;

import java.util.ArrayList;
import java.util.List;

public class Gestor {
    private static Gestor gestor = null;
    private PilaComandos<IComando> pilaundo;
    private PilaComandos<IComando> pilaredo;
    private List<String> historiadecomandos;

    public static Gestor getInstance() {
        if (gestor != null) {
            return gestor;
        } else {
            return new Gestor();
        }
    }

    private Gestor() {
        pilaredo = new PilaComandos<IComando>();
        pilaundo = new PilaComandos<IComando>();
        historiadecomandos = new ArrayList<String>();
    }

    public PilaComandos<IComando> getPilaredo() { return pilaredo; }
    public PilaComandos<IComando> getPilaundo() { return pilaundo; }

    public void execute (IComando comando) {
        comando.execute();
        pilaundo.apilar(comando);
        historiadecomandos.add(comando.getName());
    }

    public void undo() {
        if (!pilaundo.isVacia()) {
            IComando comando = pilaundo.desapilar();
            comando.undo();
            pilaredo.apilar(comando);
            historiadecomandos.add(comando.getName());
        }
    }

    public void redo() {
        if (!pilaredo.isVacia()) {
            IComando comando = pilaredo.desapilar();
            comando.execute();
            pilaundo.apilar(comando);
            historiadecomandos.add(comando.getName());
        }
    }

    public boolean isVacia(){
        return pilaundo.isVacia() && pilaredo.isVacia();
    }

    public void vaciarUndo() {
        pilaundo.vaciar();
    }

    public void vaciarRedo() {
        pilaredo.vaciar();
    }

    public List<String> getHistoriaComandos() {
        return historiadecomandos;
    }

}
