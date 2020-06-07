/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sam
 * Created: 05/06/2020
 */

CREATE TABLE "PRODUCTS"
(    
   "PRODUCT_ID" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),   
   "NAME" VARCHAR(50),     
   "DETAIL" VARCHAR(100),
   "TYPE" VARCHAR(50),
   "PRICE" DOUBLE,  
   "QUANTITY" INTEGER   
);