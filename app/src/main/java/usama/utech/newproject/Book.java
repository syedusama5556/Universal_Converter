package usama.utech.newproject;

/**
 * Created by Aws on 28/01/2018.
 */

public class Book {

    private String Title;

    private int Thumbnail;

    public Book() {
    }

    public Book(String title, int thumbnail) {

        Title = title;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
