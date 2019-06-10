package gif.ganesh.pushnotififirebase.imagestoring;

public class StoringsModel
{
    String name,imageUri;

    public StoringsModel()
    {
    }

    public StoringsModel(String name, String imageUri)
    {
        this.name = name;
        this.imageUri = imageUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
