import java.time.LocalDate;

public class Equipo {
    private String nombre;
    private int fans;    
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesConvertidos;
    private int golesRecibidos;


    public Equipo(String nombre, int fans){
        this.nombre = nombre;
        this.fans = fans;

        //inicializo en 0 las variables iniciales de los equipos
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosEmpatados = 0;
        this.partidosPerdidos = 0;
        this.golesConvertidos = 0;
        this.golesRecibidos = 0;
    }

    //Metodos getter

    public String getNombre() {
        return nombre;
    }
    public int getFans() {
        return fans;
    }
    public int getPartidosGanados() {
        return partidosGanados;
    }
    public int getPartidosJugados(){
        return partidosJugados;
    }
    
    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public int getGolesConvertidos() {
        return golesConvertidos;
    }
    public int getGolesRecibidos(){
        return golesRecibidos;
    }
    public int getDiferencialGol(){
        return golesConvertidos - golesRecibidos;
    }


    //Cuando un aprtido gana se multiplica la cantidad de partidos ganados por 3 y se suma la cantidad de partidos
    //que se empatador (suma 1 cada partido empatado)
    public int getPuntos() {
        return partidosGanados * 3 + partidosEmpatados;
    }

    //metodos setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    //Agregamos partidos a cada equipo junto con su goles
    public void agregarPartido(int golesConvertidos, int golesRecibidos) {
        this.partidosJugados++;
        this.golesConvertidos += golesConvertidos;
        this.golesRecibidos += golesRecibidos;
        if (golesConvertidos > golesRecibidos) {
            this.partidosGanados++;
        } else if (golesConvertidos == golesRecibidos) {
            this.partidosEmpatados++;
        } else {
            this.partidosPerdidos++;
        }
    }

}
