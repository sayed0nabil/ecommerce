-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ecommerce
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ecommerce
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ecommerce` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ecommerce` ;

-- -----------------------------------------------------
-- Table `ecommerce`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `credit_limit` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `image_name` VARCHAR(45),
  `password` VARCHAR(45) NOT NULL,
  `birth_date` DATE NULL,
  `admin` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecommerce`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `category_name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecommerce`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `quantity` INT NOT NULL,
  `description` VARCHAR(250),
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `category_id_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `category_id_cons`
    FOREIGN KEY (`category_id`)
    REFERENCES `ecommerce`.`category` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecommerce`.`product_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`product_image` (
  `product_id` INT NOT NULL,
  `url` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`product_id`, `url`),
  CONSTRAINT `product_id_image_cons`
    FOREIGN KEY (`product_id`)
    REFERENCES `ecommerce`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecommerce`.`credit_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`credit_card` (
  `code` INT NOT NULL AUTO_INCREMENT,
  `limit` INT NOT NULL,
  `used` TINYINT NOT NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecommerce`.`user_product_cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`user_product_cart` (
  `user_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`user_id`, `product_id`),
  CONSTRAINT `user_id_cons`
    FOREIGN KEY (`user_id`)
    REFERENCES `ecommerce`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `product_id_car_cons`
    FOREIGN KEY (`product_id`)
    REFERENCES `ecommerce`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

insert into ecommerce.user (credit_limit, first_name, last_name, email, password, admin)
values (1000, 'Admin', 'Admin', 'admin@gmail.com', 'admin', 1);
insert into ecommerce.user (credit_limit, first_name, last_name, email, password, admin)
values (1000, 'Elsayed', 'Nabil', 'sayed@gmail.com', 'sayed', 0);

insert into ecommerce.category (id, name)
values (1, 'Electronics') ;

insert into ecommerce.product (name, price, quantity, description, category_id)
values('Laptop', 5000, 10, 'Lenovo 15.6 laptop casual backpack b210 black-row.', 1);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
