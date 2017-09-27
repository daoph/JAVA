
/***********************************************************
* Create the database named prsDB
************************************************************/





DROP DATABASE IF EXISTS prsDB;
CREATE DATABASE prsDB;
USE prsDB;


CREATE TABLE User (
ID     					INT     						   PRIMARY KEY AUTO_INCREMENT,
UserName 				VARCHAR(20)	                       NOT NULL,
Password	    		VARCHAR(10)		 				   NOT NULL,
FirstName				VARCHAR(20)					   	   NOT NULL,
LastName				VARCHAR(20)					   	   NOT NULL,
Phone					VARCHAR(12)					   	   NOT NULL,
Email					VARCHAR(100)					   NOT NULL,
IsReviewer				BIT(1)							   NOT NULL,
IsAdmin					BIT(1)							   NOT NULL,
IsActive	  		    BIT(1)							   DEFAULT 1 NOT NULL,
DateCreated     		DATETIME						   DEFAULT CURRENT_TIMESTAMP NOT NULL,		
DateUpdated				DATETIME						   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
UpdatedByUser			INT 							   DEFAULT 0 NOT NULL,
CONSTRAINT uname UNIQUE (UserName)
);


CREATE TABLE Vendor (
ID     					INT     						   PRIMARY KEY AUTO_INCREMENT,
Code					VARCHAR(10)						   NOT NULL,
Name	    			VARCHAR(255)		 			   NOT NULL,
Address	    			VARCHAR(255)		 			   NOT NULL,
City	    			VARCHAR(255)		 			   NOT NULL,
State 	    			VARCHAR(2)		 				   NOT NULL,
Zip						VARCHAR(5)			               NOT NULL,
Phone	    			VARCHAR(12)	   					   NOT NULL,
Email			   		VARCHAR(100) 					   NOT NULL,
IsPreApproved			BIT(1)					   		   NOT NULL,
IsActive				BIT(1)					   		   NOT NULL,
DateCreated     		DATETIME						   NOT NULL,		
DateUpdated				DATETIME						   NOT NULL,
UpdatedByUser			INT 							   NOT NULL,
CONSTRAINT vcode UNIQUE (Code)
);


CREATE TABLE Product (
ID     					INT     						   PRIMARY KEY AUTO_INCREMENT,
VendorID				INT								   NOT NULL,
PartNumber				VARCHAR(50)			               NOT NULL,
Name	    		    VARCHAR(150)	 			   	   NOT NULL,
Price			        DECIMAL(10,2) 					   NOT NULL,
Unit			        VARCHAR(255) 					   		   ,
PhotoPath			    VARCHAR(255) 					           ,
IsActive				BIT(1)					   		   NOT NULL,
DateCreated     		DATETIME						   NOT NULL,		
DateUpdated				DATETIME						   NOT NULL,
UpdatedByUser			INT 							   NOT NULL,
FOREIGN KEY(VendorID) REFERENCES Vendor(ID),
CONSTRAINT vendor_part UNIQUE (VendorID, PartNumber)
);


CREATE TABLE Status (
ID     					INT     						   PRIMARY KEY AUTO_INCREMENT,
Description	    		VARCHAR(20)		 			   	   NOT NULL,
IsActive				BIT(1)					   		   NOT NULL,
DateCreated     		DATETIME						   NOT NULL,		
DateUpdated				DATETIME						   NOT NULL,
UpdatedByUser			INT 							   NOT NULL
);


CREATE TABLE PurchaseRequest (
ID     					INT     						   PRIMARY KEY AUTO_INCREMENT,
UserID					INT			                       NOT NULL,
Description	    		VARCHAR(100)		 			   NOT NULL,
Justification			VARCHAR(255)					   NOT NULL,
DateNeeded				Date					   		   NOT NULL,
DeliveryMode			VARCHAR(25)					   	   NOT NULL,
StatusID				INT						  		   NOT NULL,
Total					DECIMAL(10,2)					   NOT NULL,
SubmittedDate			DATE							   NOT NULL,
IsActive	  			BIT(1)							   NOT NULL,
ReasonForRejection 		VARCHAR(100)					           ,
DateCreated     		DATETIME						   NOT NULL,		
DateUpdated				DATETIME						   NOT NULL,
UpdatedByUser			INT 							   NOT NULL,
FOREIGN KEY(UserID) REFERENCES User(ID),
FOREIGN KEY(StatusID) REFERENCES Status(ID)
);


CREATE TABLE PurchaseRequestLineItem (
ID     					INT     						   PRIMARY KEY AUTO_INCREMENT,
PurchaseRequestID		INT			                       NOT NULL,
ProductID	    		INT		 			   			   NOT NULL,
Quantity			    INT  							   NOT NULL,
IsActive				BIT(1)					   		   NOT NULL,
DateCreated     		DATETIME						   NOT NULL,		
DateUpdated				DATETIME						   NOT NULL,
UpdatedByUser			INT 							   NOT NULL,
FOREIGN KEY(ProductID) REFERENCES Product(ID),
FOREIGN KEY(PurchaseRequestID) REFERENCES PurchaseRequest(ID),
CONSTRAINT req_pdt UNIQUE (PurchaseRequestID, ProductID)
);



INSERT into vendor Values
(1,'BB-1001	'),
(2,'AP-1001	'),
(3,'AM-1001	'),
(4,'ST-1001 '),
(5,'MC-1001	')
