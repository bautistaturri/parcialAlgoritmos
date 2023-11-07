import java.time.LocalDate;

public class Partido {
    private LocalDate fecha;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;


    public Partido(LocalDate fecha, Equipo equipoLocal, Equipo equipoVisitante, int golesLocal, int golesVisitante) {
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        equipoLocal.agregarPartido(golesLocal, golesVisitante);
        equipoVisitante.agregarPartido(golesVisitante, golesLocal);
    }


    //Metodos getter

    public LocalDate getFecha(){
        return fecha;
    }
    public Equipo getEquipoLocal(){
        return equipoLocal;
    }
    public Equipo getEquipoVisitante(){
        return equipoVisitante;
    }
    public int getGolesLocal(){
        return golesLocal;
    }
    public int getGolesVisitante(){
        return golesVisitante;
    }
    //sobreescribimos el toString para poder visualizar de forma correcta el metodo 
    @Override
    public String toString() {
        return "Fecha: " + fecha +
                ", Equipo Local: " + equipoLocal.getNombre() +
                ", Equipo Visitante: " + equipoVisitante.getNombre() +
                ", Resultado: " + golesLocal + " - " + golesVisitante;
    }

}
