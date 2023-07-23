SELECT b.flavor FROM first_half as a
LEFT JOIN icecream_info as b
ON a.flavor = b.flavor
WHERE a.total_order > 3000 and b.ingredient_type = 'fruit_based'
ORDER BY a.total_order desc