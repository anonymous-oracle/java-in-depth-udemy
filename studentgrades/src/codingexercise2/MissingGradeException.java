package codingexercise2;

public class MissingGradeException extends Exception{
	private int studentId;
	
	@SafeVarargs
	public <T> MissingGradeException(T ...varargs) {
		super();
		this.studentId = (int) varargs[varargs.length - 1];
	}

	public int getStudentId() {
		return studentId;
	}
	
	
	
}
