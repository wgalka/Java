# JAVA 17

#### Dodać bibliotekę JAXB do projektu np. z wykorzystaniem mavena:

```xml
<dependency>
    <groupId>com.sun.xml.bind</groupId>
    <artifactId>jaxb-impl</artifactId>
    <version>2.3.3</version>
</dependency>
<dependency>
    <groupId>com.sun.activation</groupId>
    <artifactId>jakarta.activation</artifactId>
    <version>1.2.2</version>
    <scope>compile</scope>
</dependency>
```

#### Po pobraniu biblioteki nadal nie będzie ona dostępna.
Plik module-info.java określa dostęp bibliotek do kodu w naszym projekcie i dostęp kodu z naszego projektu do bibliotek.

Stąd importy mogą nie działać poprawnie:
```java
import javax.xml.bind.*; // wyrzuci wyjątek
```

Aby umożliwić naszemu modułowi dostęp do zależności należy używamy słowa kluczowego `requires` w pliku module-info i scieżkę pakietu.
```java
requires java.xml.bind; 
```

Aby umożliwić zależności dostęp do naszego modułu używamy słowa kluczowego `opens to` w pliku module-info.
```java
opens my.module to java.xml.bind;
```

Przykładowy plik module-info.java
```java
module com.example.saveasxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    requires java.xml.bind;
    requires jakarta.activation;

    opens com.example.saveasxml to javafx.fxml, java.xml.bind;

    exports com.example.saveasxml;
}
```

## Adnotacje JAXB
### Przed definicją klasy
#### @XmlAccessorType
Na podstawie jakiego elementu klasy tworzone będą elementy XML.
Pole:
```java
@XmlAccessorType(XmlAccessType.FIELD)
```
Właściwości(get set):
```java
@XmlAccessorType(XmlAccessType.PROPERTY)
```
#### @XmlRootElement
Wskazanie korzenia dokumentu XML. Domyślnie jest taki sam jak nazwa klasy.
```java
@XmlRootElement(name = "Nazwa_korzenia")
```

### W ciele klasy nad polem lub właściwościami
#### @XmlElement
Wskazuje że dla tej wartości pola/właściwości powinien zostać utworzony element XML.
```java
@XmlElement(name = "Nazwa")
```

#### @XmlAttribute
Wskazuje że dla tej wartości pola/właściwości będzie zapisana jako atrybut elementu nadrzędnego.
```java
@XmlAttribute(name = "Nazwa", required = true)
```

#### @XmlJavaTypeAdapter
Przekształcanie domyślnych typów w Javie zostało zaimplementowane. Jeśli nasz obiekt nie konwertuje się poprawnie należy utworzyć "Adapter" który przekonwertuje obiekt do postaci możliwej do zapisu jako łańcuch znaków np.
```java
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    @Override
    public LocalDate unmarshal(String s) throws Exception {
        return LocalDate.parse(s, formatter);
    }

    @Override
    public String marshal(LocalDate localDateTime) throws Exception {
        return localDateTime.toString();
    }
}
```

```java
@XmlJavaTypeAdapter(DateAdapter.class)
```


