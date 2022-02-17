CREATE TABLE EMPLOYEE
(
    id   integer NOT NULL,
    first_name varchar,
    last_name varchar,
    position varchar,
    PRIMARY KEY (id)
);
CREATE SEQUENCE public.EMPLOYEE_S;
ALTER SEQUENCE public.EMPLOYEE_S RESTART WITH 2

