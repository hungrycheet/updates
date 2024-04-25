package Functionalnterface;

public class Notes {
    String note;
    int tagId;

    public Notes( String note, int tagId) {
        this.note = note;
        this.tagId = tagId;
    }


    public String getTagName() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
