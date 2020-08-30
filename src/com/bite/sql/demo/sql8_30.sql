/**
找出所有员工当前(to_date='9999-01-01')具体的薪水salary情况，对于相同的薪水只显示一次,并按照逆序显示
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
 */

 select salary distinct
 from
 salaries
 where to_date = '9999-01-01'
 group by salary
 order by salary desc ;


/**
获取所有部门当前(dept_manager.to_date='9999-01-01')manager的当前(salaries.to_date='9999-01-01')薪水情况，
给出dept_no, emp_no以及salary(请注意，同一个人可能有多条薪水情况记录)
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
 */
select d.dept_no,d.emp_no,s.salary
from salaries s,dept_manager d
where d.to_date='9999-01-01' and s.to_date='9999-01-01'
and s.emp_no = d.emp_no;


/**
获取所有非manager的员工emp_no
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
 */

 select emp_no
 from employees
 where emp_no not in
 (select emp_no from dept_manager)

 select employees.emp_no
 from employees left join dept_manager
 on employees.emp_no = dept_manager.emp_no
 and dept_manager.dept_no = null