//-------------------------------------------------------------
// © ANURAG AGARWAL
// Written by: ANURAG AGARWAL
//-------------------------------------------------------------

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

class Voter {

	long voterID;
	String voterName;
	byte voterAge;
	String voterEmail;
	char[] voterPcode;
	private static HashSet<Long> voterBaseId = new HashSet<Long>();
	
// getters and setters defined below

	public long getVoterID() {
		return voterID;
	}

	private long setVoterID() {
		voterID = new Random().nextLong(1, 1000);
		while (voterBaseId.add(voterID) != true) {
			voterID = new Random().nextLong(1, 1000);
		}
		return voterID;
	}

	public String getVoterName() {
		return voterName;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	public byte getVoterAge() {
		return voterAge;
	}

	public void setVoterAge(byte voterAge) {
		this.voterAge = voterAge;
	}

	public String getVoterEmail() {
		return voterEmail;
	}

	public void setVoterEmail(String voterEmail) {
		this.voterEmail = voterEmail;
	}

	public char[] getVoterPcode() {
		return voterPcode;
	}

	public void setVoterPcode(char[] voterPcode) {
		this.voterPcode = voterPcode;
	}
	//default constructor
	public Voter() {
	}

	public Voter(String voterName, byte voterAge, String voterEmail, char[] voterPcode) {
		super();
		this.voterID = setVoterID();
		this.voterName = voterName;
		this.voterAge = voterAge;
		this.voterEmail = voterEmail;
		this.voterPcode = voterPcode;
	}

	public static int findNumberOfCreatedVoters() {
		return voterBaseId.size();
	}

	@Override
	public String toString() {
		return "\nID:" + voterID + "\nName:" + voterName + "\nAge:" + voterAge + "\nEmail:" + voterEmail + "\nPcode:"
				+ String.valueOf(voterPcode) +"\n";
	}

	public boolean equals(Voter obj) {
		if (obj == null)
			return false;
		return this.voterID == obj.voterID && Arrays.equals(this.voterPcode, obj.voterPcode);
	}

}

public class VoterApplication {

	public static boolean checkPassword() {
		Scanner sc = new Scanner(System.in);
		String pass;
		boolean flag = false;
		for (int i = 0; i < 3; i++) {
			System.out.println("Please enter password");
			pass = sc.nextLine();
			if (pass.equals("password")) {
				flag = true;
				break;
			} else {
				System.out.println("Password is incorrect, attempts remaining:" + (2 - i));
			}
		}

		return flag;
	}


