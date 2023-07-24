SELECT
    b.animal_id,
    b.name
FROM animal_ins a
INNER JOIN animal_outs b
ON a.animal_id = b.animal_id
ORDER BY datediff(b.datetime, a.datetime) desc
limit 2
