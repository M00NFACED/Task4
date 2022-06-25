package ru.vsu.cs.pekshev.T4.sort;

import java.util.Comparator;
import java.util.List;

/**
 * Класс с реализацией шейкерной cортировки (ShakerSort) для массивов и списков
 */
public class ShakerSort {

    public static <T> void sort(T[] data, Comparator<T> c) {
        int left = 0;
        int right = data.length - 1;
        T tmp;
        do {
            for (int i = left; i < right; i++) {
                if (c.compare( data[i] , data[i + 1]) > 0) {
                    tmp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = tmp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (c.compare(data[i-1] , data[i]) > 0) {
                    tmp = data[i];
                    data[i] = data[i - 1];
                    data[i - 1] = tmp;
                }
            }
            left++;
        } while (left < right);
    }

    /**
     * Сортировка методом шейкерной cортировки (ShakerSort) (без компаратора для сравнимых элементов)
     *
     * @param <T> Сравнимый тип элементов массива
     * @param data Сортируемый массив типа T
     */
    public static <T extends Comparable<T>> void sort(T[] data) {
        sort(data, Comparable::compareTo);
    }


    /**
     * Сортировка методом шейкерной cортировки (ShakerSort)
     *
     * @param <T> Произвольный (но ссылочный) тип элементов списка
     * @param data Сортируемый список типа T
     * @param c Компаратор для сравнения элементов
     */
    public static <T> void sort(List<T> data, Comparator<T> c) {
        int left = 0;
        int right = data.size() - 1;
        do {
            for (int i = left; i < right; i++) {
                T a = data.get(i);
                T b = data.get(i+1);
                if (c.compare( a , b) > 0) {
                    data.set(i, b) ;
                    data.set(i + 1, a);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                T a = data.get(i-1);
                T b = data.get(i);
                if (c.compare(a , b) > 0) {
                    data.set(i, a);
                    data.set(i - 1, b);
                }
            }
            left++;
        } while (left < right);
    }

    /**
     * Сортировка методом шейкерной cортировки (ShakerSort) (без компаратора для сравнимых элементов)
     *
     * @param <T> Сравнимый тип элементов списка
     * @param data Сортируемый список типа T
     */
    public static <T extends Comparable<T>> void sort(List<T> data) {
        sort(data, (a, b) -> a.compareTo(b));
    }
}
