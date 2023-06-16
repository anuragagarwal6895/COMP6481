/**
 * Assignment 2
 * Question : 4/Part 2
 * @author Anurag Agarwal - 40232644
 * This System gives information about teams participating in the world cup.
 * Due Date : 27/11/2022
 */

package cricketTournament;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver class TournamentResults to run Cricket Tournament T20 tool
 * 
 * @author Anurag Agarwal
 *
 */
public class TournamentResults {

	/**
	 * Starting point of application - main class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Welcome to Cricket Tournament T20 : Made by Anurag Agarwal!!");
		Scanner sc = new Scanner(System.in);
		TeamList teamList = new TeamList();
		System.out.println("Enter no of teams in each Group A and B : ");
		int noOfTeams = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Team details for Group A: ");
		String[] groupA_team = new String[noOfTeams];
		String[] groupA_teamInfo = new String[6];

		ArrayList<String> AllTeams = new ArrayList<String>();

		for (int i = 0; i < noOfTeams; i++) {
			groupA_team[i] = sc.nextLine();
			groupA_teamInfo = groupA_team[i].split(" ");
			AllTeams.add(groupA_teamInfo[0]);
			if (i == 0) {
				Team team = new Team(groupA_teamInfo[0], Integer.parseInt(groupA_teamInfo[1]),
						Integer.parseInt(groupA_teamInfo[2]), Integer.parseInt(groupA_teamInfo[3]),
						Double.parseDouble(groupA_teamInfo[4]), Integer.parseInt(groupA_teamInfo[5]), "A");
				teamList.addToStart(team);
			} else {
				Team team = new Team(groupA_teamInfo[0], Integer.parseInt(groupA_teamInfo[1]),
						Integer.parseInt(groupA_teamInfo[2]), Integer.parseInt(groupA_teamInfo[3]),
						Double.parseDouble(groupA_teamInfo[4]), Integer.parseInt(groupA_teamInfo[5]), "A");
				teamList.addTeam(team);
			}
		}
		System.out.println("Enter Team details for Group B: ");
		String[] groupB_team = new String[noOfTeams];
		String[] groupB_teamInfo = new String[6];

		for (int i = 0; i < noOfTeams; i++) {
			groupB_team[i] = sc.nextLine();
			groupB_teamInfo = groupB_team[i].split(" ");
			AllTeams.add(groupB_teamInfo[0]);
			if (i == 0) {
				Team team = new Team(groupB_teamInfo[0], Integer.parseInt(groupB_teamInfo[1]),
						Integer.parseInt(groupB_teamInfo[2]), Integer.parseInt(groupB_teamInfo[3]),
						Double.parseDouble(groupB_teamInfo[4]), Integer.parseInt(groupB_teamInfo[5]), "B");
				teamList.addToStart(team);
			} else {
				Team team = new Team(groupB_teamInfo[0], Integer.parseInt(groupB_teamInfo[1]),
						Integer.parseInt(groupB_teamInfo[2]), Integer.parseInt(groupB_teamInfo[3]),
						Double.parseDouble(groupB_teamInfo[4]), Integer.parseInt(groupB_teamInfo[5]), "B");
				teamList.addTeam(team);
			}
		}
		for (String findTeam : AllTeams) {
			System.out.println(TeamList.result(findTeam));
		}

		System.out.println("Enter name of Team to check whether it Qualify for Second Round of T20:");
		String RequestedTeam = sc.nextLine();
		String Result = TeamList.result(RequestedTeam);
		System.out.println(Result);
		System.out.println("Thanks for using Cricket Tournament System!!");
		sc.close();

	}
}
