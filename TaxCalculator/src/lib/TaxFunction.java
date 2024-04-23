package lib;

public class TaxFunction {	

	private static final double taxRate = 0.05;
    private static final int maxMonthsWorked = 12;
    private static final int maxChildrenAllowed = 3;
    private static final int marriedDeduction = 54000000 + 4500000 + (maxChildrenAllowed * 1500000);
    private static final int singleDeduction = 54000000;
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int workMonths, int deductible, boolean isMarried, int childrenCount) {
        if (workMonths > maxMonthsWorked) {
            System.err.println("More than 12 months worked per year");
            return 0;
        }
        
        if (childrenCount > maxChildrenAllowed) {
            System.err.println("Number of children cannot exceed 3");
            return 0;
        }

        int deduction = isMarried ? marriedDeduction : singleDeduction;
        int taxableIncome = (monthlySalary + otherMonthlyIncome) * workMonths - deductible - deduction;

        return Math.max((int) Math.round(taxRate * taxableIncome), 0);
    }
}
