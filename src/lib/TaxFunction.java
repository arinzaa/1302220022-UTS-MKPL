package lib;

public class TaxFunction {

	private static final int BASIC_NONTAXABLE_INCOME = 54000000;
	private static final int MARRIAGE_ADDITION = 4500000;
	private static final int CHILD_ADDITION = 1500000;
	private static final int MAX_CHILDREN = 3;
	private static final double TAX_RATE = 0.05;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking,
								   int deductible, boolean isMarried, int numberOfChildren) {

		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 months working per year");
		}

		int effectiveChildren = Math.min(numberOfChildren, MAX_CHILDREN);
		int totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
		int nonTaxableIncome = BASIC_NONTAXABLE_INCOME
							 + (isMarried ? MARRIAGE_ADDITION : 0)
							 + (effectiveChildren * CHILD_ADDITION);
		int taxableIncome = totalIncome - deductible - nonTaxableIncome;

		int tax = (int) Math.round(TAX_RATE * Math.max(taxableIncome, 0));

		return tax;
	}
}
