package Conecta4.UndoRedo;

import Conecta4.Utilidades.Turno;

public class CCambiarTurno implements IComando {

    private Turno turno;

    public CCambiarTurno(Turno turno){
        this.turno = turno;
    }

    @Override
    public void execute() {
        turno.cambiaTurnoSiguiente();
    }

    @Override
    public void undo() {
        turno.cambiarTurnoAnterior();
    }

    @Override
    public void redo() {
        turno.cambiaTurnoSiguiente();
    }

    @Override
    public String getName() {
        return "Cambiar Turno";
    }
}