package composables;

import repositories.ArchiveUtil;

import java.io.IOException;
import java.nio.file.Paths;

public class StoreMain {
    public static void store(int[][][] triArray, String[][] biArray, String[] strArray, String[] genArray,String[][] fiArray, ArchiveUtil archive) throws IOException {
        boolean checking = true;
        String route = Paths.get("").toRealPath().toString()+"/src/storage/";;

        if(archive.directoriesExist()){
            checking = false;
            StoreArchive.storeItemMovie(strArray, biArray,fiArray, archive,checking);
            StoreArchive.storeNameAndGenre(strArray,genArray,archive,checking);
            StoreArchive.storeShowReport(strArray,biArray,triArray,archive,checking);
            return;
        }
        StoreArchive.storeItemMovie(strArray, biArray,fiArray, archive,checking);
        StoreArchive.storeNameAndGenre(strArray,genArray,archive,checking);
        StoreArchive.storeShowReport(strArray,biArray,triArray,archive,checking);
    }
}
