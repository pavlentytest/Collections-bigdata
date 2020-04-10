package com.company;

import java.util.*;

public class Main {


    public static void dooo() {
        dooo();
    }

    public static void main(String[] args) {
        //dooo();

        //Collections.
        // Collection


        /*
	   Collections
	      List (Списки) - ArrayList, LinkedList, Stack, Queue
	      Set (Множества) - TreeSet, TreeMap

	      Map (Мапы) - словарь, ассоц. массив (ключ - значение)
	        Hashtable, HashMap, LinkedHashMap, TreeMap

	      Stack - LIFO
	      Queue - FIFO

	    */

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();
        String[] str = {"1","2","3","4","5"};
        for(String s: str) {
            stack.push(s);
            queue.offer(s);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // печатаем и удаляем последний
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll()); // печатем и удаляем первый
        }

        /*
        Корень дерева - самый верхний узел
        Ребро - связь между узлами
        Потомок (ребенок) - узел, который имее родителя
        Родитель -уезл, который имеет ребро, связанное с ребенком
        Лист - узел не имеющий потомков
        Высота дерева - длина самого длинного пути к листу

        Бинарное дерево - для каждого узла не более 2 детей
        Полное бин дерева - ровно 2 потомка


         */

     /*
     Реализовать класс, который используя TreeSet находит список студентов, сдавших сессию на оценку выше заданного числа
      */
        TreeSet<Integer> nums = new TreeSet<>();
        nums.add(600);
        nums.add(6);
        nums.add(4);
        nums.add(-1);
        nums.add(4);
        System.out.println(nums);



    TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {
         @Override
         public int compare(Student t1, Student t2) {
            //return t1.getName().compareTo(t2.getName());
             return t1.getMark() - t2.getMark();
         }
     });
     students.add(new Student("Ivan",5));
     students.add(new Student("Max",83));
     students.add(new Student("Petr",2));
     students.add(new Student("Oleg",50));
     students.add(new Student("Marina",15));

     System.out.println(students);

  //   students.tailSet();
  //   students.subSet();
  //   students.headSet();

        SortedSet<Student>  result = students.tailSet(new Student("",20));
        System.out.println(result);

        SortedSet<Student> result2 = students.subSet(new Student("",20),new Student("",Integer.MAX_VALUE));

        /*
        Hashtable - хэш таблица
        Пары ключ-значение
        все методы в Hashtable synchronized  - могут быть проблемы со скоростью
        выполнение всех операций начинается с вычисления хэша от ключа - это фактически и будет индекс
        Неупорядочены (порядок определяется хэш функцией)
        null-ы нельзя
         */

        String abc = "Hello";
        System.out.println(abc.hashCode());

        Hashtable phones = new Hashtable();
        phones.put("Ivan","234234234");
        phones.put("Max","2555555");
        phones.put("Alex","45645646");
        phones.put("Olga","23999999");

        Enumeration keys = phones.keys();

        while(keys.hasMoreElements()) {
            String user = (String) keys.nextElement();
            String value = (String) phones.get(user);
            System.out.println("key: "+ user + "; value: "+value);
        }

        /*
        HashMap - аналогично как с hashtable, можно null, потоконебезопасный
         */

        Map<String,String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");

        System.out.println(map);

        Map<String,String> map2 = new HashMap<>();
        map.put("key4","value4");
        map.put("key5","value5");
        map.put("key6","value6");

        // добавление набора данных
        map.putAll(map2);
        // удаление объекта
        map.remove("key2");
        // поиск по ключу
        map.containsKey("key2");
        //map.containsValue()

        // перебор значений
        Set<Map.Entry<String,String>> set = map.entrySet();
        for(Map.Entry<String,String> s: set) {
            System.out.println("key: "+ s.getKey() + "; value: "+s.getValue());
        }

        // очистка
        map.clear();

        /*
        LinkedHashMap
        Упорядоченная реализация HashMap, в которой есть связи между пред и след.
         */

        Map<String,Double> currency = new LinkedHashMap<>();
        currency.put("USD",75.6);
        currency.put("EUR",89.3);
        currency.put("CZK",2.5);
        System.out.println(currency);

        for(String key: currency.keySet()) {
            System.out.println("key: "+ key + "; value: "+currency.get(key));
        }

        /*
        TreeMap - сортировка по ключам - natural ordering
        или своя сортировка через Comparator
         */

        TreeMap<Integer,String> days = new TreeMap<>();
        days.put(3,"Wednesday");
        days.put(6,"Saturday");
        days.put(1,"Monday");

        // все ключи
        System.out.println(days.keySet());

        // значения
        System.out.println(days.values());

        // получить первое значения
        System.out.println(days.get(days.firstKey()));

        System.out.println(days);



    }
}
