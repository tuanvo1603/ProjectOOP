package models;

public class Festival {
    private String date;
    private String note;
    private String festival;
    private String location;
    private String relatedFigures;
    private String first;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Festival(String date, String note, String festival, String location, String relatedFigures, String first) {
		super();
		this.date = date;
		this.note = note;
		this.festival = festival;
		this.location = location;
		this.relatedFigures = relatedFigures;
		this.first = first;
	}

	public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFestival() {
        return festival;
    }

    public void setFestival(String festival) {
        this.festival = festival;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRelatedFigures() {
        return relatedFigures;
    }

    public void setRelatedFigures(String relatedFigures) {
        this.relatedFigures = relatedFigures;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }
}
