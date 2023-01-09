package Conecta4.UndoRedo;

public class CQuitarToken implements IComando {
    private CPonerToken jugada;

    public CQuitarToken (CPonerToken jugada){
        this.jugada = jugada;
    }

    @Override
    public void execute() {
        jugada.undo();
    }

    @Override
    public void undo() {
        jugada.execute();
    }

    @Override
    public void redo() {
        jugada.undo();
    }

    @Override
    public String getName() {
        return "Quitar Ficha";
    }
}