import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StartPage extends JFrame {
    // ��l��
    private final JLabel clinicTitleLabel, advTitleLabel, IDLabel, secretLabel, IDWarnInfoLabel, secretWarnInfoLabel;
    private final JTextField IDInput;//��J������
    private final JCheckBox showPasswordCheckBox;//��ܱK�X
    private final JPasswordField secretInput; // �K�X��JPasswordField����
    private final JButton signInButton, signUpButton, forgetSecretButton;
    private final Container cp;
    public static Patient patient;
    private String IDWarning = ""; // �s��ĵ�i�T��
    private String secretWarning = ""; // �s��ĵ�i�T��
    public ArrayList<Dentist> dentists = new ArrayList<>(); // �s������ƪ��C�� �x��Dentist

    public StartPage() {
        setTitle("����w�������t��"); // �]�w�������D
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�]�m�����ù�
        setResizable(false);//�]�m�����i�Y�p
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//���o�q�������j�p
        int screenWidth = dim.width;
        int screenHeight = dim.height;
        setMinimumSize(new Dimension(screenWidth, screenHeight));//�N�����j�p�̤p�ȳ]���q������

        // �ЫإD���O�ó]�m�� GridBagLayout
        cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6, 6, 6, 6);//�C�Ӫ��󪺶��j
        g.fill = GridBagConstraints.HORIZONTAL;//������

        // �������O�Ω��n������������T
        JPanel leftPanel = new JPanel(new GridBagLayout());

        // LOGO
        // ImageIcon logoIcon = new ImageIcon(new ImageIcon("LOGO.png").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/resources/LOGO.png"));
        //�q�{�Ϲ����Y���k
        JLabel logoLabel = new JLabel(logoIcon);
        g.gridx = 0;//�y��
        g.gridy = 0;//�y��
        g.gridwidth = 3;//���ڮ��
        g.weightx = 3;//���ڪžl�Ŷ�����O
        g.anchor = GridBagConstraints.CENTER; // ���m��
        leftPanel.add(logoLabel, g);

        // �]�m�j���D
        clinicTitleLabel = new JLabel("OOO����E��");
        clinicTitleLabel.setFont(new Font("�L�n������", Font.BOLD, 60)); // �]�m�j���D�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 3;
        g.gridwidth = 3;
        g.weightx = 0;
        g.anchor = GridBagConstraints.CENTER; // ���m��
        
        leftPanel.add(clinicTitleLabel, g);

        // ������
        IDLabel = new JLabel("������");
        IDLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 6;
        g.gridwidth = 1;
        g.weightx = 0;
        g.anchor = GridBagConstraints.WEST; // �����
        leftPanel.add(IDLabel, g);
        IDInput = new JTextField(15);
        IDInput.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 7;
        g.gridwidth = 2;
        g.weightx = 0;
        leftPanel.add(IDInput, g);

        // �K�X
        secretLabel = new JLabel("�K�X");
        secretLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 9;
        g.gridwidth = 1;
        g.weightx = 0;
        leftPanel.add(secretLabel, g);
        secretInput = new JPasswordField(15);
        secretInput.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 10;
        g.gridwidth = 2;
        g.weightx = 0;
        leftPanel.add(secretInput, g);
        showPasswordCheckBox = new JCheckBox("��ܱK�X");
        showPasswordCheckBox.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 9;
        g.gridwidth = 1;
        g.weightx = 0;
        leftPanel.add(showPasswordCheckBox, g);

        forgetSecretButton = new JButton("�ѰO�K�X");
        forgetSecretButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 3;
        g.gridy = 9;
        g.gridwidth = 1;
        g.weightx = 0;
        leftPanel.add(forgetSecretButton, g);
        signInButton = new JButton("�n�J");
        signInButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 12;
        g.gridwidth = 1;
        g.weightx = 0;
        leftPanel.add(signInButton, g);
        signUpButton = new JButton("���U");
        signUpButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 3;
        g.gridy = 12;
        g.gridwidth = 1;
        g.weightx = 0;
        leftPanel.add(signUpButton, g);

        // ��l��ĵ�i�T������
        IDWarnInfoLabel = new JLabel("");
        IDWarnInfoLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 8;
        g.gridwidth = 3;
        g.weightx = 0;
        leftPanel.add(IDWarnInfoLabel, g);
        secretWarnInfoLabel = new JLabel("");
        secretWarnInfoLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 2;
        g.gridy = 11;
        g.gridwidth = 3;
        g.weightx = 0;
        leftPanel.add(secretWarnInfoLabel, g);

        // �k�����O�Ω��m�u�N�E�`�N�ƶ��v������r�T��
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        advTitleLabel = new JLabel("�N�E�`�N�ƶ�");
        advTitleLabel.setFont(new Font("�L�n������", Font.BOLD, 40)); // �]�m���D�r���B�ʲөM�j�p

        JTextArea medicalAdvice = new JTextArea("1. �w���д��e��F�E�ҳ���C\n"
                + "2. ����a���O�d�ά��������ҩ��C\n"
                + "3. �N�E�e�Шƥ�����C\n"
                + "4. �p���S��ݨD�A�д��e�i�����@�H���C\n"
                + "5. �п�u��ͩM�E�Ҫ������W�w�C\n");
        medicalAdvice.setEditable(false); // �T��s��
        medicalAdvice.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        JScrollPane scrollPane = new JScrollPane(medicalAdvice);

        rightPanel.add(advTitleLabel, BorderLayout.NORTH);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        // �N���k��ӭ��O�[��D���O��
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 1;
        g.fill = GridBagConstraints.BOTH;
        cp.add(leftPanel, g);

        g.gridx = 1;
        g.gridy = 0;
        g.gridwidth = 1;
        cp.add(rightPanel, g);

        // ���U���s�ƥ�
        signInButton.addActionListener(new SignInButtonHandler());
        signUpButton.addActionListener(new SignUpButtonHandler());
        forgetSecretButton.addActionListener(new ForgetSecretButtonHandler());
        showPasswordCheckBox.addActionListener(new PassWordHandler());

        // ���U��L�ƥ�
        IDInput.addKeyListener(new EnterKeyAdapter());
        secretInput.addKeyListener(new EnterKeyAdapter());
    }

    // ��L�ƥ�
    private class EnterKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                authenticateUser(); // ���UEnter������ҨϥΪ�
            }
        }
    }

    // ��ܱK�X���s
    private class PassWordHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (showPasswordCheckBox.isSelected()) {
                secretInput.setEchoChar((char) 0); // ��ܱK�X
            } else {
                secretInput.setEchoChar('*'); // ���ñK�X
            }
        }
    }

    // �n�J���s
    private class SignInButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            authenticateUser(); // ���U�n�J���s�����ҨϥΪ�
        }
    }

    // ���U���s
    private class SignUpButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SearchPage.modifyData=false;//�]�w���즸���U�b��
          System.out.println("StartPage�G"+SearchPage.modifyData);
            SignUpPage SUP = new SignUpPage(); // �i�J���U����
            SUP.setVisible(true);
            dispose(); // ��������
        }
    }

    // �ѰO�K�X���s
    private class ForgetSecretButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AuthenticationPage AP = new AuthenticationPage(); // �i�J���ҭ���
            AP.setVisible(true);
        }
    }

    // ���ҨϥΪ̨õn�J�}�ҹw������
    private void authenticateUser() {
        try (BufferedReader p = new BufferedReader(new FileReader("Patient.txt"))) {
            String input;
            StringTokenizer st;
            IDWarnInfoLabel.setText(IDWarning); // �]�mIDĵ�i�T��
            secretWarnInfoLabel.setText(secretWarning); // �]�m�K�Xĵ�i�T��
            while ((input = p.readLine()) != null) {
                st = new StringTokenizer(input);
                String identity = st.nextToken(); // ����
                String id = st.nextToken();//������
                String secret = st.nextToken();//�K�X
                String name = st.nextToken();//�m�W
                String birth = st.nextToken();//�ͤ�
                String address = st.nextToken();//��}
                String tel = st.nextToken();//�q��
                Detail detail = new Detail();//�ԲӰ��D
                String detailInfo;
                StringTokenizer newSt;
                if (IDInput.getText().isEmpty()) {
                    IDWarning = "�п�J������"; // �YID��J���ūh����
                    IDWarnInfoLabel.setText(IDWarning);
                } else {
                    IDWarning = Verification.verifyID(IDInput.getText()); // ����ID�O�_���榡���~
                    IDWarnInfoLabel.setText(IDWarning);
                    if (IDWarning.equals("")) { // �����ҨS�����~�T��
                        if (id.equals(IDInput.getText())) {
                            if (secretInput.getText().isEmpty()) {
                                secretWarning = "�п�J�K�X"; // �Y�K�X��J���ūh����
                                secretWarnInfoLabel.setText(secretWarning);
                            } else {
                                secretWarning = Verification.verifySecret(secretInput.getText()); // ���ұK�X
                                secretWarnInfoLabel.setText(secretWarning);
                                
                                System.out.println("check1");
                                
                                if (secretWarning.equals("")) { // �K�X�S�����~�T��
                                  
                                  System.out.println("check1");
                                  
                                    if (secret.equals(secretInput.getText())) {
                                        if (identity.equals("s")) { // �P�_�ϥΪ̨���
                                            while (st.hasMoreTokens()) {
                                                detailInfo = st.nextToken();
                                                
                                                System.out.println("check1.1");
                                                
                                                newSt = new StringTokenizer(detailInfo, ":");
                                                String key = newSt.nextToken();
                                                Boolean value = newSt.nextToken().equals("yes") ? true : false;
                                                detail.setDetail(key, value);
                                            }
                                            
                                            System.out.println("check1.2");
                                            
                                            patient = new SpecialPatient(name, id, address, tel, birth, secret, detail);
                                            
                                            System.out.println("check1"+patient);
                                        } else {
                                          
                                            while (st.hasMoreTokens()) {
                                                detailInfo = st.nextToken();
                                                newSt = new StringTokenizer(detailInfo, ":");
                                                String key = newSt.nextToken();
                                                Boolean value = newSt.nextToken().equals("yes") ? true : false;
                                                detail.setDetail(key, value);
                                            }
                                            patient = new normalPatient(name, id, address, tel, birth, secret, detail);
                                        }
                                        BasicInfoPage BIP = new BasicInfoPage();
                                        BIP.setVisible(true);
                                        dispose();
                                        break;
                                    } else {
                                        secretWarning = "�K�X��J���~"; // �K�X���~����
                                        secretWarnInfoLabel.setText(secretWarning);
                                    }
                                }
                            }
                        } else {
                            IDWarning = "�����ҿ�J���~"; // �����ҿ��~����
                            IDWarnInfoLabel.setText(IDWarning);
                            continue;
                        }
                    }
                    break;
                }
            }
        } catch (IOException c) {
            System.out.println("���Ū�����~"); // Ū���ɮ׿��~����
            System.exit(-2);
        }
    }

    public static void main(String[] args) {
        StartPage sp = new StartPage(); // �إ߶}�l��������
        sp.setVisible(true); // ��ܶ}�l����
    }
}
