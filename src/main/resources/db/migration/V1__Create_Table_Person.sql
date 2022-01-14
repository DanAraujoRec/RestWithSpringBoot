CREATE TABLE `tb_pessoa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `first_name` varchar(80) NOT NULL,
  `gender` varchar(9) NOT NULL,
  `lastname` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
)