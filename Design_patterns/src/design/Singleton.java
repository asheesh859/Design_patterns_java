package design;

import java.lang.reflect.Constructor;

class Samosa{
	
	private static Samosa samosa;
		private Samosa() {
			if(samosa!=null) {
				throw new RuntimeException("you are trying to break singleton");
			}
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
	public static void main(String[] args) throws Exception {		
		Samosa s1 = Samosa.getSamosa();	
		Samosa s2 = Samosa.getSamosa();		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());	
		//Break the singleton using reflection
		
		Constructor<Samosa> constructor = Samosa.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		Samosa s3 = constructor.newInstance();
		System.out.println(s3.hashCode());		
	}

}
