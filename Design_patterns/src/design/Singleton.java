package design;



class Samosa{
	
	private static Samosa samosa;
		private Samosa() {
			
		}
		
		public static Samosa getSamosa() {
			
			if(samosa==null) {
				
				synchronized(Samosa.class) {
					if(samosa==null) {
						samosa = new Samosa();
					}
				}
			}
			return samosa;
							
		}
	
}

public class Singleton {
	
	

	public static void main(String[] args) {
		
		Samosa s1 = Samosa.getSamosa();	
		Samosa s2 = Samosa.getSamosa();
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		
	}

}
