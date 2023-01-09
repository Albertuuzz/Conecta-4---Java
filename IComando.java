package Conecta4.UndoRedo;

public interface IComando {
    void execute();
    void undo();
    void redo();
    String getName();
}