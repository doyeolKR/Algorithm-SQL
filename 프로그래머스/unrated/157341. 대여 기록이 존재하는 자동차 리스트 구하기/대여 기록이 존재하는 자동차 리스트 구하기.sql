SELECT distinct(a.car_id)
FROM car_rental_company_car a
LEFT JOIN car_rental_company_rental_history b
ON a.car_id = b.car_id
WHERE a.car_type = '세단' AND b.start_date like '%2022-10%'
ORDER BY car_id desc;