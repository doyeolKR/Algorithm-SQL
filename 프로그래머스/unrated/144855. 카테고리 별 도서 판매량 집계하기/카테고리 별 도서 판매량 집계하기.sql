SELECT
    a.category,
    sum(b.sales)
FROM book a
LEFT JOIN book_sales b
ON a.book_id = b.book_id
WHERE b.sales_date like '%2022-01%'
GROUP BY a.category
ORDER BY a.category