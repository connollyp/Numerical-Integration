import java.util.Scanner;

public class Numerical_Integration {

	public static void main(String[] args) {
		
		double a;
		double b;
		int n;
		double A;
		double B;
		double C;
		double D;
		double E;
		double F;
		double deltaX;
		Scanner userinput = new Scanner(System.in);

		System.out.printf("Enter the limit of integration a: ");
		a = userinput.nextDouble();
		System.out.printf("Enter the limit of integration b: ");
		b = userinput.nextDouble();
		System.out.printf("Enter the number of sub intervals n: ");
		n = userinput.nextInt();
		if (n<=0) {
			System.out.printf("N can not be less than or equal to 0");
			System.exit(0);
		}
		System.out.printf("Enter the coefficent A: ");
		A = userinput.nextDouble();
		System.out.printf("Enter the coefficent B: ");
		B = userinput.nextDouble();
		System.out.printf("Enter the coefficent C: ");
		C = userinput.nextDouble();
		System.out.printf("Enter the coefficent D: ");
		D = userinput.nextDouble();
		System.out.printf("Enter the coefficent E: ");
		E = userinput.nextDouble();
		System.out.printf("Enter the coefficent F: ");
		F = userinput.nextDouble();
		deltaX = (b-a)/n;
		
		
		double midPoint = mid_point(a,b,n,A,B,C,D,E,F,deltaX);
		double trapazoid = trapazoid(a,b,n,A,B,C,D,E,F,deltaX);
		double simpson = simpsons_rule(a,b,n,A,B,C,D,E,F,deltaX);
		double numInt = numerical_integration(a,b,n,A,B,C,D,E,F,deltaX);
		double miderror = ((midPoint-numInt)/numInt)*100;
		double trapError = ((trapazoid-numInt)/numInt)*100;
		double simperror = ((simpson-numInt)/numInt)*100;
		
		System.out.printf("The exact value of the integral is: %f%n", numInt);
		System.out.printf("The Mid-Point approximation is: %f%n", midPoint);
		System.out.printf("The Mid-Point error is: %f percent%n", miderror);
		System.out.printf("The Trapazoid approximation is : %f%n", trapazoid);
		System.out.printf("The Trapazoid error is: %f percent%n", trapError);
		System.out.printf("The Simpson's approcimation is: %f%n", simpson);
		System.out.printf("The Simpson's error is: %f percent%n", simperror);
		
		
	}
		public static double mid_point(double a, double b, int n, double A, double B, double C, double D, double E, double F, double deltaX) {
		double midPoint= 0.00;
		double k = (a+(deltaX/2));
		while (k<=b){
			midPoint = midPoint + (A*(k*k*k*k*k)+B*(k*k*k*k)+C*(k*k*k)+D*(k*k)+E*(k)+F)*deltaX;
			k = k + deltaX;
		}
		return midPoint;
	}
		
		public static double trapazoid (double a, double b, int n, double A, double B, double C, double D, double E, double F, double deltaX) {
			double trapazoid = 0.00;
			double k = a;
			while (k<b) {
				double previousTrapValue = (A*(k*k*k*k*k)+B*(k*k*k*k)+C*(k*k*k)+D*(k*k)+E*(k)+F);
				k = k + deltaX;
				double currentTrapValue = (A*(k*k*k*k*k)+B*(k*k*k*k)+C*(k*k*k)+D*(k*k)+E*(k)+F);
				trapazoid = trapazoid + ((currentTrapValue+previousTrapValue)/2)*deltaX;
			}
			return trapazoid;
		}
		
		public static double simpsons_rule (double a, double b, int n, double A, double B, double C, double D, double E, double F, double deltaX) {
			double simpson = 0.00;
			double midPointValue = 0.00;
			double currentTrapValue = 0.00;
			double previousTrapVal = 0.00;
			double trapVal = 0.00;
			double x = (a+(deltaX/2));
			double k = a;
			
			while (k<b) {
				midPointValue = (A*(x*x*x*x*x)+B*(x*x*x*x)+C*(x*x*x)+D*(x*x)+E*(x)+F)*deltaX;
				x = x + deltaX;
				previousTrapVal = (A*(k*k*k*k*k)+B*(k*k*k*k)+C*(k*k*k)+D*(k*k)+E*(k)+F);
				k = k + deltaX;
				currentTrapValue = (A*(k*k*k*k*k)+B*(k*k*k*k)+C*(k*k*k)+D*(k*k)+E*(k)+F);
				trapVal = ((previousTrapVal+currentTrapValue)/2)*deltaX;
				simpson = simpson + ((midPointValue*2)+trapVal)/3;
				
			}
			return simpson;
		}
		
		public static double numerical_integration(double a, double b, int n, double A, double B, double C, double D, double E, double F, double deltaX) {
			double numerical_integration = 0.00;
			numerical_integration = (((A*(b*b*b*b*b*b))/6)+((B*(b*b*b*b*b))/5)+((C*(b*b*b*b))/4)+((D*(b*b*b))/3)+((E*(b*b))/2)+((F*(b))))- (((A*(a*a*a*a*a*a))/6)+((B*(a*a*a*a*a))/5)+((C*(a*a*a*a))/4)+((D*(a*a*a))/3)+((E*(a*a))/2)+((F*(a))));
			
			return numerical_integration;
		}

}