/**
 * @author Minh_Nguyen on  8/8/2019
 * @Project MyClass
 * @Email:
 */
public class MyClass {
    void method(ChuNhat x) {
        x.rong = 5;
        x.dai = 5;
    }

    public static void main(String[] args) {
        MyClass o = new MyClass();
        ChuNhat cn = new ChuNhat(1, 1);
        o.method(cn);
        System.out.printf("x=%d, y=%d", cn.rong, cn.dai);

    }

}
