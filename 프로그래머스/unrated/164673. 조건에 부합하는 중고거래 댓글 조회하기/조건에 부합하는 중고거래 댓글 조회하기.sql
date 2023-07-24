SELECT a.title,
    a.board_id,
    b.reply_id,
    b.writer_id,
    b.contents,
    date_format(b.created_date, '%Y-%m-%d')
FROM used_goods_board a
INNER JOIN used_goods_reply b
ON a.board_id = b.board_id
WHERE date_format(a.created_date, '%Y-%m') like '2022-10'
ORDER BY b.created_date, a.title;