/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  chris
 * Created: 04/06/2020
 */

CREATE TABLE STAFF (
    StaffEmail varchar(50) NOT NULL PRIMARY KEY,
    StaffName varchar (50),
    StaffPassword varchar (20),
    StaffPhone varchar (13),
    StaffPos varchar (50)
)
