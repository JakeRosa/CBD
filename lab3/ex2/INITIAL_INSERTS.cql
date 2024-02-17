// alinea b)

USE cbd_ex2;

-- Inserções para a tabela 'users'
INSERT INTO cbd_ex2.users (username, nome, email, user_timestamp) VALUES ('pewdiepie', 'Felix Kjellberg', 'pewds@gmail.com', toTimestamp(now()));
INSERT INTO cbd_ex2.users (username, nome, email, user_timestamp) VALUES ('mrbeast', 'Jimmy Donaldson', 'mrbeast@gmail.com', toTimestamp(now()));
INSERT INTO cbd_ex2.users (username, nome, email, user_timestamp) VALUES ('daviddobrik', 'David Dobrik', 'daviddobrik@gmail.com', toTimestamp(now()));
INSERT INTO cbd_ex2.users (username, nome, email, user_timestamp) VALUES ('markiplier', 'Mark Fischbach', 'markiplier@gmail.com', toTimestamp(now()));
INSERT INTO cbd_ex2.users (username, nome, email, user_timestamp) VALUES ('lizakoshy', 'Liza Koshy', 'lizakoshy@gmail.com', toTimestamp(now()));
INSERT INTO cbd_ex2.users (username, nome, email, user_timestamp) VALUES ('ninja', 'Tyler Blevins', 'ninja@gmail.com', toTimestamp(now()));
INSERT INTO cbd_ex2.users (username, nome, email, user_timestamp) VALUES ('lillysingh', 'Lilly Singh', 'lillysingh@gmail.com', toTimestamp(now()));
INSERT INTO cbd_ex2.users (username, nome, email, user_timestamp) VALUES ('jennamarbles', 'Jenna Marbles', 'jennamarbles@gmail.com', toTimestamp(now()));
INSERT INTO cbd_ex2.users (username, nome, email, user_timestamp) VALUES ('caseyneistat', 'Casey Neistat', 'caseyneistat@gmail.com', toTimestamp(now()));
INSERT INTO cbd_ex2.users (username, nome, email, user_timestamp) VALUES ('phillyd', 'Philip DeFranco', 'phillyd@gmail.com', toTimestamp(now()));

