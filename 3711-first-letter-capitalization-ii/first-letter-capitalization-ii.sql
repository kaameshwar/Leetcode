WITH RECURSIVE
split_words AS (
    SELECT 
        content_id,
        content_text,
        1 AS word_num,
        SUBSTRING_INDEX(content_text, ' ', 1) AS word,
        SUBSTRING(content_text, LENGTH(SUBSTRING_INDEX(content_text, ' ', 1)) + 2) AS remaining
    FROM user_content
    WHERE content_text != ''
    
    UNION ALL
    
    SELECT 
        content_id,
        content_text,
        word_num + 1,
        SUBSTRING_INDEX(remaining, ' ', 1),
        SUBSTRING(remaining, LENGTH(SUBSTRING_INDEX(remaining, ' ', 1)) + 2)
    FROM split_words
    WHERE remaining != ''
),
processed_words AS (
    SELECT 
        content_id,
        word_num,
        word,
        CASE 

            WHEN word REGEXP '^[^A-Za-z]' THEN word
       
            WHEN word REGEXP '^[A-Za-z]+(-[A-Za-z]+)+$' THEN (
          
                SELECT GROUP_CONCAT(
                    CONCAT(UPPER(LEFT(part, 1)), LOWER(SUBSTRING(part, 2)))
                    ORDER BY part_num SEPARATOR '-'
                )
                FROM (
                    SELECT 
                        SUBSTRING_INDEX(SUBSTRING_INDEX(word, '-', n.n), '-', -1) AS part,
                        n.n AS part_num
                    FROM (SELECT 1 AS n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5) n
                    WHERE n.n <= 1 + LENGTH(word) - LENGTH(REPLACE(word, '-', ''))
                ) parts
            )
 
            ELSE CONCAT(UPPER(LEFT(word, 1)), LOWER(SUBSTRING(word, 2)))
        END AS processed_word
    FROM split_words
),

recombined AS (
    SELECT 
        content_id,
        GROUP_CONCAT(processed_word ORDER BY word_num SEPARATOR ' ') AS converted_text
    FROM processed_words
    GROUP BY content_id
)
SELECT 
    uc.content_id,
    uc.content_text AS original_text,
    r.converted_text
FROM user_content uc
JOIN recombined r ON uc.content_id = r.content_id;