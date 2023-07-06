package airlines.pojos;


import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import lombok.ToString;

import java.util.List;

@ToString
public class AirlinePoiji {
    @ExcelCell(0)
    private int id ;
    @ExcelCellName("Name")
    private String name;
    @ExcelCellName("Country")
    private String country;
    @ExcelCellName("Logo")
    private String logo;
    @ExcelCellName("Slogan")
    private String slogan;
    @ExcelCellName("HeadQuarter")
    private List<String> head_quaters;
    @ExcelCellName("Website")
    private String website;
    @ExcelCellName("Established")
    private String established;
}