	public static void main(String[] args) {

		int ch = 0;
		int max_voters = 0; // maximum number of voters we can add
		int add_voter_count = Voter.findNumberOfCreatedVoters(); // keep track of how many voters we add
		int password_attempt_count = 0; // keep track of password attempt process in case of option 1
		System.out.println("Welcome to the Party Voting System\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter maximum number of voters");// enter how many voters required
		max_voters = sc.nextInt();

		Voter[] voterBase = new Voter[max_voters]; // created voters array

		label1: while (true) {

			if (password_attempt_count >= 3) {
				System.out.println("Program detected suspicious activities and will terminate immediately!");
				break label1;
			} else {

				System.out.println("What do you want to do?");
				System.out.println("1: Enter new voters (password required)");
				System.out.println("2: Change information of a voter (password required)");
				System.out.println("3: Display all voters by a specific voterPcode");
				System.out.println("4: Display all voters under a certain age.");
				System.out.println("5: Quit");
				System.out.println("Please enter your choice");
				ch = sc.nextInt();
				switch (ch) {

				case 1:
					boolean check_password_flag = checkPassword();
					if (check_password_flag == true && add_voter_count < max_voters) {
						sc.nextLine();
						System.out.println("Enter number of voters to be added");
						int add_count = Integer.parseInt(sc.nextLine());//at option1 how many u want to add at a single time
						
						//comparing number of voters to be added with the difference of max 
						//capacity and number of voters already added
						if(add_count<=(max_voters-add_voter_count))
						for(int i=0; i<add_count; i++) {	
						System.out.println("Enter new voter name");
						String voter_name = sc.nextLine();
						System.out.println("Enter new voter age");
						byte voter_age = Byte.parseByte(sc.nextLine());
						System.out.println("Enter new voter email id");
						String voter_email = sc.nextLine();
						System.out.println("Enter new voter postal code");
						char[] voter_pcode = sc.nextLine().toCharArray();
						Voter v2 = new Voter(voter_name, voter_age, voter_email, voter_pcode);

						// in end add in list
						voterBase[add_voter_count] = v2;
						System.out.println(v2.toString());
						add_voter_count=Voter.findNumberOfCreatedVoters();
						}
						else {
							System.out.println("Max Capacity exceeded, available:" + (max_voters-Voter.findNumberOfCreatedVoters()));
							System.out.println("Returning to main menu.....");	
						}
					} else {
						if (check_password_flag == false)
							password_attempt_count++;
						if (add_voter_count >= max_voters) {
							System.out.println("Maximum limit reached. Cant add any more voters");
						}
					}
				
					break;
					
				case 2:
					if (checkPassword() == true) {
						if (add_voter_count == 0) {
							System.out.println("No voters have been added");
							break;
						}
						
						sc.nextLine();
							
							String answer = "Y";
						    label2: while(answer.equals("Y")) {
							System.out.println("which voter?(Enter voter id)");
							long voter_id = sc.nextLong();
							int voterBase_index = 0;
							int flag =0;
							Voter v_obj = new Voter();
							for (Voter v : voterBase) { 
								if (v != null)
									if (v.getVoterID() == voter_id) {
										// display details if matched
										v_obj = v;
										System.out.println("Voter: " + (voterBase_index+1));
										System.out.println(v.toString());
										flag =1;
										break;
									}

								voterBase_index++;
							}
							if(flag ==0) {
							System.out.println("No such voter id present");
							System.out.println("Do you wish to enter another voter id(Y/N)");
							sc.nextLine();
							answer = sc.nextLine();
							continue label2;
							}
						    
							// display menu to ask which attribute to change
							lp2: while (true) {
								System.out.println("What information would you like to change?");
								System.out.println("1. Name");
								System.out.println("2. Age");
								System.out.println("3. Email");
								System.out.println("4. Pcode");
								System.out.println("5. Quit");
								int option = sc.nextInt();
								switch (option) {

								case 1:
									sc.nextLine();
									System.out.println("Please enter new name of the Voter");
									String name = sc.nextLine();
									v_obj.setVoterName(name);
									System.out.println("Voter: " + (voterBase_index+1));
									System.out.println(v_obj.toString());
									break;
								case 2:
									sc.nextLine();
									System.out.println("Please enter new age of the Voter");
									byte age = Byte.parseByte(sc.nextLine());
									v_obj.setVoterAge(age);
									System.out.println("Voter: " + (voterBase_index+1));
									System.out.println(v_obj.toString());
									break;
								case 3:
									sc.nextLine();
									System.out.println("Please enter new email of the Voter");
									String email = sc.nextLine();
									v_obj.setVoterEmail(email);
									System.out.println("Voter: " + (voterBase_index+1));
									System.out.println(v_obj.toString());
									break;
								case 4:
									sc.nextLine();
									System.out.println("Please enter new Postal code of the Voter");
									char[] pcode = sc.nextLine().toCharArray();
									v_obj.setVoterPcode(pcode);
									System.out.println("Voter: " + (voterBase_index+1));
									System.out.println(v_obj.toString());
									break;
								// to quit
								case 5:
									break label2;
								// incorrect option for menu
								default:
									System.out.println("Please enter correct choice");
								}
							}
						}
					}
					break;
				case 3:
					sc.nextLine();
					Voter[] listed_voters = new Voter[add_voter_count];
					int listed_voters_count = 0;
					System.out.println("Enter postal code:");
					char[] entered_pcode = sc.nextLine().toCharArray();
					for (Voter v : voterBase) {
						if (v != null)
							if (Arrays.equals(v.getVoterPcode(), entered_pcode)) {
								listed_voters[listed_voters_count] = v;
								listed_voters_count++;
							}
					}
					System.out.println("Listed voters of mentioned postal code " + String.valueOf(entered_pcode));
					if (listed_voters[0] != null) {
						for (Voter v : listed_voters) {
							if(v != null)
							System.out.println(v.toString());
						}
					} else {
						System.out.println("No voters found");
					}
					break;
				case 4:
					sc.nextLine();
					System.out.println("Enter the age for Voter Search:");
					byte age_search = sc.nextByte();
					for (Voter v : voterBase) {
						if (v != null)
							if (v.getVoterAge() < age_search) {
								// display details if matched
								System.out.println(v.toString());
							} else {
								System.out.println("No voters found");
							}
					}
					break;
				case 5:
					System.out.println("Thanks for choosing Party Voting System!!");
					break label1;
				}
			}
		}

	}
}
