package mx.edu.utng.pruebasdesoftwares.model;

/**
 * Created by Luis Grimaldo Robles on 05/02/2016.
 */
public class ItemSlideMenu {
    private int imgId;
    private String title;

    public ItemSlideMenu(int imgId, String title){
        this.imgId = imgId;
        this.title = title;
    }

    public int getImgId() {
        return imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
