package myapp.dbd_box.pojo;
import lombok.Data;

import javax.xml.soap.Text;

@Data
public class Survivor {
    private Integer survivor_id;
    private String survivor_name;
    private String survivor_icon;
    private String survivor_image;
    private String survivor_otherName;
    private String survivor_background;
}
