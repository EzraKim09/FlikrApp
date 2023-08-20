package kim.com.example.gdscappdtask;

public class Recycler {
    String imageName;
    String authorName;
    String dateSubmit;
    //String story;
    int img;

    public Recycler(String imageName, String authorName, String dateSubmitted, int img) {
        this.imageName = imageName;
        this.authorName = authorName;
        this.dateSubmit = dateSubmitted;
        this.img = img;
        //this.story = (story != null) ? story : "";
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(String dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

//    public String getStory() {
//        return story;
//    }
//
//    public void setStory(String story) {
//        this.story = story;
//    }
}
