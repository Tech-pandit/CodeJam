package Qualification_2008;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SavingTheUniverse {

	public static int solution(List<String> searchEngines, List<String> queries) {

		for (int i = 0; i < queries.size(); i++) {
			boolean found = false;
			for (int j = 0; j < searchEngines.size(); j++) {
				if (searchEngines.get(j).equals(queries.get(i))) {
					found = true;
					break;
				}
			}
			if (!found) {
				queries.remove(i);
			}
		}

		int fromPosition = 0;
		int farthestPosition = 0;
		int result = 0;
		while (fromPosition < queries.size()) {

			farthestPosition = fromPosition;
			for (int j = 0; j < searchEngines.size(); j++) {

				int travPos = fromPosition;
				

				while (travPos<queries.size() && !queries.get(travPos).equals(searchEngines.get(j)) ) {
					++travPos;
				}
				if (farthestPosition < travPos)
					farthestPosition = travPos - 1;

			}

			fromPosition = farthestPosition + 1;
			result++;
		}
		return result-1;
	}

	public static void main(String sa[]) {

		Scanner sc = new Scanner(System.in);
		List<String> searchEngines = new LinkedList<String>();
		List<String> queries = new LinkedList<String>();

		int testCases = sc.nextInt();

		for (int test = 1; test <= testCases; test++) {
			int result = 0;
			searchEngines.clear();
			queries.clear();

			int numSearchEngines = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < numSearchEngines; i++) {
				String str = sc.nextLine();
				searchEngines.add(str);
			}

			int numQueries = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < numQueries; i++) {
				String str = sc.nextLine();
				queries.add(str);
			}

			result = solution(searchEngines, queries);
			if(result==-1)
				result=0;
			System.out.println("Case #" + (test) + ": " + result);
		}

	}
}
