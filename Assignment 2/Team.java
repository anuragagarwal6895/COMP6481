/**
 * Assignment 2
 * Question : 2/Part 2
 * @author Anurag Agarwal - 40232644
 * Due Date : 27/11/2022
 */

package cricketTournament;

/**
 * Team Class implement the Groupable interface assigns Name, Games played,
 * Games Won, Games Lost, Run Rate, Points parameters
 * 
 * @author Anurag Agarwal
 *
 */
public class Team implements Groupable {

	String teamID;
	String teamName;
	int gamesPlayed;
	int gamesWon;
	int gameslost;
	double netRunRate;
	int points;
	String group;
	static int team_count = 0;

	/**
	 * Gets the Group name
	 * 
	 * @return group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Sets the Group name
	 * 
	 * @param group
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * Gets the TeamID
	 * 
	 * @return teamID
	 */
	public String getTeamID() {
		return teamID;
	}

	/**
	 * Sets the TeamID
	 * 
	 * @param teamID
	 */
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	/**
	 * Gets the TeamName
	 * 
	 * @return teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * Sets the TeamName
	 * 
	 * @param teamName
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * Gets the GamesPlayed
	 * 
	 * @return gamesPlayed
	 */
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * Sets the GamesPlayed
	 * 
	 * @param gamesPlayed
	 */
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	/**
	 * Gets the GamesWon
	 * 
	 * @return gamesWon
	 */
	public int getGamesWon() {
		return gamesWon;
	}

	/**
	 * Sets the GamesWon
	 * 
	 * @param gamesWon
	 */
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	/**
	 * Gets the Gameslost
	 * 
	 * @return gameslost
	 */
	public int getGameslost() {
		return gameslost;
	}

	/**
	 * Sets the Gameslost
	 * 
	 * @param gameslost
	 */
	public void setGameslost(int gameslost) {
		this.gameslost = gameslost;
	}

	/**
	 * Gets the NetRunRate
	 * 
	 * @return netRunRate
	 */
	public double getNetRunRate() {
		return netRunRate;
	}

	/**
	 * Sets the NetRunRate
	 * 
	 * @param netRunRate
	 */
	public void setNetRunRate(double netRunRate) {
		this.netRunRate = netRunRate;
	}

	/**
	 * Gets the Points
	 * 
	 * @return points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets the Points
	 * 
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Default Constructor
	 */
	public Team() {
	}

	/**
	 * Parameterised Constructor to initialise Team attributes
	 * 
	 * @param teamName
	 * @param gamesPlayed
	 * @param gamesWon
	 * @param gameslost
	 * @param netRunRate
	 * @param points
	 * @param group
	 */
	public Team(String teamName, int gamesPlayed, int gamesWon, int gameslost, double netRunRate, int points,
			String group) {
		this.teamID = String.valueOf(team_count++);
		this.teamName = teamName;
		this.gamesPlayed = gamesPlayed;
		this.gamesWon = gamesWon;
		this.gameslost = gameslost;
		this.netRunRate = netRunRate;
		this.points = points;
		this.group = group;
	}

	/**
	 * Clone Method for Team
	 * 
	 * @param teamID
	 * @return team
	 */
	public Team clone(String teamID) {
		Team team = new Team();
		team.teamID = teamID;
		team.teamName = this.teamName;
		team.gamesPlayed = this.gamesPlayed;
		team.gamesWon = this.gamesWon;
		team.gameslost = this.gameslost;
		team.netRunRate = this.netRunRate;
		team.points = this.points;
		return team;
	}

	/**
	 * Copy constructor
	 * 
	 * @param t
	 * @param teamId
	 */
	public Team(Team t, String teamId) {
		this.teamID = teamId;
		this.teamName = t.teamName;
		this.gamesPlayed = t.gamesPlayed;
		this.gamesWon = t.gamesWon;
		this.gameslost = t.gameslost;
		this.netRunRate = t.netRunRate;
		this.points = t.points;
	}

	/**
	 * Checks team is in the same Group
	 * 
	 * @param team
	 * @return
	 */
	@Override
	public boolean isInTheGroup(Team team) {
		if (this.getGroup().equals(team.getGroup()))
			return true;
		else
			return false;
	}

	/**
	 * toString method to print object attributes
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return "Team [teamID=" + teamID + ", teamName=" + teamName + ", gamesPlayed=" + gamesPlayed + ", gamesWon="
				+ gamesWon + ", gameslost=" + gameslost + ", netRunRate=" + netRunRate + ", points=" + points
				+ ", group=" + group + "]";
	}

	/**
	 * Checks two teams have same attributes
	 * 
	 * @param team
	 * @return boolean
	 */
	public boolean equals(Team team) {
		return (this.teamName == team.teamName && this.teamName == team.teamName && this.gamesPlayed == team.gamesPlayed
				&& this.gamesWon == team.gamesWon && this.gameslost == team.gameslost
				&& this.netRunRate == team.netRunRate && this.points == team.points);
	}

}
