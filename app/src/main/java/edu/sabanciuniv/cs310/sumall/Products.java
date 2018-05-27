package edu.sabanciuniv.cs310.sumall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.transform.Result;

public class Products {

    private int productID;
    private String productName;
    private String description;
    private String brandName;
    private int quantity;
    private double price;
    private Blob image; // Use getBitmap method to get Bitmap type of this image.
    private Connection DbConn;
    private int imageID;



    Products(int id) throws SQLException, ClassNotFoundException {
        DbManager myDbManager = new DbManager();
        this.DbConn = myDbManager.getDbConn();
        setProductID(id);

        PreparedStatement ps = this.DbConn.prepareStatement("SELECT * FROM  products p WHERE (p.ProductID = "+id + ")");
        ResultSet result = ps.executeQuery();
        result.next();

        setProductName(result.getString("ProductName"));
        setDescription(result.getString("Description"));
        setBrandName(result.getString("BrandName"));
        setQuantity(result.getInt("Quantitiy"));
        setPrice(result.getDouble("price"));
        setImageID(result.getInt("ProductImageID"));

        setImage();





    }
    private void setImage() throws SQLException{
        PreparedStatement ps = this.DbConn.prepareStatement("SELECT I.Image FROM productimage I WHERE (I.ImageID = "+this.getImageID() + ")");
        ResultSet result = ps.executeQuery();
        result.next();
        this.setImage(result.getBlob(1));

    }
    public Bitmap getBitmap ()throws SQLException{
        return this.blobToBitmap(this.getImage());
    }
    public Bitmap blobToBitmap(Blob blob)throws SQLException{
        return this.byteToBitmap(this.blobToByte(blob));

    }
    public byte [] blobToByte(Blob blob) throws SQLException{
        return  blob.getBytes(1,(int)blob.length());
    }
    public Bitmap byteToBitmap(byte[] bytes){
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

    }
    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Connection getDbConn() {
        return DbConn;
    }

    public void setDbConn(Connection dbConn) {
        DbConn = dbConn;
    }






    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
