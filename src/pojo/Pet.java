package pojo;

/**
 * @Classname Pet
 * @Created by zgw
 * @Date 2018-12-03 10:47
 * @Description 宠物类
 */
public class Pet {

    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }
}
