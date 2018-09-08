package in.co.whiznet.nurseryapp;

import java.io.Serializable;

/**
 * Created by whiznet on 12/2/18.
 */

public class TextModal implements Serializable{
    private int images;
   private String text;

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextModal() {

    }

    public TextModal(int images, String text) {

        this.images = images;
        this.text = text;
    }
}
