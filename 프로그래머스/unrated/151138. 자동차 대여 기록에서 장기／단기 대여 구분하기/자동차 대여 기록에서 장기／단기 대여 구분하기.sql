SELECT history_id, 
        car_id, 
        date_format(start_date, '%Y-%m-%d'), 
        date_format(end_date, '%Y-%m-%d'),
        if(datediff(end_date, start_date) >= 29, '장기 대여', '단기 대여')
FROM car_rental_company_rental_history
WHERE date_format(start_date, '%Y-%m') like '2022-09'
ORDER BY history_id desc;