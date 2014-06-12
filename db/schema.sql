drop table quote if exists;
drop table user if exists;

CREATE TABLE user (
   id IDENTITY,
   login VARCHAR(100),
   password VARCHAR(100)
);


CREATE TABLE quote (
    id     IDENTITY,
    text   VARCHAR (1000),
    author VARCHAR (100)
);

INSERT INTO user (login, password) VALUES
('admin', 'strongpassword');

INSERT INTO quote (text, author) VALUES
('Any fool can write code that a computer can understand. Good programmers write code that humans can understand', 'Martin Fowler'),
('Testing can only prove the presence of bugs, not their absence.', 'Edsger W. Dijkstra'),
('The best way to predict the future is to implement it.', 'Alan Kay'),
('There are two ways to write error-free programs; only the third one works.', 'Alan Perlis');

