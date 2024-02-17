// alinea a)

DROP KEYSPACE IF EXISTS cbd_ex2;

CREATE KEYSPACE cbd_ex2 WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

USE cbd_ex2;

CREATE TABLE users(
    username text PRIMARY KEY,
    nome text,
    email text,
    user_timestamp timestamp
);

CREATE TABLE videos
(
    id              int     PRIMARY KEY,
    username        text,
    name            text,
    description     text,
    tags            set<text>,
    video_timestamp timestamp
);

CREATE INDEX ON cbd_ex2.videos(tags);

CREATE TABLE videos_by_user(
    id int,
    username text,
    name text,
    description text,
    tags set<text>,
    video_timestamp timestamp,
    PRIMARY KEY ((username), video_timestamp)
);

CREATE TABLE comments(
    id int,
    video_id int,
    username text,
    comment text,
    comment_timestamp timestamp,
    PRIMARY KEY ((video_id), comment_timestamp))
    WITH CLUSTERING ORDER BY (comment_timestamp DESC);

CREATE TABLE comments_by_user(
    id int,
    video_id int,
    username text,
    comment text,
    comment_timestamp timestamp,
    PRIMARY KEY ((username), comment_timestamp))
    WITH CLUSTERING ORDER BY (comment_timestamp DESC);

CREATE TABLE comments_by_videos(
    id int,
    video_id int,
    username text,
    comment text,
    comment_timestamp timestamp,
    PRIMARY KEY ((video_id), comment_timestamp))
    WITH CLUSTERING ORDER BY (comment_timestamp DESC);

CREATE TABLE video_followers(
    video_id int,
    username text,
    PRIMARY KEY (video_id, username)
);

CREATE TABLE events(
    video_id int,
    username text,
    event_type text,
    event_timestamp timestamp,
    second timestamp,
    PRIMARY KEY ((video_id, username), event_timestamp)
);

CREATE TABLE ratings (
   video_id int,
   rating_id int,
   rating double,
   PRIMARY KEY ((video_id), rating, rating_id)
);

CREATE TABLE videos_by_rating (
   video_id int,
   rating_id int,
   rating double,
   PRIMARY KEY ((rating), video_id, rating_id)
);