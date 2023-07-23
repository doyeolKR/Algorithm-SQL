SELECT dr_name, dr_id, mcdp_cd, date_format(hire_ymd, '%Y-%m-%d') FROM doctor
WHERE mcdp_cd = 'cs' or mcdp_cd = 'gs'
ORDER BY hire_ymd desc, dr_name;