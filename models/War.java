package models;

public class War {
    private int id;
    private String name;
    private String leader;
    private String enemy;
    private String era;
    private String period;
    private String result;

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
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getEnemy() {
		return enemy;
	}
	public void setEnemy(String enemy) {
		this.enemy = enemy;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}


}
