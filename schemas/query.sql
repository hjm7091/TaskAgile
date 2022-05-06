show databases;

create database app_messages;

use app_messages;

show tables;

drop table if exists `messages`;

create table `messages` (
	`id` int(11) not null auto_increment,
    `text` varchar(128) collate utf8_bin not null default '',
    `created_date` datetime not null default current_timestamp,
    primary key (`id`)
) engine=InnoDB default charset=utf8 collate=utf8_bin;

show full columns from messages;

select * from messages;

DROP SCHEMA IF EXISTS `task_agile`;

CREATE SCHEMA IF NOT EXISTS `task_agile` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `task_agile` ;

-- -----------------------------------------------------
-- Table `task_agile`.`user`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `task_agile`.`user` ;

CREATE TABLE IF NOT EXISTS `task_agile`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email_address` VARCHAR(128) NOT NULL,
  `username` VARCHAR(64) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `created_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_address_uidx` (`email_address` ASC),
  UNIQUE INDEX `username_uidx` (`username` ASC))
ENGINE = InnoDB;

show full columns from `task_agile`.`user`;

show indexes from `task_agile`.`user`;

select * from `task_agile`.`user`;

-- -----------------------------------------------------
-- Table `task_agile`.`team`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `task_agile`.`team` ;

CREATE TABLE IF NOT EXISTS `task_agile`.`team` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `archived` TINYINT(1) NOT NULL DEFAULT 0,
  `created_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_team_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `task_agile`.`user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

show full columns from `task_agile`.`team`;

show indexes from `task_agile`.`team`;

select * from `task_agile`.`team`;

-- -----------------------------------------------------
-- Table `task_agile`.`board`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `task_agile`.`board` ; 

CREATE TABLE IF NOT EXISTS `task_agile`.`board` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NOT NULL,
  `description` VARCHAR(256) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `team_id` INT(11) NULL,
  `archived` TINYINT(1) NOT NULL DEFAULT 0,
  `created_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_team_id_idx` (`team_id` ASC),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_board_team_team_id`
    FOREIGN KEY (`team_id`)
    REFERENCES `task_agile`.`team` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_board_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `task_agile`.`user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

show full columns from `task_agile`.`board`;

show indexes from `task_agile`.`board`;

select * from `task_agile`.`board`;

-- -----------------------------------------------------
-- Table `task_agile`.`board_member`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `task_agile`.`board_member` ;

CREATE TABLE IF NOT EXISTS `task_agile`.`board_member` (
  `board_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  INDEX `fk_board_id_idx` (`board_id` ASC),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  PRIMARY KEY (`user_id`, `board_id`),
  CONSTRAINT `fk_board_member_board_board_id`
    FOREIGN KEY (`board_id`)
    REFERENCES `task_agile`.`board` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_board_member_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `task_agile`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

show full columns from `task_agile`.`board_member`;

show indexes from `task_agile`.`board_member`;

select * from `task_agile`.`board_member`;

-- -----------------------------------------------------
-- Table `task_agile`.`card_list`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `task_agile`.`card_list` ;

CREATE TABLE IF NOT EXISTS `task_agile`.`card_list` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `board_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `name` VARCHAR(128) NOT NULL,
  `position` INT(11) NOT NULL,
  `archived` TINYINT(1) NOT NULL DEFAULT 0,
  `created_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_board_id_idx` (`board_id` ASC),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_card_list_board_board_id`
    FOREIGN KEY (`board_id`)
    REFERENCES `task_agile`.`board` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_card_list_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `task_agile`.`user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

show full columns from `task_agile`.`card_list`;

show indexes from `task_agile`.`card_list`;

select * from `task_agile`.`card_list`;

-- -----------------------------------------------------
-- Table `task_agile`.`card`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `task_agile`.`card` ;

CREATE TABLE IF NOT EXISTS `task_agile`.`card` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `card_list_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `description` TEXT NOT NULL,
  `position` INT(11) NOT NULL,
  `archived` TINYINT(1) NOT NULL,
  `created_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_card_list_id_idx` (`card_list_id` ASC),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_card_card_list_card_list_id`
    FOREIGN KEY (`card_list_id`)
    REFERENCES `task_agile`.`card_list` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_card_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `task_agile`.`user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

show full columns from `task_agile`.`card`;

show indexes from `task_agile`.`card`;

select * from `task_agile`.`card`;

-- -----------------------------------------------------
-- Table `task_agile`.`assignment`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `task_agile`.`assignment`;

CREATE TABLE IF NOT EXISTS `task_agile`.`assignment` (
  `card_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`card_id`, `user_id`),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_assignment_card_card_id`
    FOREIGN KEY (`card_id`)
    REFERENCES `task_agile`.`card` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_assignment_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `task_agile`.`user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

show full columns from `task_agile`.`assignment`;

show indexes from `task_agile`.`assignment`;

select * from `task_agile`.`assignment`;

-- -----------------------------------------------------
-- Table `task_agile`.`attachment`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `task_agile`.`attachment`;

CREATE TABLE IF NOT EXISTS `task_agile`.`attachment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `card_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `file_name` VARCHAR(255) NOT NULL,
  `file_path` VARCHAR(255) NOT NULL,
  `file_type` INT(11) NOT NULL,
  `archived` TINYINT(1) NOT NULL DEFAULT 0,
  `created_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_card_id_idx` (`card_id` ASC),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_attachment_card_card_id`
    FOREIGN KEY (`card_id`)
    REFERENCES `task_agile`.`card` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_attachment_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `task_agile`.`user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

show full columns from `task_agile`.`attachment`;

show indexes from `task_agile`.`attachment`;

select * from `task_agile`.`attachment`;

-- -----------------------------------------------------
-- Table `task_agile`.`activity`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `task_agile`.`activity`;

CREATE TABLE IF NOT EXISTS `task_agile`.`activity` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `card_id` INT(11) NULL,
  `board_id` INT(11) NOT NULL,
  `type` TINYINT(1) NOT NULL DEFAULT 0,
  `detail` JSON NOT NULL,
  `created_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  INDEX `fk_board_id_idx` (`board_id` ASC),
  INDEX `fk_card_id_idx` (`card_id` ASC),
  CONSTRAINT `fk_activity_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `task_agile`.`user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_board_board_id`
    FOREIGN KEY (`board_id`)
    REFERENCES `task_agile`.`board` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_activity_card_card_id`
    FOREIGN KEY (`card_id`)
    REFERENCES `task_agile`.`card` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

show full columns from `task_agile`.`activity`;

show indexes from `task_agile`.`activity`;

select * from `task_agile`.`activity`;