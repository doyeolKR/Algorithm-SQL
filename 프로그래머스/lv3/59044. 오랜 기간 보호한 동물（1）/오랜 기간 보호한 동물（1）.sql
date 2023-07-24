SELECT
    a.name,
    a.datetime
FROM animal_ins a
LEFT JOIN animal_outs b
ON a.animal_id = b.animal_id
WHERE b.animal_id is null
ORDER BY a.datetime
limit 3;