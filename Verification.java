import java.util.Calendar;
public class Verification{
    static public String verifyName(String name){
         String specialChars = "_'~!@#$%^&*()+={}':;',[]";//�S��r��
        if(name.length()<2){
            return "�m�W���פ��i�p��2";
        }
        else if(name.length()>10){
            return "�m�W���פ��i�j��10";
        }
        else{ 
            for (int i = 0; i < name.length(); i++) {
              if (specialChars.contains(String.valueOf(name.charAt(i)))) {
                return "�m�W�u��]�t����B�^��r�ũM - �Ÿ�";
              }
            }
        }
        return "";
    }
    static public String verifyID(String ID){
        char firstChar=ID.charAt(0);
        if(ID.length()!=10){
            return "�����Ҫ��׶���10";
        }
        //�ˬd�����Ҹ��X���Ĥ@�Ӧr���O�_���j�g�r��
        else if(!Character.isLetter(firstChar)||!Character.isUpperCase(firstChar)){
            return "�����Ү榡���~�A�Э��s��J";
        }
        else if (ID.charAt(1) != '1' && ID.charAt(1) != '2') {//�ˬd�Ĥ@�X�Ʀr�O�_��1��2
            return "�����Ү榡���~�A�Э��s��J";
        }
        else {
            for(int i=2;i<=9;i++){
                if(!Character.isDigit(ID.charAt(i))){
                    return "��E�X�ݬ��Ʀr�A�Э��s��J";
                }
            }
        }
        return "";
    }
    static public String verifyAddress(String address){
        String specialChars = "_'~!@#$%^&*()+={}':;',[]"; // �S��r��
        if (!address.contains("��") && !address.contains("��")) {
          return "�a�}�榡��J���~�A�Х]�t��/��";
        } else {
          for (int i = 0; i < address.length(); i++) {
            if (specialChars.contains(String.valueOf(address.charAt(i)))) {
                return "�a�}���i�]�t�S��r��";
            }
          }
        }
    return "";
    }
    static public String verifyTEL(String TEL){
        if(TEL.length()!=10){
            return "�q�ܸ��X��J���~�A�Э��s��J";
        }
        else if (!TEL.substring(0, 2).equals("09")) {
            return "��J�ȶ���������X";
        }
        return "";
    }
    static public String verifyBirth(String birth){
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        String[] Date=birth.split("-");
        int birthYear=Integer.parseInt(Date[0]);
        int birthMonth=Integer.parseInt(Date[1]);
        int birthDay=Integer.parseInt(Date[2]);
        if(birthYear>year){
            return "�Фſ�ܥ��Ӥ���A�Э��s��J";
        }
        else if(birthYear==year&&birthMonth>month){
            return "�Фſ�ܥ��Ӥ���A�Э��s��J";
        }
        else if(birthYear==year&&birthMonth==month&&birthDay>day){
            return "�Фſ�ܥ��Ӥ���A�Э��s��J";
            
        }
        return "";
    }
    static public String verifyAppointed(int y, int m, int d){
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        if(y==year && m<month){
            return "����w�L�A�Э��s��J";
        }
        else if(y==year && m<=month && d<=day){
            return "����w�L�A�Э��s��J";
        }
        return "";
    }
    static public String verifySecret(String secret){
        if(secret.equals("")){
            return "�п�J�K�X";
        // �ϥΥ��h��F���ˬd�K�X�O�_�ŦX�n�D
        }else if (!secret.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d{4,}).*$")) {
            //^ �M $�G���O�ǰt�r�ꪺ�}�l�M�����C
            //(?=.*[A-Z])�G�ˬd�r�ꤤ�O�_�ܤ֥]�t�@�Ӥj�g�r���C
            //(?=.*[a-z])�G�ˬd�r�ꤤ�O�_�ܤ֥]�t�@�Ӥp�g�r��
            //(?=.*\\d{4,})�G�ˬd�r�ꤤ�O�_�ܤ֥]�t�|�ӼƦr
            return "�K�X�����]�t�ܤ֤@�Ӥj�g�^��B�@�Ӥp�g�^��M�|��Ʀr";
        }
        return "";
    }
}
