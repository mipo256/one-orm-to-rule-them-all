CREATE TABLE IF NOT EXISTS posts(
  id BIGSERIAL,
  topic TEXT,
  score REAL,
  created_at TIMESTAMP
);

INSERT INTO posts(id, topic, score, created_at) SELECT
  generate_series(0, 100),
  CASE floor(random() * 4)
     WHEN 0 THEN 'databases'
     WHEN 1 THEN 'operating-systems'
     WHEN 2 THEN 'compilers'
     WHEN 3 THEN 'computer-science'
  END,
  random() * 10,
  NOW() - (((random() * 100)::text) || ' days')::INTERVAL;

SELECT
	ROW_NUMBER() over(PARTITION BY topic ORDER BY score) as row_number
FROM posts;

WITH ranks AS (
  SELECT
      id,
      topic,
      score,
      ROW_NUMBER() over(PARTITION BY topic ORDER BY score DESC) as row_number
  FROM posts
  WHERE
    topic IN ('databases', 'compilers')
    AND created_at > NOW() - INTERVAL '30 days'
)
SELECT * FROM ranks r WHERE r.row_number <= 5;
