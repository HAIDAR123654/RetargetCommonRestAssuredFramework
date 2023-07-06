package airlines;

import airlines.pojos.AirlinePoiji;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;

import java.io.File;
import java.util.List;

public class PoijiTest {

    public static void main(String[] args) {
        PoijiOptions.PoijiOptionsBuilder.settings().addListDelimiter(";").build();
        List<AirlinePoiji> data = Poiji.fromExcel(new File("src/test/resources/testdata/CreateAirlineData.xlsx"), AirlinePoiji.class);
        System.out.println(data);
    }
}
