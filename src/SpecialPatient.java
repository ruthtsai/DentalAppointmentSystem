//�S��f�H(�~�ӯf�H)�A�����O�P���O�����t���B���P
public class SpecialPatient extends Patient {
  private static final int COPAYFEE=0;//�����O
  private static final int HEALTHPREMIUM=50;//���O�O
  
  public SpecialPatient(String n, String id, String addr, String tel, String birth, String sec, Detail det) { 
    super(n,id,addr,tel,birth,sec,det);
  }
  
   // Accessors
  public static int getCopayFee() {
    return COPAYFEE;
  }

  public static int getHealthPremium() {
    return HEALTHPREMIUM;
  }
  public int calculateCharge() {
    return COPAYFEE + HEALTHPREMIUM;
  }
    public String toString(){
    return "s "+getId()+" "+getSecret()+" "+getName()+
      " "+getBirthDate()+" "+getAddress()+" "+getTel()+" "+getDetailInfo();
  }
}
