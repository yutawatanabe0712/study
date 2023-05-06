package check;
import constants.Constants;



public class Check {
	
	private String firstName = "渡邊";
	private String lastName = "勇太";
	
	private void printName(){
		System.out.println("printNameメソッド → " + this.firstName + this.lastName);
	}
	
	
	
	public static void main(String[] args) {
		
		Check check = new Check();
		check.printName();
		
		Pet pet = new Pet(Constants.CHECK_CLASS_JAVA, Constants.CHECK_CLASS_HOGE);
		pet.introduce();
		
		RobotPet robotPet = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
		robotPet.introduce();
	}
}
