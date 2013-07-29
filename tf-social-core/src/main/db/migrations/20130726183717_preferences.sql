CREATE TABLE `Preferences` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `post_on_fb_timeline` BIT(1) NULL DEFAULT NULL ,
  `send_email` BIT(1) NULL DEFAULT NULL ,
  `user_fkey` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB;

ALTER TABLE 
	Preferences 
ADD CONSTRAINT 
	fk_preferences_user_connection
		FOREIGN KEY (user_fkey) REFERENCES UserConnection(id);