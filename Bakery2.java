package qsda;
import java.util.Arrays; 
import java.util.Calendar; 
public class Bakery2 { 
	static final int SUM = 100; 
	static String[] bakery = new String[SUM]; 
	static final String BREAD_1 = "식빵"; 
	static final String BREAD_2 = "소보로"; 
	static final String BREAD_3 = "크림빵"; 
	static final String BREAD_4 = "팥빵"; 
	static int cnt_1=0,cnt_2=0,cnt_3=0,cnt_4=0; 
	public static void main(String[] args) {
		//100개 빵 생산
		makeBakery(); 
		//종류별 카운트 
		countBread(); 
		//print class 
		printList(); 
		} 
	private static void printList() { 
		Calendar c1 = Calendar.getInstance(); 
		Calendar c2 = Calendar.getInstance();
		int year = c1.get(Calendar.YEAR); 
		int month = c1.get(Calendar.MONTH);
		int day = c1.get(Calendar.DAY_OF_MONTH); 
		int hour = c1.get(Calendar.HOUR); 
		int min = c1.get(Calendar.MINUTE); 
		int sec = c1.get(Calendar.SECOND);
		c2.add(Calendar.DAY_OF_MONTH,100);
		int year2 = c2.get(Calendar.YEAR); 
		int month2 = c2.get(Calendar.MONTH);
		int day2 = c2.get(Calendar.DAY_OF_MONTH); 
		System.out.print(Integer.toString(year)); 
		System.out.print(Integer.toString(month+1));
		System.out.println(Integer.toString(day)); 
		System.out.print(Integer.toString(hour)); 
		System.out.print(Integer.toString(min)); 
		System.out.println(Integer.toString(sec)); 
		System.out.print(Integer.toString(year2)); 
		System.out.print(Integer.toString(month2+1));
		System.out.println(Integer.toString(day2)); 
		} 
	private static void countBread() {
		for(String str: bakery) { 
			switch(str) { 
			case BREAD_1:
				++cnt_1;
			break;
			case BREAD_2: 
				++cnt_2; 
			break;
			case BREAD_3: 
				++cnt_3;
			break;
			case BREAD_4:
				++cnt_4; 
			break;
			} 
			} 
		System.out.println(BREAD_1+"\t"+cnt_1);
		System.out.println(BREAD_2+"\t"+cnt_2); 
		System.out.println(BREAD_3+"\t"+cnt_3); 
		System.out.println(BREAD_4+"\t"+cnt_4);
		}
	private static void makeBakery() {
		int i=0;
		String bread = null;
		for(i=0; i<100; i++) { 
			switch ((int) (Math.random() * 4)) { 
			case 0: 
				bread = BREAD_1; 
				break; 
			case 1: 
				bread = BREAD_2;
				break; 
			case 2:
				bread = BREAD_3; 
				break;
			case 3:
					bread = BREAD_4; 
					break;
			default:
					break; 
					} 
			bakery[i] = bread;
			System.out.println(i+"\t"+bakery[i]);
			} 
		Arrays.sort(bakery);
		int cnt = 0; 
		for(String str: bakery) { 
			System.out.println(cnt+"\t"+str); cnt++; 
			}
		}
	
}


	
//출처: http://emessell.tistory.com/11 [JAVA, ELECTRIC]