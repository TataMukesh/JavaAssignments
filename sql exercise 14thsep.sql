-- Add 5 years 10 months and 6 days to the given date
select adddate(adddate(curdate(),INTERVAL '5-10' YEAR_MONTH), interval '6' DAY); 

--  Display DayName of last day of current month
select DAYNAME(last_day(curdate()));

-- Display last day of the year
select CONCAT("31-12-",YEAR(CURDATE()));

-- Display the first Day of the previous month
select adddate(last_day(adddate(curdate(), INTERVAL '-2' MONTH)), INTERVAL '1' DAY);

-- Display the last occurrence of given char in a string
select length('hello') - instr(reverse('hello'),'l') + 1;

-- Display all names of Emp table in sentence case means (first char capital and remining are lower case)
use infinite;
select concat(left(ename,1),lower(right((ename),length(ename)-1))) from emp;

-- In Word 'misissipi' count no.of i's
select length('misissipi') - length(replace('misissipi', 'i', ''));

-- 1) Display all records from agent table
select * from agent;

-- 2) Display all records from Agent whose MaritalStatus is 0
select *
from agent
where maritalstatus = 0;

-- 3) Display AgentId, firstName,LastName,city,state, MaritalStatus, 

		-- if maritalStatus is 0 then 'Unmarried'
        -- if maritalStatus is 1 then 'Married'
select AgentId, firstName,LastName,city,state,
case MaritalStatus
	when 0 then 'Unmarried'
    when 1 then 'Married'
    end 'MaritalStatus'
from agent;

-- 4) Display all records from Policy 
select * from policy;

-- 5) Display all records whose Annualpremium > 100000
select * from policy where AnnualPremium > 100000;

-- 6) Display PolicyID, AppNumber, PayMode, 	
	-- if paymode is 1 then 'Yearly'
	-- if payMode is 2 then 'Half-Yearly'
	-- if payMode is 3 then 'Quarterly'
select PolicyID, AppNumber,
case PaymentModeId
	when 1 then 'Yearly'
    when 2 then 'Half-Yearly'
    when 3 then 'Quarterly'
end 'PayMode'
from policy;