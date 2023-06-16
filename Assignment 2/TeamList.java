/**
 * Assignment 2
 * Question : 3/Part 2
 * @author Anurag Agarwal - 40232644
 * Due Date : 27/11/2022
 */

package cricketTournament;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * class Teamlist has inner class called TeamNode and methods to manage linklist operations
 * @author Anurag Agarwal
 *
 */

public class TeamList {

	/**
	 * Teamnode has all the methods to perform operations on teamlist
	 * 
	 * @author Anurag Agarwal
	 *
	 */
	public class TeamNode implements Comparable<TeamNode> {

		/**
		 * Team object
		 */
		private Team team;

		/**
		 * default constructor
		 */
		public TeamNode() {
			this.setTeam(null);
		}

		/**
		 * parameterised constructor
		 * 
		 * @param team
		 * @param node
		 */
		public TeamNode(Team team, TeamNode node) {
			this.team = team;
		}

		/**
		 * Gets the team name
		 * 
		 * @return team
		 */
		public Team getTeam() {
			return team;
		}

		/**
		 * Sets the Team name
		 * 
		 * @param t
		 */
		public void setTeam(Team t) {
			this.team = t;
		}

		/**
		 * toString method to print object attributes
		 * 
		 * @return
		 */
		@Override
		public String toString() {
			return "TeamNode [teamNode=" + ", \n team=" + team.toString() + "]";
		}

		/**
		 * clone method
		 * 
		 * @param node
		 */
		public TeamNode(TeamNode node) {
			setTeam(node.getTeam());
		}

		/**
		 * Method to compare between teams
		 * 
		 * @param o
		 * @return result
		 */
		@Override
		public int compareTo(TeamNode o) {
			// TODO Auto-generated method stub
			boolean checkPoints = this.getTeam().getPoints() > o.getTeam().getPoints()
					&& this.getTeam().getGroup().equals(o.getTeam().getGroup());
			boolean checkRunRate = this.getTeam().getNetRunRate() > o.getTeam().getNetRunRate()
					&& this.getTeam().getGroup().equals(o.getTeam().getGroup());
			int result = 1;

			if (((checkPoints == true) || (checkPoints == true && checkRunRate == true)))
				result = -1;

			if ((checkPoints == false && checkRunRate == true)) {
				result = -1;
			}
			return result;
		}
	}

	/**
	 * First position of list
	 */
	private int head;
	/**
	 * size of list
	 */
	private int size;
	/**
	 * List of Teams
	 */
	public static LinkedList<TeamNode> list = new LinkedList<>();

	/**
	 * Gets the head of the list
	 * 
	 * @return head
	 */
	public int getHead() {
		return head;
	}

	/**
	 * Sets the head of the list
	 * 
	 * @param head
	 */
	public void setHead(int head) {
		this.head = head;
	}

	/**
	 * Gets the Size of the list
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the Size of the list
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * default constructor
	 */
	public TeamList() {
		this.head = 0;
		this.size = list != null ? list.size() : 0;
	}

	/**
	 * Initializes head and size of team list
	 * 
	 * @param teamList
	 */
	public TeamList(TeamList teamList) {
		this.setHead(teamList.getHead());
		this.setSize(teamList.getSize());
	}

	/**
	 * add to Start
	 * 
	 * @param t
	 */
	public void addToStart(Team t) {
		TeamNode teamNode = new TeamNode();
		teamNode.setTeam(t);
		if (!list.contains(teamNode))
			list.addFirst(teamNode);
		Collections.sort(list);
	}

	/**
	 * method to add element at the top of the list
	 * 
	 * @param team
	 */
	public void addTeam(Team team) {
		TeamNode teamNode = new TeamNode();
		teamNode.setTeam(team);
		if (!list.contains(teamNode)) {
			list.add(teamNode);
			Collections.sort(list);
		}

	}

