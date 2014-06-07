drop table quote;

CREATE TABLE quote (
    id     IDENTITY,
    text   VARCHAR (1000),
    author VARCHAR (100)
);

INSERT INTO QUOTE (text, author) VALUES
('Any fool can write code that a computer can understand. Good programmers write code that humans can understand', 'Martin Fowler'),
('Testing can only prove the presence of bugs, not their absence.', 'Edsger W. Dijkstra'),
('The best way to predict the future is to implement it.', 'Alan Kay'),
('There are two ways to write error-free programs; only the third one works.', 'Alan Perlis');
