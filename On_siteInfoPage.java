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

public class On_siteInfoPage extends JFrame {
    private final JLabel therapyLabel, dentistLabel, numberLabel, chargeLabel;
    private final JTextField therapyOutput, dentistOutput, numberOutput, chargeOutput;
    private final JButton enterButton, modifyButton, deleteButton;
    private final Container cp;
    private On_siteDentist on_siteDentist = new On_siteDentist();

    public On_siteInfoPage(String therapy, String dentist) {
        setTitle("�������\");
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

        // �]�m�v�����ؼ��ҩM��X
        therapyLabel = new JLabel("�v������");
        therapyLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(therapyLabel, g);

        therapyOutput = new JTextField(therapy);
        therapyOutput.setEditable(false);
        therapyOutput.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 1;
        g.gridwidth = 3;
        g.weightx = 0;
        g.fill = GridBagConstraints.BOTH;
        cp.add(therapyOutput, g);

        // �]�m���w��ͼ��ҩM��X
        dentistLabel = new JLabel("���w���");
        dentistLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(dentistLabel, g);

        dentistOutput = new JTextField(dentist);
        dentistOutput.setEditable(false);
        dentistOutput.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 3;
        g.gridwidth = 3;
        g.weightx = 0;
        g.fill = GridBagConstraints.BOTH;
        cp.add(dentistOutput, g);

        // �]�m�ݶE���Ǽ��ҩM��X
        numberLabel = new JLabel("�ݶE����");
        numberLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 4;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(numberLabel, g);

        numberOutput = new JTextField();
        numberOutput.setEditable(false);
        numberOutput.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 5;
        g.gridwidth = 3;
        g.weightx = 0;
        g.fill = GridBagConstraints.BOTH;
        cp.add(numberOutput, g);

        // �]�m�O�μ��ҩM��X
        chargeLabel = new JLabel("�O��(NT$)");
        chargeLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 6;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(chargeLabel, g);

        chargeOutput = new JTextField(String.valueOf(StartPage.patient.calculateCharge()));
        chargeOutput.setEditable(false);
        chargeOutput.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 7;
        g.gridwidth = 3;
        g.weightx = 0;
        g.fill = GridBagConstraints.BOTH;
        cp.add(chargeOutput, g);

        // �]�m���s
        enterButton = new JButton("�T�w");
        enterButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 9;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(enterButton, g);

        modifyButton = new JButton("�ק�");
        modifyButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 9;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(modifyButton, g);

        deleteButton = new JButton("�R��");
        deleteButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 3;
        g.gridy = 9;
        g.gridwidth = 1;
        g.weightx = 0;
        cp.add(deleteButton, g);

        // �p��ݶE����
        int number = 0;
        try (BufferedReader p = new BufferedReader(new FileReader("Register.txt"))) {
            String input;
            while ((input = p.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(input, " ");
                if (st.hasMoreTokens()) {
                    st.nextToken();
                    String getRegister=st.nextToken();
                    if (getRegister.equals("On_site")) {
                        number += 1;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("���Ū�����~");
        }
        numberOutput.setText(String.valueOf(number));

        

        // ���U���s�ƥ�
        enterButton.addActionListener(new EnterButtonHandler());
        modifyButton.addActionListener(new ModifyButtonHandler());
        deleteButton.addActionListener(new DeleteButtonHandler());
    }

    // �T�w���s�B�z�{��
    private class EnterButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BasicInfoPage BIP = new BasicInfoPage();
            BIP.setVisible(true);
            dispose();
        }
    }

    // �ק���s�B�z�{��
    private class ModifyButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            on_siteDentist.modifyOn_sitePatient(StartPage.patient.getId(), therapyOutput.getText(), dentistOutput.getText()); // �ǤJ�Ѽ� ID ���� ���
            dispose();
        }
    }

    // �R�����s�B�z�{��
    private class DeleteButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            on_siteDentist.deleteOn_sitePatient(StartPage.patient.getId(), therapyOutput.getText(), dentistOutput.getText()); // �ǤJ�Ѽ� ID ���� ���
            dispose();
        }
    }
}
