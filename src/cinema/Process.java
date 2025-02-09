package cinema;

public class Process {
    public static void iniInfo(int[][][] matrix){
        if(matrix != null){
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    for(int k = 0; k < matrix[i][j].length; k++){
                        matrix[i][j][k] = 0;
                    }
                }
            }
        }
    }

    public static void iniShowtime(int[][] showtime){
        if(showtime != null){
            for(int i = 0; i < showtime.length; i++){
                for(int j = 0; j < showtime[i].length; j++){
                    showtime[i][j] = 0;
                }
            }
        }
    }

    public static void iniMovie(String[] name) {
        if(name != null){
            for(int i = 0; i < name.length; i++){
                name[i] = "";
            }
        }
    }

    public static void attachData(int[][][] matrix, int[][] showtime, String[] name) {

    }
}
