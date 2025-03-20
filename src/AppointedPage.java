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
import java.util.Calendar;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class AppointedPage extends JFrame {
    // �w�q���ҡB�U�Կ��M���s
    private final JLabel therapyLabel, dentistLabel, appointmentLabel, therapyWarningLabel, dentistWarningLabel, appointmentWarningLabel;
    private final JComboBox<String> therapyComboBox, dentistComboBox, timeComboBox;
    private final JComboBox<Integer> yearComboBox, monthComboBox, dayComboBox;
    private final JButton enterButton, cancelButton;
    private final Calendar calendar = Calendar.getInstance();
    private final int Year = calendar.get(Calendar.YEAR);
    private final Container cp;
    private final String[] object = {"�п�ܪv������", "���P�v��", "�ںުv��", "�B��", "����_�ά���", "�q���ɺ�", "�Ӥ�", "�s�@����"};
    private String warning;

    public AppointedPage() {
        setTitle("����w�������t��");
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

        // �]�m�v�����ؼ��ҩM�U�Կ��
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
        g.gridwidth = 4;
        g.weightx = 0;
        g.fill = GridBagConstraints.BOTH;
        cp.add(therapyComboBox, g);

        therapyWarningLabel = new JLabel("\t");
        therapyWarningLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 2;
        g.gridwidth = 2;
        g.weightx = 0;
        cp.add(therapyWarningLabel, g);

        // �]�m���w��ͼ��ҩM�U�Կ��
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
        g.gridwidth = 4;
        g.weightx = 0;
        g.fill = GridBagConstraints.BOTH;
        cp.add(dentistComboBox, g);

        dentistWarningLabel = new JLabel("\t");
        dentistWarningLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 5;
        g.gridwidth = 2;
        g.weightx = 0;
        cp.add(dentistWarningLabel, g);

        // �]�m�w���ɶ����ҩM�U�Կ��
        appointmentLabel = new JLabel("�w���ɶ�");
        appointmentLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 6;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(appointmentLabel, g);

        yearComboBox = new JComboBox<>();
        yearComboBox.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 7;
        g.gridwidth = 1;
        g.weightx = 0;
        g.fill = GridBagConstraints.BOTH;
        cp.add(yearComboBox, g);
        for (int i = Year; i <= Year + 2; i++) {
            yearComboBox.addItem(i);
        }

        monthComboBox = new JComboBox<>();
        monthComboBox.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 7;
        g.gridwidth = 1;
        g.weightx = 0;
        g.fill = GridBagConstraints.BOTH;
        cp.add(monthComboBox, g);
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(i);
        }

        dayComboBox = new JComboBox<>();
        dayComboBox.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 3;
        g.gridy = 7;
        g.gridwidth = 1;
        g.weightx = 0;
        g.fill = GridBagConstraints.BOTH;
        cp.add(dayComboBox, g);
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }
        timeComboBox = new JComboBox<>();
        timeComboBox.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 4;
        g.gridy = 7;
        g.gridwidth = 1;
        g.weightx = 0;
        g.fill = GridBagConstraints.BOTH;
        cp.add(timeComboBox, g);
        for (int i = 10; i < 23; i++) {
            timeComboBox.addItem(i + ":00");
            timeComboBox.addItem(i + ":30");
        }

        appointmentWarningLabel = new JLabel("\t");
        appointmentWarningLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 8;
        g.gridwidth = 2;
        g.weightx = 0;
        cp.add(appointmentWarningLabel, g);

        // �]�m�T�w�M�������s
        enterButton = new JButton("�T�w");
        enterButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 10;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(enterButton, g);

        cancelButton = new JButton("����");
        cancelButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 10;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(cancelButton, g);

        // ���U���s�ƥ�
        therapyComboBox.addActionListener(new TherapyComboBoxHandler());
        cancelButton.addActionListener(new CancelButtonHandler());
        enterButton.addActionListener(new EnterButtonHandler());
        
        dentistComboBox.addActionListener(new UpdateDayListener());
        yearComboBox.addActionListener(new UpdateDayListener());
        monthComboBox.addActionListener(new UpdateDayListener());
        dayComboBox.addActionListener(new UpdateTimeListener());

        // ���U��L�ƥ�
        therapyComboBox.addKeyListener(new enterKeyAdapter());
        dentistComboBox.addKeyListener(new enterKeyAdapter());
        timeComboBox.addKeyListener(new enterKeyAdapter());
    }

    // �v�����ؤU�Կ��ƥ�B�z
    private class TherapyComboBoxHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateDentistComboBox();
        }
    }

   // �]�mEnter��ƥ�
    private class enterKeyAdapter extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                int selectedYear = (int)yearComboBox.getSelectedItem();
                int selectedMonth = (int)monthComboBox.getSelectedItem();
                int selectedDay  = (int)dayComboBox.getSelectedItem();
                warning=Verification.verifyAppointed(selectedYear,selectedMonth, selectedDay);
                System.out.println(warning);
                if(!warning.isEmpty()){
                JOptionPane.showMessageDialog(null, warning, "���~", JOptionPane.ERROR_MESSAGE);
                }else{
                    makeAppointment();
                }
            }
        }
    }
    

    // �T�w���s�ƥ�B�z
    private class EnterButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
          // �]�mJOptionPane���r��j�p
          Font OPfont = new Font("�L�n������", Font.PLAIN, 18);
          UIManager.put("OptionPane.messageFont", OPfont);
          UIManager.put("OptionPane.buttonFont", OPfont);
        
            int selectedYear = (int)yearComboBox.getSelectedItem();
            int selectedMonth = (int)monthComboBox.getSelectedItem();
            int selectedDay  = (int)dayComboBox.getSelectedItem();
            warning=Verification.verifyAppointed(selectedYear,selectedMonth, selectedDay);
            if(!warning.isEmpty()){
              JOptionPane.showMessageDialog(null, warning, "���~", JOptionPane.ERROR_MESSAGE);
            }else{
                makeAppointment();
            }
            
        }
    }

   // �������s�ƥ�B�z�A���N��Ʀs�J�ɮ�
    private class CancelButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BasicInfoPage BIP = new BasicInfoPage();
            BIP.setVisible(true);
            dispose();
        }
    }

   // ��s����M�ɶ��U�Կ��ƥ�B�z
    private class UpdateDayListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateDays();
        }
    }
    private class UpdateTimeListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            updateTimeComboBox();
        }
    }

   
    //��k�G��s����ﶵ
    private void updateDays(){
        int year =(int)yearComboBox.getSelectedItem();
        int month =(int)monthComboBox.getSelectedItem();
        int daysInMonth;
        dayComboBox.removeAllItems();
        switch(month){
            case 2:
                if((year%4==0&&year%100!=0)||(year%400==0)){
                    daysInMonth=29;
                }else{
                    daysInMonth=28;
                }
                break;
            case 4: case 6: case 9: case 11:
                daysInMonth=30;
                break;
            default:
                daysInMonth=31;
        }
        for(int i=1;i<=daysInMonth;i++){
            dayComboBox.addItem(i);
        }
      }

    // ��s���w��ͤU�Կ��
    private void updateDentistComboBox() {
        dentistComboBox.removeAllItems();
        try (BufferedReader p = new BufferedReader(new FileReader("Dentist.txt"))) {
            String input;
            while ((input = p.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(input, " ");
                if (st.hasMoreTokens()) {
                    String getName = st.nextToken();
                    while (st.hasMoreTokens()) {
                        String speciality = st.nextToken();
                        if (speciality.equals(therapyComboBox.getSelectedItem())) {
                            dentistComboBox.addItem(getName);
                            break;
                        }
                    }
                }
            }
        } catch (IOException c) {
            System.out.println("���Ū�����~");
        }
    }

    // ��s�ɶ��U�Կ��
    private void updateTimeComboBox() {
        timeComboBox.removeAllItems();
        for (int i = 10; i < 23; i++) {
            timeComboBox.addItem(i + ":00");
            timeComboBox.addItem(i + ":30");
        }
        if (dentistComboBox.getSelectedItem() != null && yearComboBox.getSelectedItem() != null
                && monthComboBox.getSelectedItem() != null && dayComboBox.getSelectedItem() != null) {
            try (BufferedReader p = new BufferedReader(new FileReader("Register.txt"))) {
                String input;
                while ((input = p.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(input, " ");
                    if (st.countTokens() >= 7) {
                        String getId=st.nextToken();//���o������
                        String getRegister = st.nextToken();//���o��������
                        st.nextToken();//���o�v������
                        String getDentist = st.nextToken();//���o���w���
                        String getYear = st.nextToken();//���o�~��
                        String getMonth = st.nextToken();//���o���
                        String getDay = st.nextToken();//���o���
                        String getTime = st.nextToken();//���o�ɶ�
                        
                        //System.out.println(getRegister.equals("Appointed"));
                        //System.out.println(getDentist.equals(dentistComboBox.getSelectedItem()));
                        //System.out.println(getYear.equals(String.valueOf(yearComboBox.getSelectedItem())));
                        //System.out.println(getDay.equals(String.valueOf(dayComboBox.getSelectedItem())));
                        
                        if (getRegister.equals("Appointed")
                                && getDentist.equals(dentistComboBox.getSelectedItem())
                                && getYear.equals(String.valueOf(yearComboBox.getSelectedItem()))
                                && getMonth.equals(String.valueOf(monthComboBox.getSelectedItem()))
                                && getDay.equals(String.valueOf(dayComboBox.getSelectedItem()))) {
                            timeComboBox.removeItem(getTime);//�R���w�Q������ɶ�
                        }
                        if(getId.equals(StartPage.patient.getId())//�Y�ӯf�H���ɶ��w�w��
                                &&getYear.equals(String.valueOf(yearComboBox.getSelectedItem()))
                                &&getMonth.equals(String.valueOf(monthComboBox.getSelectedItem()))
                                &&getDay.equals(String.valueOf(dayComboBox.getSelectedItem()))){
                            timeComboBox.removeItem(getTime);//�R���w�Q������ɶ�
                        }
                    }
                }
            } catch (IOException c) {
                System.out.println("���Ū�����~");
            }
        }
    }

    // �w������
    private void makeAppointment() {
        String selectedTherapy = (String) therapyComboBox.getSelectedItem();
        String selectedDentist = (String) dentistComboBox.getSelectedItem();
        String selectedYear = String.valueOf(yearComboBox.getSelectedItem());
        String selectedMonth =String.valueOf(monthComboBox.getSelectedItem());
        String selectedDay =String.valueOf(dayComboBox.getSelectedItem());
        String selectedTime = (String) timeComboBox.getSelectedItem();
        // �榡�Ʈɶ�
        String appointmentTime = selectedYear + "�~" + selectedMonth + "��" + selectedDay + "��" + selectedTime;

        if (selectedTherapy.equals("�п�ܪv������")) {
            warning = "�п�ܪv������";
            therapyWarningLabel.setText(warning);
        } else if (selectedDentist == null) {
            warning = "�п�ܫ��w���";
            dentistWarningLabel.setText(warning);
        } else if (selectedYear == null || selectedMonth == null || selectedDay == null || selectedTime == null) {
            warning = "�п�J�w�����";
            appointmentWarningLabel.setText(warning);
        } else {
            try (BufferedReader p = new BufferedReader(new FileReader("Dentist.txt"))) {
                String input;
                while ((input = p.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(input, " ");
                    if (st.hasMoreTokens()) {
                        String getName = st.nextToken();
                        if (getName.equals(selectedDentist)) {
                            try (FileWriter f = new FileWriter("Register.txt", true);
                                    PrintWriter pw = new PrintWriter(f)) {
                                pw.println(StartPage.patient.getId()+ " Appointed " + selectedTherapy + " " + selectedDentist + " "
                                        + selectedYear + " " + selectedMonth + " " + selectedDay + " " + selectedTime);
                            } catch (IOException c) {
                                System.out.println("�ɮ׶}�ҿ��~");
                            }
                            break;
                        }
                    }
                }
            } catch (IOException c) {
                System.out.println("���Ū�����~");
            }
            dispose();
            AppointedInfoPage AIP = new AppointedInfoPage(appointmentTime, selectedDentist, selectedTherapy);  // �����Ѽ� �ɶ� ��� ����
            AIP.setVisible(true);
        }
    }
    public void modify(){
        cp.remove(cancelButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
}
