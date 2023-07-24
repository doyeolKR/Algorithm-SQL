SELECT
    b.ingredient_type,
    sum(a.total_order) as TOTAL_ORDER
FROM first_half a
JOIN icecream_info b
ON a.flavor = b.flavor
GROUP BY b.ingredient_type
ORDER BY TOTAL_ORDER