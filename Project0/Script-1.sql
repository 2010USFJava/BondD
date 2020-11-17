

--DDL 
create schema if not exists project0 authorization "Tech"; 

set search_path to project0;



create table if not exists account (account_id serial primary key , 
balance double precision, is_deactivated boolean, is_pending boolean);

create table if not exists account_lookup (account_id integer, 
	customer_id integer, primary key (account_id, customer_id));

create table if not exists customer (first_name varchar(30), last_name varchar(30), 
	is_active boolean, user_name varchar (30), 
	password varchar (30), customer_id serial primary key,  
	address varchar(50), phone_number varchar(12));

create table if not exists employee (first_name varchar(30), last_name varchar(30), 
	is_active boolean, user_name varchar (30), password varchar (30),
	employee_id serial primary key, position varchar(30));

alter table account add column time_stamp timestamp,
	add column update_type varchar(10), 
	add column updated_by varchar(20);

create table if not exists project0.transactions (deposit double precision, 
	withdrawl double precision, account_id integer primary key, 
	time_stamp timestamp);

alter table account_lookup add constraint fk_acct_id foreign key (account_id) 
references account (account_id) on update cascade on delete cascade;



alter table account_lookup add constraint fk_cust_id_update foreign key (customer_id) 
references customer (customer_id) on update cascade on delete cascade;


alter sequence project0.customer_customer_id_seq restart with 10000 increment by 1;
alter sequence project0.account_account_id_seq restart with 100000 increment by 1;

alter table employee add column status varchar(8);

--DML testing in DB before writing in STS

--select all statments 
select * from project0.employee;
select * from project0.customer;
select* from project0.account;
select* from project0.account_lookup;


--Insert sameple data
insert into customer (first_name, last_name, is_active, user_name, password, address, phone_number)
 values ('john', 'doe', true, 'jodoe', 'password', '123 anywhere street, anytown USA, 12345', '555-555-1212');
insert into customer (first_name, last_name, is_active, user_name, password, address, phone_number)
 values ('Jane', 'Doe', true, 'jadoe', 'password', '123 Anywhere St, Anytown USA, 12345', '555-555-1213'),
		('Sally', 'Joe', true, 'SalJo', 'password', '125 Anywhere St, Anytown USA, 12345', '555-555-2323'),
		('Joe', 'Joe', true, 'JoJo', 'password', '125 Anywhere St, Anytown USA, 12345', '555-555-2212'); 

update customer set first_name = 'John', last_name = 'Doe' where customer_id = 10000;

insert into employee (first_name,last_name, is_active, user_name, password , position)
values ('Admin', 'Administrator', true, 'admin', 'password', 'Administrator');

insert into account (balance, is_deactivated,is_pending) values (150.00, false, true);

insert into account_lookup (account_id, customer_id) values (100000, 10000);

update employee set status = 'ADMIN' where user_name = 'admin';

-- function
create function lookup ( ) returns integer  as $variable$
declare 
	variable integer;
begin 
	select count(*) into variable from account_lookup;
	return variable;
end; $variable$ language plpgsql;

select lookup();


