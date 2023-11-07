import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Comparator;
public class Torneo {
    //cada torneo posee una lista de equipos y de partidos
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public Torneo(){
        equipos = new ArrayList<>();
        partidos = new ArrayList<>();
    }


    //Se agrega a la lista de equipos objetos de tipo Equipo
    public void cargarEquipo(String nombre, int fans){
        equipos.add(new Equipo(nombre,fans));
    }
    
    public void mostrarEquipos(){
        System.out.println("equipos del torneo");
        for(Equipo equipo:equipos){
            System.out.println(equipo.getNombre());
        }
    }


    private Equipo buscarEquipoPorNombre(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    public void cargarPartido(String nombreLocal, String nombreVisitante, LocalDate fecha, int golesLocal, int golesVisitante) {
        Equipo equipoLocal = buscarEquipoPorNombre(nombreLocal);
        Equipo equipoVisitante = buscarEquipoPorNombre(nombreVisitante);

        //Agrego condicion para que no chifle
        if (equipoLocal != null && equipoVisitante != null) {
            Partido partido = new Partido(fecha, equipoLocal, equipoVisitante, golesLocal, golesVisitante);
            partidos.add(partido);
        } else {
            System.out.println("No se encontraron los equipos");
        }
    }


    public void mostrarPartidosEnFecha(LocalDate fecha) {
        System.out.println("Partidos jugados en la fecha " + fecha + ":");
        for (Partido partido : partidos) {
            if (partido.getFecha().equals(fecha)) {
                System.out.println(partido);
            }
        }
    }

    //
    public void mostrarTablaDePosiciones() {
        System.out.println("Tabla de Posiciones:");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-10s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s%n",
                "Equipo", "Ju", "Pu", "Ga", "Em", "Pe", "GF", "GC", "DG");
        System.out.println("---------------------------------------------------");
    
        equipos.sort(Comparator.comparing(Equipo::getPuntos).reversed()
                .thenComparing(Equipo::getDiferencialGol).reversed());
    
        for (Equipo equipo : equipos) {
            System.out.printf("%-10s | %-2d | %-2d | %-2d | %-2d | %-2d | %-2d | %-2d | %-2d%n",
                    equipo.getNombre(), equipo.getPartidosJugados(), equipo.getPuntos(),
                    equipo.getPartidosGanados(), equipo.getPartidosEmpatados(),
                    equipo.getPartidosPerdidos(), equipo.getGolesConvertidos(),
                    equipo.getGolesRecibidos(), equipo.getDiferencialGol());
        }
    }
    

    public static void main(String[] args){

        //b.1 creamos un torneo vacio. Esto lo logramos definiendo un objeto de tipo Torneo 
        Torneo torneo = new Torneo();



        //b.2 agregamos equipos al torneo
        //Esto lo logramos utilizando un metodo "agregarEquipo" que toma un objeto Equipo y lo alamacena
        //en la lista de equipos
        torneo.cargarEquipo("Team A", 100);
        torneo.cargarEquipo("Team B", 200);
        torneo.cargarEquipo("Team C", 300);
        torneo.cargarEquipo("Team D", 400);
        torneo.cargarEquipo("Team E", 500);
        torneo.cargarEquipo("Team F", 600);
        torneo.cargarEquipo("Team G", 700);
        torneo.cargarEquipo("Team H", 800);

        //visualizamos los equipos
        torneo.mostrarEquipos();
        
    
        //b.3 cargarPartidos, definimos los objetos de equipo local y visitante y agregamos condiciones para
        //ser añadido a la lista
        torneo.cargarPartido("Team A", "Team B", LocalDate.of(2023, 11, 4), 2, 0);
        torneo.cargarPartido("Team C", "Team D", LocalDate.of(2023, 11, 4), 2, 1);
        torneo.cargarPartido("Team E", "Team F", LocalDate.of(2023, 11, 4), 2, 2);
        torneo.cargarPartido("Team G", "Team H", LocalDate.of(2023, 11, 4), 2, 3);
        // Fecha 2 - 12/11
        torneo.cargarPartido("Team B", "Team A", LocalDate.of(2023, 11, 12), 1, 1);
        torneo.cargarPartido("Team C", "Team D", LocalDate.of(2023, 11, 12), 3, 0);
        torneo.cargarPartido("Team F", "Team E", LocalDate.of(2023, 11, 12), 1, 2);
        torneo.cargarPartido("Team H", "Team G", LocalDate.of(2023, 11, 12), 0, 0);

        //b.4 mostrar partidos en una fecha dada 

        torneo.mostrarPartidosEnFecha(LocalDate.of(2023,11,12));
        /*
         Partidos jugados en la fecha 2023-11-12:
        Partido@156643d4
        Partido@123a439b
        Partido@7de26db8
        Partido@1175e2db
         */
        //La salida anterior de datos es por no haber sobreecrito el metodo toString(), tomando los parametros
        //de su definicion nativa. Para solucionarlo sobreescribimos el metodo toString() dentro de la clase
        //Partido
    
        torneo.mostrarTablaDePosiciones();

        /* Salida

         *Tabla de Posiciones:
---------------------------------------------------
---------------------------------------------------
Team D     | 2  | 0  | 0  | 0  | 2  | 1  | 5  | -4
Team F     | 2  | 1  | 0  | 1  | 1  | 3  | 4  | -1
Team G     | 2  | 1  | 0  | 1  | 1  | 2  | 3  | -1
Team B     | 2  | 1  | 0  | 1  | 1  | 1  | 3  | -2
Team A     | 2  | 4  | 1  | 1  | 0  | 3  | 1  | 2
Team E     | 2  | 4  | 1  | 1  | 0  | 4  | 3  | 1
Team H     | 2  | 4  | 1  | 1  | 0  | 3  | 2  | 1
Team C     | 2  | 6  | 2  | 0  | 0  | 5  | 1  | 4
         */
    
    }
}
