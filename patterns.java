// public class patterns {

//     public static void invertedHalfPyramid(int n){
//         char cha = 'a';
//         for(int i=n;i>=1;i--){
//             for(int j=1;j<=i;j++){
//                 // System.out.print(i);
//                 System.out.print(cha);
//                 // System.out.print(j);
//                 cha++;
//             }
//             System.out.println();
//         }
//     }
//     public static void halfPyramid(int n){
//         for (int i=1;i<=n;i++){
//             for(int j=1;j<=i;j++){
//                 // System.out.print("*");
//                 if ((i+j)%2 == 0){
//                     System.out.print("1");
//                 }
//                 else{
//                     System.out.print("0");
//                 }
//             }
//             System.out.println();
            
//         }
//     }
//     public static void main(String[] args) {
//         // System.out.println("hello");
//         // invertedHalfPyramid(5);
//         halfPyramid(5);
//         // System.out.println(result);
//     }
// }

public class patterns {
    public static void linearSearch(String num[], String key){
        for(int i=0;i<=num.length;i++){
            if(num[i]==key){
                System.out.println("found at index "+i);
                return;
            }
        }
    }
    public static void main(String[] args) {
        String num[] = {"chips", "cookies", "chocolate"};
        String key = "cookies";
        linearSearch(num, key);
    }
}
