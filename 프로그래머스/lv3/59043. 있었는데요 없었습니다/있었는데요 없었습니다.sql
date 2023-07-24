SELECT
    a.animal_id,
    a.name
FROM animal_ins a
LEFT JOIN animal_outs b
ON a.animal_id = b.animal_id
WHERE timestampdiff(second, a.datetime, b.datetime) < 0
ORDER BY a.datetime 