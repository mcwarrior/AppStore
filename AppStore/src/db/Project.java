package db;

public class Project {
	private String projectName;
	private String website;
	private String desc;
	
	public Project(){
		projectName = "";
		website = "";
		desc = "";
	}
	
	public String getProjectName() {
		return projectName;
	}
	public String getWebsite() {
		return website;
	}
	public String getDesc() {
		return desc;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
