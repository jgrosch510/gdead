
package com.mooseriver.gdead.Tables;

import com.mooseriver.gdead.Base.LocalDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author jgrosch
 */
public class SetList extends LocalDB {

    /**
     * 
     */
    private String keyName; 
    
    /**
     * 
     */
    private String artistName; 
    
    /**
     * 
     */
    private String artistKey; 
    
    /**
     * 
     */
    private String showsKey; 
    
    /**
     * 
     */
    private String showDate; 
    
    /**
     * 
     */
    private String venue; 
    
    /**
     * 
     */
    private String city; 
    
    /**
     * 
     */
    private String state; 
    
    /**
     * 
     */
    private String set1; 
    
    /**
     * 
     */
    private String set2; 
    
    /**
     * 
     */
    private String set3; 
    
    /**
     * 
     */
    private String encore; 
    
    /**
     * 
     */
    private String comment; 
    
    /**
     * 
     */
    private String lastUpdate; 
    
    /**
     * 
     */
    private String showYear; 
    
    /**
     * 
     */
    private String showMonth;
    
    /**
     * 
     */
    private String showDay;
    
    /**
     * 
     */
    private String showsUserId; 

    /**
     * 
     */
    public SetList() {
        super();
        
        // LocalDB
        this.tableName = "setlists";
        // recNum         -  int autoincrement
        // recId          - String
        // insertTime     - String
        // lastUpdateTime - String
        // active         - boolean
        // recStatus      - String
        // recVersion     - int
        
        this.keyName     = "";
        this.artistName  = ""; // Band
        this.artistKey   = "";
        this.showsKey    = "";
        this.showDate    = "";
        this.venue       = "";
        this.city        = "";
        this.state       = "";
        this.set1        = "";
        this.set2        = "";
        this.set3        = "";
        this.encore      = "";
        this.comment     = "";
        this.lastUpdate  = "";
        this.showYear    = "";
        this.showMonth   = "";
        this.showDay     = "";
        this.showsUserId = "";
    }

    /**
     * 
     * @param rs 
     */
    public SetList(ResultSet rs) {
        this();
        
        try {
            this.recNum       = rs.getInt("rec_num");
            this.recId        = rs.getString("rec_id");
            this.artistName   = rs.getString("band");
            this.artistKey    = rs.getString("artist_key");
            this.showsKey     = rs.getString("shows_key");
            this.showDate     = rs.getString("show_date");
            this.venue        = rs.getString("venue");
            this.city         = rs.getString("city");
            this.state        = rs.getString("state_abbr");
            this.comment      = rs.getString("comment");
            this.set1         = rs.getString("set_1");
            this.set2         = rs.getString("set_2");
            this.set3         = rs.getString("set_3");
            this.lastUpdate   = rs.getString("lastupdate");
            this.showYear     = rs.getString("showyear");
            this.showsUserId  = rs.getString("showsusedid");
            
            int k = 0;
        } catch (SQLException ex) {
            Logger.getLogger(SetList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param jObj 
     */
    public SetList(JSONObject jObj) {
        this();
        
        this.artistName   = (String)jObj.get("name");
        this.artistKey    = (String)jObj.get("artist_key");
        this.showsKey     = (String)jObj.get("shows_key");
        this.showDate     = (String)jObj.get("showdate");
        this.venue        = (String)jObj.get("venue");
        this.city         = (String)jObj.get("city");
        this.state        = (String)jObj.get("state");
        this.comment      = (String)jObj.get("comment");
        this.lastUpdate   = (String)jObj.get("lastupdate");
        this.showYear     = (String)jObj.get("showyear");
        this.showsUserId  = (String)jObj.get("showsusedid");
        
        if (this.showsUserId == null) {
            this.showsUserId = "";
        }
        
        JSONArray s1 = null;
        String tmpStr  = "";
        String tmpStr2 = "";
        
        for (int index = 1; index <= 3; index++) {
            String setName = String.format("set%d", index);
            Object obj = jObj.get(setName);
            if (obj.getClass() == JSONArray.class) {
                StringBuilder sb = new StringBuilder();
                s1 = (JSONArray) obj;
                Iterator it = s1.iterator();
                boolean firstTime = true; 
                while(it.hasNext()) {
                    if (firstTime) {
                        tmpStr = String.format("%s",(String) it.next());   
                        firstTime = false;
                    } else {
                        tmpStr = String.format(", %s",(String) it.next());   
                    }
                    sb.append(tmpStr);
                }
            tmpStr2 = sb.toString();
            } else if (obj.getClass() == String.class) {
                tmpStr2 = (String) obj;
            }
            
            switch (index) {
                case 1:
                    this.set1 = tmpStr2;
                    break;
                case 2:
                    this.set2 = tmpStr2;
                    break;
                case 3:
                    this.set3 = tmpStr2;
                    break;
                default:
                    break;
            }   // End of switch
        }   // End of for loop
        
        
        return;
    }   // End of constructor JSONObject
    
    /**
     * 
     * @return 
     */
    public String getKeyName() {
        return this.keyName;
    }

    /**
     * 
     * @return 
     */
    public String getArtistName() {
        return this.artistName;
    }

    /**
     * 
     * @return 
     */
    public String getArtistKey() {
        return this.artistKey;
    }

    public String getShowsKey() {
        return this.showsKey;
    }

    public String getShowDate() {
        return this.showDate;
    }

    public String getVenue() {
        return this.venue;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getSet1() {
        return this.set1;
    }

    public String getSet2() {
        return this.set2;
    }

    public String getSet3() {
        return this.set3;
    }

    public String getEncore() {
        return this.encore;
    }

    public String getComment() {
        return this.comment;
    }

    public String getLastUpdate() {
        return this.lastUpdate;
    }

    public String getShowYear() {
        return this.showYear;
    }

    public String getShowsUserId() {
        return this.showsUserId;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setArtistKey(String artistKey) {
        this.artistKey = artistKey;
    }

    public void setShowsKey(String showsKey) {
        this.showsKey = showsKey;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setSet1(String set1) {
        this.set1 = set1;
    }

    public void setSet2(String set2) {
        this.set2 = set2;
    }

    public void setSet3(String set3) {
        this.set3 = set3;
    }

    public void setEncore(String encore) {
        this.encore = encore;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setShowYear(String showYear) {
        this.showYear = showYear;
    }

    public void setShowsUserId(String showsUserId) {
        this.showsUserId = showsUserId;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toInsertString() {
        StringBuilder sb = new StringBuilder();
        
        return sb.toString();
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toUpdateString() {
        StringBuilder sb = new StringBuilder();
        
        return sb.toString();    }

    /**
     * 
     * @return 
     */
    @Override
    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        
        return sb.toString();    }

    /**
     * 
     * @return 
     */
    @Override
    public String toSQL() {
        StringBuilder sb = new StringBuilder();
        
        return sb.toString();    }

    /**
     * 
     * @return 
     */
    @Override
    public String dumpDbRecord() {
        StringBuilder sb = new StringBuilder();
        
        return sb.toString();    }
    
}
