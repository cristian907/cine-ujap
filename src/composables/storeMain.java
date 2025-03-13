package composables;

import java.io.IOException;
import java.nio.file.Paths;

public class storeMain {
    public static void store(int[][][] triArray, String[][] biArray, String[] strArray) throws IOException {
        String route = Paths.get("").toRealPath().toString()+"/src/storage/";;

        storeArchive.storeItemMovie(strArray, biArray, triArray, route);
        storeArchive.storeName(strArray,route);
        storeArchive.storeHour(biArray,route);
        storeArchive.storeShowReport(strArray,biArray,triArray,route);
    }
}
