SELECT
    a.writer_id,
    b.nickname,
    sum(a.price) as total
FROM used_goods_board a
LEFT JOIN used_goods_user b
ON a.writer_id = b.user_id
WHERE a.status = 'DONE'
GROUP BY writer_id
HAVING total >= 700000
ORDER BY total