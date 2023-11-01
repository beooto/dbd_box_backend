package myapp.dbd_box.pojo;

import lombok.Data;

@Data
public class Skill {
    private Integer skill_id;
    private Integer player_id;
    private String  name;
    private String  icon;
    private String  detail;

}
