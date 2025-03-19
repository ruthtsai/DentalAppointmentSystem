
//�f�H(�����O) ��H���O
public abstract class Patient{
    private final String name,id,address,Tel,birthDate,secret;
    private final Detail detail;

    public Patient(String n, String id, String addr, String tel, String birth, String sec, Detail det) {
        name = n;
        this.id = id;
        address = addr;
        Tel = tel;
        birthDate = birth;
        secret = sec;
        detail = det;
    }
    public String getId() {
        return id;
    }
    public String getSecret() {
        return secret;
    }
    public String getName() {
        return name;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public String getAddress() {
        return address;
    }
    public String getTel() {
        return Tel;
    }
    public Detail getDetail(){
        return detail;
    }
    public String getDetailInfo() {
        return detail.showDetail();
    }

    //��H��k�A�Ω��~��
    public abstract String toString();
    
    public abstract int calculateCharge();
}
