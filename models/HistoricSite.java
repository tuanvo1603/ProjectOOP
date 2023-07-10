package models;

import java.util.ArrayList;

public class HistoricSite {
    private String note;
    private String historicSite;
    private String relatedFestival;
    private String location;
    private ArrayList<String> relatedThings;
    private String approvedYear;
    private String describe;
    private String type;

    public String getNote() {
        return note;
    }

    public HistoricSite(String historicSite, String location, String type, String approvedYear,
			String describe, String note, ArrayList<String> relatedThings, String relatedFestival) {
		super();
		this.note = note;
		this.historicSite = historicSite;
		this.relatedFestival = relatedFestival;
		this.location = location;
		this.relatedThings = relatedThings;
		this.approvedYear = approvedYear;
		this.describe = describe;
		this.type = type;
	}

	public void setNote(String note) {
        this.note = note;
    }

    public String getHistoricSite() {
        return historicSite;
    }

    public void setHistoricSite(String historicSite) {
        this.historicSite = historicSite;
    }

    public String getRelatedFestival() {
        return relatedFestival;
    }

    public void setRelatedFestival(String relatedFestival) {
        this.relatedFestival = relatedFestival;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getRelatedThings() {
        return relatedThings;
    }

    public void setRelatedThings(ArrayList<String> relatedThings) {
        this.relatedThings = relatedThings;
    }

    public String getApprovedYear() {
        return approvedYear;
    }

    public void setApprovedYear(String approvedYear) {
        this.approvedYear = approvedYear;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}

