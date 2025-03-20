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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;


public class SignUpPage extends JFrame{
    private final JLabel nameLabel,IDLabel,addressLabel,TELLabel,birthLabel,secretLabel,detailLabel;
    private final JTextField nameInput,IDInput,TELInput,secretInput,addressInput;
    private final JComboBox<Integer> yearInput,monthInput,dayInput;
    private final JButton submitButton,clearButton,backtoStartPageButton;
    private final Container cp;
    private static final Calendar calendar=Calendar.getInstance();
    private final int Year=calendar.get(Calendar.YEAR);
    private final Detail detail=new Detail();
    private final Map<String,JRadioButton[]> detailRadioButtons;
    private String warning;
    
    //���������O
    private boolean identity;

    public SignUpPage(){
        setTitle("���U");
        // �]�m���������ù��åB���i�Y�p
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = dim.width;
        int screenHeight = dim.height;
        setMinimumSize(new Dimension(screenWidth,screenHeight));
        
        Font labelFont = new Font("�L�n������", Font.PLAIN, 30);

        //�ЫإD���O�ó]�m�� GridLayout
        cp=getContentPane();
        cp.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets=new Insets(6,6,6,6);
        g.fill = GridBagConstraints.HORIZONTAL;

        nameLabel=new JLabel("�m�W");
        nameLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=0;
        g.gridy=0;
        g.gridwidth=1;
        g.weightx=0;
        cp.add(nameLabel,g);
        nameInput=new JTextField(20);
        nameInput.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=1;
        g.gridy=1;
        g.gridwidth=3;
        g.weightx=0;
        g.fill = GridBagConstraints.HORIZONTAL;
        cp.add(nameInput,g);
        
        IDLabel=new JLabel("������");
        IDLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=0;
        g.gridy=3;
        g.gridwidth=1;
        g.weightx=0;
        cp.add(IDLabel,g);
        IDInput=new JTextField(20);
        IDInput.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=1;
        g.gridy=4;
        g.gridwidth=3;
        g.weightx=0;
        g.fill = GridBagConstraints.HORIZONTAL;
        cp.add(IDInput,g);
        
        addressLabel=new JLabel("��}");
        addressLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=0;
        g.gridy=6;
        g.gridwidth=1;
        g.weightx=0;
        cp.add(addressLabel,g);
        addressInput=new JTextField(20);
        addressInput.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=1;
        g.gridy=7;
        g.gridwidth=3;
        g.weightx=0;
        g.fill = GridBagConstraints.HORIZONTAL;
        cp.add(addressInput,g);

        TELLabel=new JLabel("�q�ܸ��X");
        TELLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=0;
        g.gridy=9;
        g.gridwidth=1;
        g.weightx=0;
        cp.add(TELLabel,g);
        TELInput=new JTextField(20);
        TELInput.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=1;
        g.gridy=10;
        g.gridwidth=3;
        g.weightx=0;
        g.fill = GridBagConstraints.HORIZONTAL;
        cp.add(TELInput,g);

        birthLabel=new JLabel("�ͤ�");
        birthLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=0;
        g.gridy=12;
        g.gridwidth=1;
        g.weightx=0;
        cp.add(birthLabel,g);
        yearInput=new JComboBox<>();
        yearInput.setFont(labelFont);
        g.gridx=1;
        g.gridy=13;
        g.gridwidth=1;
        g.weightx=0;
        cp.add(yearInput,g);
        for(int i=Year;i > Year - 120;i--){
            yearInput.addItem(i);
        }
        monthInput=new JComboBox<>();
        monthInput.setFont(labelFont);
        g.gridx=2;
        g.gridy=13;
        g.gridwidth=1;
        g.weightx=0;
        cp.add(monthInput,g);
        for(int i=1;i <= 12;i++){
            monthInput.addItem(i);
        }
        dayInput=new JComboBox<>();
        dayInput.setFont(labelFont);
        g.gridx=3;
        g.gridy=13;
        g.gridwidth=1;
        g.weightx=0;
        cp.add(dayInput,g);
        updateDays();

        monthInput.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                updateDays();
            }
        });

        secretLabel=new JLabel("�K�X");
        secretLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=0;
        g.gridy=15;
        g.gridwidth=1;
        g.weightx=0;
        g.weighty=0;
        cp.add(secretLabel,g);
        secretInput=new JTextField(20);
        secretInput.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=1;
        g.gridy=16;
        g.gridwidth=3;
        g.weightx=0;
        g.weighty=0;
        g.fill = GridBagConstraints.HORIZONTAL;
        cp.add(secretInput,g);
        detailLabel=new JLabel("�Ц^���U�C���D");
        detailLabel.setFont(new Font("�L�n������", Font.BOLD, 40)); // �]�m�r���B�ʲөM�j�p
        g.gridx=4;
        g.gridy=0;
        g.gridwidth=1;
        g.weightx=0;
        cp.add(detailLabel,g);
        JPanel detailPanel=new JPanel();
        detailPanel.setLayout(new GridLayout(0,3));
        JScrollPane scrollPane=new JScrollPane(detailPanel);
        g.gridx=4;
        g.gridy=1;
        g.gridwidth=3;
        g.gridheight=18;
        g.weightx=1;
        g.weighty=1;
        g.fill = GridBagConstraints.BOTH;
        cp.add(scrollPane,g);
        detailRadioButtons=new HashMap<>();//�syes/No���s
        int i=0;
        for(String key : detail.getKeys()){
            JLabel questionLabel=new JLabel(key);
            questionLabel.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
            JRadioButton yesButton=new JRadioButton("Yes");
            yesButton.setFont(labelFont);
            JRadioButton noButton=new JRadioButton("No");
            noButton.setFont(labelFont);
            
            //���s��P�@�ӭ��O�A�u��G�ܤ@
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(yesButton);
            buttonGroup.add(noButton);
        
            
            detailRadioButtons.put(key,new JRadioButton[]{yesButton,noButton});
            detailPanel.add(questionLabel);
            detailPanel.add(yesButton);
            detailPanel.add(noButton);
            //�p�G�O�qsearchPage�Ӫ��A�h�����O���i�ק�
            if(i==0&&SearchPage.modifyData){
              yesButton.setEnabled(false);
              noButton.setEnabled(false);
              if(identity){
                yesButton.setSelected(true);
              }else{
                noButton.setSelected(true);
              }
            }
            i++;
        }
        
        
        submitButton=new JButton("�e�X");
        submitButton.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=1;
        g.gridy=20;
        g.gridwidth=1;
        g.weightx=0;
        g.fill = GridBagConstraints.NONE;
        cp.add(submitButton,g);
        clearButton=new JButton("�M��");
        clearButton.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=3;
        g.gridy=20;
        g.gridwidth=1;
        g.weightx=0;
        g.fill = GridBagConstraints.NONE;
        cp.add(clearButton,g);
        backtoStartPageButton=new JButton("�^��n�J");
        backtoStartPageButton.setFont(labelFont); // �]�m�r���B�ʲөM�j�p
        g.gridx=5;
        g.gridy=20;
        g.gridwidth=0;
        g.weightx=0;
        g.fill = GridBagConstraints.NONE;
        cp.add(backtoStartPageButton,g);

        // ���U���s�ƥ�
        submitButton.addActionListener(new SubmitButtonHandler());
        clearButton.addActionListener(new ClearButtonHandler());
        backtoStartPageButton.addActionListener(new BacktoStartPageButtonHandler());
        
        // ���U��L�ƥ�
        IDInput.addKeyListener(new enterKeyAdapter());
        nameInput.addKeyListener(new enterKeyAdapter());
        TELInput.addKeyListener(new enterKeyAdapter());
        addressInput.addKeyListener(new enterKeyAdapter());
        secretInput.addKeyListener(new enterKeyAdapter());

        //���U�ƹ��ƥ�
        addressInput.addMouseListener(new AddressMouseHandler());
        secretInput.addMouseListener(new SecretMouseHandler());
    }
    
    //�]�m�ƹ��ƥ�
    private class AddressMouseHandler extends MouseAdapter {
      public void mouseEntered(MouseEvent e) {
        if(addressInput.getText().isEmpty()){//��a�}���Q�ϥΪ̿�J��
          addressInput.setText("��J�榡:OO��/��");
          addressInput.setFont(new Font("�L�n������", Font.PLAIN, 24)); // �]�m�r���B�ʲөM�j�p
        }
      }
      public void mouseClicked(MouseEvent e){
        if(addressInput.getText().equals("��J�榡:OO��/��")){
          addressInput.setText("");
        }
      }
      public void mouseExited(MouseEvent e){
        if(addressInput.getText().equals("��J�榡:OO��/��")){
          addressInput.setText("");
        }
      }
  }

  private class SecretMouseHandler extends MouseAdapter{
    public void mouseEntered(MouseEvent e){
      if(secretInput.getText().isEmpty()){//��K�X���Q�ϥΪ̿�J��
        secretInput.setText("���]�t�j�p�g�^��U�@�P�ܤ֥|��Ʀr");
        secretInput.setFont(new Font("�L�n������", Font.PLAIN, 24)); // �]�m�r���B�ʲөM�j�p
      }
    }
    public void mouseClicked(MouseEvent e){
      if(secretInput.getText().equals("���]�t�j�p�g�^��U�@�P�ܤ֥|��Ʀr")){
        secretInput.setText("");
      }
    }
    public void mouseExited(MouseEvent e){
      if(secretInput.getText().equals("���]�t�j�p�g�^��U�@�P�ܤ֥|��Ʀr")){
        secretInput.setText("");
      }
    }
  }

    // �]�mEnter��ƥ�
    private class enterKeyAdapter extends KeyAdapter{
        public void keyPressed(KeyEvent e){//��ϥΪ̦b��J����Uenter��
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                submit();
            }
        }
    }
    
    //�e�X���s
    private class SubmitButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e){
        submit();
      }
    }
    
    //�M�����s
    private class ClearButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e){//�M����J���e
        nameInput.setText("");
        addressInput.setText("");
        secretInput.setText("");
        TELInput.setText("");
       
        if (!SearchPage.modifyData){//�s�Τ�
            IDInput.setText("");
        }
      }
    }
    
    // �^��n�J���s
    private class BacktoStartPageButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e){
        System.out.println("SignUpPage�G"+SearchPage.modifyData);
        //�p�G�OSearchPage�Ӫ��A���^��n�J�ɱN�쥻��Ƽg�^�ɮ�
        if(SearchPage.modifyData){
          try(FileWriter fr=new FileWriter("Patient.txt",true);// �ΨӱN��Ƽg�J�ɮ�
              PrintWriter p=new PrintWriter(fr)){//�ΨӱN��Ƽg�J�ɮ�
                    p.println(StartPage.patient.toString());
            }catch(IOException ex){
              System.out.println("�ɮ׼g�J����");
              System.exit(-1);
            }
        }
        
          StartPage SP=new StartPage();
          SP.setVisible(true);

          dispose();
        
      }
    }
    
    private void submit(){
        boolean isValid;
        for(String key : detailRadioButtons.keySet()){
          JRadioButton[] buttons=detailRadioButtons.get(key);//���o���I�諸���e
          if(buttons[0].isSelected()){
            detail.setDetail(key,true);
          }else{
            detail.setDetail(key,false);
          }
        }
        String name=nameInput.getText();//���o�m�W
        String id=IDInput.getText();//���o������
        String address=addressInput.getText();//���o�a�}

        String tel=TELInput.getText();//���o�q�ܸ��X
        tel=tel.replace(" ","");//�N�q�ܸ��X�����Ŧr�겾��
        tel=tel.replace("-","");//�N�q�ܸ��X����-����
        tel=tel.replace("_","");//�N�q�ܸ��X����_����
        tel=tel.replace("(","");//�N�q�ܸ��X����(����
        tel=tel.replace(")","");//�N�q�ܸ��X����)����
        tel=tel.replace("#","");//�N�q�ܸ��X����#����
        tel=tel.replace("+886","0");//�N�q�ܸ��X����+886�אּ0
        String birthDate=yearInput.getSelectedItem()+"-"+monthInput.getSelectedItem()+"-"+dayInput.getSelectedItem();//���o�X�ͤ��
        String secret=secretInput.getText();//���o�K�X
        isValid=validateInputs(name,id,address,tel,secret);//�P�_�O�_����J���~
        
        
        if(isValid){            
            try(FileWriter fr=new FileWriter("Patient.txt",true);// �ΨӱN��Ƽg�J�ɮ�
              PrintWriter p=new PrintWriter(fr)){//�ΨӱN��Ƽg�J�ɮ�
                String patinetInfo=id+" "+secret+" "+name+" "+birthDate+" "+address+" "+tel+" "+detail.showDetail();
                
                System.out.println(patinetInfo);
                
                if(detail.getDetail("�O�_���S����(�a���B����)")==false){
                    p.println("n "+patinetInfo);//�@��f�H
                    }
                  else{
                    p.println("s "+patinetInfo);//�S��f�H
                  }
            }catch(IOException ex){
              System.out.println("�ɮ׼g�J����");
              System.exit(-1);
            }
              StartPage SP=new StartPage();
              SP.setVisible(true);
              dispose();
            }
    }

    // ��k�G��ID�B�ͤ餣�i�ק諸��k�Afor ��s�ӤH���(�T�wID�B�ͤ�)
    public void modifyInfo(String id, String birth, boolean identity){
      this.identity = identity;
      // ID�]�m�����i�s��
      IDInput.setText(id);
      IDInput.setEditable(false);
      
      // �ͤ�]�m�����i�s��
      String[] dateParts = birth.split("-");
      yearInput.addItem(Integer.parseInt(dateParts[0]));
      yearInput.setSelectedItem(Integer.parseInt(dateParts[0]));
      yearInput.setEnabled(false); // �T�νs��
      
      monthInput.addItem(Integer.parseInt(dateParts[1]));
      monthInput.setSelectedItem(Integer.parseInt(dateParts[1]));
      monthInput.setEnabled(false); // �T�νs��
      
      dayInput.addItem(Integer.parseInt(dateParts[2]));
      dayInput.setSelectedItem(Integer.parseInt(dateParts[2]));
      dayInput.setEnabled(false); // �T�νs��   
      
      
 
    }
    

    //��k�G��s����ﶵ
    private void updateDays(){
        int year =(int)yearInput.getSelectedItem();
        int month =(int)monthInput.getSelectedItem();
        int daysInMonth;
        dayInput.removeAllItems();
        switch(month){//�P�_�Ӥ���Ѽ�
            case 2:
                if((year%4==0&&year%100!=0)||(year%400==0)){//�P�_�O�_���|�~
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
            dayInput.addItem(i);
        }
      }

    //��k�G�P�O��J�O�_�X�z
    private boolean validateInputs(String name,String id,String address,String tel,String secret){
      boolean isValid=true;
      
      // �]�mJOptionPane���r��j�p
      Font OPfont = new Font("�L�n������", Font.PLAIN, 18);
        UIManager.put("OptionPane.messageFont", OPfont);
        UIManager.put("OptionPane.buttonFont", OPfont);
        
      //�p�G�O�ŭȡA���ܻݿ�J���
      if(name.isEmpty()||id.isEmpty()||address.isEmpty()||tel.isEmpty()||secret.isEmpty()){
          JOptionPane.showMessageDialog(this, "��J�Ȥ��i����", "���~", JOptionPane.ERROR_MESSAGE);//�N�ϼг]�m�����~����
          isValid=false;
      }else{
        warning=Verification.verifyName(name);
        if(!warning.isEmpty()){
          JOptionPane.showMessageDialog(this, warning, "���~", JOptionPane.ERROR_MESSAGE);
          isValid=false;
        }else{
          warning=Verification.verifyID(id);
          if(!warning.isEmpty()){
            JOptionPane.showMessageDialog(this, warning, "���~", JOptionPane.ERROR_MESSAGE);
            isValid=false;
          }else{
            
            try(BufferedReader p=new BufferedReader(new FileReader("Patient.txt"))){
              StringTokenizer st;
              String input;  
              while((input=p.readLine())!=null){
                 
                    st=new StringTokenizer(input);
                    if (st.hasMoreTokens()) {
                      st.nextToken(); // ����
                      String getID=st.nextToken();
                      System.out.println(getID);
                      if(id.equals(getID)){
                        warning="�����Ҥw���U";
                        JOptionPane.showMessageDialog(this, warning, "���~", JOptionPane.ERROR_MESSAGE);
                        isValid=false;
                        break;
                      }
                    }
                }
            } catch (IOException ex) {
            }
            warning=Verification.verifyAddress(address);
            if(!warning.isEmpty()){
              JOptionPane.showMessageDialog(this, warning, "���~", JOptionPane.ERROR_MESSAGE);
              isValid=false;
            }else{
              warning=Verification.verifyTEL(tel);
              if(!warning.isEmpty()){
                JOptionPane.showMessageDialog(this, warning, "���~", JOptionPane.ERROR_MESSAGE);
                isValid=false;
              }else{
                warning=Verification.verifyBirth((int)yearInput.getSelectedItem()+"-"+(int)monthInput.getSelectedItem()+"-"+(int)dayInput.getSelectedItem());
                if(!warning.isEmpty()){
                  JOptionPane.showMessageDialog(this, warning, "���~", JOptionPane.ERROR_MESSAGE);
                  isValid=false;
                }else{
                  warning=Verification.verifySecret(secret);
                  if(!warning.isEmpty()){
                    JOptionPane.showMessageDialog(this, warning, "���~", JOptionPane.ERROR_MESSAGE);
                    isValid=false;
                  }
                }
              }

            }

          }  
      }
    }
    return isValid;
  }
    }
