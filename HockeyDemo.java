package hockeyPackageEh;
import java.io.*;
import java.util.*;
public class HockeyDemo {

	/*-------------------------------------------------------------------
	 * HockeyDemo makes use of HockeyTeam.class and HockeyLeague.class  *
	 *              GLOBAL HOCKEY LEAGUE est. 2018                      *
	 *------------------------------------------------------------------*/
	public static void main(String[] args)throws IOException {
		
		//round1
		HockeyLeague round1 = new HockeyLeague();
		round1.inputData();
		System.out.println("Round 1 Standings: ");
		System.out.println();
		round1.standings();
		
		//round2
		round1.update();
		System.out.println();
		System.out.println("Round 2 Standings:");
		System.out.println();
		round1.standings();
		
		//round2 sorted by points
		round1.sort();
		System.out.println();
		System.out.println("Round 2 Standings (sorted by Pts.): ");
		System.out.println();
		round1.standings();	
		
		//round 2 sorted by wins
		System.out.println();
		System.out.println("Round 2 Standings (sorted by wins): ");
		System.out.println();
		round1.sortBy("WINS"); //ignore case working properly
		round1.standings();
		
		//round2 sorted by losses
		System.out.println();
		System.out.println("Round 2 Standings (sorted by losses): ");
		System.out.println();
		round1.sortBy("losses");
		round1.standings();
		
		//round2 sorted by ties
		System.out.println();
		System.out.println("Round 2 Standings (sorted by ties): ");
		System.out.println();
		round1.sortBy("ties");
		round1.standings();
		
		//sorted by city
		System.out.println();
		System.out.println("Round 2 Standings (sorted by city): ");
		System.out.println();
		round1.sortBy("city");
		round1.standings();
		
		//example of incorrect sort call
		System.out.println();
		round1.sortBy("goals");
		
		//League Leaders:
		System.out.println();
		round1.leagueLeaders();
		
	}

}
