import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SearchPage extends JFrame {
    private final JLabel nameTitleLabel, nameLabel, IDLabel, addressLabel, TELLabel, birthLabel, passwordLabel, detailLabel, appointmentLabel;
    private final JTextField nameOutput, IDOutput, addressOutput, TELOutput, birthOutput, passwordOutput;
    private final Container cp;
    private final JButton modifyButton, backButton;
    // �f�H���
    private final ArrayList<ArrayList<String>> regestRecords = new ArrayList<>();// �s�f�H���E����
    static boolean modifyData = false;//�Ω�վ���
    public SearchPage() {
        setTitle("�j�M���");
        // �]�m���������ù��åB���i�Y�p
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = dim.width;
        int screenHeight = dim.height;
        setMinimumSize(new Dimension(screenWidth,screenHeight));

        // �ЫإD���O�ó]�m�� BorderLayout
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JPanel centerPan = new JPanel(new GridLayout(1, 2));
        // ���o�f�H���
        loadPatientRegest("Register.txt", StartPage.patient.getId());


        
        // ���������Ω��n������������T
        JPanel leftPanel = new JPanel(new GridLayout(1,2));
        JPanel l1Panel = new JPanel(new GridBagLayout());
        JPanel l2Panel = new JPanel(new BorderLayout());

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6, 6, 6, 6);
        g.fill = GridBagConstraints.NORTHEAST;

        // �Τ@�r��
        Font labelFont = new Font("�L�n������", Font.PLAIN, 24);

        nameTitleLabel = new JLabel("�ӤH���");
        nameTitleLabel.setFont(new Font("�L�n������", Font.BOLD, 30)); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 1;
        g.anchor = GridBagConstraints.NORTHEAST; // �����
        l1Panel.add(nameTitleLabel, g);

        nameLabel = new JLabel("�m�W");
        nameLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 1;
        l1Panel.add(nameLabel, g);
        nameOutput = new JTextField(StartPage.patient.getName(),60);
        nameOutput.setEditable(false);// �]�m�����i�s��
        nameOutput.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx = 1;
        g.gridy = 2;
        g.gridwidth = 2;
        l1Panel.add(nameOutput, g);

        IDLabel = new JLabel("������");
        IDLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 1;
        l1Panel.add(IDLabel, g);
        IDOutput = new JTextField(StartPage.patient.getId(),60);
        IDOutput.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        IDOutput.setEditable(false);// �]�m�����i�s��
        g.gridx = 1;
        g.gridy = 4;
        g.gridwidth = 2;
        l1Panel.add(IDOutput, g);

        addressLabel = new JLabel("��}");
        addressLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 5;
        g.gridwidth = 1;
        l1Panel.add(addressLabel, g);

        addressOutput = new JTextField(StartPage.patient.getAddress(), 60);
        addressOutput.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        addressOutput.setEditable(false); // �]�m�����i�s��

        JScrollPane addressScrollPane = new JScrollPane(addressOutput);
        addressScrollPane.setPreferredSize(new Dimension(200, 60)); // �]�m�u�ʭ��O�����n�ؤo
        addressScrollPane.setMinimumSize(new Dimension(200, 60)); // �]�m�u�ʭ��O���̤p�ؤo
        g.gridx = 1;
        g.gridy = 6;
        g.gridwidth = 2;
        l1Panel.add(addressScrollPane, g);

        TELLabel = new JLabel("�q�ܸ��X");
        TELLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 7;
        g.gridwidth = 1;
        l1Panel.add(TELLabel, g);
        TELOutput = new JTextField(StartPage.patient.getTel(),60);
        TELOutput.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        TELOutput.setEditable(false);// �]�m�����i�s��
        g.gridx = 1;
        g.gridy = 8;
        g.gridwidth = 2;
        l1Panel.add(TELOutput, g);

        birthLabel = new JLabel("�ͤ�");
        birthLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 9;
        g.gridwidth = 1;
        l1Panel.add(birthLabel, g);
        birthOutput = new JTextField(StartPage.patient.getBirthDate(),60);
        birthOutput.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        birthOutput.setEditable(false);// �]�m�����i�s��
        g.gridx = 1;
        g.gridy = 10;
        g.gridwidth = 2;
        l1Panel.add(birthOutput, g);

        passwordLabel = new JLabel("�K�X");
        passwordLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx = 0;
        g.gridy = 11;
        g.gridwidth = 1;
        l1Panel.add(passwordLabel, g);
        
        passwordOutput = new JTextField(StartPage.patient.getSecret(),60);
        passwordOutput.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        passwordOutput.setEditable(false);// �]�m�����i�s��
        g.gridx = 1;
        g.gridy = 12;
        g.gridwidth = 2;
        l1Panel.add(passwordOutput, g);

        nameOutput.setMinimumSize(new Dimension(200, 60));//�]�w��r�س̤p��
        IDOutput.setMinimumSize(new Dimension(200, 60));//�]�w��r�س̤p��
        TELOutput.setMinimumSize(new Dimension(200, 60));//�]�w��r�س̤p��
        birthOutput.setMinimumSize(new Dimension(200, 60));//�]�w��r�س̤p��
        passwordOutput.setMinimumSize(new Dimension(200, 60));//�]�w��r�س̤p��
        
        modifyButton=new JButton("�ק�");
        modifyButton.setFont(labelFont);
        modifyButton.setSize(30, 20);// �]�m�j�p
              
        backButton=new JButton("��^");
        backButton.setFont(labelFont);
        backButton.setSize(30, 20);// �]�m�j�p
               
        JPanel actionPan = new JPanel(new GridBagLayout());
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 1;
        actionPan.add(backButton,g);
        
        g.gridx = 1;
        g.gridy = 0;
        g.gridwidth = 1;
        actionPan.add(modifyButton,g);
       
        g.gridx = 0;
        g.gridy = 13;
        g.gridwidth = 3;
        l1Panel.add(actionPan,g);

        // ���@�[�J
        leftPanel.add(l1Panel);

        //�ԲӸ��
        detailLabel = new JLabel("�ԲӸ��");
        detailLabel.setFont(new Font("�L�n������", Font.BOLD, 30)); // �]�m�r���B�ʲөM�j�p
        
        l2Panel.add(detailLabel, BorderLayout.NORTH);

        JPanel detailLeftPanel = new JPanel(new GridLayout(16,1));
        JPanel detailRightPanel = new JPanel(new GridLayout(16,1));
        
        l2Panel.add(detailLeftPanel, BorderLayout.CENTER);
        l2Panel.add(detailRightPanel, BorderLayout.EAST);

        
        String[] details = StartPage.patient.getDetail().showDetail().split(" ");
        
        for (String detail : details) {
          String[] parts = detail.split(":");
          JLabel questionLabel = new JLabel(parts[0]);
            questionLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
            JLabel ansLabel;
            if(StartPage.patient.getDetail().getDetail(parts[0])){
              ansLabel = new JLabel("Yes");
              ansLabel.setForeground(Color.RED);
            }
            else{
              ansLabel = new JLabel("No");
            }
            ansLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
            ansLabel.setHorizontalAlignment(SwingConstants.LEFT);
            detailLeftPanel.add(questionLabel,g);

            detailRightPanel.add(ansLabel,g);
        }

        // ���G�[�J
        leftPanel.add(l2Panel);

        // �k�������Ω����E����
        JPanel rightPanel = new JPanel(new BorderLayout());
        

       //���E����
        appointmentLabel=new JLabel("�����O��");
        appointmentLabel.setFont(new Font("�L�n������", Font.BOLD, 30)); // �]�m�r���B�ʲөM�j�p

        JPanel appointmentPanel=new JPanel(new BorderLayout());
        JPanel appointmentTitlePanel = new JPanel(new GridLayout(0,5));
        JPanel appointmentContentPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(0, 5);
        gridLayout.setVgap(4); // �]�m�������Z
        gridLayout. setHgap(4);//�]�m�������Z
        appointmentContentPanel.setLayout(gridLayout);
        
        JScrollPane appointmentScrollPane=new JScrollPane(appointmentContentPanel);

        //�p���D
        
        JLabel typeLabel = new JLabel("����", SwingConstants.CENTER);
        typeLabel.setFont(new Font("�L�n������", Font.BOLD, 24));
        appointmentTitlePanel.add(typeLabel);

        JLabel itemLabel = new JLabel("����", SwingConstants.CENTER);
        itemLabel.setFont(new Font("�L�n������", Font.BOLD, 24));
        appointmentTitlePanel.add(itemLabel);

        JLabel doctorLabel = new JLabel("���", SwingConstants.CENTER);
        doctorLabel.setFont(new Font("�L�n������", Font.BOLD, 24));
        appointmentTitlePanel.add(doctorLabel);

        JLabel timeLabel = new JLabel("�ɶ�", SwingConstants.CENTER);
        timeLabel.setFont(new Font("�L�n������", Font.BOLD, 24));
        appointmentTitlePanel.add(timeLabel);

        JLabel modifyLabel = new JLabel("�ԲӸ��", SwingConstants.CENTER);
        modifyLabel.setFont(new Font("�L�n������", Font.BOLD, 24));
        appointmentTitlePanel.add(modifyLabel);

        //�ƪ�
        
        appointmentPanel.add(appointmentTitlePanel, BorderLayout.NORTH);
        appointmentPanel.add(appointmentScrollPane, BorderLayout.CENTER);

        rightPanel.add(new JPanel(), BorderLayout.WEST); 
        rightPanel.add(appointmentLabel, BorderLayout.NORTH);
        rightPanel.add(appointmentPanel, BorderLayout.CENTER);
        
        boolean hasData = false;//�O�_���N�E����
        
        if (!regestRecords.isEmpty()){
          
          for (ArrayList<String> r:regestRecords){
            String type=r.get(0);
            if (type.equals("�w���ݶE")){ 
              hasData = true;
              String therapy=r.get(1);
              String dentist=r.get(2);
              String date=r.get(3);
                 
              //�ۭq��k�վ�r��
              appointmentContentPanel.add(createJLabel(type, labelFont));
              appointmentContentPanel.add(createJLabel(therapy, labelFont));
              appointmentContentPanel.add(createJLabel(dentist, labelFont));
              appointmentContentPanel.add(createJLabel(date, labelFont));
              JPanel BTNpanel  = new JPanel(new GridBagLayout());
              JButton modifyButton=new JButton("�˵�");
              modifyButton.setFont(labelFont);
              modifyButton.setSize(30, 20);// �]�m�j�p
              g.gridx = 1;
              g.gridy = 1;
              g.gridwidth = 1;
              g.anchor= GridBagConstraints.CENTER; // ���m��
              BTNpanel.add(modifyButton, g);
              appointmentContentPanel.add(BTNpanel);

              //���ק諸�欰
              modifyButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  AppointedInfoPage AIP=new AppointedInfoPage(date,dentist,therapy);
                  AIP.setVisible(true);   
                  dispose();
                }
              });
            }else if(type.equals("�{������")){
              hasData = true;
              String therapy=r.get(1);
              String dentist=r.get(2);
              String number=r.get(3);

              appointmentContentPanel.add(createJLabel(type, labelFont));
              appointmentContentPanel.add(createJLabel(therapy, labelFont));
              appointmentContentPanel.add(createJLabel(dentist, labelFont));
              appointmentContentPanel.add(createJLabel(number, labelFont));
                    
              JPanel BTNpanel = new JPanel(new GridBagLayout());
              JButton modifyButton=new JButton("�˵�");
              modifyButton.setFont(labelFont);
              modifyButton.setSize(30, 20);// �]�m�j�p
              g.gridx = 1;
              g.gridy = 1;
              g.gridwidth = 1;
              g.weightx = 0;
              g.anchor= GridBagConstraints.CENTER; // ����m��
              BTNpanel.add(modifyButton, g);
              appointmentContentPanel.add(BTNpanel);

              //���ק諸�欰
              modifyButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  On_siteInfoPage OIP=new On_siteInfoPage(therapy,dentist);
                  OIP.setVisible(true);  
                  dispose();
                }
              });
            }
          }
        }
        if(!hasData){
          appointmentContentPanel.add(createJLabel("�ثe�L�N�E����", labelFont));
       }
        
        //�[�J�D���O
        centerPan.add(leftPanel);
        centerPan.add(rightPanel);
        cp.add(centerPan, BorderLayout.CENTER);//�m��



       //���U���s
        backButton.addActionListener(new BackButtonHandler());
        modifyButton.addActionListener(new ModifyButtonHandler());
    }

   //��^��
    private class BackButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            BasicInfoPage BIP=new BasicInfoPage();
            BIP.setVisible(true);
            dispose();
        }
    }
    
   //�ק���
    private class ModifyButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
          modifyData = true;//�]�w���w�վ�
          //Ū���çR���ӯf�H��ơA�}�ҵ��U����(id�P�ͤ餣�i�s��)
          ArrayList<String> lines=new ArrayList<>();// �Ыؤ@��ArrayList�Ӧs�xŪ������
          try (BufferedReader br=new BufferedReader(new FileReader("Patient.txt"))){
            String input;
            while((input=br.readLine())!=null){
                StringTokenizer st=new StringTokenizer(input," ");
                if(st.hasMoreTokens()){
                  st.nextToken();//�Ĥ@���O�����O
                    // �p�GID�P��J��ID�۲�
                    String getID=st.nextToken();
                    if(getID.equals(StartPage.patient.getId())){
                       continue;
                    }
                }
                // �N�o�@��K�[��lines��
                lines.add(input);
            }
        }catch(IOException c){
            System.out.println("���Ū�����~");
        }

        try(PrintWriter pw=new PrintWriter(new FileWriter("Patient.txt"))){
            // �Nlines�����C�@��g�J����
            for(String line:lines){
                pw.println(line);
            }
        }catch(IOException ex){
            System.out.println("��Ƽg�J���~");
        }
        
        //�}�ҥD�n�e��
        SignUpPage SUP=new SignUpPage();
        SUP.modifyInfo(StartPage.patient.getId(), StartPage.patient.getBirthDate(), StartPage.patient.getDetail().getDetail("�O�_���S����(�a���B����)"));//ID�B�ͤ�B�����O���i��
        SUP.setVisible(true);
        dispose();
        }
    }


    //Ū����������
    public void loadPatientRegest(String filename,String ID){
      try (BufferedReader br=new BufferedReader(new FileReader(filename))){
        String line;//����Ū���@���
        int countNum=0;//�p��{���Ǹ�
            
        while ((line=br.readLine()) != null){
          StringTokenizer st=new StringTokenizer(line," ");
          String fileID = st.nextToken();//������
          String type = st.nextToken();//����
                
          ArrayList<String> innerArr=new ArrayList<>();
     
          if (st.hasMoreTokens()){
            if(fileID.equals(ID)){
              //�Ω�p��{���Ǹ�
              if(type.equals("On_site")){
                countNum+=1;
              }
              if (type.equals("Appointed")){
                type="�w���ݶE";
                innerArr.add(type);
                innerArr.add(st.nextToken());//����
                innerArr.add(st.nextToken());//���
                String date=st.nextToken() + "�~" + st.nextToken() + "��" + st.nextToken() + "��" + st.nextToken();
                innerArr.add(date);//�ɶ�
              } else{
                type="�{������";
                innerArr.add(type);
                innerArr.add(st.nextToken());//����
                innerArr.add(st.nextToken());//���
                innerArr.add("�ݶE�Ǹ��G"+countNum);//�ݶE����
              }
              regestRecords.add(innerArr);//��JregestRecords
            }  
          }
        }
          
      } catch (IOException e){
        System.out.println("�ɮ�Ū�����~");
      }
    }
    // ��k�G�۩w�q��k�ӳЫبó]�m�r�骺JLabel
    private JLabel createJLabel(String text, Font font) {
      JLabel label = new JLabel(text, SwingConstants.CENTER);
      label.setFont(font);
      return label;
    }
}
