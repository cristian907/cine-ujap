package process;

public class processMain {
    public static  void process(int triArray[][][], String biArray[][], String strArray[]){
        //Inicio de Arrglos
        process.iniSeats(triArray);
        process.iniShowtime(biArray);
        process.iniMovie(strArray);

        //Process desarrollo
        process.attachData(biArray, strArray);
        process.showCase(strArray,biArray);

        process.showMenu(strArray,biArray,triArray);
    }

}
