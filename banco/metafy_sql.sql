-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fiaptdso
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fiaptdso` DEFAULT CHARACTER SET utf8 ;
USE `fiaptdso` ;

-- -----------------------------------------------------
-- Table `fiaptdso`.`tbl_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fiaptdso`.`tbl_usuario` ;

CREATE TABLE IF NOT EXISTS `fiaptdso`.`tbl_usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `ds_nome` VARCHAR(72) NOT NULL,
  `ds_email` VARCHAR(255) NOT NULL,
  `dt_nascimento` DATE NOT NULL,
  `dt_criacao` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `ds_senha` VARCHAR(72) NOT NULL,
  `im_avatar_url` VARCHAR(200) NULL,
  `nr_telefone` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `ds_email_unique` ON `fiaptdso`.`tbl_usuario` (`ds_email` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `fiaptdso`.`tbl_criador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fiaptdso`.`tbl_criador` ;

CREATE TABLE IF NOT EXISTS `fiaptdso`.`tbl_criador` (
  `id_criador` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  `vl_avaliacao` INT,
  PRIMARY KEY (`id_criador`, `id_usuario`),
  CONSTRAINT `fk_criador_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `fiaptdso`.`tbl_usuario` (`id_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `idx_criador_usuario_id_usuario` ON `fiaptdso`.`tbl_criador` (`id_usuario` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `fiaptdso`.`tbl_evento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fiaptdso`.`tbl_evento` ;

CREATE TABLE IF NOT EXISTS `fiaptdso`.`tbl_evento` (
  `id_evento` INT NOT NULL AUTO_INCREMENT,
  `ds_nome` VARCHAR(72) NOT NULL,
  `ds_descricao` TINYTEXT NOT NULL,
  `vl_avaliacao` INT NULL,
  `dt_inicio` DATETIME NOT NULL,
  `dt_fim` DATETIME NOT NULL,
  `id_criador` INT NOT NULL,
  PRIMARY KEY (`id_evento`, `id_criador`),
  CONSTRAINT `fk_evento_criador`
    FOREIGN KEY (`id_criador`)
    REFERENCES `fiaptdso`.`tbl_criador` (`id_criador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `idx_evento_criador_id_criador` ON `fiaptdso`.`tbl_evento` (`id_criador` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `fiaptdso`.`tbl_usuario_evento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fiaptdso`.`tbl_usuario_evento` ;

CREATE TABLE IF NOT EXISTS `fiaptdso`.`tbl_usuario_evento` (
  `id_usuario` INT NOT NULL,
  `id_evento` INT NOT NULL,
  PRIMARY KEY (`id_usuario`, `id_evento`),
  CONSTRAINT `fk_usuario_evento`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `fiaptdso`.`tbl_usuario` (`id_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_evento_usuario`
    FOREIGN KEY (`id_evento`)
    REFERENCES `fiaptdso`.`tbl_evento` (`id_evento`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `idx_tbl_usuario_evento_id_evento` ON `fiaptdso`.`tbl_usuario_evento` (`id_evento` ASC) VISIBLE;

CREATE INDEX `idx_tbl_usuario_evento_id_usuario` ON `fiaptdso`.`tbl_usuario_evento` (`id_usuario` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
