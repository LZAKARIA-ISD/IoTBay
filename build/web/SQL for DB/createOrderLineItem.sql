CREATE TABLE ORDERLINEITEM (
    ORDERID int NOT NULL,
    PRODUCTID int NOT NULL,
    QTY_ORDERED int,
    RATE int,
    PRIMARY KEY (ORDERID),
    CONSTRAINT PRODUCTS FOREIGN KEY (PRODUCTID)
    REFERENCES PRODUCTS(PRODUCT_ID)
);