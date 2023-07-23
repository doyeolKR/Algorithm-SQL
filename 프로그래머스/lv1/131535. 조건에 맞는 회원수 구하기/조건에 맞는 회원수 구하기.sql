SELECT count(user_id) FROM user_info
WHERE year(joined) = '2021' and age between 20 and 29;