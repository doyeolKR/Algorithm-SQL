SELECT mcdp_cd as '진료과 코드', count(mcdp_cd) as '5월예약건수' FROM appointment
WHERE date_format(apnt_ymd, '%Y-%m') like '2022-05%'
GROUP BY mcdp_cd
ORDER BY count(mcdp_cd), mcdp_cd