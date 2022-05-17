package text;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Sun {
    private String name;

    public String shine(){
        return "It's shinning";
    }

}
