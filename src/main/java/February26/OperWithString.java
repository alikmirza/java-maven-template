package February26;

public class OperWithString extends Filterable {
    @Override
    public String filter(String origin){
        char c;
        final String VOW="AEUIO";
        final String vow=VOW.toLowerCase();
        StringBuilder stringBuilder=new StringBuilder();
        String temp;
        for (int i = 0; i <origin.length(); i++) {
            if (vow.contains(String.valueOf(origin.charAt(i)))){
                temp=String.valueOf(origin.charAt(i));
                origin=origin.replaceAll(temp,"1");
            }
        }
        return origin.replaceAll("1","");
    }


}
