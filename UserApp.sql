CREATE DATABASE UserApp;

USE UserApp;
CREATE TABLE `Address` (
  `AddressId` int NOT NULL AUTO_INCREMENT,
  `Street` varchar(255) DEFAULT NULL,
  `Suite` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Zipcode` varchar(255) DEFAULT NULL,
  `Latitude` varchar(45) DEFAULT NULL,
  `Longitude` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`AddressId`)
);

CREATE TABLE `Company` (
  `CompanyId` int NOT NULL AUTO_INCREMENT,
  `Companyname` varchar(255) DEFAULT NULL,
  `Catchphrase` varchar(255) DEFAULT NULL,
  `Cbs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CompanyId`)
);

CREATE TABLE `User` (
  `UserId` int NOT NULL AUTO_INCREMENT, 
  `Fullname` varchar(255) DEFAULT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL UNIQUE,
  `Phone` varchar(255) DEFAULT NULL,
  `Website` varchar(255) DEFAULT NULL,
  `CompanyId` int NOT NULL Default 1,
  `AddressId` int NOT NULL Default 1,
  PRIMARY KEY (`UserId`),
  KEY `user_ibfk_1` (`CompanyId`),
  KEY `user_ibfk_2` (`AddressId`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`CompanyId`) REFERENCES `Company` (`CompanyId`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`AddressId`) REFERENCES `Address` (`AddressId`)
);

