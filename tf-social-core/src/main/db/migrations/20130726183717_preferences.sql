-- -----------------------------------------------------
-- Table `test`.`Preferences`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `test`.`Preferences` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `postOnFBTimeline` BIT(1) NULL DEFAULT NULL ,
  `sendEmail` BIT(1) NULL DEFAULT NULL ,
  `user_fkey` BIGINT(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;