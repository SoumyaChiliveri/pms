CREATE TABLE User(
    userId INT not null,
    username VARCHAR(50) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL

);
CREATE TABLE Policy(
    policyId INT NOT NULL,
    policyName VARCHAR(50) NOT NULL,
    policyDetails VARCHAR(50) NOT NULL
);
CREATE TABLE User_Policy(
    userId INT NOT NULL,
    policyId INT NOT NULL,
    amountPaid DOUBLE,
    policyEndDate DATE(7),
    valid BOOLEAN
);
ALTER TABLE User_Policy ADD FOREIGN KEY (userId) REFERENCES User(userId);
ALTER TABLE User_Policy ADD FOREIGN KEY (policyId) REFERENCES Policy(policyId);
ALTER TABLE User_Policy ADD PRIMARY KEY (userId,policyId);
