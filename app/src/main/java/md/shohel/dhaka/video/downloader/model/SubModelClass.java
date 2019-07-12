package md.shohel.dhaka.video.downloader.model;

public class SubModelClass {
    private String thumbnailUrl;
    private String targetUrl;

    public SubModelClass(){

    }


    public SubModelClass(String thumbnailUrl, String targetUrl) {
        this.thumbnailUrl = thumbnailUrl;
        this.targetUrl = targetUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
}
