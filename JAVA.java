import java.util.*;
class Complex{
    int real;
    int ima;
    
    public Complex(int r,int i){
        real = r;
        ima = i;
    }
    
    public Complex Add(Complex a, Complex b){
        return new Complex((a.real + b.real),(a.ima + b.ima));
    }
    public Complex Sub(Complex a, Complex b){
        return new Complex((a.real - b.real),(a.ima - b.ima));   
    }
    
    public void print(){
        if(real ==0 && ima !=0){
            System.err.println("imag"+ ima);
        }
        else if(real!=0 && ima==0){
            System.out.println(real);
        }
        else{
            System.out.println("real"+real+"imag"+ima);
        }
    }
    
}
public class JAVA{
    public static void main(String[] args) {
        Complex c1 = new Complex(15,9);
        Complex c2 = new Complex(5,6);
        Complex a = c1.Add(c1,c2);
        Complex b = c1.Sub(c1,c1);
        a.print();
        b.print();
    }
}


// import java.util.ArrayList;

// public class JAVA {
//     public static void main(String[] args) {
//         ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(1);
//         list.add(3);
//         ArrayList<Integer> list2 = new ArrayList<>();
//         list2.add(12);
//         list2.add(39);
//         list2.add(69);
//         list2.add(9);
//         mainList.add(list);
//         mainList.add(list2);
//         System.out.print(mainList);
//     }
// }