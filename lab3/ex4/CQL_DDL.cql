DROP KEYSPACE IF EXISTS spotify;

CREATE KEYSPACE spotify WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 3};

CREATE TABLE spotify.users (
    username TEXT PRIMARY KEY,
    name TEXT,
    email TEXT
);

CREATE TABLE spotify.artists (
    artist_id INT PRIMARY KEY,
    artist_name TEXT,
    music_style SET<TEXT>
);

CREATE INDEX ON spotify.artists(music_style);

CREATE TABLE spotify.songs (
    song_id INT PRIMARY KEY,
    song_name TEXT,
    artist_id INT,
    released date
);

CREATE INDEX ON spotify.songs(song_name);
CREATE INDEX ON spotify.songs (released);

CREATE TABLE spotify.songs_by_artist (
    artist_id INT,
    song_id INT,
    song_name TEXT,
    released date,
    PRIMARY KEY (artist_id, released, song_id)
) WITH CLUSTERING ORDER BY (released DESC);

CREATE TABLE spotify.playlists (
    playlist_id INT PRIMARY KEY,
    playlist_name TEXT,
    songs LIST<TEXT>,
);

CREATE TABLE spotify.following (
    username TEXT,
    artist_id INT,
    artist_name TEXT,
    PRIMARY KEY (username, artist_id)
);

CREATE TABLE spotify.liked_songs (
    username TEXT,
    song_id INT,
    song_name TEXT,
    PRIMARY KEY (username, song_id)
);

CREATE TABLE spotify.liked_playlists (
    username TEXT,
    playlist_id INT,
    playlist_name TEXT,
    PRIMARY KEY (username, playlist_id)
);

CREATE TABLE spotify.user_reviews (
    username TEXT PRIMARY KEY,
    reviews MAP<INT, INT>
);

