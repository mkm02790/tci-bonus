# tci-bonus

Summary of coding assignment
The Implementation Logic
API Signatures and Class Structures
API Signature
BonusCalculator Service
EmployeMapper Service
Bonus DTO Class - this maps to the bonus json object
Employee DTO Class
Sample Request and Response Json
Sample Request
Sample Response


1.	Summary of coding assignment

You are required to create a very small Spring project that implements an API which determines which employees are eligible for a bonus. It receives a list of bonus elements in the json (see later sections for details and structure) and returns a list of eligible employee elements in the response json (see later sections for details and structure)

You will be graded on the following:
●	Correctness: given an incoming json, the response should be correct
●	Use of gradle to build the project
●	Use of java stream apis
●	Exception Handling: are we returning the error message if something goes wrong?
●	Any unit test that you write

Depending on your experience, you may be able to implement some or all, but attempt as much as you can.

You can either upload the project source on gitlab/bitbucket etc (preferable) or alternatively, you can show us the implementation from your machine when we speak.

Time for the exercise: try and return this within 3 days.


2.	The Implementation Logic

This figure below explains the flow (you need to implement the controller, the BonusCalculator Service and the EmployeeMapper Service and the Bonus and Employee DTO objects):

 
Note: the API structure, Service and DTO class signatures and the sample request and response jsons are all defined in section 3 and 4 of this document

a.	In the controller, convert the incoming json (see section 4 for sample request json) to Bonus DTOs and invoke the Spring service BonusCalculator
b.	The service BonusCalculator will  filter out the employees who are not active as of today  (which means those who have either exit or not yet joined)
c.	The BonusCalculator service will then call another Spring service, EmployeeMapper that takes the list of the filtered Bonus objects and maps these to Employee objects . It then return a hashmap with key currency and value as list of  employees sorted by name
d.	Finally the controller will convert this hashmap to a json of employee elements(see section 4 for sample response json)

3.	API Signatures and Class Structures

a.	API Signature
POST /tci/bonus/eligibility
Request body: see sample request in section 4
Response body: : see sample response in section 4

b.	BonusCalculator Service

public interface BonusCalculator{
	public Map<String, List<Employee>> calculate(List<Bonus>);
}

c.	EmployeMapper Service
public interface EmployeeMapper{
	public Map<String, List<Employee>> map (List<Bonus>);
//in the returned map the key is currency and the value is sorted list of employee for that currency

}

d.	Bonus DTO Class - this maps to the bonus json object

public class Bonus {
//the data types of these fields are as per the incoming json bonus element
  empName;
  amount;
  currency;
  joiningDate;
  exitDate;
  
  //add getter/Setter
}


e.	Employee DTO Class
Public class Employee{
	String name;
long amount;
//add getter and setters
}




4.	Sample Request and Response Json 
a.	Sample Request
{
	"bonus": [
		{
			"empName": "raj singh",
			"amount": 5000,
			"currency": "INR",
			"joiningDate": "may-20-2022",
			"exitDate": "may-20-2023"
		},
		{
			"empName": "pratap m",
			"amount": 3000,
			"currency": "INR",
			"joiningDate": "jan-01-2021",
			"exitDate": "may-20-2023"
		},
		{
			"empName": "sushmita lal",
			"amount": 4000,
			"currency": "INR",
			"joiningDate": "jan-01-2021",
			"exitDate": "dec-31-2021"
		},
		{
			"empName": "sam",
			"amount": 2500,
			"currency": "USD",
			"joiningDate": "may-20-2022",
			"exitDate": "may-20-2023"
		},
		{
			"empName": "john",
			"amount": 2500,
			"currency": "USD",
			"joiningDate": "jan-20-2023",
			"exitDate": "dec-30-2024"
		},
		{
			"empName": "susan",
			"amount": 700,
			"currency": "USD",
			"joiningDate": "jan-01-2022",
			"exitDate": "dec-31-2022"
		}
	]
}






b.	Sample Response
{
	"errorMessage": "",
	"data": [
	  {
			"currency": "INR",
			"employees": [
				{
					"empName": "pratap m",
					"amount": 3000
				},
				{
					"name": "raj singh",
					"amount": 5000
				}
			]
		},
		{
			"currency": "USD",
			"employees": [
				{
					"empName": "sam",
					"amount": 2500
				},
				{
					"empName": "susan",
					"amount": 700
				}
			]
		}
	]
}






