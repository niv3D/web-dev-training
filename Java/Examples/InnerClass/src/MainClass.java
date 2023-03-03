
public class MainClass {
	
	
	public static void main(String[] args) {
		
		OuterClass outerClassOne = new OuterClass();
		
		outerClassOne.heyThere();
		
		
		OuterClass.InnerClass innerClassOne = outerClassOne.new InnerClass();
		
		OuterClass.InnerClass innerClassTwo = outerClassOne.new InnerClass();
		
		
		innerClassOne.heyThere();
		innerClassTwo.heyThere();
		
		
		OuterClass outerClassTwo = new OuterClass();
		
		OuterClass.InnerClass innerClassThree = outerClassTwo.new InnerClass();
		
		
		outerClassTwo.heyThere();
		innerClassThree.heyThere();
		
	}
	
	
	
}
