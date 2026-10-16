WITH RECURSIVE cte AS
(
    SELECT
        content_id,
        content_text,
        1 AS pos,

        CASE
            WHEN SUBSTRING(content_text,1,1) NOT REGEXP '[A-Za-z]'
                THEN 0
            WHEN SUBSTRING_INDEX(content_text,' ',1)
                 REGEXP '^[A-Za-z]+(-[A-Za-z]+)+$'
                THEN 2
            ELSE 1
        END AS word_type,

        CAST(
            CASE
                WHEN SUBSTRING(content_text,1,1) REGEXP '[A-Za-z]'
                    THEN UPPER(SUBSTRING(content_text,1,1))
                ELSE SUBSTRING(content_text,1,1)
            END
            AS CHAR(10000)
        ) AS converted_text

    FROM user_content

    UNION ALL

    SELECT
        content_id,
        content_text,
        pos + 1,

        CASE
            WHEN SUBSTRING(content_text,pos+1,1) = ' '
                THEN 0

            WHEN SUBSTRING(content_text,pos,1) = ' '
                THEN
                    CASE
                        WHEN SUBSTRING(
                            content_text,
                            pos + 1,
                            LOCATE(
                                ' ',
                                CONCAT(SUBSTRING(content_text,pos+1),' ')
                            ) - 1
                        ) NOT REGEXP '^[A-Za-z]'
                            THEN 0

                        WHEN SUBSTRING(
                            content_text,
                            pos + 1,
                            LOCATE(
                                ' ',
                                CONCAT(SUBSTRING(content_text,pos+1),' ')
                            ) - 1
                        ) REGEXP '^[A-Za-z]+(-[A-Za-z]+)+$'
                            THEN 2

                        ELSE 1
                    END

            ELSE word_type
        END,

        CAST(
            CONCAT(
                converted_text,

                CASE
                    WHEN SUBSTRING(content_text,pos+1,1) = ' '
                        THEN ' '

                    WHEN SUBSTRING(content_text,pos,1) = ' '
                        THEN
                            CASE
                                WHEN SUBSTRING(content_text,pos+1,1)
                                     NOT REGEXP '[A-Za-z]'
                                    THEN SUBSTRING(content_text,pos+1,1)
                                ELSE UPPER(SUBSTRING(content_text,pos+1,1))
                            END

                    WHEN word_type = 0
                        THEN SUBSTRING(content_text,pos+1,1)

                    WHEN word_type = 2
                         AND SUBSTRING(content_text,pos,1) = '-'
                        THEN UPPER(SUBSTRING(content_text,pos+1,1))

                    WHEN SUBSTRING(content_text,pos+1,1) REGEXP '[A-Za-z]'
                        THEN LOWER(SUBSTRING(content_text,pos+1,1))

                    ELSE SUBSTRING(content_text,pos+1,1)
                END
            )
            AS CHAR(10000)
        )

    FROM cte
    WHERE pos < CHAR_LENGTH(content_text)
)

SELECT
    content_id,
    content_text AS original_text,
    converted_text
FROM cte
WHERE pos = CHAR_LENGTH(content_text)
ORDER BY content_id;