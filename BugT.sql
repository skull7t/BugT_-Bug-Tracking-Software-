CREATE TABLE `bugs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(20) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `short_hand` varchar(500) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `severity` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `tester_name` varchar(20) DEFAULT NULL,
  `developer_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `devtesters` (
  `id` int NOT NULL AUTO_INCREMENT,
  `catg` varchar(10) DEFAULT NULL,
  `project_name` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `empid` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `development` varchar(60) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `leaders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `empid` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `userid` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `manager` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `emp_code` varchar(10) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `userid` varchar(10) DEFAULT NULL,
  `company` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL,
  `to_username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `project` (
  `id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(20) DEFAULT NULL,
  `manager_n` varchar(30) DEFAULT NULL,
  `client` varchar(20) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `team_leader` varchar(20) DEFAULT NULL,
  `due` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM final_tcr.bugs;