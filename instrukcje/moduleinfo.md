# module-info.java (JAVA 9+)

Jest to plik który opisuje zależności pomiędzy pakietami w naszym pakiecie.

## module-info.java
plik module-info.java powinien znajdować się w korzeniu aplikacji

np. src/main/java/module-info.java

## zawartość pliku module-info

### Definicja modułu
Używając słówka kluczowego `module` a następnie podając nazwę deklarujemy dany moduł.

```java
module myModuleName{
    // pakiety w naszym pakiecie i zależności pomiędzy nimi
}

```

### Requires
pakiety które będą dostępne podczas działania i kompilacji definiujemy słówkiem kluczowym `requires` a następnie podajemy nazwę pakietu.

```java
module myModuleName{
    requires package.name;
}
```

Jeśli pakiety ma być dostępny tylko podczas kompilacji należy dodać słówko kluczowe `static`.

```java
module myModuleName{
    requires static package.name;
}
```

Jeśli chcemy aby pakiet był "importowany" razem z naszym modułem użyjemy słówka kluczovego `transitive`

```java
module myModuleName{
    requires transitive package.name;
}
```

### Exports

Aby umożliwić dostęp do publicznych skłądowych jednego z pakietów należy użyć słówka kluczowego `exports`

```java
module myModuleName{
    exports package.name;
}
```

Aby umożliwić dostęp do api do składowych pakietu wybranemu pakietowi używa się `exports to`

```java
module myModuleName{
    exports package.name to package.which.use.our.api;
}
```

### Uses

```java
module my.module {
    uses class.name;
}
```

### Provide

```java
module my.module {
    provides MyInterface with MyInterfaceImpl;
}
```

### Opens

Pozwala na dostęp do pól prywatnych w klasach.

```java
module my.module {
  opens com.my.package;
}
```

lub tylko dla wybranych modułów

```java
module my.module {
    opens com.my.package to moduleOne, moduleTwo, etc.;
}
```

