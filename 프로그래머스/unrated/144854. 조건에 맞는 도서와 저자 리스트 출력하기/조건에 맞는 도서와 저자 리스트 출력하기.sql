SELECT
    a.book_id,
    b.author_name,
    date_format(a.published_date, '%Y-%m-%d')
FROM book a
JOIN author b 
ON a.author_id = b.author_id
WHERE a.category like '%경제%'
ORDER BY a.published_date