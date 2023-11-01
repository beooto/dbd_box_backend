package myapp.dbd_box.pojo;

import lombok.Data;


@Data
public class Addon {
    private Integer killer_addon_id;
    private Integer killer_id;
    private String  killer_addon_icon;
    private String  killer_addon_name;
    private String  killer_addon_detail;
}
