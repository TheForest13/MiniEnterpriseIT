CREATE TABLE EMPLOYEE
(
    id          INTEGER NOT NULL,
    first_name  VARCHAR,
    last_name   VARCHAR,
    position    VARCHAR,
    current_emp BOOLEAN,
    PRIMARY KEY (id)
);

CREATE SEQUENCE public.EMPLOYEE_S;
ALTER SEQUENCE public.EMPLOYEE_S RESTART WITH 2

