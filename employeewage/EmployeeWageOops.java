package empWageOOPS;
import java.util.ArrayList;
import java.util.HashMap;
public class EmployeeWageOops implements InEmployeeWageOops{
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;
	int daySalary;
	ArrayList<Integer>dailyWage=new ArrayList<Integer>();
	private ArrayList<CompanyEmpWage> companyEmpWageArrayList;
	private HashMap<String,CompanyEmpWage> companyEmpWageMap;
	public EmployeeWageOops() {
		companyEmpWageArrayList=new ArrayList<>();
		companyEmpWageMap=new HashMap<>();
	}
	public void dailyWage()
	{
		dailyWage.add(daySalary);
	}
	public void addCompanyEmpWage(String company,int empRatePerHr,int numberOfWorkingDays,int maxHrPerMonth) {
		CompanyEmpWage companyEmpWage=new CompanyEmpWage(company,empRatePerHr,numberOfWorkingDays,maxHrPerMonth);
		companyEmpWageArrayList.add(companyEmpWage);
		companyEmpWage.setTotalEmpWage(this.computerEmpWage(companyEmpWage));
		System.out.println(companyEmpWage);
	}
}
private int computeEmpWage(CompanyEmpWage companyEmpWage) {
	int empHrs=0;
	int totalEmpHrs=0;
	int totalWorkingDays=0;
	while(totalEmpHrs <= companyEmpWage.maxHrPerMonth && totalWorkingDays < companyEmpWage.numberOfWorkingDays) {
		totalWorkingDays++;
		double empCheck=Math.floor(Math.random()*10)%3;
		switch ((int) empCheck) {
		case IS_FULL_TIME:
			empHrs=8;
			break;
		case IS_PART_TIME:
			empHrs=4;
			break;
		default:
			empHrs=0;
		}
		int daySalary=empHrs*companyEmpWage.empRatePerHr;
		companyEmpWage.dailyWage.add(daySalary);
		totalEmpHrs+=empHrs;
		System.out.println(companyEmpWage.dailyWage);
		return totalEmpHrs*companyEmpWage.empRatePerHr;
	}
	public int getTotalEmpWage(String company)
	{
		return companyEmpWageMap.get(company).totalEmpWage;
		}
	}
public static void main(String args[])
{
	EmployeeWageOops empWageBuilder=new EmployeeWageOops();
	empWageBuilder.addCompanyEmpWage("icici",50,4,100);
	empWageBuilder.addCompanyEmpWage("DMart",20,4,100);
	empWageBuilder.addCompanyEmpWage("TCS",68,0,100);
	empWageBuilder.addCompanyEmpWage("IBM",180,8,100);
	empWageBuilder.addCompanyEmpWage("Google",180,10,100);
	empWageBuilder.computeEmpWage();
	System.out.println("Total wage of queried company:"+empWageBuilder.getTotalEmpWage("Google"));
	System.out.println();
}
interface InEmployeeWagesOops
{
	public void addCompanyEmpWage(String company,int empRatePerHr,int numberOfWorkingDays,int maxHrPerMonth);
	public void computeEmpWage();
}
class CompanyEmpWage
{
	public String company;
	public int empRatePerHr;
	public int numberOfWorkingDays;
	public int maxHrPerMonth;
	public int totalEmpWage;
	ArrayList<Integer>dailyWage=new ArrayList<Integer>();
    public CompanyEmpWage(String company,int numberOfWorkingDays,int maxHrsPerMonth)
    {
    	this.company=company;
    	this.empRatePerHr=empRatePerHr;
    	this.numberOfWorkingDays=numberOfWorkingDays;
    	this.maxHrsPerMonth=maxHrsPerMonth;
    }
    public void setTotalEmpWage(int totalEmpWage)
    {
    	this.totalEmpWage=totalEmpWage;
    }
    public String toString()
    {
    	return "Total Employee Wage for"+company+"is"+totalEmpWage;    
    	}
    }
