package text;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Light {

    String name;
    Integer age;
    Integer maxToSeparate; // На сколько звёзд может разделиться звезда

    int i = 0;
    public Light(String name, Integer age, Integer maxToSeparate) throws Exception{
        this.name = name;
        if(age < 0) throw new Exception("Error with year old");
        if(maxToSeparate < 0) throw new Exception("Error with maxToSeparate");
        this.age = age;
        this.maxToSeparate = maxToSeparate;
    }

    public Sun toSeparate() throws Exception {
        if(i >= maxToSeparate) throw new Exception("The spot of light has already been seperated!");
        i++;
        Sun sun = new Sun();
        sun.setName("Звезда от " + this.name + " номер " + i);
        return sun;
    }
}
