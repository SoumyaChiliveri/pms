insert into policy("POLICYID","POLICYNAME","POLICYDETAILS") values (1,'Health Insurance Policy 1','Policy Details 1');
insert into policy("POLICYID","POLICYNAME","POLICYDETAILS") values (2,'Health Insurance Policy 2','Policy Details 2');
insert into policy("POLICYID","POLICYNAME","POLICYDETAILS") values (3,'Health Insurance Policy 3','Policy Details 3');
insert into policy("POLICYID","POLICYNAME","POLICYDETAILS") values (4,'Health Insurance Policy 4','Policy Details 4');
insert into policy("POLICYID","POLICYNAME","POLICYDETAILS") values (5,'Health Insurance Policy 5','Policy Details 5');

INSERT INTO user("userId", "username" , "firstName" , "lastName" , "address" , "phone" , "email" ,"password") 
VALUES (1,'yogiji','Yogi','Ji','Paperville','9990001000','email@gmail.com','yogiji');
INSERT INTO user("userId", "username" , "firstName" , "lastName" , "address" , "phone" , "email" ,"password") 
VALUES (2,'Admin','Admin','','Paperville','9990001000','email@gmail.com','Admin');

insert into user_policy("USERPOLICYID","POLICYID","USERID","AMOUNTPAID", "POLICYENDDATE","VALID") values (1,1,1,100,'2018-01-01',true);
insert into user_policy("USERPOLICYID","POLICYID","USERID","AMOUNTPAID", "POLICYENDDATE","VALID") values (2,2,1,200,'2018-01-01',true);

