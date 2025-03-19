//�ѰO�K�X�ɴ��ܭ���
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ReviewPage extends JFrame{
    private final Container cp;
    private final JLabel IDLabel,IDInput,secretLabel,secretInput;
    private final JButton backToStartPage;
    
    public ReviewPage(){
        setTitle("���Ҧ��\");
        setSize(500, 500);
        setLocationRelativeTo(null);//�}�Ҥ�������ܩ����������
        cp=getContentPane();
        cp.setLayout(new GridBagLayout());
        GridBagConstraints g=new GridBagConstraints();
        g.insets=new Insets(5,5,5,5);

        // �Τ@�r��
        Font labelFont = new Font("�L�n������", Font.PLAIN, 30);
        
        IDLabel=new JLabel("������");
        IDLabel.setFont(labelFont);
        g.gridx=0;
        g.gridy=0;
        g.gridwidth=1;
        cp.add(IDLabel,g);
        IDInput=new JLabel("\t");
        IDInput.setFont(labelFont);
        g.gridx=1;
        g.gridy=1;
        g.gridwidth=1;
        g.fill=GridBagConstraints.BOTH;
        cp.add(IDInput,g);
        
        secretLabel=new JLabel("�K�X");
        secretLabel.setFont(labelFont);
        g.gridx=0;
        g.gridy=2;
        g.gridwidth=1;
        cp.add(secretLabel,g);
        secretInput=new JLabel("\t");
        secretInput.setFont(labelFont);
        g.gridx=1;
        g.gridy=3;
        g.gridwidth=1;
        g.fill=GridBagConstraints.BOTH;
        cp.add(secretInput,g);
        backToStartPage=new JButton("�^��n�J");
        backToStartPage.setFont(labelFont);
        g.gridx=1;
        g.gridy=5;
        g.gridwidth=1;
        cp.add(backToStartPage,g);

        try(BufferedReader p=new BufferedReader(new FileReader("Patient.txt"))){
            String input;
            StringTokenizer st;
            while((input=p.readLine())!=null){
                st=new StringTokenizer(input);
                st.nextToken();//����
                String ID=st.nextToken();//������
                String secret=st.nextToken();//�K�X
                if(ID.equals(AuthenticationPage.ID)){
                    IDInput.setText(ID);
                    secretInput.setText(secret);
                    break;
                }
            }
        } catch(IOException c){
            System.out.println("���Ū�����~");
            System.exit(-2);
        }
        // ���U���s�ƥ�
        backToStartPage.addActionListener(new BackToStartPageButtonHandler());
        
    }
    
    //�^��n�J��
    private class BackToStartPageButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e){
        dispose();
      }
    }
       
}
