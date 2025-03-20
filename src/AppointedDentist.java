//�w�����(�~��Dentist)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AppointedDentist extends Dentist{
    
    //�R���w��������k
    public void deleteAppointedPatient(String ID,String therapy, String dentist, String time){
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
                        if(getRegister.equals("Appointed")){
                            String getSpeciality=st.nextToken();
                            String getDentist=st.nextToken();
                            String getTime=st.nextToken()+"�~"+st.nextToken()+"��"+st.nextToken()+"��"+st.nextToken();
                            // �p�G���ǰt���O���A���L�Ӧ�]�Y�R���Ӧ�^
                            if(getSpeciality.equals(therapy)&&getDentist.equals(dentist)&&getTime.equals(time)){
                                continue;
                            }
                        }                        
                    }
                }
                lines.add(input);//�N���x�s����ƼȦs��lines��
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
        //�}�ҥD�n�e��
        BasicInfoPage BIP=new BasicInfoPage();
        BIP.setVisible(true);
        
    }
    
    //�ק�w��������k�G�G�q�ɮפ��R���ŦX���w ID�B�v�����ءB��ͩM�ɶ��A�M�᭫�s�g�^��l���O���C�}�ҹw���e��
    public void modifyAppointedPatient(String ID,String therapy, String dentist, String time){
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
                        if(getRegister.equals("Appointed")){
                            String getSpeciality=st.nextToken();
                            String getDentist=st.nextToken();
                            String getTime=st.nextToken()+"�~"+st.nextToken()+"��"+st.nextToken()+"��"+st.nextToken();
                            // �p�G���ǰt���O���A���L�Ӧ�]�Y�R���Ӧ�^
                            if(getSpeciality.equals(therapy)&&getDentist.equals(dentist)&&getTime.equals(time)){
                                continue;
                            }
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
        //�}�ҹw���e��
        AppointedPage AP = new AppointedPage();
        AP.setVisible(true);
        AP.modify();
    }
    public void deleteOn_sitePatient(String ID,String therapy,String dentist){}
    public void modifyOn_sitePatient(String ID,String theray,String denist){}
    
}
