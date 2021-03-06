/**
 * 最大公约数
 */

package math;

public class GreatestCommonDivisor {
	static final int N = 10;
	static final int RANGE = 100;//number range
	public static void main(String[] args) {
		int a,b;
		for(int i=0;i<N;i++){
			a=(int)(Math.random()*RANGE+10);
			b=(int)(Math.random()*RANGE+10);
			System.out.printf("辗转相除法,%d和%d的最大公约数:%d%n",a,b,loopDivide(a,b));
			System.out.printf("更相减损术,%d和%d的最大公约数:%d%n",a,b,loopSubstract(a,b));
			System.out.printf("穷举法        ,%d和%d的最大公约数:%d%n",a,b,seekThrough(a,b));
		}
	}
	//辗转相除法
	static int loopDivide(int a,int b){
		int c;
		while(b != 0){
			c=a%b;
			a=b;
			b=c;
		}
		return a;
	}

	//更相减损术
	static int loopSubstract(int a,int b){
		while(a != b){
			if(a>b){
				a-=b;
			}else{
				b-=a;
			}
		}
		return a;
	}

	//穷举法
	static int seekThrough(int a,int b){
		int num = Math.min(a, b);
		while(num>1){
			if(0 == a%num && 0 == b%num){
				return num;
			}
			num--;
		}
		return 1;
	}
}