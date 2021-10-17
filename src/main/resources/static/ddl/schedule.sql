CREATE SEQUENCE seq_emp;
CREATE SEQUENCE seq_scd;


CREATE TABLE employee (
    emp_no NUMBER(10),
    emp_name VARCHAR2(20) NOT NULL,
    dpt_no NUMBER(10) NOT NULL,
    pos_no NUMBER(10) NOT NULL,
    password VARCHAR2(10) NOT NULL,
    CONSTRAINT pk_employee PRIMARY KEY (emp_no)
);

CREATE TABLE department (
    dpt_no NUMBER(10),
    dpt_name VARCHAR2(20) NOT NULL,
    CONSTRAINT pk_department PRIMARY KEY(dpt_no)
);

CREATE TABLE position (
    pos_no NUMBER(10),
    pos_name VARCHAR2(20),
    CONSTRAINT pk_position PRIMARY KEY(pos_no)
);

CREATE TABLE schedule (
    scd_no NUMBER(10),
    scd_title VARCHAR2(50) NOT NULL,
    scd_content VARCHAR2(100),
    writer_emp_no NUMBER (10) NOT NULL,
    scd_code VARCHAR2 (10) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    CONSTRAINT pk_schedule PRIMARY KEY(scd_no)
);

ALTER TABLE employee
ADD CONSTRAINT fk_dpt_no FOREIGN KEY(dpt_no) REFERENCES department(dpt_no);
ALTER TABLE employee
ADD CONSTRAINT fk_pos_no FOREIGN KEY(pos_no) REFERENCES position(pos_no);
ALTER TABLE schedule
ADD CONSTRAINT fk_writer_emp_no FOREIGN KEY(writer_emp_no) REFERENCES employee(emp_no);


DROP TABLE employee;
DROP TABLE schedule;
DROP TABLE department;
DROP TABLE position;

DROP SEQUENCE seq_emp;
DROP SEQUENCE seq_scd;

SELECT * FROM employee;
SELECT * FROM department;
SELECT * FROM schedule;
SELECT * FROM position;

INSERT INTO department
VALUES (1, '사장실');
INSERT INTO department
VALUES (2, '인사부');
INSERT INTO department
VALUES (3, '개발부');
INSERT INTO department
VALUES (4, '영업부');

INSERT INTO position
VALUES (1, '사장');
INSERT INTO position
VALUES (2, '부장');
INSERT INTO position
VALUES (3, '대리');
INSERT INTO position
VALUES (4, '사원');


INSERT INTO employee
VALUES (seq_emp.nextval, '김사장', 1, 1, 1234);
INSERT INTO employee
VALUES (seq_emp.nextval, '김영업', 4, 2, 1111);
INSERT INTO employee
VALUES (seq_emp.nextval, '김철수', 4, 4, 2222);
INSERT INTO employee
VALUES (seq_emp.nextval, '이개발', 3, 4, 3333);
INSERT INTO employee
VALUES (seq_emp.nextval, '홍길동', 3, 2, 4444);

INSERT INTO schedule
VALUES (1, '첫번째 스케줄','내용',1,1,'2021-10-11','2021-10-14' );
INSERT INTO schedule
VALUES (2, '두번째 스케줄','내용',2,2,'2021-10-13','2021-10-14' );

--자바랑 sql 연동해서 시간까지 받아오는 방법..인데.....왜......
 #{startDate,jdbcType=TIMESTAMP},#{endDate,jdbcType=TIMESTAMP})