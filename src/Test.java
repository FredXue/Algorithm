import org.apache.commons.codec.binary.Base64;

public class Test{
    
    public static void main(String[] args){

        long unixTime = System.currentTimeMillis();
        long preTime = unixTime-1111;
        String rawString = preTime + "1111" + unixTime;
        
        byte[] encoded = Base64.encodeBase64(rawString);
        String encodedString = new String(encoded);
        
        System.out.println(encodedString);
    }
}