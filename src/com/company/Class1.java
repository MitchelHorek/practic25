package com.company;

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Class1 {
    public static class SortingStudentsByGPA implements Comparator<Student> {

        void quickSort(Student[] numbers, int left, int right) {
            Student pivot; // разрешающий элемент
            int l_hold = left; //левая граница
            int r_hold = right; // правая граница
            pivot = numbers[left];
            while (left < right) // пока границы не сомкнутся
            {
                while (compare(numbers[right], pivot) < 0 || (compare(numbers[right], pivot) == 0) && (left < right))
                    right--; // сдвигаем правую границу пока элемент [right] больше [pivot]
                if (left != right) // если границы не сомкнулись
                {
                    Student tmp = numbers[left];
                    numbers[left] = numbers[right];
                    numbers[right] = tmp;
                    left++; // сдвигаем левую границу вправо
                }
                while (compare(numbers[left], pivot) > 0 || (compare(numbers[left], pivot) == 0) && (left < right))
                    left++; // сдвигаем левую границу пока элемент [left] меньше [pivot]
                if (left != right) // если границы не сомкнулись
                {
                    Student tmp = numbers[left];
                    numbers[left] = numbers[right];
                    numbers[right] = tmp; // перемещаем элемент [left] на место [right]
                    right--; // сдвигаем правую границу вправо
                }
            }
            numbers[left] = pivot; // ставим разрешающий элемент на место
            int pivot1 = left;
            //pivot = left;
            left = l_hold;
            right = r_hold;
            if (left < pivot1) // Рекурсивно вызываем сортировку для левой и правой части массива
                quickSort(numbers, left, pivot1 - 1);
            if (right > pivot1)
                quickSort(numbers, pivot1 + 1, right);
        }

        void mergeSort(Student[] a, int l, int r) {
            if (l == r) return; // границы сомкнулись
            int mid = (l + r) / 2; // определяем середину последовательности
            // и рекурсивно вызываем функцию сортировки для каждой половины
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);
            int i = l;  // начало первого пути
            int j = mid + 1; // начало второго пути
            Student[] tmp = new Student[r + 1]; //Arrays.copyOf(a, a.length); // дополнительный массив
            for (int step = 0; step < r - l + 1; step++) // для всех элементов дополнительного массива
            {
                // записываем в формируемую последовательность меньший из элементов двух путей
                // или остаток первого пути если j > r
                if ((j > r) || ((i <= mid) && compare(a[i], a[j]) > 0)) {
                    tmp[step] = a[i];
                    i++;
                } else {
                    tmp[step] = a[j];
                    j++;
                }
            }
            // переписываем сформированную последовательность в исходный массив
            for (int step = 0; step < r - l + 1; step++)
                a[l + step] = tmp[step];
        }

        public boolean gg(Student a, Student b) {
            switch (compare(a, b)) {
                case 1:
                    return true;
                default:
                    return false;

            }
        }
        public int compare(Student a, Student b) {
            return a.getSum().compareTo(b.getSum());

        }
    }

    public static class Test1 {

        static void bubleSort(int mas[]) {
            boolean isSorted = false;
            int buf;
            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < mas.length - 1; i++) {
                    if (mas[i] > mas[i + 1]) {
                        isSorted = false;
                        buf = mas[i];
                        mas[i] = mas[i + 1];
                        mas[i + 1] = buf;
                    }
                }
            }
        }


        public static void main(String[] args) {
            Random rand = new Random();
            Student students[] = new Student[10];
            int iDNumber[] = new int[10];
            int id, d, m, y;

            String names[] = {"Amanda", "Brendan", "Tiffany", "Kate", "Steve"};
            String names2[] = {"Seyfried", "Fraser", "Haddish", "Keith", "Jobs"};
            String[] mon = {"января", "февраля", "марта", "апреля", "мая",
                    "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря"};

            for (int i = 0; i < 10; ++i) {
                id = rand.nextInt(1000) + 1000 + rand.nextInt(1000) + 1000;
                d = rand.nextInt(30) + 1;
                m = rand.nextInt(11) + 1;
                y = rand.nextInt(5) + 1;
                iDNumber[i] = id;
                students[i] = new Student(id, names[rand.nextInt(5)] + " " + names2[rand.nextInt(5)],
                        rand.nextInt(5) + 1, rand.nextInt(5) + 1, rand.nextInt(5) + 1, d, m, y);
            }

            System.out.print("выберите формат даты:\n1 - dd.mm.yy\n2 - dd.mm.year\n3 - dd month year\n");
            Scanner scan = new Scanner(System.in);
            int k = scan.nextInt();
            for (Student i : students) {
                System.out.print(i.toString(k) + "\n");
            }
        }
    }

    public static class Student {
        int id;
        String name;
        int math, prog, phys;
        String sum;
        int day, month, year;
        String[] mon = {"января", "февраля", "марта", "апреля", "мая",
                "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря"};

        Student(int id, String name, int math, int prog, int phys, int day, int month, int year) {
            this.id = id;
            this.math = math;
            this.name = name;
            this.phys = phys;
            this.prog = prog;
            this.day = day;
            this.month = month;
            this.year = year;
            sum = Integer.toString(Math.round((math + prog + phys) / 3));
        }

        public String getSum() {
            return sum;
        }


        @Override
        public String toString() {
            return "id=" + id + ":\n" +
                    "\t\tname=" + name +
                    "\n\t\tmath=" + math +
                    "\n\t\tprog=" + prog +
                    "\n\t\tphys=" + phys +
                    "\n\t\tfinal score=" + sum;
        }

        public String toString(int a) {
            String day1, month1;
            if (day>0 && day<10)
                day1 = "0"+day;
            else
                day1= ""+day;
            if (month>0 && month<10)
                month1 = "0"+ month;
            else
                month1 = ""+month;
            switch (a) {
                case 1:
                    return "id=" + id + ":\n" +
                            "\t\t" + name + "\n\t\t"+day1 + "." + month1 + ".0" + year;
                case 2:
                    return "id=" + id + ":\n" +
                            "\t\t" + name + "\n\t\t" +day1 + "." + month1 + ".200" + year;
                case 3:
                    return "id=" + id + ":\n" +
                            "\t\t" + name + "\n\t\t"+day1 + " " + mon[month - 1] + " 200" + year + "года";
            }
            return "";
        }
    }
}
