package 设计模式.过滤器模式;

/**
 * Created by liuzhiyang on 2020/12/31 下午3:02
 */
public class Person {

    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name,String gender,String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }

}
