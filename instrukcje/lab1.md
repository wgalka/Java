# Lab1
Praca w środowisku Netbeansi i InteliJ

## Pytania
Objaśnić pojęcia:
- zmienne
- typy zmiennych
- instrukcje warunkowe oraz pętle
- tablice
- kompilator
- funkcja (jak wygląda/z czego się składa np. w C)
- kiedy stosujemy return w funkcji

W jaki sposób skompilować program?

Wymienić poznane operatory:
- arytmetyczne
- przypisania
- porównania
- logiczne


## Zadania
### Zainstalować JDK.
### Utworzyć projekt.
Utworzyć projekt o nazwie lab1 a w nim plik `Main.java` o nastepującej zawartości

```java
package com.company;
public class Main {

    public static void main(String[] args) {
	// write your code here
    System.out.print("Hello World!");
    }
}
```
### Uruchomić program.
### Interakcja z programem - wypisywanie informacji
Do wypisywania łańcuchów znaków na ekranie służy funkcja: `System.out.print();` lub `System.out.println();`

Zmodyfikuj program i utwórz zmienną `name` przechowującą twoje imię. Wypisz wartość na ekranie za pomocą funckji `print()`.

Prymitywne typy danych:

| typ       | ilość bitów | minimum         | maksimum              |
|-----------| ------------| ----------------|-----------------------|
| byte      | 8	          |-128             | 127	                |
| short     | 16	      |-32,768          | 32,767                |
| int       | 32          |-2,147,483,648   |  2,147,483,647        |
| long      | 64	      | -2<sup>63</sup> | -2<sup>63</sup> - 1   |
| float     | 32	      | -               | -                     |
| double    | 64	      | -               | -                     |
| char      | 16	      | -               | -                     |
| boolean   | 1	          | –	            | –                     |

Wrapery:
- [String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)
- [Integer](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Integer.html)
- [Long](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Long.html)
- [Float](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Float.html)
- [Double](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Double.html)
- [Boolean](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Boolean.html)
- [Character](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Character.html)

[https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/package-summary.html](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/package-summary.html)

Utwórz zmienne (nazwy zmiennych dynamicznych - camelCase) przechowujące rózne typy zmiennych. Wypisz wartości tych zmiennych oraz informacje na temat danego typu - np. maksymalna/minimalna wartość, w postaci:
`"zmienna x = [wartość zmiennej]. Maksymalna wartość typu [typ] wynosi: [wartość], minimalna wartość: [wartość]"`


[https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)