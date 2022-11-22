package com.example.saveasxml;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TableViewTest extends Application {
    private final static int rowsPerPage = 10;
    FileChooser fileChooser = new FileChooser();
    private Pagination pagination;
    private ObservableList<Pracownik> data = FXCollections.observableArrayList(

            new Pracownik("Jan", "Kowalski", 'M', "Stolarz", LocalDate.of(2020, 2, 10), false),
            new Pracownik("Joanna", "Rakowska", 'K', "Piekarz", LocalDate.of(2020, 9, 12), true),
            new Pracownik("Stefan", "Burczymucha", 'M', "Mechanik", LocalDate.of(2020, 2, 10), false),
            new Pracownik("Jan", "Czekański", 'M', "Ślusarz", LocalDate.of(2020, 9, 12), true),
            new Pracownik("Rafał", "Brudolf", 'M', "Ślusarz", LocalDate.of(2020, 3, 18), true),
            new Pracownik("Miłosz", "Rudolf", 'M', "Mechanik", LocalDate.of(2020, 8, 21), false),
            new Pracownik("Janina", "Lopez", 'K', "Piekarz", LocalDate.of(2020, 12, 23), false),
            new Pracownik("Michalina", "Mackowiak", 'K', "Lekarz", LocalDate.of(2020, 1, 10), true),
            new Pracownik("Paweł", "Materla", 'M', "Mechanik", LocalDate.of(2020, 2, 27), false),
            new Pracownik("Jerzy", "Owsiany", 'M', "Ślusarz", LocalDate.of(2020, 3, 13), true),
            new Pracownik("Andrzej", "Flamaster", 'M', "Piekarz", LocalDate.of(2020, 8, 12), false),
            new Pracownik("Celina", "Kuzminska", 'K', "Lekarz", LocalDate.of(2020, 2, 18), true),
            new Pracownik("Agnieszka", "Polonska", 'K', "Piekarz", LocalDate.of(2020, 3, 26), true),
            new Pracownik("Barbara", "Polanska", 'M', "Piekarz", LocalDate.of(2020, 4, 22), true),
            new Pracownik("Janusz", "Zapraty", 'M', "Mechanik", LocalDate.of(2020, 5, 21), false),
            new Pracownik("Dawid", "Zgoda", 'M', "Stolarz", LocalDate.of(2020, 6, 23), false),
            new Pracownik("Kamil", "Stopa", 'M', "Mechanik", LocalDate.of(2020, 7, 25), true),
            new Pracownik("Patrycja", "Łamaga", 'K', "Piekarz", LocalDate.of(2020, 8, 29), false),
            new Pracownik("Kazimierz", "Zgoda", 'M', "Stolarz", LocalDate.of(2020, 9, 10), false),
            new Pracownik("Piotr", "Pantofel", 'M', "Stolarz", LocalDate.of(2020, 9, 11), false),
            new Pracownik("Anna", "Kapela", 'K', "Piekarz", LocalDate.of(2020, 11, 20), true),
            new Pracownik("Tomasz", "Matej", 'M', "Lekarz", LocalDate.of(2020, 12, 15), false),
            new Pracownik("Przemysław", "Chleb", 'M', "Stolarz", LocalDate.of(2020, 8, 14), false),
            new Pracownik("Oliwia", "Kura", 'K', "Stolarz", LocalDate.of(2020, 8, 12), false),
            new Pracownik("Alicja", "Prosta", 'K', "Lekarz", LocalDate.of(2020, 4, 27), true),
            new Pracownik("Robert", "Kawalec", 'M', "Stolarz", LocalDate.of(2020, 3, 26), true),
            new Pracownik("Zbigniew", "Marzec", 'M', "Mechanik", LocalDate.of(2020, 4, 25), true),
            new Pracownik("Genowefa", "Kwiecień", 'K', "Mechanik", LocalDate.of(2020, 5, 24), true),
            new Pracownik("Ewelina", "Rakowska", 'K', "Piekarz", LocalDate.of(2020, 6, 23), false),
            new Pracownik("Zofia", "Maj", 'K', "Lekarz", LocalDate.of(2020, 2, 10), false)

    );
    private final TableView<Pracownik> table = new TableView<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox(10);
        table.setEditable(true);

        TableColumn<Pracownik, String> imieCol = new TableColumn<Pracownik, String>("Imię");
        imieCol.setMinWidth(100);
        imieCol.setCellValueFactory(new PropertyValueFactory<>("imie"));

        Callback<TableColumn<Pracownik, String>, TableCell<Pracownik, String>> defaultCellFactory = TextFieldTableCell
                .forTableColumn();

        imieCol.setCellFactory(col -> {
            TableCell<Pracownik, String> cell = defaultCellFactory.call(col);
            cell.setAlignment(Pos.CENTER_LEFT);
            return cell;
        });
        imieCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Pracownik, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Pracownik, String> t) {
                ((Pracownik) t.getTableView().getItems().get(t.getTablePosition().getRow())).setImie(t.getNewValue());

            }
        });

        TableColumn<Pracownik, String> nazwiskoCol = new TableColumn<Pracownik, String>("Nazwisko");
        nazwiskoCol.setMinWidth(100);
        nazwiskoCol.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));

        Callback<TableColumn<Pracownik, String>, TableCell<Pracownik, String>> defaultCellFactoryN = TextFieldTableCell
                .forTableColumn();

        nazwiskoCol.setCellFactory(col -> {
            TableCell<Pracownik, String> cell = defaultCellFactoryN.call(col);
            cell.setAlignment(Pos.CENTER_LEFT);
            return cell;
        });
        nazwiskoCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Pracownik, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Pracownik, String> t) {
                ((Pracownik) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                        .setNazwisko(t.getNewValue());

            }
        });

        TableColumn<Pracownik, Character> plecCol = new TableColumn<Pracownik, Character>("Płeć");
        plecCol.setMinWidth(100);
        Callback<TableColumn<Pracownik, Character>, TableCell<Pracownik, Character>> plecCellFactory = new Callback<TableColumn<Pracownik, Character>, TableCell<Pracownik, Character>>() {
            @Override
            public TableCell<Pracownik, Character> call(final TableColumn<Pracownik, Character> param) {

                final TableCell<Pracownik, Character> cell = new TableCell<Pracownik, Character>() {
                    SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(true);
                    private Button btn = new Button("");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            switchedOn.set(!switchedOn.get());
                        });

                        switchedOn.addListener(new ChangeListener<Boolean>() {
                            @Override
                            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                                Pracownik data = getTableView().getItems().get(getIndex());
                                Image image = null;
                                if (t1) {
                                    image = new Image(
                                            "file:C:\\Users\\Dawid\\Documents\\NetBeansProjects\\Lab6\\src\\main\\java\\com\\example\\lab6\\woman.png",
                                            32, 32, false, false);
                                    setText(" K ");
                                    data.setPlec('K');
                                } else {
                                    image = new Image(
                                            "file:C:\\Users\\Dawid\\Documents\\NetBeansProjects\\Lab6\\src\\main\\java\\com\\example\\lab6\\man.png",
                                            32, 32, false, false);
                                    setText(" M ");
                                    data.setPlec('M');
                                }
                                btn.setGraphic(new ImageView(image));
                                setGraphic(btn);
                                setContentDisplay(ContentDisplay.LEFT);
                            }
                        });

                    }

                    @Override
                    public void updateItem(Character item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText("");
                        } else {
                            Pracownik data = getTableView().getItems().get(getIndex());
                            Image image = null;
                            if (data.getPlec() == 'K') {
                                image = new Image(
                                        "file:C:\\Users\\Dawid\\Documents\\NetBeansProjects\\Lab6\\src\\main\\java\\com\\example\\lab6\\woman.png",
                                        32, 32, false, false);
                                setText(" K ");
                                switchedOn.set(true);
                            } else {
                                image = new Image(
                                        "file:C:\\Users\\Dawid\\Documents\\NetBeansProjects\\Lab6\\src\\main\\java\\com\\example\\lab6\\man.png",
                                        32, 32, false, false);
                                setText(" M ");
                                switchedOn.set(false);
                            }
                            btn.setGraphic(new ImageView(image));
                            setGraphic(btn);
                        }
                    }
                };

                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        };
        plecCol.setCellFactory(plecCellFactory);
        plecCol.setStyle("-fx-alignment: CENTER");

        TableColumn<Pracownik, String> zawodCol = new TableColumn<>("Zawód");
        zawodCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Pracownik, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Pracownik, String> i) {
                        final String value = i.getValue().getZawod();
                        return Bindings.createObjectBinding(() -> value);
                    }

                });

        ObservableList<String> options = FXCollections.observableArrayList("Lekarz", "Mechanik", "Piekarz", "Stolarz",
                "Ślusarz");

        zawodCol.setCellFactory(tc -> {
            ComboBox<String> combo = new ComboBox<>(options);
            TableCell<Pracownik, String> cell = new TableCell<Pracownik, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        combo.setValue(item);
                        setGraphic(combo);
                    }
                }
            };
            combo.setOnAction(e -> table.getItems().get(cell.getIndex()).setZawod(combo.getValue()));
            cell.setAlignment(Pos.CENTER);
            return cell;
        });

        TableColumn<Pracownik, Void> dataUrodzeniaCol = new TableColumn("Data urodzenia");
        Callback<TableColumn<Pracownik, Void>, TableCell<Pracownik, Void>> cellFactoryDataUrodzenia = (
                final TableColumn<Pracownik, Void> param) -> {
            final TableCell<Pracownik, Void> cell = new TableCell<Pracownik, Void>() {

                private final DatePicker du = new DatePicker();

                {
                    du.setOnAction((ActionEvent event) -> {
                        Pracownik data = getTableView().getItems().get(getIndex());
                        data.setData_urodzenia(du.getValue());
                    });
                }

                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        Pracownik data = getTableView().getItems().get(getIndex());

                        du.setValue(data.getData_urodzenia());
                        setGraphic(du);
                    }
                }
            };

            cell.setAlignment(Pos.CENTER);
            return cell;
        };
        dataUrodzeniaCol.setCellFactory(cellFactoryDataUrodzenia);

        TableColumn<Pracownik, Boolean> aktywnyZawodowoCol = new TableColumn<>("Aktywny zawodowo");
        aktywnyZawodowoCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Pracownik, Boolean>, ObservableValue<Boolean>>() {
                    @Override
                    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Pracownik, Boolean> i) {
                        final Boolean value = i.getValue().isAktywny_zawodowo();
                        return Bindings.createObjectBinding(() -> value);
                    }
                });

        aktywnyZawodowoCol.setCellFactory(param -> {
            return new TableCell<Pracownik, Boolean>() {
                {
                    setAlignment(Pos.CENTER);
                }

                @Override
                protected void updateItem(Boolean item, boolean empty) {
                    if (!empty && item != null) {
                        CheckBox cb = new CheckBox();
                        cb.setSelected(item);
                        cb.setFocusTraversable(false);
                        cb.selectedProperty().addListener(
                                (obs, old, niu) -> getTableView().getItems().get(getIndex()).setAktywny_zawodowo(niu));
                        setGraphic(cb);
                    } else {
                        setGraphic(null);
                    }
                }
            };
        });

        table.setItems(data);
        table.getColumns().addAll(imieCol, nazwiskoCol, plecCol, zawodCol, dataUrodzeniaCol, aktywnyZawodowoCol);
        vBox.getChildren().addAll(table);
        // MENU
        MenuBar menuBar = new MenuBar();
        BorderPane root = new BorderPane();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);
        Menu fileMenu = new Menu("Opcje");
        MenuItem saveOption = new MenuItem("Zapisz");
        MenuItem openOption = new MenuItem("Otworz");
        MenuItem exitOption = new MenuItem("Wyjdź");
        exitOption.setOnAction((ActionEvent event) -> Platform.exit());
        fileMenu.getItems().addAll(saveOption, openOption, exitOption);
        menuBar.getMenus().addAll(fileMenu);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        // Utworzenie dokumentu
        Document doc = dBuilder.newDocument();
        // Utworzenie korzenia o nazwie pracownicy
        Element rootElement = doc.createElement("Pracownicy");
        // Dodanie korzenia praciwnicy do dokumentu
        doc.appendChild(rootElement);
        // dla pracownika w liście:
        for (Pracownik elem : data) {
            // Dodanie nowej gałęzi Pracownik do korzenia Pracownicy
            Element pracownik = doc.createElement("Pracownik");
            rootElement.appendChild(pracownik);
            // Utworzenie nowej gałęzi imie
            Element imie = doc.createElement("imie");
            // Utworzenie wartości dla gałęzi i doadnie jej.
            imie.appendChild(doc.createTextNode(elem.getImie()));
            // Dodanie gałęzi imie do Pracownika
            pracownik.appendChild(imie);

            Element nazwisko = doc.createElement("nazwisko");
            nazwisko.appendChild(doc.createTextNode(elem.getNazwisko()));
            pracownik.appendChild(nazwisko);
            Element plec = doc.createElement("plec");
            plec.appendChild(doc.createTextNode(Character.toString(elem.getPlec())));
            pracownik.appendChild(plec);
            Element zawod = doc.createElement("zawod");
            zawod.appendChild(doc.createTextNode(elem.getZawod()));
            pracownik.appendChild(zawod);
            Element dataUrodzenia = doc.createElement("dataUrodzenia");
            dataUrodzenia.appendChild(doc.createTextNode(elem.getData_urodzenia().toString()));
            pracownik.appendChild(dataUrodzenia);
            Element aktywnyZawodowo = doc.createElement("aktywnyZawodowo");
            aktywnyZawodowo.appendChild(doc.createTextNode(String.valueOf(elem.isAktywny_zawodowo())));
            pracownik.appendChild(aktywnyZawodowo);
        }

        saveOption.setOnAction((ActionEvent e) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "xml"));
            File file = fileChooser.showSaveDialog(primaryStage);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            try {
                transformer = transformerFactory.newTransformer();
            } catch (TransformerConfigurationException transformerConfigurationException) {
                transformerConfigurationException.printStackTrace();
            }
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            try {
                transformer.transform(source, result);
            } catch (TransformerException transformerException) {
                transformerException.printStackTrace();
            }
        });
        openOption.setOnAction((ActionEvent event) -> {
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "xml"));
            File file = fileChooser.showOpenDialog(primaryStage);
            data.removeAll();
            try {
                data = loadXML(file);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        });

        pagination = new Pagination((data.size() / rowsPerPage + 1), 0);
        pagination.setPageFactory((pageIndex) -> this.createPage(pageIndex));
        AnchorPane anchor = new AnchorPane();
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 10.0);
        AnchorPane.setLeftAnchor(pagination, 10.0);
        anchor.getChildren().addAll(pagination);
        root.setBottom(anchor);
        root.setCenter(vBox);
        Scene scene = new Scene(root, 750, 650);
        primaryStage.setTitle("Tabela pracowników");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node createPage(int pageIndex) {
        int fromIndex = pageIndex * rowsPerPage;
        int toIndex = Math.min(fromIndex + rowsPerPage, data.size());
        table.setItems(FXCollections.observableArrayList(data.subList(fromIndex, toIndex)));
        table.setPrefHeight(520);
        VBox vBox = new VBox(table);
        vBox.setMaxHeight(table.getMaxHeight());
        return vBox;
    }

    public static ObservableList<Pracownik> loadXML(File file)
            throws ParserConfigurationException, IOException, SAXException, IOException {
        // Podanie ścieżki do pliku
        // Utworzenie obiektów fabryki\
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        // Umieszcza wszystkie węzły tekstowe na pełnej głębokości poddrzewa pod tym
        // węzłem, w tym węzły atrybutów, w „normalnej” formie, w której tylko struktura
        // (np. elementy, komentarze, instrukcje przetwarzania, sekcje CDATA i odwołania
        // do encji) oddzielają węzły tekstowe , tzn. nie ma żadnych sąsiadujących
        // węzłów tekstowych ani pustych węzłów tekstowych.
        doc.getDocumentElement().normalize();
        // Wypisanie korzenia
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        // Pobranie wezłów pracownik (lista pracowników)
        NodeList nList = doc.getElementsByTagName("Pracownik");
        System.out.println("----------------------------");
        // Utworzenie pustej listy w której będą ładowani pracownicy
        ObservableList<Pracownik> lista = FXCollections.observableArrayList();
        for (int temp = 0; temp < nList.getLength(); temp++) {
            // utworzenie pustego pracownika którego pola będą uzupełniane w kolejnych
            // iteracjach i dodawane do listy
            Pracownik p1 = new Pracownik();
            org.w3c.dom.Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + ((org.w3c.dom.Node) nNode).getNodeName());
            if (((org.w3c.dom.Node) nNode).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                // Ustawienie imienia w obiekcie pracownik
                p1.setImie(eElement.getElementsByTagName("imie").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("imie").item(0).getTextContent());
                p1.setNazwisko(eElement.getElementsByTagName("nazwisko").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("nazwisko").item(0).getTextContent());
                p1.setZawod(eElement.getElementsByTagName("zawod").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("zawod").item(0).getTextContent());
                // Konwersja string to char i zapis w obiekcie
                p1.setPlec(eElement.getElementsByTagName("plec").item(0).getTextContent().charAt(0));
                System.out.println(eElement.getElementsByTagName("plec").item(0).getTextContent().charAt(0));
                p1.setData_urodzenia(
                        LocalDate.parse(eElement.getElementsByTagName("dataUrodzenia").item(0).getTextContent()));
                System.out.println(LocalDate.parse(eElement.getElementsByTagName("dataUrodzenia").item(0).getTextContent()));
                p1.setAktywny_zawodowo(Boolean
                        .parseBoolean(eElement.getElementsByTagName("aktywnyZawodowo").item(0).getTextContent()));
                System.out.println(eElement.getElementsByTagName("aktywnyZawodowo").item(0).getTextContent());
                lista.add(p1);
            }
        }
        return lista;
    }

}
