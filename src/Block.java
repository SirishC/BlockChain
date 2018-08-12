/**
 * BlockChain 01
 * Created by Sirish on 05/08/18.
 */

//Block Class
import java.util.Date;
    public class Block {
    public String Hash;
    public String PreviousHash;
    private String Data ;
    private long TimeStamp;


    public Block(String Data, String PreviousHash){
        this.Data=Data;
        this.PreviousHash = PreviousHash;
        this.TimeStamp = new Date().getTime();
        this.Hash = calculateHash();
    }
    public String calculateHash(){
        String calculatehash = StringUtil.applySha256(Data+PreviousHash+TimeStamp);
        return calculatehash;

    }
}
