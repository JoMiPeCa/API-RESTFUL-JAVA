SET DB_CLOSE_DELAY -1;        
;             
CREATE USER IF NOT EXISTS "USER" SALT '7009b83574fc38e1' HASH '6a6159733bc9dbd771500c5f0e4c491332079a0d0b0b80c07628a1e0fc570909' ADMIN;       
CREATE SEQUENCE "PUBLIC"."hibernate_sequence" START WITH 5;   
CREATE CACHED TABLE "PUBLIC"."personal_data"(
    "email" VARCHAR(100) NOT NULL,
    "name" VARCHAR(100) NOT NULL,
    "password" VARCHAR(100) NOT NULL,
    "phones_number" VARCHAR(100),
    "session_data_id" BINARY
);              
ALTER TABLE "PUBLIC"."personal_data" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("email");             
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.personal_data;           
INSERT INTO "PUBLIC"."personal_data" VALUES
('test@test.com', 'john Smith', 'testA12', '12345678', X'edc6bc2beb514e179211d24cadb889df');     
CREATE CACHED TABLE "PUBLIC"."phones"(
    "number" VARCHAR(100) NOT NULL,
    "citycode" VARCHAR(3) NOT NULL,
    "countrycode" VARCHAR(3) NOT NULL
);   
ALTER TABLE "PUBLIC"."phones" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C" PRIMARY KEY("number");   
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.phones;  
INSERT INTO "PUBLIC"."phones" VALUES
('12345678', '1', '12');
CREATE CACHED TABLE "PUBLIC"."session_data"(
    "id" BINARY NOT NULL,
    "date_created" DATE NOT NULL,
    "date_modified" DATE,
    "isactive" BOOLEAN NOT NULL,
    "last_login" DATE,
    "token" VARCHAR(255)
); 
ALTER TABLE "PUBLIC"."session_data" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_D" PRIMARY KEY("id"); 
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.session_data;            
INSERT INTO "PUBLIC"."session_data" VALUES
(X'edc6bc2beb514e179211d24cadb889df', DATE '2022-04-17', DATE '2022-04-17', TRUE, DATE '2022-04-17', NULL);       
ALTER TABLE "PUBLIC"."personal_data" ADD CONSTRAINT "PUBLIC"."FKpk46q0co15lv6gqaymwcvnsre" FOREIGN KEY("phones_number") REFERENCES "PUBLIC"."phones"("number") NOCHECK;       
ALTER TABLE "PUBLIC"."personal_data" ADD CONSTRAINT "PUBLIC"."FKqj0wjjr5j8b3ic4h6ijfb3ilf" FOREIGN KEY("session_data_id") REFERENCES "PUBLIC"."session_data"("id") NOCHECK;   
