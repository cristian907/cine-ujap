package composables;

import java.io.IOException;
import java.nio.file.Paths;

public class StoreMain {
    public static void store(int[][][] triArray, String[][] biArray, String[] strArray) throws IOException {
        String route = Paths.get("").toRealPath().toString()+"/src/storage/";;

        StoreArchive.storeItemMovie(strArray, biArray, route);
        StoreArchive.storeName(strArray,route);
        StoreArchive.storeHour(biArray,route);
        StoreArchive.storeShowReport(strArray,biArray,triArray,route);
    }
}
