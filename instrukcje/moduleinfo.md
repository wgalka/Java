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

<button id="btn1" >example</button>
<div id="as1" style="visible:hidden; background-color:#EEFFEE">
 ```java
    module myModuleName{
        requires transitive package.name;
    }
```
</div>
<script>
    function myFunction() {
  document.getElementById("as1").style.visibility = "visible";
}
    document.getElementById("btn1").addEventListener("click", myFunction);
    
</script>