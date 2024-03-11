package myapp.dbd_box.pojo;

import lombok.Data;
@Data
public class Offering {
    private Integer id;
    private String  name;
    private String  icon;
    private String  level;
    private String  detail;
    private String  note;
    private String  class_name;
    private Integer belong;
}
