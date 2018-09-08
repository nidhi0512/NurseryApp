package in.co.whiznet.nurseryapp;


import java.io.Serializable;

public class QuizModal implements Serializable {
    private String alphabet;
    private TextModal image1;
    private TextModal image2;
    private TextModal image3;
    private TextModal image4;
    private TextModal trueans;

    public QuizModal() {
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public TextModal getImage1() {
        return image1;
    }

    public void setImage1(TextModal image1) {
        this.image1 = image1;
    }

    public TextModal getImage2() {
        return image2;
    }

    public void setImage2(TextModal image2) {
        this.image2 = image2;
    }

    public TextModal getImage3() {
        return image3;
    }

    public void setImage3(TextModal image3) {
        this.image3 = image3;
    }

    public TextModal getImage4() {
        return image4;
    }

    public void setImage4(TextModal image4) {
        this.image4 = image4;
    }

    public TextModal getTrueans() {
        return trueans;
    }

    public void setTrueans(TextModal trueans) {
        this.trueans = trueans;
    }

    public QuizModal(String alphabet, TextModal image1, TextModal image2, TextModal image3, TextModal image4, TextModal trueans) {

        this.alphabet = alphabet;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.trueans = trueans;
    }
}