
/*
Програмне завдання. Створити два generic-методи для пошуку спільних елементів
в двох контейнерах різних типів (ArrayList та одновимірний масив)
//todo з даними одного типу без дозволу явного наслідування.
В першому методі повернути Map із спільними
елементами в якості ключів та повною кількістю повторів елементів в якості значень.
В другому методі до ArrayList додати
//todo всі елементи з масиву, що є відсутніми в ArrayList.
Випробувати методи на об’єктах одного класу (наприклад, Animal) із
набором полів за вибором студента. Проаналізувати можливість використання
створених методів для передавання в них в якості параметрів контейнерів, що можуть
містити об’єкти підкласів (Dog, Cat, Poodle, тощо). //todo При визначенні спільних
//todo елементів в об’єктах підкласів використовувати тільки поля суперкласу.
 */

import java.util.*;

public class Main {

    public static <T> Map<T, Integer> searchingForCommonElements1(ArrayList<T> al, T ar[]) {
        Map<T, Integer> mapResult = new HashMap<>();

        ArrayList<T> ar2 = new ArrayList<>();
        ArrayList<T> alKey = new ArrayList<>();
        ArrayList<T> allElem = new ArrayList<>();

        for (T a : ar) {
            ar2.add(a);
        }

        for (T a : al) {
            alKey.add(a);
        }

        for (T a : al) {
            allElem.add(a);
        }

        for (T a : ar) {
            allElem.add(a);
        }

        alKey.retainAll(ar2);

        for(int i = 0; i<alKey.size();i++) {
            int fullNumberOfRepetitions = 0;

            for (int j = 0; j < allElem.size(); j++) {

                if (alKey.get(i) == allElem.get(j)) {
                    fullNumberOfRepetitions++;
                }
            }
            mapResult.put(alKey.get(i), fullNumberOfRepetitions);
        }
        return mapResult;
    }

    public static <T> void searchingForCommonElements2(ArrayList<T> al, T ar[]) {

        ArrayList<T> ar2 = new ArrayList<>();
        ArrayList<T> al2 = new ArrayList<>();

        for (T a : ar) {
            ar2.add(a);
        }

        for (T a : al) {
            al2.add(a);
        }

        for(int i=0; i<ar2.size(); i++){
            if(!al.contains(ar2.get(i))){
                al.add(ar2.get(i));
            }
        }

        for (T a : al) {
            System.out.println(a);
        }
    }




    public static void main(String[] args) {
        ArrayList<Integer> listI = new ArrayList<>();
        listI.add(2);
        listI.add(4);
        listI.add(6);
        listI.add(12);
        listI.add(13);
        listI.add(4);
        listI.add(13);

        Integer[] arrI = {8, 6, 40, 13, 13, 13, 13};

        System.out.println(searchingForCommonElements1(listI, arrI));
        searchingForCommonElements2(listI, arrI);

        System.out.println("=======================================================================================");

        ArrayList<String> listS = new ArrayList<>();
        listS.add("a");
        listS.add("abc");
        listS.add("b");
        listS.add("c");
        listS.add("ab");
        listS.add("ac");
        listS.add("abc");

        String[] arrS = {"ac", "ab", "as", "c", "abc", "ab", "aa", "bb", "ab"};

        System.out.println(searchingForCommonElements1(listS, arrS));
        searchingForCommonElements2(listS, arrS);

        System.out.println("=======================================================================================");

        Animal a1=new Animal("a1", 1, false);
        Animal a2=new Animal("a2", 2, true);
        Animal a3=new Animal("a3", 3, false);
        Animal a4=new Animal("a4", 4, true);
        Animal a5=new Animal("a5", 5, true);
        Animal a6=new Animal("a6", 6, false);
        Animal a7=new Animal("a7", 7, false);
        Animal a8=new Animal("a8", 8, true);

        Animal[] arAn = {a1, a2, a5,a6,a8, a5};
        ArrayList<Animal> alAn = new ArrayList<>();
        alAn.add(a3);
        alAn.add(a4);
        alAn.add(a7);
        alAn.add(a4);
        alAn.add(a1);
        alAn.add(a5);

        System.out.println(searchingForCommonElements1(alAn , arAn));
        searchingForCommonElements2(alAn,  arAn);

        System.out.println("=======================================================================================");

        Cat c1 = new Cat("c1", 1, true);
        Cat c2 = new Cat("c2", 2, false);
        Cat c3 = new Cat("c3", 3, true);
        Cat c4 = new Cat("c4", 4, false);
        Dog d1=new Dog("d1", 1, false);
        Dog d2=new Dog("d2", 2, true);
        Dog d3=new Dog("d3", 3, false);
        Dog d4=new Dog("d4", 4, true);

        System.out.println("=======================================================================================");

        Animal[] arAnCh = {c1, d2, a5,a6,a8, a5, c3, d4,d2};
        ArrayList<Animal> alAnCh = new ArrayList<>();
        alAnCh.add(c3);
        alAnCh.add(d2);
        alAnCh.add(d3);
        alAnCh.add(a3);
        alAnCh.add(a7);
        alAnCh.add(a6);
        alAnCh.add(c1);
        alAnCh.add(c3);
        alAnCh.add(a4);
        alAnCh.add(d4);
        alAnCh.add(a4);

        System.out.println(searchingForCommonElements1(alAnCh , arAnCh));
        searchingForCommonElements2(alAnCh,  arAnCh);
    }
}

class Animal{
    String name;
    Integer age;
    Boolean isMale;

    public Animal(String name, Integer age, Boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                '}';
    }
}

class Cat extends Animal{

    public Cat(String name, Integer age, Boolean isMale) {
        super(name, age, isMale);
    }
}
class Dog extends Animal{

    public Dog(String name, Integer age, Boolean isMale) {
        super(name, age, isMale);
    }
}