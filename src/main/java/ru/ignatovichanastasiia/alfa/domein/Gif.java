/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.ignatovichanastasiia.alfa.domein;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ignatovichanastasiia 
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
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

//bitly_url: string
//The unique bit.ly URL for this GIF	"http://gph.is/1gsWDcL"
//embed_url: string
//A URL used for embedding this GIF	"http://giphy.com/embed/YsTs5ltWtEhnq"
//username: string
//The username this GIF is attached to, if applicable	"JoeCool4000"
//source: string
//The page on which this GIF was found	"http://www.reddit.com/r/reactiongifs/comments/1xpyaa/superman_goes_to_hollywood/"
//rating: string
//The MPAA-style rating for this content. Examples include Y, G, PG, PG-13 and R	"g"
//content_url: string
//Currently unused	
//user: User
//An object containing data about the user associated with this GIF, if applicable.	
//source_tld: string
//The top level domain of the source URL.	"cheezburger.com"
//source_post_url: string
//The URL of the webpage on which this GIF was found.	"http://cheezburger.com/5282328320"
//update_datetime: string
//The date on which this GIF was last updated.	"2013-08-01 12:41:48"
//create_datetime: string
//The date this GIF was added to the GIPHY database.	"2013-08-01 12:41:48"
//import_datetime: string
//The creation or upload date from this GIF's source.	"2013-08-01 12:41:48"
//trending_datetime: string
//The date on which this gif was marked trending, if applicable.	"2013-08-01 12:41:48"
//images: Images
//An object containing data for various available formats and sizes of this GIF.	
//title: string
//The title that appears on giphy.com for this GIF.	"Happy Dancing GIF"
    
}
