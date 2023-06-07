INSERT INTO `new_schema1.1.4`.`roles` (`name`) VALUES ('ROLE_ADMIN');
INSERT INTO `new_schema1.1.4`.`roles` (`name`) VALUES ('ROLE_USER');

INSERT INTO `new_schema1.1.4`.`users` (`email`, `name`, `last_name`, `password`, `username`) VALUES ('admin@mail.com', 'admin', 'admin', '$2a$12$K/19g.4EART79omznyECPeWKU0DkdCCVg0Fg7tGOr7BZ4tOrYqdpy', 'admin');
INSERT INTO `new_schema1.1.4`.`users` (`email`, `name`, `last_name`, `password`, `username`) VALUES ('user@mail.com', 'user', 'user', '$2a$10$.L01AXUJylxf/8DJ39fxyO/9wINO79m1BU3niAPKTfoTsSx1nLdFO', 'user');

INSERT INTO `new_schema1.1.4`.`users_roles` (`user_id`, `roles_id`) VALUES ('1', '1');
INSERT INTO `new_schema1.1.4`.`users_roles` (`user_id`, `roles_id`) VALUES ('1', '2');
INSERT INTO `new_schema1.1.4`.`users_roles` (`user_id`, `roles_id`) VALUES ('2', '2');