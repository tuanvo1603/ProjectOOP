package models;

import java.util.ArrayList;

public class HistoricalFigure {
    private String name;
    private String realName;
    private ArrayList<String> altername;
    private String birth;
    private String lost;
    private String position;
    private String workTime;
    private String era;
    
    public HistoricalFigure(String name, String realName, ArrayList<String> altername, String birth, String lost,
			String position, String workTime, String era, String father, String mother, String preceded,
			String succeeded) {
		super();
		this.name = name;
		this.realName = realName;
		this.altername = altername;
		this.birth = birth;
		this.lost = lost;
		this.position = position;
		this.workTime = workTime;
		this.era = era;
		this.father = father;
		this.mother = mother;
		this.preceded = preceded;
		this.succeeded = succeeded;
	}

	private String father;
    private String mother;
    private String preceded;
    private String succeeded;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public ArrayList<String> getAlternameList() {
        return altername;
    }

    public String getAlternameString(){
        String str = "";
        for(int i = 0; i < altername.size(); i++){
            if(i == altername.size()-1) str += altername.get(i) +".";
            else str += altername.get(i) + ", ";
        }
        return str;
    }


    public void setAltername(ArrayList<String> altername) {
        this.altername = altername;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        this.era = era;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getPreceded() {
        return preceded;
    }

    public void setPreceded(String preceded) {
        this.preceded = preceded;
    }

    public String getSucceeded() {
        return succeeded;
    }

    public void setSucceeded(String succeeded) {
        this.succeeded = succeeded;
    }
}

