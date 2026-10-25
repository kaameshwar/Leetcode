WITH user_stats AS (
    SELECT 
        user_id,
        event_type,
        plan_name,
        monthly_amount,
        event_date,
        ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY event_date DESC) AS rn,
        MIN(event_date) OVER (PARTITION BY user_id) AS first_date,
        MAX(event_date) OVER (PARTITION BY user_id) AS last_date,
        MAX(monthly_amount) OVER (PARTITION BY user_id) AS max_amount,
        SUM(CASE WHEN event_type = 'downgrade' THEN 1 ELSE 0 END) OVER (PARTITION BY user_id) AS downgrade_count
    FROM subscription_events
)
SELECT 
    user_id,
    plan_name AS current_plan,
    monthly_amount AS current_monthly_amount,
    max_amount AS max_historical_amount,
    DATEDIFF(last_date, first_date) AS days_as_subscriber
FROM user_stats
WHERE rn = 1
  AND event_type != 'cancel'
  AND downgrade_count >= 1
  AND monthly_amount < max_amount * 0.5
  AND DATEDIFF(last_date, first_date) >= 60
ORDER BY days_as_subscriber DESC, user_id ASC;