package com.example.top10downloader;

public class FeedEntry {
    private String title;
    private String description;
    private String episodeType;
    private String summary;
    private String imageURL;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEpisodeType() {
        return episodeType;
    }

    public void setEpisodeType(String episodeType) {
        this.episodeType = episodeType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return  "title=" + title + '\n' +
                ", description=" + description + '\n' +
                ", episodeType=" + episodeType + '\n' +
                ", imageURL=" + imageURL.toString() + '\n';
    }
}
