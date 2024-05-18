package codingexercise2;


public class StudentUtil {

	public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException, IllegalArgumentException {
		if (studentIdList.length != studentsGrades.length) {
			throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: "
					+ studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
		}
		double[] studentGPA = new double[studentIdList.length];
		for (int i = 0; i < studentIdList.length; i++) {
			char[] grades = studentsGrades[i];
			double totalGPA = 0;
			for (char c : grades) {
				if (c == 'A') {
					totalGPA += 4;
				} else if (c == 'B') {
					totalGPA += 3;
				} else if (c=='C'){
					totalGPA += 2;
				} else if (c==' ') {
					throw new MissingGradeException(studentIdList[i]);
				}
			}
			studentGPA[i] = totalGPA / grades.length;
			totalGPA = 0;

		}

		return studentGPA;
	}

	public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) throws InvalidDataException {
		// perform parameter validation. Return null if passed parameters are not valid

		// invoke calculateGPA

		// construct the result array and return it. You would need an extra for loop to
		// compute the size of the resulting array

		if (!(lower < higher && lower >= 0 && higher >= 0)) {
			return null;
		}

		double[] studentGPAs;
		try {
			studentGPAs = calculateGPA(studentIdList, studentsGrades);
			int countGPA = 0;
			for (int i = 0; i < studentGPAs.length; i++) {
				if (lower <= studentGPAs[i] && studentGPAs[i] <= higher) {
					countGPA += 1;
				}
			}
			int[] newStudentIDs = new int[countGPA];
			for (int i = 0; i < studentGPAs.length; i++) {
				if (lower <= studentGPAs[i] && studentGPAs[i] <= higher) {
					if (countGPA > 0) {
						newStudentIDs[newStudentIDs.length - countGPA] = studentIdList[i];
						countGPA -= 1;
					}
				}
			}

		return newStudentIDs;
		} catch (IllegalArgumentException | MissingGradeException e) {
			// TODO Auto-generated catch block
			InvalidDataException chainedException = new InvalidDataException();
			chainedException.initCause(e);
			throw chainedException;
		}
		


	}
	public static void main(String[] args) {
		 
		int[] studentIdList = { 1001, 1002, 1003 };
		char[][] studentsGrades = { { 'A', 'A', 'A', 'B' }, { 'B', 'B', 'B', 'A' }, { 'A', 'A', 'B' } };
		double[] gpaList = null;
 
		try {
			gpaList = calculateGPA(studentIdList, studentsGrades);
		} catch (MissingGradeException e) {
			e.printStackTrace();
		}		
 
		for (double gpa : gpaList) {
			System.out.println("gpa: " + gpa);
		}		
 
		int[] id;
		try {
			id = getStudentsByGPA(3.5, 4.0, studentIdList, studentsGrades);
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		
	}
}