-- --------------------------------------------------------
-- Host:                         35.200.225.150
-- Server version:               5.7.14-google-log - (Google)
-- Server OS:                    Linux
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for test
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `test`;

-- Dumping structure for table test.property
CREATE TABLE IF NOT EXISTS `property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lat` double DEFAULT NULL,
  `lang` double DEFAULT NULL,
  `price` double DEFAULT '-1',
  `bedroom` int(11) DEFAULT NULL,
  `bathroom` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table test.property: ~18 rows (approximately)
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT IGNORE INTO `property` (`id`, `lat`, `lang`, `price`, `bedroom`, `bathroom`) VALUES
	(1, 28.668859, 77.231758, 500, 2, 2),
	(2, 28.649481, 77.238349, 1500, 4, 2),
	(3, 28.649481, 77.238349, 200, 2, 2),
	(4, 28.649481, 77.238349, 3000, 4, 4),
	(5, 28.649481, 77.238349, 1000, 0, 2),
	(6, 28.649481, 77.238349, 1210, 2, 2),
	(7, 28.649481, 77.238349, 1000, 4, 0),
	(8, 28.649481, 77.238349, 1500, 4, 2),
	(9, 28.638484, 77.240738, 3000, 1, 4),
	(10, 28.638484, 77.240738, 1000, 3, 2),
	(11, 28.627786, 77.240824, 1000, 4, 0),
	(12, 28.627786, 77.240824, 1500, 4, 2),
	(13, 28.652796, 77.428011, 3000, 1, 4),
	(14, 28.652796, 77.428011, 200, 3, 2),
	(15, 28.652796, 77.428011, 10000, 4, 4),
	(16, 28.652796, 77.428011, 1200, 3, 2),
	(17, 0, 0, 100, 2, 4),
	(18, 0, 0, 100, 2, 4);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;

-- Dumping structure for table test.searchQuery
CREATE TABLE IF NOT EXISTS `searchQuery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lat` double DEFAULT NULL,
  `lang` double DEFAULT NULL,
  `min_budget` double DEFAULT '-1',
  `max_budget` double DEFAULT '-1',
  `min_bedroom` int(11) DEFAULT '-1',
  `max_bedroom` int(11) DEFAULT '-1',
  `min_bathroom` int(11) DEFAULT '-1',
  `max_bathroom` int(11) DEFAULT '-1',
  `fromTo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table test.searchQuery: ~18 rows (approximately)
/*!40000 ALTER TABLE `searchQuery` DISABLE KEYS */;
INSERT IGNORE INTO `searchQuery` (`id`, `lat`, `lang`, `min_budget`, `max_budget`, `min_bedroom`, `max_bedroom`, `min_bathroom`, `max_bathroom`, `fromTo`) VALUES
	(1, 28.63306, 77.219302, 100, 1000, 2, 4, 1, 3, 'cp'),
	(2, 28.63306, 77.219302, -1, 1000, 0, 4, 0, 3, 'cp'),
	(3, 28.63306, 77.219302, 1012, -1, 2, 4, 1, 3, 'cp'),
	(4, 28.63306, 77.219302, 0, 1000, 2, 4, 1, 3, 'cp'),
	(5, 28.649331, 77.225822, -1, 1000, 0, 4, 2, 4, 'chawari'),
	(6, 28.649331, 77.225822, 200, -1, 2, 0, 4, 3, 'chawari'),
	(7, 28.649331, 77.225822, 200, 1000, 2, 6, 2, 0, 'chawari'),
	(8, 28.649331, 77.225822, -1, -1, 0, 0, 0, 3, 'chawari'),
	(9, 28.657616, 77.236365, 100, 1000, 2, 4, 2, 0, 'lalquila'),
	(10, 28.657616, 77.236365, 100, 1000, 4, 4, 1, 3, 'lalquila'),
	(11, 28.657616, 77.236365, 100, 1000, 2, 4, 5, 3, 'lalquila'),
	(12, 28.657616, 77.236365, -1, 1000, 0, 4, 1, 0, 'lalquila'),
	(13, 28.657616, 77.236365, 100, -1, 2, 0, 0, 3, 'lalquila'),
	(14, 28.623643, 77.219302, 100, 1000, 2, 4, 1, 3, 'nirvan'),
	(15, 28.623643, 77.219302, 100, 1000, 2, 4, 0, 3, 'nirvan'),
	(16, 28.623643, 77.219302, -1, 1000, 0, 4, 1, 3, 'nirvan'),
	(17, 28.623643, 77.219302, 100, 1000, 2, 4, 2, 0, 'nirvan'),
	(18, 28.623643, 77.219302, 100, -1, 2, 0, 1, 3, 'nirvan');
/*!40000 ALTER TABLE `searchQuery` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
