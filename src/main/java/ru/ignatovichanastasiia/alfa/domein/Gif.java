/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.ignatovichanastasiia.alfa.domein;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *
 * @author ignatovichanastasiia 
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Gif {    
    
    private String type;
    private String id;
    private String slut;
    private String url;
    @SerializedName("bitly_url")
    private String bitlyUrl;
    @SerializedName("embed_url")
    private String embedUrl;
    private String username;
    private String sourse;
    private String rating;
    @SerializedName ("content_url")
    private String contentUrl;
//    private Object User;
    @SerializedName ("source_tld")
    private String sourseTld;
    @SerializedName ("source_post_url")
    private String sourcePostUrl;
    @SerializedName ("update_datetime")
    private String updateDatetime;
    @SerializedName ("create_datetime")
    private String createDatetime;
    @SerializedName ("import_datetime")
    private String importDatetime;
    @SerializedName ("trending_datetime")
    private String trendingDatetime;
//    private Object images;
    private String title;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getSlut() {
        return slut;
    }

    public String getUrl() {
        return url;
    }

    public String getBitlyUrl() {
        return bitlyUrl;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getSourse() {
        return sourse;
    }

    public String getRating() {
        return rating;
    }

    public String getContentUrl() {
        return contentUrl;
    }

//    public Object getUser() {
//        return User;
//    }

    public String getSourseTld() {
        return sourseTld;
    }

    public String getSourcePostUrl() {
        return sourcePostUrl;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public String getImportDatetime() {
        return importDatetime;
    }

    public String getTrendingDatetime() {
        return trendingDatetime;
    }

//    public Object getImages() {
//        return images;
//    }

    public String getTitle() {
        return title;
    }
}

