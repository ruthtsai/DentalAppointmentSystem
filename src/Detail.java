
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Detail{
    private final LinkedHashMap<String,Boolean> detailLinkedHashMap;

    public Detail(){
        detailLinkedHashMap = new LinkedHashMap<>();
         // �N�w�]�����إ[�J LinkedHashMap ���A�C�Ӷ��عw�]�Ȭ� false
        add("�O�_���S����(�a���B����)");
        add("�Ī��L�Ӥ���");
        add("���Ĥ��}����");
        add("�~�˦�y����");
        add("�j�˯������M");
        add("�����~�F���g");
        add("�����ޤ��x��");
        add("�W�E�u�����D");
        add("��ҡB�ܰs�B�b�}");
        add("������");
        add("��Ŧ�f�B�����");
        add("�}���f�B���n�f");
        add("�xŦ�f�B��Ŧ�f");
        add("�͵���");
        add("����v����");
        add("���貨�P�Ī�");
    }

    // �s�W���ب� detailLinkedHashMap ���A�w�]�Ȭ� false
    public void add(String key){
        detailLinkedHashMap.put(key,false);
    }

    //�]�m�S�w key ���Ȭ� value�A�ê�^���e����
    public Boolean setDetail(String key,boolean value){
        return detailLinkedHashMap.replace(key,value);
    }

    // ����S�w key ����
    public Boolean getDetail(String key){
        return detailLinkedHashMap.get(key);
    }

    // ����Ҧ� key�A�ê�^�@�ӥ]�t�o�� key �� ArrayList
    public ArrayList<String> getKeys(){
        return new ArrayList<>(detailLinkedHashMap.keySet());
    }

    // �H�r��Φ���� detailLinkedHashMap ���Ҧ� key �M��������
    public String showDetail(){
        StringBuilder details = new StringBuilder();//StringBuilder �O�إߩM�ק�r�ꪺ���O �� String �󰪮�
        // �M�� detailLinkedHashMap ���C�� key
        //�إߤ@�ӭ��N���]Iterator�^�CkeySet() ��k��^�@�ӥ]�t�Ҧ��䪺 Set�Aiterator() ��k�h��^�o�Ӷ��X�����N���C
        Iterator<String>st1 = detailLinkedHashMap.keySet().iterator();
        while (st1.hasNext()){
            String key = st1.next();
            // �p�G key ���Ȭ� true�A��� "yes"�A�_�h��� "no"
            if(detailLinkedHashMap.get(key)==true){
                details.append(key).append(":yes ");
            }
            else{
                details.append(key).append(":no ");
            }
        }
        return details.toString();
    }
}
