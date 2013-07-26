-- -----------------------------------------------------
-- Table `test`.`UserConnection`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `test`.`UserConnection` (
  `userId` VARCHAR(255) NOT NULL ,
  `providerId` VARCHAR(255) NOT NULL ,
  `providerUserId` VARCHAR(255) NOT NULL DEFAULT '' ,
  `rank` INT(11) NOT NULL ,
  `displayName` VARCHAR(255) NULL DEFAULT NULL ,
  `profileUrl` VARCHAR(512) NULL DEFAULT NULL ,
  `imageUrl` VARCHAR(512) NULL DEFAULT NULL ,
  `accessToken` VARCHAR(255) NOT NULL ,
  `secret` VARCHAR(255) NULL DEFAULT NULL ,
  `refreshToken` VARCHAR(255) NULL DEFAULT NULL ,
  `expireTime` BIGINT(20) NULL DEFAULT NULL ,
  `id` BIGINT(20) NOT NULL DEFAULT '0' ,
  PRIMARY KEY (`userId`, `providerId`, `providerUserId`, `id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE UNIQUE INDEX `UserConnectionRank` ON `test`.`UserConnection` (`userId` ASC, `providerId` ASC, `rank` ASC) ;

USE `test` ;
