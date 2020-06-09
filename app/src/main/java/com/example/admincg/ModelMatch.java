package com.example.admincg;

public class ModelMatch {
    String image,match_no,type,id,pass,date,time,prize,per_kill,entry,mode,map,uid,is_full;
    boolean live;

    public ModelMatch(boolean live) {
        this.live = live;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public ModelMatch() {
    }

    public ModelMatch(String image, String match_no, String type, String id, String pass, String date, String time, String prize, String per_kill, String entry, String mode, String live, String map, String uid, String is_full) {
        this.image = image;
        this.match_no = match_no;
        this.type = type;
        this.id = id;
        this.pass = pass;
        this.date = date;
        this.time = time;
        this.prize = prize;
        this.per_kill = per_kill;
        this.entry = entry;
        this.mode = mode;
        this.map = map;
        this.uid = uid;
        this.is_full = is_full;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMatch_no() {
        return match_no;
    }

    public void setMatch_no(String match_no) {
        this.match_no = match_no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getPer_kill() {
        return per_kill;
    }

    public void setPer_kill(String per_kill) {
        this.per_kill = per_kill;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }



    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIs_full() {
        return is_full;
    }

    public void setIs_full(String is_full) {
        this.is_full = is_full;
    }
}
