/**
 * Created by Nigel on 6/16/16.
 */
public class Item {
    private String name;
    private int id;
    private int price;
    private int quantity;

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public int getPrice(){
        return this.price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}

