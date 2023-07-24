SELECT
    member_id, 
    member_name,
    gender,
    date_format(date_of_birth, '%Y-%m-%d')
FROM member_profile
WHERE gender = 'W' and month(date_of_birth) like '3' and tlno is not null
ORDER BY member_id