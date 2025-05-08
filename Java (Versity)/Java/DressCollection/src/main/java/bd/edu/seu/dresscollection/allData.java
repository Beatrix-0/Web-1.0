package bd.edu.seu.dresscollection;

import javafx.scene.image.Image;

public class allData {
    private String name;
    private String type ;
    private String color;
    private String price;
    private String date ;
    private String quantity;
    private String boost ;
     private String size ;
     private String details;
     private String customer;
    private String coupon;
    private Image image;

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

     public String getCoupun() {
         return coupon;
     }
     public void setCoupun(String coupon) {
         this.coupon = coupon;
     }


     public String getSize() {
         return size;
     }
     public void setSize(String size) {
         this.size = size;
     }

     public String getDetails() {
         return details;
     }

     public void setDetails(String details) {
         this.details = details;
     }

     public String getCustomer() {
         return customer;
     }

     public void setCustomer(String customer) {
         this.customer = customer;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBoost() {
        return boost;
    }

    public void setBoost(String boost) {
        this.boost = boost;
    }

    allData(String name,String type,String color,String price,String date,String quantity,String boost , String size,String details,String customer , String coupon , Image image) {
        this.name=name;
        this.type=type;
        this.color=color;
        this.price=price;
        this.date=date;
        this.quantity=quantity;
        this.boost=boost;
        this.size=size;
        this.details=details;
        this.customer=customer;
        this.coupon=coupon;
        this.image=image;

    }
}
