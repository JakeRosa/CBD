// alinea e)
DELETE FROM spotify.users WHERE username = 'pedrocas';
DELETE FROM spotify.users WHERE username = 'luispires';
DELETE FROM spotify.users WHERE username = 'alexfigueiredo';
DELETE FROM spotify.users WHERE username = 'andreluis';
DELETE FROM spotify.users WHERE username = 'tiagosilvs';

UPDATE spotify.users SET name = 'Paulo Pereira Júnior' WHERE username = 'paul2001';
UPDATE spotify.user_reviews SET reviews[7] = 5 WHERE username = 'juls';
UPDATE spotify.playlists SET songs =  ['NÃO SOU O UNICO', 'A Minha Casinha', 'Contentores', 'Sangue Oculto', 'Efectivamente', 'Ouvi Dizer'] WHERE playlist_id = 2;
UPDATE spotify.artists SET music_style = {'ROCKZÃO'} WHERE artist_id = 2;
UPDATE spotify.users SET email = 'juliaandrade@gmail.com' WHERE username = 'juls';


// alinea f)

// Retorna a música mais recente de um artista específico
SELECT song_name, released FROM spotify.songs_by_artist WHERE artist_id = 1 LIMIT 1;

// Retorna uma playlist específica
SELECT * FROM spotify.playlists WHERE playlist_id = 1;

// Retorna os artistas seguidos por um user
SELECT * FROM spotify.following WHERE username = 'paul2001';

// Retorna as músicas curtidas por um user
SELECT * FROM spotify.liked_songs WHERE username = 'paul2001';

// Conta o número de músicas curtidas por user
SELECT username, COUNT(*) AS liked_songs_count FROM spotify.liked_songs GROUP BY username;

// Retorna as playlists curtidas por um user
SELECT * FROM spotify.liked_playlists WHERE username = 'paul2001';

// Obtém as informações de uma música específica
SELECT * FROM spotify.songs WHERE song_name = 'Do You No Wrong';

// Obtém as músicas de um artista ordenadas das mais antigas para as mais recentes
SELECT * FROM spotify.songs_by_artist WHERE artist_id = 1 ORDER BY released ASC;

// Obtém as informações de um user específico
SELECT * FROM spotify.users WHERE username = 'paul2001';

// Retorna as avaliações de um user específico
SELECT * FROM spotify.user_reviews WHERE username = 'juls';

// Obtém os artistas que têm um determinado estilo de música
SELECT * FROM spotify.artists WHERE music_style CONTAINS 'Alternative Rock';

// Obtém as músicas de uma determinada data
SELECT * FROM spotify.songs WHERE released = '2007-01-17';

