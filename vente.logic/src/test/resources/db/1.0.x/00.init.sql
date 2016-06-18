-- -----------------------------------------------------
-- Table `test_vente`.`shop`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_vente`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `address` VARCHAR(1000) NULL,
  `create_date` DATETIME NULL,
  `update_date` DATETIME NULL,
  `tel` VARCHAR(16) NULL,
  `shop_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `fk_user_shop_idx` (`shop_id` ASC),
  CONSTRAINT `fk_user_shop`
    FOREIGN KEY (`shop_id`)
    REFERENCES `test_vente`.`shop` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

