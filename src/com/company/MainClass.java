import java.util.Scanner;

class Strana{
    String name;
    double square;
}

public class MainClass{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество стран");
        int n=sc.nextInt();
        Strana country[]=new Strana[n];
        System.out.println("Введите информацию о странах");
        for(int i = 0; i < country.length; i++){
            sc.nextLine();
            country[i]=new Strana();
            System.out.println("Название "+(i+1)+" страны");
            country[i].name=sc.nextLine();
            System.out.println("Площадь "+(i+1)+" страны");
            country[i].square=sc.nextDouble();
        }

        System.out.println("\nХаракатеристики стран:");
        for(int i=0; i<country.length; i++){
            System.out.println(""+country[i].name+"\t"+country[i].square+" млн кв.км");

        }

        int nmax=0;

        double max=country[nmax].square;
        for(int i = 0; i< country.length;i++)
            if(country[i].square>max){
                max=country[i].square;
                nmax=i;
            }
        System.out.println("\nСтрана с максимальной площадью: ");
        System.out.println(""+country[nmax].name+"\t"+country[nmax].square+"млн кв.км");

        for (int i=0; i< country.length-1; i++)
            for (int j=0; j< country.length-1-i; j++)
                if (country[j].square>country[j+1].square){
                    Strana p=country[j];
                    country[j]=country[j+1];
                    country[j+1]=p;
                }
        System.out.println("\nСортировка по площади:");
                for(int i=0; i<country.length;i++){
                    System.out.println(""+country[i].name+"\t"+country[i].square+"млн кв.км");
                }
        for (int i=0; i< country.length-1; i++)
            for (int j=0; j< country.length-i-1; j++)
                if (country[j].name.compareTo(country[i+1].name)>0){
                    Strana p=country[j];
                    country[j]=country[j+1];
                    country[j+1]=p;
                }
        System.out.println("\nСортировка по названиям:");
        for(int i=0; i<country.length;i++){
            System.out.println(""+country[i].name+"\t"+country[i].square+"млн кв.км");
        }

        double s=0;
        for(int i=0; i< country.length;i++)
            s+=country[i].square;
        double sr=s/country.length;
        System.out.println("Средняя площадь ="+sr);
        System.out.println("\nСтраны, с площадью больше средней");
        for (int i = 0; i < country.length; i++) {
            if (country[i].square>sr)
            System.out.println(country[i].name +"\t"+country[i].square +" млн кв. км");
        }

        sc.nextLine();
        System.out.println("Введите название искомой страны");
        String name=sc.nextLine();
        int nom=-1;

        for (int i = 0; i < country.length; i++)
            if (name.equalsIgnoreCase(country[i].name))
                nom=i;
        if (nom!=-1) {
            System.out.println("Такая страна есть в списке. Это "
                    +country[nom].name+" "+country[nom].square+" млн кв. км");
        }else System.out.println("Такой страны нет в списке");


    }
}