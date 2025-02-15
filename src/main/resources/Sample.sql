CREATE SCHEMA gfgmicroservicesdemo
--

 --
ALTER TABLE gfgmicroservicesdemo.employee
ADD PRIMARY KEY (id);
 --
 INSERT INTO gfgmicroservicesdemo.employee(id,name,email,age) values (1,'Tauseef','tauseef@example.com',35);
 INSERT INTO gfgmicroservicesdemo.employee(id,name,email,age) values (2,'Tauseef123','tauseef@example.com',36);
 INSERT INTO gfgmicroservicesdemo.employee(id,name,email,age) values (3,'Tauseef345','tauseef@example.com',37);
 --
 SELECT * from  gfgmicroservicesdemo.employee
 --
 CREATE TABLE gfgmicroservicesdemo.address (
 id int not null,
 city varchar(255),
 state varchar(255),
 employee_id int);
 --
 INSERT INTO gfgmicroservicesdemo.address(id,city,state,employee_id) values (1,'Bangalore','KA',1);
 --
 SELECT ea.id, ea.city, ea.state FROM gfgmicroservicesdemo.address ea join gfgmicroservicesdemo.employee e on e.id = ea.employee_id where ea.employee_id= 2
 --
 select * from gfgmicroservicesdemo.address


 --
 CREATE SCHEMA mds
 --
 CREATE TABLE mds.products(
 id int,
 name varchar(255),
 price float);
 --
 select * from mds.products
 --
 drop table  mds.products
 --
  CREATE SCHEMA springbatch
  --
  SELECT * from springbatch.person
  --

   CREATE TABLE gfgmicroservicesdemo.student (
 id int not null,
 name varchar(255));
 --
INSERT INTO gfgmicroservicesdemo.student(id,name) values(1,'Tauseef');
INSERT INTO gfgmicroservicesdemo.student(id,name) values(2,'Shyam');
INSERT INTO gfgmicroservicesdemo.student(id,name) values(3,'Ram');
INSERT INTO gfgmicroservicesdemo.student(id,name) values(4,'Amritesh');
--
CREATE TABLE gfgmicroservicesdemo.result (
 id int not null,
 subject varchar(255),
 marks double,
 student_id int);
 --
 INSERT INTO gfgmicroservicesdemo.result(id,subject,marks,student_id) values(1,'Physics', 95.8, 1);
 INSERT INTO gfgmicroservicesdemo.result(id,subject,marks,student_id) values(1,'Math', 100, 2);
 INSERT INTO gfgmicroservicesdemo.result(id,subject,marks,student_id) values(1,'Physics', 92, 1);
 INSERT INTO gfgmicroservicesdemo.result(id,subject,marks,student_id) values(1,'Math', 95.8, 4);
 INSERT INTO gfgmicroservicesdemo.result(id,subject,marks,student_id) values(1,'Che', 95.9, 1);
 INSERT INTO gfgmicroservicesdemo.result(id,subject,marks,student_id) values(1,'Che', 95.8, 2);

 --
 commit;
 --
 WITH ranktabledata AS (
 select s.name, r.subject, r.marks, r.student_id, RANK() over (partition by  r.subject order by r.marks desc) AS rank1
 from gfgmicroservicesdemo.result r, gfgmicroservicesdemo.student s
 where r.student_id = s.id)
 select name, subject, marks
 from ranktabledata
 where rank1 =1;
 --
 WITH RankedMarks AS (
    SELECT
        m.subject,
        s.name,
        m.marks,
        ROW_NUMBER() OVER (PARTITION BY m.subject ORDER BY m.marks DESC) AS rank1
    FROM gfgmicroservicesdemo.result m
    JOIN gfgmicroservicesdemo.student s ON m.student_id = s.id
)
SELECT subject, name, marks
FROM RankedMarks
WHERE rank1 = 1;
--
SELECT * from gfgmicroservicesdemo.result
--
/*DECLARE
  rows_deleted INTEGER := 0;
BEGIN
  LOOP
    DELETE FROM your_table
    WHERE trans_date > to_date('',)       -- (e.g., some filtering condition, or just leave it empty for all rows)
      AND ROWNUM <= 1000);                -- Adjust this number to the batch size you want

    rows_deleted := SQL%ROWCOUNT;         -- Get the number of rows deleted in this batch

    COMMIT;  -- Optionally commit after each batch

    EXIT WHEN rows_deleted = 0;  -- Exit the loop when no more rows are deleted
  END LOOP;
END;
--














