-- MySQL Script generated by MySQL Workbench
-- dom 02 ago 2015 14:55:44 ART
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pdfindexer
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pdfindexer` DEFAULT CHARACTER SET latin1 ;
USE `pdfindexer` ;

-- -----------------------------------------------------
-- Table `pdfindexer`.`tipo_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pdfindexer`.`tipo_usuario` (
  `idTipo_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo_nombre` VARCHAR(45) NULL DEFAULT NULL,
  `dia` INT(11) NULL DEFAULT NULL,
  `semana` INT(11) NULL DEFAULT NULL,
  `mes` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idTipo_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pdfindexer`.`CodigosVerificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pdfindexer`.`CodigosVerificacion` (
  `codigo` VARCHAR(45) NOT NULL,
  `dias` INT(11) NULL DEFAULT NULL,
  `usado` VARCHAR(45) NULL DEFAULT NULL,
  `id_tipo_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC),
  INDEX `fk_CodigosVerificacion_tipo_usuario1` (`id_tipo_usuario` ASC),
  CONSTRAINT `fk_CodigosVerificacion_tipo_usuario1`
    FOREIGN KEY (`id_tipo_usuario`)
    REFERENCES `pdfindexer`.`tipo_usuario` (`idTipo_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pdfindexer`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pdfindexer`.`users` (
  `USER_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  `ENABLED` TINYINT(1) NOT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `apellido` VARCHAR(45) NULL DEFAULT NULL,
  `razonsocial` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` VARCHAR(45) NULL DEFAULT NULL,
  `ruc` VARCHAR(45) NULL DEFAULT NULL,
  `mail` VARCHAR(45) NULL DEFAULT NULL,
  `tipo_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `caduca` DATE NULL DEFAULT NULL,
  `temporal` TINYINT(1) NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE INDEX `USERNAME_UNIQUE` (`USERNAME` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pdfindexer`.`busquedas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pdfindexer`.`busquedas` (
  `idBusqueda` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL DEFAULT NULL,
  `users_USER_ID` INT(10) UNSIGNED NOT NULL,
  `tipo_busqueda` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idBusqueda`),
  INDEX `fk_busqueda_users1` (`users_USER_ID` ASC),
  CONSTRAINT `fk_busqueda_users1`
    FOREIGN KEY (`users_USER_ID`)
    REFERENCES `pdfindexer`.`users` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pdfindexer`.`archivos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pdfindexer`.`archivos` (
  `idArchivo` INT(11) NOT NULL AUTO_INCREMENT,
  `busqueda_idBusqueda` INT(11) NOT NULL,
  `fechaInclucion` DATE NULL DEFAULT NULL,
  `archivo` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`idArchivo`),
  INDEX `fk_archivos_busqueda1` (`busqueda_idBusqueda` ASC),
  CONSTRAINT `fk_archivos_busqueda1`
    FOREIGN KEY (`busqueda_idBusqueda`)
    REFERENCES `pdfindexer`.`busquedas` (`idBusqueda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 148
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pdfindexer`.`documentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pdfindexer`.`documentos` (
  `idDocumento` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha_inclusion` DATE NULL DEFAULT NULL,
  `path` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`idDocumento`))
ENGINE = InnoDB
AUTO_INCREMENT = 43
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pdfindexer`.`resultado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pdfindexer`.`resultado` (
  `idResultado` INT(11) NOT NULL AUTO_INCREMENT,
  `pagina` INT(11) NOT NULL,
  `archivo` VARCHAR(240) NULL DEFAULT NULL,
  `veces_encontrada` INT(11) NULL DEFAULT NULL,
  `resultado` VARCHAR(2500) NULL DEFAULT NULL,
  `archivo_idArchivo` INT(11) NOT NULL,
  `palabra` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idResultado`),
  INDEX `fk_resultado_archivos1` (`archivo_idArchivo` ASC),
  CONSTRAINT `fk_resultado_archivos1`
    FOREIGN KEY (`archivo_idArchivo`)
    REFERENCES `pdfindexer`.`archivos` (`idArchivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 487
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pdfindexer`.`terminos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pdfindexer`.`terminos` (
  `idTermino` INT(11) NOT NULL AUTO_INCREMENT,
  `idBusqueda` INT(11) NOT NULL,
  `termino` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idTermino`),
  INDEX `fk_terminos_busqueda_idx` (`idBusqueda` ASC),
  CONSTRAINT `fk_terminos_busqueda`
    FOREIGN KEY (`idBusqueda`)
    REFERENCES `pdfindexer`.`busquedas` (`idBusqueda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pdfindexer`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pdfindexer`.`user_roles` (
  `USER_ROLE_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `USER_ID` INT(10) UNSIGNED NOT NULL,
  `AUTHORITY` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  INDEX `FK_user_roles` (`USER_ID` ASC),
  CONSTRAINT `FK_user_roles`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `pdfindexer`.`users` (`USER_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pdfindexer`.`usuario_temporal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pdfindexer`.`usuario_temporal` (
  `idUsuarioTemporal` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` VARCHAR(45) NULL DEFAULT NULL,
  `apellido` VARCHAR(45) NULL DEFAULT NULL,
  `razonsocial` VARCHAR(45) NULL DEFAULT NULL,
  `ruc` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` VARCHAR(45) NULL DEFAULT NULL,
  `mail` VARCHAR(45) NULL DEFAULT NULL,
  `passwd` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuarioTemporal`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



INSERT INTO pdfindexer.users (USERNAME,PASSWORD, ENABLED,nombre,apellido,razonsocial,telefono,ruc,mail,tipo_usuario,caduca,temporal)
VALUES ('root', 'root', TRUE,'martin','lquerica','razonsocial','4220929','ruc','sourceSistemas@gmail.com','vip','2100-03-10',true);
 
INSERT INTO pdfindexer.user_roles ( USER_ID,AUTHORITY)
VALUES ( 1, 'ROLE_USER');

insert into tipo_usuario (tipo_nombre,dia,semana,mes) values ('estandard',3,3,3);
insert into tipo_usuario (tipo_nombre,dia,semana,mes) values ('advance',6,6,6);
insert into tipo_usuario (tipo_nombre,dia,semana,mes) values ('premium',9,9,9);
insert into tipo_usuario (tipo_nombre,dia,semana,mes) values ('vip',999999,999999,999999);
