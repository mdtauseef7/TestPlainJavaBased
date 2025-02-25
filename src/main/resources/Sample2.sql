--Bucket Employees in range of salary.
SELECT
    CASE
        WHEN salary < 30000 THEN 'Below 20,000'
        WHEN salary BETWEEN 20000 AND 50000 THEN 'Between 20,000-50,000'
        ELSE 'Above 50,000'
    END AS salary_range,
    COUNT(*) AS employee_count
FROM tbl_employee
GROUP BY salary_range;