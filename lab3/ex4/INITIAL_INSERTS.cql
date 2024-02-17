USE spotify;

INSERT INTO spotify.users (username, name, email) VALUES ('paul2001', 'Paulo Pereira', 'paulo@gmail.com');
INSERT INTO spotify.users (username, name, email) VALUES ('ritaa13', 'Rita Almeida', 'ralmeida@gmail.com');
INSERT INTO spotify.users (username, name, email) VALUES ('tiagosilvs', 'Tiago Silva', 'silva@gmail.com');
INSERT INTO spotify.users (username, name, email) VALUES ('juls', 'Julia Andrade', 'juls@gmail.com');
INSERT INTO spotify.users (username, name, email) VALUES ('pedrocas', 'Pedro Ferreira', 'pedrocas@gmail.com');
INSERT INTO spotify.users (username, name, email) VALUES ('luispires', 'Luis Pires', 'pires@gmail.com');
INSERT INTO spotify.users (username, name, email) VALUES ('alexfigueiredo', 'Alexandre Figueiredo', 'afigs@gmail.com');
INSERT INTO spotify.users (username, name, email) VALUES ('andreluis', 'Andre Luis', 'alalal@gmail.com');

INSERT INTO spotify.artists (artist_id, artist_name, music_style) VALUES (1, 'Richie Campbell', {'Reggae', 'Pop'});
INSERT INTO spotify.artists (artist_id, artist_name, music_style) VALUES (2, 'Xutos e Pontapés', {'Rock'});
INSERT INTO spotify.artists (artist_id, artist_name, music_style) VALUES (3, 'GNR', {'Pop Rock'});
INSERT INTO spotify.artists (artist_id, artist_name, music_style) VALUES (4, 'Nirvana', {'Rock'});
INSERT INTO spotify.artists (artist_id, artist_name, music_style) VALUES (5, 'Red Hot Chili Peppers', {'Funk Rock', 'Funk Metal', 'Punk Rock'});
INSERT INTO spotify.artists (artist_id, artist_name, music_style) VALUES (6, 'Linkin Park', {'Rock', 'Metal', 'Pop', 'Alternative Rock'});
INSERT INTO spotify.artists (artist_id, artist_name, music_style) VALUES (7, 'Ornatos Violeta', {'Alternative Rock', 'Ska', 'Jazz'});
INSERT INTO spotify.artists (artist_id, artist_name, music_style) VALUES (8, 'Foo Fighters', {'Alternative Rock', 'Grunge', 'Hard Rock'});
INSERT INTO spotify.artists (artist_id, artist_name, music_style) VALUES (9, 'U2', {'Alternative Rock', 'Rock'});
INSERT INTO spotify.artists (artist_id, artist_name, music_style) VALUES (10, 'Queen', {'Hard Rock', 'Pop Rock', 'Prog Rock'});

INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (1, 'Do You No Wrong', 1, '2016-05-05');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (2, 'Let You Go', 1, '2023-04-15');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (3, 'A Minha Casinha', 2, '1988-11-13');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (4, 'Contentores', 2, '1987-10-11');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (5, 'Sangue Oculto', 3, '1992-06-23');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (6, 'Efectivamente', 3, '1986-09-26');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (7, 'Smells Like Teen Spirit', 4, '1991-11-18');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (8, 'Come As You Are', 4, '1991-03-04');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (9, 'Under The Bridge', 5, '1992-03-12');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (10, 'Snow (Hey Oh)', 5, '2007-01-17');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (11, 'What Ive Done', 6, '2007-04-01');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (12, 'Ouvi Dizer', 7, '1999-11-22');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (13, 'Everlong', 8, '1997-08-18');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (14, 'With Or Without You', 9, '1987-03-16');
INSERT INTO spotify.songs (song_id, song_name, artist_id, released) VALUES (15, 'Under Pressure', 10, '1981-10-25');

INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (1, 'Do You No Wrong', 1, '2016-05-05');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (2, 'Let You Go', 1, '2023-04-15');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (3, 'A Minha Casinha', 2, '1988-11-13');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (4, 'Contentores', 2, '1987-10-11');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (5, 'Sangue Oculto', 3, '1992-06-23');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (6, 'Efectivamente', 3, '1986-09-26');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (7, 'Smells Like Teen Spirit', 4, '1991-11-18');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (8, 'Come As You Are', 4, '1991-03-04');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (9, 'Under The Bridge', 5, '1992-03-12');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (10, 'Snow (Hey Oh)', 5, '2007-01-17');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (11, 'What Ive Done', 6, '2007-04-01');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (12, 'Ouvi Dizer', 7, '1999-11-22');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (13, 'Everlong', 8, '1997-08-18');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (14, 'With Or Without You', 9, '1987-03-16');
INSERT INTO spotify.songs_by_artist (song_id, song_name, artist_id, released) VALUES (15, 'Under Pressure', 10, '1981-10-25');

INSERT INTO spotify.playlists (playlist_id, playlist_name, songs) VALUES (1, 'Richie Playlist', ['Do You No Wrong', 'Let You Go']);
INSERT INTO spotify.playlists (playlist_id, playlist_name, songs) VALUES (2, 'Rock Tuga', ['A Minha Casinha', 'Contentores', 'Sangue Oculto', 'Efectivamente', 'Ouvi Dizer']);
INSERT INTO spotify.playlists (playlist_id, playlist_name, songs) VALUES (3, 'Rock Hits', ['Smells Like Teen Spirit', 'Come As You Are', 'Under The Bridge', 'Snow (Hey Oh)', 'What Ive Done', 'Everlong', 'With Or Without You', 'Under Pressure']);

INSERT INTO spotify.following (username, artist_id, artist_name) VALUES ('paul2001', 1, 'Richie Campbell');
INSERT INTO spotify.following (username, artist_id, artist_name) VALUES ('paul2001', 2, 'Xutos e Pontapés');
INSERT INTO spotify.following (username, artist_id, artist_name) VALUES ('paul2001', 3, 'GNR');
INSERT INTO spotify.following (username, artist_id, artist_name) VALUES ('paul2001', 7, 'Ornatos Violeta');
INSERT INTO spotify.following (username, artist_id, artist_name) VALUES ('juls', 4, 'Nirvana');
INSERT INTO spotify.following (username, artist_id, artist_name) VALUES ('juls', 5, 'Red Hot Chili Peppers');
INSERT INTO spotify.following (username, artist_id, artist_name) VALUES ('juls', 6, 'Linkin Park');
INSERT INTO spotify.following (username, artist_id, artist_name) VALUES ('juls', 8, 'Foo Fighters');
INSERT INTO spotify.following (username, artist_id, artist_name) VALUES ('juls', 9, 'U2');
INSERT INTO spotify.following (username, artist_id, artist_name) VALUES ('juls', 10, 'Queen');

INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('paul2001', 1, 'Do You No Wrong');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('paul2001', 2, 'Let You Go');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('paul2001', 3, 'A Minha Casinha');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('paul2001', 4, 'Contentores');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('paul2001', 5, 'Sangue Oculto');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('paul2001', 6, 'Efectivamente');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('paul2001', 12, 'Ouvi Dizer');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('juls', 7, 'Smells Like Teen Spirit');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('juls', 8, 'Come As You Are');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('juls', 9, 'Under The Bridge');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('juls', 10, 'Snow (Hey Oh)');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('juls', 11, 'What Ive Done');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('juls', 13, 'Everlong');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('juls', 14, 'With Or Without You');
INSERT INTO spotify.liked_songs(username, song_id, song_name) VALUES ('juls', 15, 'Under Pressure');

INSERT INTO spotify.liked_playlists(username, playlist_id, playlist_name) VALUES ('paul2001', 1, 'Richie Playlist');
INSERT INTO spotify.liked_playlists(username, playlist_id, playlist_name) VALUES ('paul2001', 2, 'Rock Tuga');
INSERT INTO spotify.liked_playlists(username, playlist_id, playlist_name) VALUES ('juls', 3, 'Rock Hits');

INSERT INTO spotify.user_reviews(username, reviews) VALUES ('paul2001', {1: 5, 2: 4, 3: 4, 4: 4, 5: 4, 6: 4, 12: 5});
INSERT INTO spotify.user_reviews(username, reviews) VALUES ('juls', {7: 5, 8: 4, 9: 4, 10: 4, 11: 5, 13: 4, 14: 4, 15: 5});

























