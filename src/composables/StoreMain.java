package composables;

import repositories.ArchiveUtil;

import java.io.IOException;
import java.nio.file.Paths;

public class StoreMain {
    public static void store(int[][][] triArray, String[][] biArray, String[] strArray, String[] genArray, ArchiveUtil archive) throws IOException {
        boolean checking = true;
        String route = Paths.get("").toRealPath().toString()+"/src/storage/";;

        if(archive.directoriesExist()){
            checking = false;
            StoreArchive.storeItemMovie(strArray, biArray, archive,checking);
            StoreArchive.storeName(strArray,archive,checking);
            StoreArchive.storeHour(biArray,archive,checking);
            StoreArchive.storeNameAndGender(strArray,genArray,archive,checking);
            StoreArchive.storeShowReport(strArray,biArray,triArray,archive,checking);
            return;
        }
        StoreArchive.storeItemMovie(strArray, biArray, archive,checking);
        StoreArchive.storeName(strArray,archive,checking);
        StoreArchive.storeHour(biArray,archive,checking);
        StoreArchive.storeShowReport(strArray,biArray,triArray,archive,checking);
    }
}
