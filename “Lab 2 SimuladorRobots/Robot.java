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
    public float getPuntosVida(){
        return puntosVida;
    }
    public float getAtaque(){
        return ataque;
    }
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPuntosVida(float puntosVida) {
        this.puntosVida= puntosVida;
    }
    public void setAtaque(float ataque) {
        this.ataque= ataque;
    }
    //metodos
    //con este metodo un robot ataca al otro y tambien se obliga a q seimpre se haga aunque sea 1 de dano
    public void atacar(Robot vsRobot) {
        int danoVerdadero= this.ataque- vsRobot.defensa;
        if (danoVerdadero<1){
            danoVerdadero=1;
        }
        vsRobot.puntosVida= vsRobot.puntosVida-danoVerdadero;
        System.out.println(this.nombre + " ataca a " + vsRobot.nombre + 
                           " puntos de dano causados" + danoVerdadero);
        System.out.println(vsRobot.nombre + " tiene " + vsRobot.puntosVida + " puntos de vida");
    }

    public boolean estaVivo() {
        return puntosVida > 0;
    }



    


}