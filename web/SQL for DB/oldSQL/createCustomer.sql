/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  chris
 * Created: 04/06/2020
 */

CREATE TABLE CUSTOMERS (
    CusEmail varchar(50) NOT NULL PRIMARY KEY,
    CusName varchar (50),
    CusPassword varchar (20),
    CusPhone varchar (13),
    CusType varchar (10)
)