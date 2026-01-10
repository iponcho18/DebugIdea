-- Crear esquema
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(300),
    age INT,
    email VARCHAR(150),
    password VARCHAR(300),
    create_at TIMESTAMP,
    create_by VARCHAR(150),
    update_at TIMESTAMP,
    update_by VARCHAR(150)
);

CREATE TABLE page (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(300) UNIQUE,
    create_at TIMESTAMP,
    create_by VARCHAR(150),
    update_at TIMESTAMP,
    update_by VARCHAR(150),
    id_user INT UNIQUE,
    FOREIGN KEY (id_user) REFERENCES usuario(id)
);

CREATE TABLE post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(300),
    create_at TIMESTAMP,
    create_by VARCHAR(150),
    update_at TIMESTAMP,
    update_by VARCHAR(150),
    img VARCHAR(255),
    id_page INT,
    FOREIGN KEY (id_page) REFERENCES page(id)
);

CREATE TABLE service (
      service_id VARCHAR(100) PRIMARY KEY,
      service_description VARCHAR(200),
      service_host VARCHAR(80),
      service_port INT,
      service_secure SMALLINT,
      service_timeout SMALLINT,
      service_baseurl VARCHAR(200),
      service_name VARCHAR(100),
      service_method VARCHAR(20)
);

INSERT INTO service (service_id,service_host,service_method,service_port,service_secure,service_baseurl,service_name,service_timeout,service_description) values ('IFCONFIG','ifconfig.io','GET',443,1,'/','all.json',10,'');

-- Insertar datos en la tabla AppUser
INSERT INTO usuario (name, age, email, password,create_at,update_at) VALUES ('User1', 25, 'user1@example.com', 'password1',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO usuario (name, age, email, password,create_at,update_at) VALUES ('User2', 30, 'user2@example.com', 'password2',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO usuario (name, age, email, password,create_at,update_at) VALUES ('User3', 28, 'user3@example.com', 'password3',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO usuario (name, age, email, password,create_at,update_at) VALUES ('User4', 29, 'user4@example.com', 'password4',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

-- Insertar datos en la tabla Page para cada usuario
INSERT INTO Page (create_at,update_at, title, id_user) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'User1 Page', 1);
INSERT INTO Page (create_at,update_at, title, id_user) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'User2 Page', 2);
INSERT INTO Page (create_at,update_at, title, id_user) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'User3 Page', 3);

-- Insertar datos en la tabla Post para cada página
-- Posts para la página de User1
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 1 for User1', 'img1.jpg', 1);
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 2 for User1', 'img2.jpg', 1);
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 3 for User1', 'img3.jpg', 1);
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 4 for User1', 'img4.jpg', 1);
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 5 for User1', 'img5.jpg', 1);

-- Posts para la página de User2
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 1 for User2', 'img1.jpg', 2);
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 2 for User2', 'img2.jpg', 2);
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 3 for User2', 'img3.jpg', 2);
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 4 for User2', 'img4.jpg', 2);
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 5 for User2', 'img5.jpg', 2);

-- Posts para la página de User3
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 1 for User3', 'img1.jpg', 3);
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 2 for User3', 'img2.jpg', 3);
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 3 for User3', 'img3.jpg', 3);
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 4 for User3', 'img4.jpg', 3);
INSERT INTO Post (create_at,update_at, content, img, id_page) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 'Content 5 for User3', 'img5.jpg', 3);
