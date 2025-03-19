import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BasicInfoPage extends JFrame{
    private final Container cp;
    private final JLabel IDLabel,nameLabel,birthLabel;
    private final JTextField IDOutput,nameOutput,birthOutput;
    private final JButton appointedButton,On_siteButton,searchButton,backToStartPage;

    public BasicInfoPage(){
        setTitle("�򥻸��");
        
        // �]�m���������ù��åB���i�Y�p
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = dim.width;
        int screenHeight = dim.height;
        setMinimumSize(new Dimension(screenWidth,screenHeight));
 
        cp=getContentPane();
        cp.setLayout(new GridBagLayout());
        GridBagConstraints g=new GridBagConstraints();
        g.insets=new Insets(6,6,6,6);

        
        // ���������Ω��ϥΪ̬�����T�P���s
        JPanel leftPanel = new JPanel(new GridBagLayout());
        
        IDLabel=new JLabel("������");
        IDLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx=0;
        g.gridy=0;
        g.gridwidth=1;
        g.weightx=0;
        leftPanel.add(IDLabel,g);

        IDOutput=new JTextField(20);
        IDOutput.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        IDOutput.setEditable(false);
        g.gridx=1;
        g.gridy=1;
        g.gridwidth=4;
        g.weightx=0;
        leftPanel.add(IDOutput,g);

        nameLabel=new JLabel("�m�W");
        nameLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx=0;
        g.gridy=2;
        g.gridwidth=1;
        g.weightx=0;
        leftPanel.add(nameLabel,g);

        nameOutput=new JTextField(20);
        nameOutput.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx=0;
        nameOutput.setEditable(false);
        g.gridx=1;
        g.gridy=3;
        g.gridwidth=4;
        g.weightx=0;
        leftPanel.add(nameOutput,g);

        birthLabel=new JLabel("�ͤ�");
        birthLabel.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx=0;
        g.gridy=4;
        g.gridwidth=1;
        g.weightx=0;
        leftPanel.add(birthLabel,g);

        birthOutput=new JTextField(20);
        birthOutput.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        birthOutput.setEditable(false);
        g.gridx=1;
        g.gridy=5;
        g.gridwidth=4;
        g.weightx=0;
        leftPanel.add(birthOutput,g);

        appointedButton=new JButton("�w��");
        appointedButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx=1;
        g.gridy=6;
        g.gridwidth=1;
        g.weightx=0;
        leftPanel.add(appointedButton,g);

        On_siteButton=new JButton("�{��");
        On_siteButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx=2;
        g.gridy=6;
        g.gridwidth=1;
        g.weightx=0;
        leftPanel.add(On_siteButton,g);

        searchButton=new JButton("�d��");
        searchButton.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx=3;
        g.gridy=6;
        g.gridwidth=1;
        g.weightx=0;
        leftPanel.add(searchButton,g);

        
        // �k�������A�k�U����m�^�쭺��
        JPanel rightPanel = new JPanel(new BorderLayout());
        JPanel nullPanel = new JPanel(new BorderLayout());
        backToStartPage=new JButton("�^�쭺��");
        backToStartPage.setFont(new Font("�L�n������", Font.PLAIN, 30)); // �]�m�r���B�ʲөM�j�p
        rightPanel.add(backToStartPage, BorderLayout.SOUTH);
        rightPanel.add(nullPanel, BorderLayout.CENTER);

        IDOutput.setText(StartPage.patient.getId());
        nameOutput.setText(StartPage.patient.getName());
        birthOutput.setText(StartPage.patient.getBirthDate());

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
        appointedButton.addActionListener(new AppointedButtonHandler());
        On_siteButton.addActionListener(new On_siteButtonHandler());
        searchButton.addActionListener(new SearchButtonHandler());
        backToStartPage.addActionListener(new BackToStartPageHandler());
    }
    
    
    //�w����
    private class AppointedButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        AppointedPage AP=new AppointedPage();
        AP.setVisible(true);
        dispose();
      }
    }
    
    //�{����
    private class On_siteButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        On_sitePage OP=new On_sitePage();
        OP.setVisible(true);
        dispose();
      }
    }
    
    //�d����
    private class SearchButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        SearchPage SP=new SearchPage();
        SP.setVisible(true);
        dispose();
      }
    }
    
    //�^�쭺����
    private class BackToStartPageHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        StartPage SP=new StartPage();
        SP.setVisible(true);
        dispose();
      }
    }
    
    
    
    
}
