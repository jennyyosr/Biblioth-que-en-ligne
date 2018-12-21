-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 21 déc. 2018 à 19:20
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `livre`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `titre` varchar(50) NOT NULL,
  `auteur` varchar(20) DEFAULT NULL,
  `genre` varchar(20) DEFAULT NULL,
  `prix` varchar(5) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=213 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`id`, `titre`, `auteur`, `genre`, `prix`, `description`, `image`) VALUES
(1, 'Pride and prejudice', 'Jane Asuten', 'Romance', '15', NULL, 'assets/prideandprejudice.jpg'),
(2, 'The Vampire Diaries', 'L.J smith', 'Romance', '15', NULL, 'assets/thevampirediaries.jpg'),
(3, 'How to Kill a Mockingbird', 'Harper Lee', 'Drama', '12', NULL, 'assets/howtokillamockingbird.jpg'),
(6, 'The Lord of The Rings', 'by J.R.R. Tolkien', 'fantasy', '15', NULL, 'assets/thelordoftherings.jpg'),
(7, 'The Great Gatsby', 'F. Scott Fitzgerald', 'drama', '10', NULL, 'assets/1.jpg'),
(10, 'The Hobbit', 'J.R.R. Tolkien', 'fantasy', '7', NULL, 'assets/thehobbit.jpg'),
(11, 'The Book Thief', 'Markus Zusak', 'Drama', '16', NULL, 'assets/thebookthief.jpg'),
(15, 'The Handmaid\'s Tale', 'Margaret Atwood', 'drama', '32', NULL, 'assets/TheHandmaidTale.jpg'),
(21, 'Harry Potter and the chamber of secret', 'J.K Rowling', 'fantasy', '10', NULL, 'assets/3.jpg'),
(22, 'Harry Potter and the Prisoner of Azkaban', 'J.K Rowling', 'fantasy', '12', NULL, 'assets/the prizonerofAzkaban.jpg'),
(70, 'Harry Potter and the Philosopher stone', 'J.K Rowling', 'fantasy', '200', NULL, 'assets/harrypotter1.jpeg'),
(24, 'The Adventures of Sherlock Holmes', 'Arthur Conan Doyle', 'mystery', '20', NULL, 'assets/TheAdventuresofSherlockHolmes.jpg'),
(9, 'The Chronicles of Narnia', 'C.S. Lewis', 'fantasy', '8', NULL, 'assets/thechroniclesofnarnia.jpg'),
(13, 'The Time Traveler\'s Wife', 'Audrey Niffenegger', 'romance fantasy', '13', NULL, 'assets/TheTimeTravelersWife.jpg'),
(150, 'The Fault in our Stars', 'John Green', 'Romance', '20', NULL, 'assets/Thefaultinourstars.jpg'),
(212, 'Great Expectation', 'Charles Dickens', 'fantasy', '15', NULL, 'assets/greatexpectation.jpg'),
(100, 'Harry Potter and the Deathly Hallows', 'J.K. Rowling', 'fantasy', '15', NULL, 'assets/harrypotter7.jpg'),
(50, 'Harry Potter and the Half-Blood Prince', 'Charles Dickens', 'fantasy', '9', NULL, 'assets/HarryPotterandtheHalfBloodPrince.jpg'),
(30, 'The Lion, the Witch, and the Wadrobe', 'C.S. Lewis', 'fantasy', '13', NULL, 'assets/The Lionthe Witchand theWadrobe.jpg');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
