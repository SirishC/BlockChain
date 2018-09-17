/**
 * BlockChain 01
 * Created by sirish on 05/08/18.
 */

// Main Class
import com.google.gson.GsonBuilder;
import java.util.*;
public class NoobChain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static boolean isCheck(){
        Block currentBlock;
        Block PreviousBlock;

        for(int i=1 ;i< blockchain.size();i++){
            currentBlock = blockchain.get(i);
            PreviousBlock = blockchain.get(i-1);
            if(!currentBlock.PreviousHash.equals(PreviousBlock.Hash)){
                return false;
            }
        }
     return  true;
    }
    public static void main(String []args){
        Scanner inp = new Scanner(System.in);
        blockchain.add(new Block("Genesis Block !","0"));
        char rep ='y';
        while(rep=='y') {
            System.out.println();
            System.out.println("THIS IS A BLOCKCHAIN : \n   (1)ADD A BLOCK IN TO A BLOCK CHAIN \n   (2)CHECK VALIDITIY OF THE BLOCK CHAIN \n   (3)DISPLAY THE BLOCK CHAIN \n   (4)DELETE A BLOCK \n   (5)MODIFY THE BLOCKCHAIN \n   (6)EXIT THE CHAIN ");
            System.out.print("      > ");
            int ch = inp.nextInt();
            String data;
            switch (ch) {
                case 1: {
                    System.out.println("ENTER THE MESSAGE : ");
                    inp.nextLine();
                    data = inp.nextLine();
                    blockchain.add(new Block(data, blockchain.get(blockchain.size() - 1).Hash));
                    break;
                }
                case 2: {
                    System.out.println("__________________________________________________________________________________________");
                    if (isCheck()) {
                        System.out.println("This Block is Not Hacked ! : ) \n Chain is Safe !");
                    } else {
                        System.out.println("Wanna Cry! :'( \n Chain is Broken !");
                    }
                    System.out.println("__________________________________________________________________________________________");
                    break;
                }
                case 3:{
                    System.out.println("__________________________________________________________________________________________");
                    String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
                    System.out.println(blockchainJson);
                    System.out.println("__________________________________________________________________________________________");
                    break;
                }
                case 4:{
                    if(blockchain.size()>1) {
                        blockchain.remove(blockchain.size() - 1);
                        System.out.println("__________________________________________________________________________________________");
                        System.out.println("THE LATEST BLOCK IS  REMOVED");
                        System.out.println("__________________________________________________________________________________________");
                    }
                    else
                    {
                        System.out.println("__________________________________________________________________________________________");
                        System.out.println("THE CHAIN IS EMPTY");
                        System.out.println("__________________________________________________________________________________________");
                    }
                    break;
                }
                case 5:{
                    System.out.println("THERE ARE "+(blockchain.size()-1)+" BLOCKS IN THE BLOCKCHAIN \n ENTER THE BLOCK NUMBER WHICH IS TO BE MODIFIED  ");
                    int index = inp.nextInt();
                    System.out.println("ENTER THE NEW MESSAGE :");
                    inp.next();
                    String Data = inp.nextLine();
                    Block NewBlock = new Block(Data,blockchain.get(index).Hash);
                    blockchain.set(index,NewBlock);
                    break;
                }
                case 6:{
                    rep='n';
                    break;
                }
                default: {
                    System.out.println("PLEASE ENTER THE VALID INPUT");
                }
            }
        }

    }
}
