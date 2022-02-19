CREATE TABLE TASK
(
    id          INTEGER NOT NULL,
    employee_id INTEGER,
    title  VARCHAR,
    "description"   VARCHAR,
    date_created    DATE,
    date_completion DATE,
    "uid"        VARCHAR,
    PRIMARY KEY (id)
);

CREATE SEQUENCE public.TASK_S;
ALTER SEQUENCE public.TASK_S RESTART WITH 2