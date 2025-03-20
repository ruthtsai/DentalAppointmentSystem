import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AppointedInfoPage extends JFrame {
    // �w�q���ҡB�奻�ةM���s
    private final JLabel Label, therapyLabel, dentistLabel, timeLabel, chargeLabel;
    private final JTextField selectedTherapyOutput, selectedDentistOutput, selectedTimeOutput, chargeOutput;
    private final JButton enterButton, modifyButton, deleteButton;
    private final Container cp;
    private final AppointedDentist appointedDentist = new AppointedDentist();

    public AppointedInfoPage(String date, String dentist, String therapy) { // �����ѼơG�ɶ��B��͡B����
        setTitle("�w�����\");
        // �]�m���������ù��åB���i�Y�p
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = dim.width;
        int screenHeight = dim.height;
        setMinimumSize(new Dimension(screenWidth,screenHeight));

        // �ЫإD���O�ó]�m�� GridLayout
        cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6, 6, 6, 6);
        g.fill = GridBagConstraints.HORIZONTAL;

        // �Ыبó]�m���ҩM�奻��
        therapyLabel = new JLabel("�v������");
        therapyLabel.setFont(new Font("�L�n������", Font.PLAIN, 30));
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 1;
        cp.add(therapyLabel, g);

        selectedTherapyOutput = new JTextField(therapy);
        selectedTherapyOutput.setEditable(false);
        selectedTherapyOutput.setFont(new Font("�L�n������", Font.PLAIN, 30));
        g.gridx = 1;
        g.gridy = 1;
        g.gridwidth = 4;
        g.fill = GridBagConstraints.BOTH;
        cp.add(selectedTherapyOutput, g);

        dentistLabel = new JLabel("���w���");
        dentistLabel.setFont(new Font("�L�n������", Font.PLAIN, 30));
        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 1;
        cp.add(dentistLabel, g);

        selectedDentistOutput = new JTextField(dentist);
        selectedDentistOutput.setEditable(false);
        selectedDentistOutput.setFont(new Font("�L�n������", Font.PLAIN, 30));
        g.gridx = 1;
        g.gridy = 4;
        g.gridwidth = 4;
        cp.add(selectedDentistOutput, g);

        timeLabel = new JLabel("�w���ɶ�");
        timeLabel.setFont(new Font("�L�n������", Font.PLAIN, 30));
        g.gridx = 0;
        g.gridy = 5;
        g.gridwidth = 1;
        cp.add(timeLabel, g);

        selectedTimeOutput = new JTextField(date);
        selectedTimeOutput.setEditable(false);
        selectedTimeOutput.setFont(new Font("�L�n������", Font.PLAIN, 30));
        g.gridx = 1;
        g.gridy = 6;
        g.gridwidth = 4;
        cp.add(selectedTimeOutput, g);

        chargeLabel = new JLabel("�O��(NT$)");
        chargeLabel.setFont(new Font("�L�n������", Font.PLAIN, 30));
        g.gridx = 0;
        g.gridy = 7;
        g.gridwidth = 1;
        cp.add(chargeLabel, g);

        chargeOutput = new JTextField(String.valueOf(StartPage.patient.calculateCharge()));
        chargeOutput.setEditable(false);
        chargeOutput.setFont(new Font("�L�n������", Font.PLAIN, 30));
        g.gridx = 1;
        g.gridy = 8;
        g.gridwidth = 4;
        cp.add(chargeOutput, g);

        Label = new JLabel("�д��e�ܫe�x����");
        Label.setFont(new Font("�L�n������", Font.PLAIN, 30));
        g.gridx = 0;
        g.gridy = 9;
        g.gridwidth = 3;
        cp.add(Label, g);

        enterButton = new JButton("�T�w");
        enterButton.setFont(new Font("�L�n������", Font.PLAIN, 30));
        g.gridx = 1;
        g.gridy = 11;
        g.gridwidth = 1;
        cp.add(enterButton, g);

        modifyButton = new JButton("�ק�");
        modifyButton.setFont(new Font("�L�n������", Font.PLAIN, 30));
        g.gridx = 2;
        g.gridy = 11;
        g.gridwidth = 1;
        cp.add(modifyButton, g);

        deleteButton = new JButton("�R��");
        deleteButton.setFont(new Font("�L�n������", Font.PLAIN, 30));
        g.gridx = 3;
        g.gridy = 11;
        g.gridwidth = 1;
        cp.add(deleteButton, g);

        // ���U���s�ƥ�
        enterButton.addActionListener(new EnterButtonHandler());
        modifyButton.addActionListener(new ModifyButtonHandler());
        deleteButton.addActionListener(new DeleteButtonHandler());

        // �q�ɮ�Ū�����U��ƨç�s����
        try (BufferedReader p = new BufferedReader(new FileReader("Register.txt"))) {
            String input;
            while ((input = p.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(input, " ");
                if (st.hasMoreTokens()) {
                    String getID = st.nextToken();
                    if (getID.equals(StartPage.patient.getId())) {
                        String getRegister = st.nextToken();
                        if (getRegister.equals("Appointed")) {
                            String getTherapy = st.nextToken();//�v������
                            String getDentist = st.nextToken();//���w���
                            String getYear = st.nextToken();//�~��
                            String getMonth = st.nextToken();//���
                            String getDay = st.nextToken();//���
                            String getTime = st.nextToken();//�ɶ�
                            String getDate = getYear + "�~" + getMonth + "��" + getDay + "��" + getTime; // �榡��
                            if (therapy.equals(getTherapy) && dentist.equals(getDentist) && date.equals(getDate)) {
                                selectedTherapyOutput.setText(getTherapy);
                                selectedDentistOutput.setText(getDentist);
                                selectedTimeOutput.setText(getDate);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("���Ū�����~");
        }
    }

    // �T�w���s�ƥ�B�z��
    private class EnterButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BasicInfoPage BIP = new BasicInfoPage();
            BIP.setVisible(true);
            dispose();
        }
    }

    // �ק���s�ƥ�B�z��
    private class ModifyButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String sTO = selectedTherapyOutput.getText();
            String sDO = selectedDentistOutput.getText();
            String sTimeO = selectedTimeOutput.getText();

            // �ϥιw��������O���ק��k�A�R����e��ƨö}�ҹw���e��
            appointedDentist.modifyAppointedPatient(StartPage.patient.getId(), sTO, sDO, sTimeO);
            
            // ��������
            dispose();
        }
    }

    // �R�����s�ƥ�B�z��
    private class DeleteButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String sTO = selectedTherapyOutput.getText();
            String sDO = selectedDentistOutput.getText();
            String sTimeO = selectedTimeOutput.getText();
            // �ϥιw��������O���R����k�A�R����e��ƨö}�ҥD�n�e��
            appointedDentist.deleteAppointedPatient(StartPage.patient.getId(), sTO, sDO, sTimeO);

            // ��������
            dispose();
        }
    }
}
