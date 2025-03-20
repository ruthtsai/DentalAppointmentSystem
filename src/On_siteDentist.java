
//�{�����(�~��Dentist)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class On_siteDentist extends Dentist{
    
    //�ק��k�G�q�ɮפ��R���ŦX���w ID�B�v�����ء]therapy�^�M��͡]dentist�^���O���A�M�᭫�s�g�^��l���O���C�åB�}�Ҳ{���������ϥΪ̭��s����
    public void modifyOn_sitePatient(String ID,String therapy,String dentist){
        ArrayList<String> lines=new ArrayList<>();
        try(BufferedReader p=new BufferedReader(new FileReader("Register.txt"))){
            String input;
            // �q�ɮפ��v��Ū��
            while((input=p.readLine())!=null){
                StringTokenizer st=new StringTokenizer(input," ");
                if(st.hasMoreTokens()){
                    String getID=st.nextToken();
                    if(getID.equals(ID)){
                        String getRegister=st.nextToken();
                        String getSpeciality=st.nextToken();
                        String getDentist=st.nextToken();
                        // �p�G���ǰt���O���A���L�Ӧ�]�Y�R���Ӧ�^
                        if(getRegister.equals("On_site")&&getSpeciality.equals(therapy)&&getDentist.equals(dentist)){
                            continue;
                        }
                    }
                }
                lines.add(input);
            }
        }catch(IOException c){
            System.out.println("���Ū�����~");
        }

        try(PrintWriter pw=new PrintWriter(new FileWriter("Register.txt"))){
            for(String line:lines){
                pw.println(line);
            }
        }catch(IOException e){
            System.out.println("��Ƽg�J���~");
        }
        On_sitePage OP=new On_sitePage();
        OP.setVisible(true);
        OP.modify();
    }
    
    //�R����k
    public void deleteOn_sitePatient(String ID,String therapy,String dentist){
        //�Ȧs�D�R����ƪ��ƾ�
        ArrayList<String> lines=new ArrayList<>();

        // �ϥ� try-with-resources Ū���ɮסA�T�O�۰����� BufferedReader
        try(BufferedReader p=new BufferedReader(new FileReader("Register.txt"))){
            String input;
            while((input=p.readLine())!=null){
                StringTokenizer st=new StringTokenizer(input," ");
                if(st.hasMoreTokens()){
                    String getID=st.nextToken();
                    if(getID.equals(ID)){
                        String getRegister=st.nextToken();
                        String getSpeciality=st.nextToken();
                        String getDentist=st.nextToken();
                        if(getRegister.equals("On_site")&&getSpeciality.equals(therapy)&&getDentist.equals(dentist)){
                            continue;
                        }
                    }
                }
                lines.add(input);
            }
        }catch(IOException c){
            System.out.println("���Ū�����~");
        }

        // �ϥ� try-with-resources �g�J�ɮסA�T�O�۰����� PrintWriter
        try(PrintWriter pw=new PrintWriter(new FileWriter("Register.txt"))){
            for(String line:lines){
                pw.println(line);
            }
        }catch(IOException e){
            System.out.println("��Ƽg�J���~");
        }
        BasicInfoPage BIP=new BasicInfoPage();
        BIP.setVisible(true);
    }
    public void addAppointedDentist(String time,String ID){}
    public void modifyAppointedPatient(String ID,String selectedTherapyOutput, String selectedDentistOutput, String selectedTimeOutput){}
    public void deleteAppointedPatient(String ID,String selectedTherapyOutput, String selectedDentistOutput, String selectedTimeOutput){}
}
