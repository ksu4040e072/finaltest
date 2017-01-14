package ksu4040e072.finaltest;

/**
 * Created by nick on 2017/1/4.
 */
import java.io.Serializable;

public class Member implements Serializable{ // VO- Value Object
    private int id;
    private int image;
    private String name;


    public Member() {
        super();
    }

    public Member(int id, int image, String name) {
        super();
        this.id = id;
        this.image = image;
        this.name = name;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
