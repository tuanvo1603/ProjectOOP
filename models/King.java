package models;

import java.util.ArrayList;



public class King {
    private int id;
    private String name;
    private String era;
    public String getGoverment() {
		return goverment;
	}

	public void setGoverment(String goverment) {
		this.goverment = goverment;
	}
	private String birth;
    private String death;
    private String label;
    private String otherName;
    private String goverment;

    private static int numberOfKings = 0;

    public King() {

    }

    public int getNumberOfKings(){
        return numberOfKings;
    }
    public static ArrayList<King> kingsList = new ArrayList<>();

   
    public King(int id, String name, String birth, String death, String era, String label, String otherName, String goverment) {
		super();
		this.id = id;
		this.name = name;
		this.era = era;
		this.birth = birth;
		this.death = death;
		this.label = label;
		this.otherName = otherName;
		this.goverment = goverment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEra() {
		return era;
	}

	public void setEra(String era) {
		this.era = era;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getDeath() {
		return death;
	}

	public void setDeath(String death) {
		this.death = death;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public static ArrayList<King> getKingsList() {
        return kingsList;
    }

    public static void addKing(King king) {
        kingsList.add(king);
        numberOfKings++;
    }

    public static void printAllKings() {
        for (King king : kingsList) {
            System.out.println(king.toString());
        }
    }
}
