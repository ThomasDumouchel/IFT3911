package Models.PlaneTripModel;

public enum PlaneSectionLayoutType {
	TIGHT,
	MEDIUM,
	COMFORT,
	LARGE;

	public int getSeatCount() {
		int seatCount = 0;
		switch (this) {
			case TIGHT:
				seatCount = 3;
				break;
			case MEDIUM:
				seatCount = 6;
				break;
			case COMFORT:
				seatCount = 4;
				break;
			case LARGE:
				seatCount = 10;
				break;
		}

		return seatCount;
	}

	public String getRowLetter(int num) {
		String rowLetter = "";
		char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

		String str = Character.toString(alphabet[num-1]); 

		String[] rowMap = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		rowMap[0] = "A";

		return rowLetter;
	}
}

// cree un array
// 1 map a A
// 2 map a B
// 3 map a C etc...
/*
 * char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
 * 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
 * 
 * String str = Character.toString(alphabet[num-1]);
 * 
 * String[] rowMap = {"A", "B", "C", "D", ...}
 * rowMap[0] == "A"
 * 
 */