	/**
	 * Calculates the score data and gives the result as if team Qualifies or not
	 * 
	 * @param teamName
	 * @return result
	 */
	public static String result(String teamName) {

		String result = null;
		// find the team

		Optional<Team> selectedTeam = list.stream().map(x -> x.getTeam()).filter(x -> x.getTeamName().equals(teamName))
				.findFirst();

		if (!selectedTeam.isPresent()) {
			result = "No such team present!!!";
			return result;
		}
		Team selectedTeamObj = selectedTeam.get();
		// list of teams in the same group
		List<Team> teams = list.stream().map(x -> x.getTeam())
				.filter(x -> x.getGroup().equals(selectedTeamObj.getGroup())).collect(Collectors.toList());
		Integer teamIndex = teams.indexOf(selectedTeamObj);

		// if team is on 1st position
		if (teamIndex == 0 || teamIndex == 1) {
			Team prevTeam = (teamIndex - 1) >= 0 ? teams.get(teamIndex - 1) : null;
			Team nextTeam = (teamIndex + 1) < teams.size() ? teams.get(teamIndex + 1) : null;

			// if there is only one team in the group
			if (prevTeam == null && nextTeam == null) {
				return "Team" + selectedTeamObj.getTeamName() + "is highest in the group";
			}

			if (nextTeam != null) {
				if (nextTeam.getPoints() < selectedTeamObj.getPoints()) {
					return selectedTeamObj.getTeamName()
							+ " qualifies for the second round as it has more points than other "
							+ (teams.size() - teams.indexOf(selectedTeamObj) - 1) + " teams.";
				}
				if (nextTeam.getNetRunRate() < selectedTeamObj.getNetRunRate()) {
					return selectedTeamObj.getTeamName() + " qualifies for the second round as it has higher run rate.";
				}
			}
		} else {
			Team prevTeam = (teamIndex - 1) >= 0 ? teams.get(teamIndex - 1) : null;
			if (prevTeam != null) {
				if (prevTeam.getPoints() > selectedTeamObj.getPoints()) {
					return selectedTeamObj.getTeamName()
							+ " can't qualify for the second round as it doesn't have enough points.";
				}
				if (prevTeam.getNetRunRate() > selectedTeamObj.getNetRunRate()) {
					return selectedTeamObj.getTeamName()
							+ " can't qualify for the second round as it doesn't have high enough run rate.";
				}
			}
		}
		return result;
	}

	/**
	 * method to add element at any given index
	 * 
	 * @param index
	 * @param teamNode
	 * @throws IndexOutOfBoundsException
	 */
	public static void insertAtIndex(int index, TeamNode teamNode) throws IndexOutOfBoundsException {

		if (0 <= index && index < list.size()) {
			list.add(index, teamNode);
			Collections.sort(list);
		} else
			throw new IndexOutOfBoundsException("Index is not valid");
	}

	/**
	 * method to delete element at any given index
	 * 
	 * @param index
	 * @throws IndexOutOfBoundsException
	 */
	public static void deleteFromIndex(int index) throws IndexOutOfBoundsException {

		if (0 <= index && index < list.size())
			list.remove(index);
		else
			throw new IndexOutOfBoundsException("Index is not valid");

		System.out.println(list.toString());
	}

	/**
	 * method to replace element at any given index
	 * 
	 * @param index
	 * @param t
	 */
	public void replaceAtIndex(int index, Team t) {
		if (0 <= index && index < list.size()) {
			TeamNode teamNodes = new TeamNode();
			teamNodes.setTeam(t);
			// replace logic for the list
			list.set(index, teamNodes);

		} else
			return;
	}

	/**
	 * to find a Team from a list
	 * 
	 * @param teamId
	 * @return teamname
	 */
	public static Team find(String teamId) {

		for (TeamNode teamNodes : list) {
			teamNodes.getTeam().getTeamID().equals(teamId);
			return teamNodes.getTeam();
		}
		return null;
	}

	/**
	 * checks if the group contains specific team
	 * 
	 * @param teamId
	 * @return
	 */
	public boolean contains(String teamId) {
		for (TeamNode teamNode : list) {
			// if the below condition matches then team present in the list
			teamNode.getTeam().getTeamID().equals(teamId);
			// if above condition is satisfied then return true else return false
			return true;
		}
		return false;
	}
}
