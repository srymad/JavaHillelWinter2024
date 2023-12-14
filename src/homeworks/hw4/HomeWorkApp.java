package homeworks.hw4;

public class HomeWorkApp {
    public void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }

    public void checkSumSign(){
        int a = -5;
        int b = 5;
        System.out.println(a + b >= 0 ? "Сума позитивна" : "Сума негативна");
    }

    public void printColor(){
        int value = 10;
        if(value <= 0) System.out.println("Червоний");
        else if(value > 100) System.out.println("Зелений");
        else System.out.println("Жовтий");
    }

    public void compareNumber(){
        int a = 10;
        int b = 10;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    public boolean taskSix(int a, int b){
        return (a + b >= 10 && a + b <= 20);
    }

    public void taskSeven(int a){
        System.out.println(a >= 0 ? "Додатнє число" : "Від'ємне число");
    }

    public boolean taskEight(int a){
        return a < 0;
    }

    public void taskNine(String s, int n){
        s = s + '\n';
        System.out.println("Result:\n" + s.repeat(n));
    }

    public boolean taskTen(int year){
        if(year % 4 == 0){
            if(year % 400 == 0) return true;
            else if(year % 100 == 0) return false;
            else return true;
        }else return false;
    }





}
