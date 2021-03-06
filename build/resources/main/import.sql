DROP SCHEMA PUBLIC CASCADE;

DROP TABLE IF EXISTS class;

DROP TABLE IF EXISTS student;

DROP TABLE IF EXISTS CLASS_STUDENT;

CREATE MEMORY TABLE IF NOT EXISTS class (ID INTEGER NOT NULL, name VARCHAR(75), description VARCHAR(255));

CREATE MEMORY TABLE IF NOT EXISTS student(ID INTEGER NOT NULL, name VARCHAR(100));

CREATE MEMORY TABLE IF NOT EXISTS CLASS_STUDENT(CLASS_ID INTEGER NOT NULL, STUDENT_ID INTEGER NOT NULL);

GRANT SELECT ON TABLE class TO PUBLIC;
GRANT SELECT ON TABLE student TO PUBLIC;
GRANT SELECT ON TABLE CLASS_STUDENT TO PUBLIC;
GRANT UPDATE ON TABLE class TO sa;
GRANT UPDATE ON TABLE student TO sa;
GRANT UPDATE ON TABLE CLASS_STUDENT TO sa;

COMMIT;

INSERT INTO class (ID, name, description) VALUES (1, 'Comp Sci', 'Computer Science'), (2, 'Math', 'Mathematics'), (3, 'English', 'English')

INSERT INTO student (ID, name) VALUES (10, 'John Smith'), (11, 'Jane Doe'), (12, 'Jack Frost');

INSERT INTO CLASS_STUDENT (CLASS_ID, STUDENT_ID) VALUES (1,11), (1,12), (2,10), (2, 11), (3,10), (3, 12);

COMMIT
