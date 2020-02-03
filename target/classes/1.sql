CREATE SCHEMA `okr` ;

CREATE TABLE `okr`.`belRegions` (
	`id_belRegions` INT NOT NULL AUTO_INCREMENT,
	`regionName` VARCHAR(45) NOT NULL,
	`regionCenterName` VARCHAR(45) NOT NULL,
	`area` DOUBLE NOT NULL,
	`popul` DOUBLE NOT NULL,
	PRIMARY KEY (`id_belRegions`));
  
INSERT INTO `okr`.`belRegions` (`regionName`, `regionCenterName`, `area`, `popul`) VALUES ('Brestskaya', 'Brest', '32.8', '1445.6');
INSERT INTO `okr`.`belRegions` (`regionName`, `regionCenterName`, `area`, `popul`) VALUES ('Vitebskaya', 'Vitebsk', '40', '1294.7');
INSERT INTO `okr`.`belRegions` (`regionName`, `regionCenterName`, `area`, `popul`) VALUES ('Gomelskaya', 'Gomel', '40.4', '1485.1');
INSERT INTO `okr`.`belRegions` (`regionName`, `regionCenterName`, `area`, `popul`) VALUES ('Grodnenskaya', 'Grodno', '25.1', '1123.5');
INSERT INTO `okr`.`belRegions` (`regionName`, `regionCenterName`, `area`, `popul`) VALUES ('Minskaya', 'Minsk', '39.96', '1474.1');
INSERT INTO `okr`.`belRegions` (`regionName`, `regionCenterName`, `area`, `popul`) VALUES ('Mogilevskaya', 'Mogilev', '29', '1146.8');
