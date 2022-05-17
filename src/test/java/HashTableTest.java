import Hash.MyHashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashTableTest {
    MyHashTable myHashTable;
    String answer = "<HashTable[<Hash.Item(2,2)>,<Hash.Item(4,656)>,<Hash.Item(5,890)>,<Hash.Item(6,2)>,<Hash.Item(7,253)><Hash.Item(1,1)>]>";


    @BeforeEach
    public void init(){
        myHashTable = new MyHashTable(10);
    }

    @Test
    public void test1(){
        myHashTable.put("1", 1);
        myHashTable.put("2", 2);
        myHashTable.put("4", 656);
        myHashTable.put("5", 890);
        myHashTable.put("6", 2);
        myHashTable.put("7", 253);
        Assertions.assertEquals(answer, myHashTable.toString());
    }

    @Test
    public void test2(){
        myHashTable.put("1", 1);
        myHashTable.put("2", 2);
        myHashTable.put("4", 656);
        myHashTable.put("5", 890);
        myHashTable.put("6", 2);
        myHashTable.put("7", 253);

        Assertions.assertEquals(myHashTable.get("4"), 656);
    }

    @Test
    public void test3(){
        myHashTable.put("1", 1);
        myHashTable.put("2", 2);
        myHashTable.put("4", 656);
        myHashTable.put("5", 890);
        myHashTable.put("6", 2);
        myHashTable.put("7", 253);

        Assertions.assertEquals(myHashTable.size(), 6);
    }

    @Test
    public void test4(){
        myHashTable.put("1", 1);
        myHashTable.put("2", 2);
        myHashTable.put("4", 656);
        myHashTable.put("5", 890);
        myHashTable.put("6", 2);
        myHashTable.put("7", 253);
        myHashTable.put("8", 253);

        myHashTable.remove("8");

        Assertions.assertEquals(answer, myHashTable.toString());
    }
}