-- Inserções para a tabela 'videos'
INSERT INTO cbd_ex2.videos (id, username, name, description, tags, video_timestamp) VALUES (1, 'pewdiepie', 'Video1', 'Descrição do Video1', {'gaming', 'funny', 'Aveiro'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos (id, username, name, description, tags, video_timestamp) VALUES (2, 'mrbeast', 'Video2', 'Descrição do Video2', {'challenge', 'philanthropy'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos (id, username, name, description, tags, video_timestamp) VALUES (3, 'daviddobrik', 'Video3', 'Descrição do Video3', {'vlog', 'comedy'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos (id, username, name, description, tags, video_timestamp) VALUES (4, 'markiplier', 'Video4', 'Descrição do Video4', {'gaming', 'horror'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos (id, username, name, description, tags, video_timestamp) VALUES (5, 'lizakoshy', 'Video5', 'Descrição do Video5', {'comedy', 'vlog', 'Aveiro'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos (id, username, name, description, tags, video_timestamp) VALUES (6, 'ninja', 'Video6', 'Descrição do Video6', {'gaming', 'streaming'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos (id, username, name, description, tags, video_timestamp) VALUES (7, 'lillysingh', 'Video7', 'Descrição do Video7', {'comedy', 'inspiration'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos (id, username, name, description, tags, video_timestamp) VALUES (8, 'jennamarbles', 'Video8', 'Descrição do Video8', {'vlog', 'comedy', 'Aveiro'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos (id, username, name, description, tags, video_timestamp) VALUES (9, 'caseyneistat', 'Video9', 'Descrição do Video9', {'vlog', 'cinematography'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos (id, username, name, description, tags, video_timestamp) VALUES (10, 'phillyd', 'Video10', 'Descrição do Video10', {'news', 'commentary'}, toTimestamp(now()));

-- Inserções para a tabela 'videos_by_user'
INSERT INTO cbd_ex2.videos_by_user (id, username, name, description, tags, video_timestamp) VALUES (1, 'pewdiepie', 'Video1', 'Descrição do Video1', {'gaming', 'funny'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos_by_user (id, username, name, description, tags, video_timestamp) VALUES (2, 'mrbeast', 'Video2', 'Descrição do Video2', {'challenge', 'philanthropy'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos_by_user (id, username, name, description, tags, video_timestamp) VALUES (3, 'daviddobrik', 'Video3', 'Descrição do Video3', {'vlog', 'comedy'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos_by_user (id, username, name, description, tags, video_timestamp) VALUES (4, 'markiplier', 'Video4', 'Descrição do Video4', {'gaming', 'horror'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos_by_user (id, username, name, description, tags, video_timestamp) VALUES (5, 'lizakoshy', 'Video5', 'Descrição do Video5', {'comedy', 'vlog'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos_by_user (id, username, name, description, tags, video_timestamp) VALUES (6, 'ninja', 'Video6', 'Descrição do Video6', {'gaming', 'streaming'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos_by_user (id, username, name, description, tags, video_timestamp) VALUES (7, 'lillysingh', 'Video7', 'Descrição do Video7', {'comedy', 'inspiration'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos_by_user (id, username, name, description, tags, video_timestamp) VALUES (8, 'jennamarbles', 'Video8', 'Descrição do Video8', {'vlog', 'comedy'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos_by_user (id, username, name, description, tags, video_timestamp) VALUES (9, 'caseyneistat', 'Video9', 'Descrição do Video9', {'vlog', 'cinematography'}, toTimestamp(now()));
INSERT INTO cbd_ex2.videos_by_user (id, username, name, description, tags, video_timestamp) VALUES (10, 'phillyd', 'Video10', 'Descrição do Video10', {'news', 'commentary'}, toTimestamp(now()));

-- Inserções para a tabela 'comments'
INSERT INTO cbd_ex2.comments (id, video_id, username, comment, comment_timestamp) VALUES (1, 2, 'pewdiepie', 'Comentário 1', toTimestamp(now()));
INSERT INTO cbd_ex2.comments (id, video_id, username, comment, comment_timestamp) VALUES (2, 3, 'mrbeast', 'Comentário 2', toTimestamp(now()));
INSERT INTO cbd_ex2.comments (id, video_id, username, comment, comment_timestamp) VALUES (3, 3, 'daviddobrik', 'Comentário 3', toTimestamp(now()));
INSERT INTO cbd_ex2.comments (id, video_id, username, comment, comment_timestamp) VALUES (4, 3, 'markiplier', 'Comentário 4',  toTimestamp(now()));
INSERT INTO cbd_ex2.comments (id, video_id, username, comment, comment_timestamp) VALUES (5, 2, 'lizakoshy', 'Comentário 5', toTimestamp(now()));
INSERT INTO cbd_ex2.comments (id, video_id, username, comment, comment_timestamp) VALUES (6, 1, 'ninja', 'Comentário 6', toTimestamp(now()));
INSERT INTO cbd_ex2.comments (id, video_id, username, comment, comment_timestamp) VALUES (7, 1, 'lillysingh', 'Comentário 7', toTimestamp(now()));
INSERT INTO cbd_ex2.comments (id, video_id, username, comment, comment_timestamp) VALUES (8, 2, 'jennamarbles', 'Comentário 8', toTimestamp(now()));
INSERT INTO cbd_ex2.comments (id, video_id, username, comment, comment_timestamp) VALUES (9, 2, 'caseyneistat', 'Comentário 9', toTimestamp(now()));
INSERT INTO cbd_ex2.comments (id, video_id, username, comment, comment_timestamp) VALUES (10, 1, 'phillyd', 'Comentário 10', toTimestamp(now()));

-- Inserções para a tabela 'comments_by_user'
INSERT INTO cbd_ex2.comments_by_user (id, video_id, username, comment, comment_timestamp) VALUES (1, 2, 'pewdiepie', 'Comentário 1', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_user (id, video_id, username, comment, comment_timestamp) VALUES (2, 3, 'mrbeast', 'Comentário 2', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_user (id, video_id, username, comment, comment_timestamp) VALUES (3, 3, 'daviddobrik', 'Comentário 3', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_user (id, video_id, username, comment, comment_timestamp) VALUES (4, 3, 'markiplier', 'Comentário 4',  toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_user (id, video_id, username, comment, comment_timestamp) VALUES (5, 2, 'lizakoshy', 'Comentário 5', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_user (id, video_id, username, comment, comment_timestamp) VALUES (6, 1, 'ninja', 'Comentário 6', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_user (id, video_id, username, comment, comment_timestamp) VALUES (7, 1, 'lillysingh', 'Comentário 7', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_user (id, video_id, username, comment, comment_timestamp) VALUES (8, 2, 'mrbeast', 'Comentário 8', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_user (id, video_id, username, comment, comment_timestamp) VALUES (9, 2, 'caseyneistat', 'Comentário 9', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_user (id, video_id, username, comment, comment_timestamp) VALUES (10, 1, 'phillyd', 'Comentário 10', toTimestamp(now()));

-- Inserções para a tabela 'comments_by_videos'
INSERT INTO cbd_ex2.comments_by_videos (id, video_id, username, comment, comment_timestamp) VALUES (1, 2, 'pewdiepie', 'Comentário 1', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_videos (id, video_id, username, comment, comment_timestamp) VALUES (2, 3, 'mrbeast', 'Comentário 2', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_videos (id, video_id, username, comment, comment_timestamp) VALUES (3, 3, 'daviddobrik', 'Comentário 3', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_videos (id, video_id, username, comment, comment_timestamp) VALUES (4, 3, 'markiplier', 'Comentário 4',  toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_videos (id, video_id, username, comment, comment_timestamp) VALUES (5, 2, 'lizakoshy', 'Comentário 5', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_videos (id, video_id, username, comment, comment_timestamp) VALUES (6, 1, 'ninja', 'Comentário 6', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_videos (id, video_id, username, comment, comment_timestamp) VALUES (7, 1, 'lillysingh', 'Comentário 7', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_videos (id, video_id, username, comment, comment_timestamp) VALUES (8, 2, 'jennamarbles', 'Comentário 8', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_videos (id, video_id, username, comment, comment_timestamp) VALUES (9, 2, 'caseyneistat', 'Comentário 9', toTimestamp(now()));
INSERT INTO cbd_ex2.comments_by_videos (id, video_id, username, comment, comment_timestamp) VALUES (10, 1, 'phillyd', 'Comentário 10', toTimestamp(now()));

-- Inserções para a tabela 'video_followers'
INSERT INTO cbd_ex2.video_followers (video_id, username) VALUES (2, 'pewdiepie');
INSERT INTO cbd_ex2.video_followers (video_id, username) VALUES (1, 'mrbeast');
INSERT INTO cbd_ex2.video_followers (video_id, username) VALUES (2, 'daviddobrik');
INSERT INTO cbd_ex2.video_followers (video_id, username) VALUES (2, 'markiplier');
INSERT INTO cbd_ex2.video_followers (video_id, username) VALUES (1, 'lizakoshy');
INSERT INTO cbd_ex2.video_followers (video_id, username) VALUES (3, 'ninja');
INSERT INTO cbd_ex2.video_followers (video_id, username) VALUES (2, 'lillysingh');
INSERT INTO cbd_ex2.video_followers (video_id, username) VALUES (1, 'jennamarbles');
INSERT INTO cbd_ex2.video_followers (video_id, username) VALUES (2, 'caseyneistat');
INSERT INTO cbd_ex2.video_followers (video_id, username) VALUES (3, 'phillyd');

-- Inserções para a tabela 'events'
INSERT INTO cbd_ex2.events (video_id, username, event_type, event_timestamp, second) VALUES (2, 'pewdiepie', 'play', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_ex2.events (video_id, username, event_type, event_timestamp, second) VALUES (1, 'mrbeast', 'pause', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_ex2.events (video_id, username, event_type, event_timestamp, second) VALUES (3, 'daviddobrik', 'stop', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_ex2.events (video_id, username, event_type, event_timestamp, second) VALUES (1, 'mrbeast', 'play', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_ex2.events (video_id, username, event_type, event_timestamp, second) VALUES (2, 'lizakoshy', 'pause', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_ex2.events (video_id, username, event_type, event_timestamp, second) VALUES (1, 'mrbeast', 'stop', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_ex2.events (video_id, username, event_type, event_timestamp, second) VALUES (1, 'mrbeast', 'play', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_ex2.events (video_id, username, event_type, event_timestamp, second) VALUES (1, 'mrbeast', 'pause', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_ex2.events (video_id, username, event_type, event_timestamp, second) VALUES (1, 'caseyneistat', 'stop', toTimestamp(now()), toTimestamp(now()));
INSERT INTO cbd_ex2.events (video_id, username, event_type, event_timestamp, second) VALUES (3, 'phillyd', 'play', toTimestamp(now()), toTimestamp(now()));

-- Inserções para a tabela 'ratings'
INSERT INTO cbd_ex2.ratings (video_id, rating_id, rating) VALUES (2, 1, 4.2);
INSERT INTO cbd_ex2.ratings (video_id, rating_id, rating) VALUES (3, 2, 4.0);
INSERT INTO cbd_ex2.ratings (video_id, rating_id, rating) VALUES (1, 3, 4.3);
INSERT INTO cbd_ex2.ratings (video_id, rating_id, rating) VALUES (2, 4, 5.0);
INSERT INTO cbd_ex2.ratings (video_id, rating_id, rating) VALUES (3, 5, 3.2);
INSERT INTO cbd_ex2.ratings (video_id, rating_id, rating) VALUES (1, 6, 3.4);
INSERT INTO cbd_ex2.ratings (video_id, rating_id, rating) VALUES (2, 7, 5.0);
INSERT INTO cbd_ex2.ratings (video_id, rating_id, rating) VALUES (3, 8, 4.1);
INSERT INTO cbd_ex2.ratings (video_id, rating_id, rating) VALUES (1, 9, 5.0);
INSERT INTO cbd_ex2.ratings (video_id, rating_id, rating) VALUES (2, 10, 4.6);

-- Inserções para a tabela 'videos_by_rating'
INSERT INTO cbd_ex2.videos_by_rating (video_id, rating_id, rating) VALUES (2, 1, 4.2);
INSERT INTO cbd_ex2.videos_by_rating (video_id, rating_id, rating) VALUES (3, 2, 4.0);
INSERT INTO cbd_ex2.videos_by_rating (video_id, rating_id, rating) VALUES (1, 3, 4.3);
INSERT INTO cbd_ex2.videos_by_rating (video_id, rating_id, rating) VALUES (2, 4, 5.0);
INSERT INTO cbd_ex2.videos_by_rating (video_id, rating_id, rating) VALUES (3, 5, 3.2);
INSERT INTO cbd_ex2.videos_by_rating (video_id, rating_id, rating) VALUES (1, 6, 3.4);
INSERT INTO cbd_ex2.videos_by_rating (video_id, rating_id, rating) VALUES (2, 7, 5.0);
INSERT INTO cbd_ex2.videos_by_rating (video_id, rating_id, rating) VALUES (3, 8, 4.1);
INSERT INTO cbd_ex2.videos_by_rating (video_id, rating_id, rating) VALUES (1, 9, 5.0);
INSERT INTO cbd_ex2.videos_by_rating (video_id, rating_id, rating) VALUES (2, 10, 4.6);