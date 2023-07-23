SELECT pt_name, pt_no, gend_cd, age, if(tlno is null, 'NONE', tlno) FROM patient
WHERE gend_cd = 'W' and age <= 12
ORDER BY age desc, pt_name;