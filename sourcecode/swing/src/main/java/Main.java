import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Utworzenie obiektu okna głównego
        JFrame frame = new JFrame();
        // Ustawienie domyślnej operacji do zamknięcia aplikacji
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setName("MainFrame");
        // Ustawienie rozmiarów okna
        frame.setSize(new Dimension(400,400));
        // Ustawienie nazwy okna
        frame.setTitle("Moja pierwsza apliakcja");

        // Utworzenie paska menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu();
        // Ustawienie napisu menu
        menu.setText("file");

        // Utworzenie opcji w menu
        JMenuItem item1 = new JMenuItem();
        // Ustawienie napisu danej opcji
        item1.setText("opcja1");
        // W większości obiektów możemy przy utworzeniu obiektu odrazu zainicjalizować jego pewne właściwości.
        JMenuItem item2 = new JMenuItem("opcja 2");
        JMenuItem item3 = new JMenuItem("opcja 3");
        JMenuItem item4 = new JMenuItem("opcja 4");
        // Dodanie opcji do menu
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        // Dodanie menu do paska
        menuBar.add(menu);

        // Dodanie Menu do okna głównego
        frame.setJMenuBar(menuBar);

        // Pobranie "pojemnika na treśc"
        Container contentPane = frame.getContentPane();
        // Utworzenie menedzera layoutu
        BorderLayout borderLayout = new BorderLayout();
        // Ustawienie menedzera dla ContentPane
        contentPane.setLayout(borderLayout);

        // Utworzenie przycisku
        JButton btn1 = new JButton("przycisk1");
        JButton btn2 = new JButton("przycisk2");
        JButton btn3 = new JButton("przycisk3");
        // Utworznie TextArea
        TextArea textArea1 = new TextArea(2,5);
        textArea1.setText("123 + 7654 = ?????");
        // zablokowanie polu tekstowemu możliwości edytowania
        textArea1.setEditable(false);

        // Dodanie przycisku do kontenera na treść wskazując miejsce w BorderLayout
        contentPane.add(btn1,BorderLayout.NORTH);
        contentPane.add(btn2,BorderLayout.WEST);
        contentPane.add(btn3,BorderLayout.EAST);
        // Dodanie pola tekstowego do panelu
        contentPane.add(textArea1,BorderLayout.SOUTH);

        // Utworzenie nowego kontenera
        Container centerPanel = new Container();
        // Utworzenie GridLayout o 2 wierszach i 2 kolumnach
        GridLayout gridLayoutMeneger = new GridLayout(2,2);
        // ustawienie menedzera dla tego kontenera
        centerPanel.setLayout(gridLayoutMeneger);
        // dodanie kontenera na środek ContentPane
        contentPane.add(centerPanel, BorderLayout.CENTER);

        JButton center_btn1 = new JButton("przycisk1");
        JButton center_btn2 = new JButton("przycisk1");
        JButton center_btn3 = new JButton("przycisk1");
        JButton center_btn4 = new JButton("przycisk1");
        // Dodanie przycisków do środkowego panelu
        centerPanel.add(center_btn1);
        centerPanel.add(center_btn2);
        centerPanel.add(center_btn3);
        centerPanel.add(center_btn4);



//        DODAWANIE AKCJI DLA PRZYCISKÓW - Jeden z wielu możliwych sposobów.

        ActionListener action1 = new ActionListener(){
            @Override
            // za pomocą obiektu ActionEvent możemy dowiedzieć się jaki element wywołał metodę itp...
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "Wciśnięto przycisk.",
                        "Akcja dla Przycisk 1",
                        JOptionPane.PLAIN_MESSAGE);
                // Wypisanie w konsoli informacji na temat action Event
                System.out.println(e.toString());
            }
        };
        btn1.addActionListener(action1);

        // Dodanie akcji na przycisk sposób 2
        btn2.addActionListener(e -> {

            JOptionPane.showMessageDialog(frame,
                    e.getActionCommand(),
                    "ActionCommand",
                    JOptionPane.PLAIN_MESSAGE);

            ;
            if(btn2.getBackground() == Color.RED){
                // Za pomocą setActionCommand możemy przechowywać np stan przycisku
                btn2.setActionCommand("Kolor Zielony");
                btn2.setBackground(Color.green);
            }else {
                btn2.setActionCommand("Kolor Czerwony");
                btn2.setBackground(Color.red);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }


}
