DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
  id int NOT NULL,
  title varchar(255) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  image_url varchar(255) DEFAULT NULL,
  image_width int DEFAULT NULL,
  image_height int DEFAULT NULL,
  icon_url varchar(255) DEFAULT NULL,
  icon_width int DEFAULT NULL,
  icon_height int DEFAULT NULL,
  click_url varchar(255) DEFAULT NULL,
  impression_link varchar(255) DEFAULT NULL
);
