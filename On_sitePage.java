import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class On_sitePage extends JFrame {
    private final JLabel therapyLabel, dentistLabel, therapyWarningLabel, dentistWarningLabel;
    private JComboBox<String> therapyComboBox, dentistComboBox;
    private final JButton enterButton, cancelButton;
    private final Container cp;
    private final String[] object = {"�п�ܪv������", "�ˬd", "�~��", "�ɳE��", "�ޤ�", "���h"};
    private String warning;

    public On_sitePage() {
        setTitle("����{�������t��");
        // �]�m���������ù��åB���i�Y�p
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = dim.width;
        int screenHeight = dim.height;
        setMinimumSize(new Dimension(screenWidth,screenHeight));
        

        // �ЫإD���O�ó]�m�� GridBagLayout
        cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6, 6, 6, 6);
        g.fill = GridBagConstraints.HORIZONTAL;

        therapyLabel = new JLabel("�v������");
        therapyLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(therapyLabel, g);

        therapyComboBox = new JComboBox<>(object);
        therapyComboBox.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 1;
        g.gridwidth = 3;
        g.weightx = 0;
        cp.add(therapyComboBox, g);

        therapyWarningLabel = new JLabel("\t");
        therapyWarningLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 2;
        g.gridwidth = 2;
        g.weightx = 0;
        cp.add(therapyWarningLabel, g);

        dentistLabel = new JLabel("���w���");
        dentistLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(dentistLabel, g);

        dentistComboBox = new JComboBox<>();
        dentistComboBox.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 4;
        g.gridwidth = 3;
        g.weightx = 0;
        cp.add(dentistComboBox, g);

        dentistWarningLabel = new JLabel("\t");
        dentistWarningLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 5;
        g.gridwidth = 2;
        g.weightx = 0;
        cp.add(dentistWarningLabel, g);

        enterButton = new JButton("�T�w");
        enterButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 7;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(enterButton, g);

        cancelButton = new JButton("����");
        cancelButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 7;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(cancelButton, g);

        try (BufferedReader p = new BufferedReader(new FileReader("Register.txt"))) {
            String input;
            while ((input = p.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(input, " ");
                if (st.hasMoreTokens()) {
                    String getID = st.nextToken();
                    st.nextToken();
                    String getTherapy = st.nextToken();
                    st.nextToken();
                    if (getID.equals(StartPage.patient.getId())) {
                        therapyComboBox.removeItem(getTherapy);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("���Ū�����~");
        }

        // ���U���s�ƥ�
        therapyComboBox.addActionListener(new TherapyComboBoxHandler());
        enterButton.addActionListener(new EnterButtonHandler());
        cancelButton.addActionListener(new CancelButtonHandler());

        //���U��L�ƥ�
        therapyComboBox.addKeyListener(new enterKeyAdapter());
        dentistComboBox.addKeyListener(new enterKeyAdapter());
    }

    // �v�����ؿ�ܳB�z�{��
    private class TherapyComboBoxHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dentistComboBox.removeAllItems();
            try (BufferedReader p = new BufferedReader(new FileReader("Dentist.txt"))) {
                String input;
                while ((input = p.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(input, " ");
                    String getName = st.nextToken();
                    while (st.hasMoreTokens()) {
                        String speciality = st.nextToken();
                        if (speciality.equals(therapyComboBox.getSelectedItem())) {
                            dentistComboBox.addItem(getName);
                            break;
                        }
                    }
                }
            } catch (IOException c) {
                System.out.println("���Ū�����~");
                System.exit(-2);
            }
        }
    }

    // �]�mEnter��ƥ�
    private class enterKeyAdapter extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                makeOn_site();
            }
        }
    }

    // �T�w���s�B�z�{��
    private class EnterButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            makeOn_site();
        }
    }

    // �������s�B�z�{��
    private class CancelButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BasicInfoPage BIP = new BasicInfoPage();
            BIP.setVisible(true);
            dispose();
        }
    }

    private void makeOn_site(){
        String selectedTherapy = (String) therapyComboBox.getSelectedItem();
            String selectedDentist = (String) dentistComboBox.getSelectedItem();
            if (selectedTherapy.equals("�п�ܪv������")) {
                warning = "�п�ܪv������";
                therapyWarningLabel.setText(warning);
            } else {
                if (selectedDentist == null) {
                    warning = "�п�ܫ��w���";
                    dentistWarningLabel.setText(warning);
                } else {
                    try (BufferedReader p = new BufferedReader(new FileReader("Dentist.txt"))) {
                        String input;
                        while ((input = p.readLine()) != null) {
                            StringTokenizer st = new StringTokenizer(input, " ");
                            String getName = st.nextToken();
                            if (getName.equals(selectedDentist)) {
                                try (FileWriter f = new FileWriter("Register.txt", true)) {
                                    PrintWriter pw = new PrintWriter(f);
                                    pw.println(StartPage.patient.getId() + " On_site " + selectedTherapy + " " + selectedDentist + " ");
                                    pw.close();
                                } catch (IOException c) {
                                    System.out.println("�ɮ׶}�ҿ��~");
                                    System.exit(-1);
                                }
                                break;
                            }
                        }
                    } catch (IOException c) {
                        System.out.println("���Ū�����~");
                        System.exit(-2);
                    }
                    dispose();
                    On_siteInfoPage OIP = new On_siteInfoPage(selectedTherapy, selectedDentist);
                    OIP.setVisible(true);
                }
            }
    }
    public void modify(){
        cp.remove(cancelButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
}
