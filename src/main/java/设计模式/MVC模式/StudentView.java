package 设计模式.MVC模式;

/**
 * Created by liuzhiyang on 2020/12/31 下午3:23
 */
public class StudentView {

    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }

}
