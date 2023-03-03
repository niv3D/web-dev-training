
public class OuterClass {
	
	private int number;
	
	public void heyThere() {
		
		System.out.println("hey There from outer!");
	}
	
	public class InnerClass{
		
		public InnerClass() {
			number++;
		}
		
		public void heyThere() {
			
			System.out.println("hey There from inner!" + number);
			
		}
		
	}

}
