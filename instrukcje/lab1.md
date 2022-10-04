# Lab1
Praca w środowisku [Netbeansi](https://netbeans.apache.org/) i [InteliJ](https://www.jetbrains.com/idea/download/)

## Pytania
Wyszukać w internecie opisy różnych wersji języka Java i wymienić ciekawe zmiany.

Objaśnić pojęcia:
- zmienna
- typy zmiennych
- instrukcje warunkowe oraz pętle
- tablice
- kompilator
- IDE (Zintegrowane środowisko programistyczne, w jaki sposób ułatwia programowanie)
- funkcja (jak wygląda/z czego się składa np. w C)
- kiedy stosujemy return w funkcji

W jaki sposób skompilować program?

Co musi mieć program aby działać?

Wymienić konwencje nazewnictwa zmiennych.

Wymienić poznane operatory:
- arytmetyczne
- przypisania
- porównania
- logiczne
- inkrementacji i dekrementacji

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
### Skompilować program.
### Uruchomić program
### Interakcja z programem - wypisywanie informacji
Do wypisywania łańcuchów znaków na ekranie służy funkcja: `System.out.print();` lub `System.out.println();`

Zmodyfikuj program i utwórz zmienną `name` przechowującą twoje imię. Wypisz wartość na ekranie za pomocą funckji `print()`.

Prymitywne typy danych w języku Java:

| typ       | ilość bitów | minimum         | maksimum              |
|-----------|-------------|-----------------|-----------------------|
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

### Operacje na łańcuchach znaków
Utwórz klasę `Main1.java`. Utworzyć publiczną statyczną metodę main() nic nie zwracającą. Zdefiniuj zmienną testVariable zawierającą łańcuch znaków "kiedy kot ma Alę," oraz zmienną testVariable2 zawierającą łańcuch "to Ala ma kota."

Korzystając z [dokumentacji jezyka java](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html) znajdź metody i zaprezentuj ich działanie:
- wypisując literę znajdującą się na 7 indeksie
- wypisującą kod w standardzie Unicide litery znajdującej się na 8 indeksie
- połącz łańcuchy znaków przechowywane w zmiennych i przypisz do zmiennej resultVar
- sprawdź czy łańcuch znaków zawiera słowa "kot" oraz "ala".
- sprawdź czy zdanie w zmiennej jest zakończone znakiem '.'.
- zamień wszystkie litery w zmiennej testVariable na małe natomiast w testVariable2 na wielkie.
- zwróć łańcuch znaków pomiędzy 3 a 7 indeksem.

### Konwersja i rzutowanie
Utworzyć klasę `Main2.java` oraz metodę main().  Utworzyć zmienną cGrades = 10. Rozwiń program tak by obliczał ilość stopni Farenheita na podstawie tej zmiennej według wzoru: $(°C * (9 / 5)) + 32 = °F$ i wypisuje tę informację w konsoli.

Utworzyć klasę Main3.java oraz metodę main(). Utwórzyć program który ze zmiennej userInput zawierającej łańcuch znaków "x = 12, y = 30, z = 3" odczyta poszczególne wartości a następnie wypisze ich sumę. 
