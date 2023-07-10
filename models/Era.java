package models;

import java.util.List;


public class Era {
    private int id;
    private String era;
    private String period;
    private String time;
    private List<String> Kings;



    public Era() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public Era(int id, String era, String period, String time, List<String> kings) {
		super();
		this.id = id;
		this.era = era;
		this.period = period;
		this.time = time;
		Kings = kings;
	}

	public String getEra() {
		return era;
	}

	public void setEra(String era) {
		this.era = era;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<String> getKings() {
		return Kings;
	}

	public void setKings(List<String> kings) {
		Kings = kings;
	}


}
