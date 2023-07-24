SELECT hour(datetime) as hour, count(*) FROM animal_outs
WHERE hour(datetime) between 9 and 19
GROUP BY hour 
ORDER BY hour