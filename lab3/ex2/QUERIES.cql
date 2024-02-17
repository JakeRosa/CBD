// alinea b)

USE cbd_ex2;

select * from users;
select * from videos;
select * from videos_by_user;
select * from comments;
select * from comments_by_user;
select * from comments_by_videos;
select * from video_followers;
select * from events;
select * from ratings;
select * from videos_by_rating;

// alinea c)

// 7. Permitir a pesquisa de todos os vídeos de determinado autor
SELECT * FROM videos_by_user WHERE username = 'pewdiepie';

// 8. Permitir a pesquisa de comentários por utilizador, ordenado inversamente pela data
SELECT * FROM comments_by_user WHERE username = 'mrbeast' ORDER BY comment_timestamp DESC;

// 9. Permitir a pesquisa de comentários por vídeos, ordenado inversamente pela data
SELECT * FROM comments_by_videos WHERE video_id = 1 ORDER BY comment_timestamp DESC;

// 10. Permitir a pesquisa do rating médio de um vídeo e quantas vezes foi votado
SELECT video_id, AVG(rating) AS average_rating, COUNT(rating_id) AS total_votes FROM ratings WHERE video_id = 1;


// alinea d)

// 1. Os últimos 3 comentários introduzidos para um vídeo
SELECT * FROM comments WHERE video_id = 2 ORDER BY comment_timestamp DESC LIMIT 3;

// 2. Lista das tags de determinado vídeo
SELECT tags FROM videos WHERE id=1;

// 3. Todos os vídeos com a tag Aveiro
// foi criado um index para o efeito
SELECT * FROM cbd_ex2.videos WHERE tags CONTAINS 'Aveiro';

// 4. Os últimos 5 eventos de determinado vídeo realizados por um utilizador
SELECT * FROM events WHERE username='mrbeast' and video_id=1 LIMIT 5;

// 5. Vídeos partilhados por determinado utilizador (maria1987, por exemplo) num determinado período de tempo (Agosto de 2017, por exemplo)
SELECT * FROM videos_by_user WHERE username='markiplier' and video_timestamp > '2023-11-19';

// 6. Os últimos 10 vídeos, ordenado inversamente pela data da partilhada
// Impossivel, pois cada video é uma partição separada logo teria de fazer-se uma ordenação global, que não é viável em Cassandra

// 7. Todos os seguidores (followers) de determinado vídeo
SELECT username FROM video_followers WHERE video_id = 2;

// 8. Impossivel, pois não tenho uma tabela que associe os users aos videos seguidos, mas mesmo que tivesse também não seria possivel realizar a query, sendo que o problema teria de ser tratado a nivel aplicacional

// 9. Impossivel, visto que com a tabela ratings apenas consigo fazer o avg para cada partição individualmente, pois Cassandra não suporta queries globais.

// 10. Uma query que retorne todos os vídeos e que mostre claramente a forma pela qual estão ordenados
// como a partition key é o video_id, cada video tem a sua partição e não é possível fazer uma ordenação global, logo não há uma ordem clara
SELECT * FROM videos;

// 11. Impossivel, teria de ser criada uma tabela adicional para mapear cada tag ao número de videos da mesma, e manter esse mapeamento atualizado a nível aplicacional

// 12. Obter todos os ratings de um determinado video
SELECT * FROM ratings WHERE video_id = 1;

// 13. Todas as avaliações de rating 5
// Criei esta tabela a achar que fosse vir a ser necessária mas afinal não foi, aproveitei para usá-la aqui
SELECT * FROM videos_by_rating WHERE rating = 5

