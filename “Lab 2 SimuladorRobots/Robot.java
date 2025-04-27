public class Robot{
    //atributos
    private String nombre;
    private int puntosVida;
    private int ataque;
    private int defensa;
    //metodo constructor ajustando los valores que se pidieron en el ejercicio
    public Robot(String nombre, int puntosVida, int ataque, int defensa){
        this.nombre= nombre;
        if (puntosVida<50) {
            this.puntosVida= 50;
        } else if (puntosVida>100) {
            this.puntosVida= 100;
        } else {
            this.puntosVida= puntosVida;
        }
        if (ataque < 10) {
            this.ataque = 10;
        } else if (ataque > 20) {
            this.ataque = 20;
        } else {
            this.ataque = ataque;
        }
        if (defensa < 0) {
            this.defensa = 0;
        } else if (defensa > 10) {
            this.defensa = 10;
        } else {
            this.defensa = defensa;
        }
    }
    //Getters
    public String getNombre() {
        return nombre;
    }
    public int getPuntosVida(){
        return puntosVida;
    }
    public int getAtaque(){
        return ataque;
    }
    public int getDefensa(){
        return defensa;
    }
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPuntosVida(int puntosVida) {
        this.puntosVida= puntosVida;
    }
    public void setDefensa(int defensa) {
        this.defensa= defensa;
    }
    //metodos
    //con este metodo un robot ataca al otro y tambien se obliga a q simpre se haga aunque sea 1 de dano
    public void atacar(Robot otroRobot) {
        int danoVerdadero= this.ataque- otroRobot.defensa;
        if (danoVerdadero<1){
            danoVerdadero=1;
        }
        otroRobot.puntosVida= otroRobot.puntosVida-danoVerdadero;
        System.out.println(this.nombre + " ataca a  " + otroRobot.nombre + 
                           " puntos de dano causados  " + danoVerdadero);
        System.out.println(otroRobot.nombre + " tiene  " + otroRobot.puntosVida + " puntos de vida  ");
    }
    //aqui se crea un booleano porque asi lo dice el ejercicio
    public boolean estaVivo() {
        return puntosVida > 0;
    }
}