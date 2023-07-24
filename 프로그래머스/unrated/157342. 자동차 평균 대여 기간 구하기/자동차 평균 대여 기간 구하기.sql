SELECT
    car_id,
    ROUND(avg(datediff(end_date, start_date)+1), 1) as AVERAGE_DURATION
FROM car_rental_company_rental_history
GROUP BY car_id
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION desc, car_id desc