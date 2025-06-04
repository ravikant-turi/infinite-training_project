package lms.leaveManagement.main;

public class SwatiMain {

	public static void main(String[] args) {
		
		System.out.println("enter welocme");
		
	String str="abc";
	
	solve(0,"",str);
}
	public static void solve(int i ,String take,String nontake) {
		
		if(nontake.length()==0) {
			System.out.print(take +" ,");
			return ;
		}
		char ch=nontake.charAt(0);
	  
		solve(i,take,nontake.substring(1,nontake.length()));
	  solve(i,ch+take,nontake.substring(1,nontake.length()));
		
		
	}
}
