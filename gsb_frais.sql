-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 13 mars 2021 à 15:44
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gsb_frais`
--

-- --------------------------------------------------------

--
-- Structure de la table `etat`
--

DROP TABLE IF EXISTS `etat`;
CREATE TABLE IF NOT EXISTS `etat` (
  `id` char(2) NOT NULL,
  `libelle` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etat`
--

INSERT INTO `etat` (`id`, `libelle`) VALUES
('CL', 'Saisie clôturée'),
('CR', 'Fiche créée, saisie en cours'),
('RB', 'Remboursée'),
('VA', 'Validée et mise en paiement');

-- --------------------------------------------------------

--
-- Structure de la table `fichefrais`
--

DROP TABLE IF EXISTS `fichefrais`;
CREATE TABLE IF NOT EXISTS `fichefrais` (
  `idutilisateur` int(4) NOT NULL,
  `mois` char(6) NOT NULL,
  `nbjustificatifs` int(11) DEFAULT NULL,
  `montantvalide` decimal(10,2) DEFAULT NULL,
  `datemodif` date DEFAULT NULL,
  `idetat` char(2) DEFAULT 'CR',
  PRIMARY KEY (`idutilisateur`,`mois`),
  KEY `idetat` (`idetat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fichefrais`
--

INSERT INTO `fichefrais` (`idutilisateur`, `mois`, `nbjustificatifs`, `montantvalide`, `datemodif`, `idetat`) VALUES
(1, '1', 0, '0.00', '2021-01-22', 'CL'),
(1, '3-2021', 0, '0.00', '2021-02-28', 'CL'),
(4, '2-2021', 0, '0.00', '2021-02-14', 'CL');

-- --------------------------------------------------------

--
-- Structure de la table `fraisforfait`
--

DROP TABLE IF EXISTS `fraisforfait`;
CREATE TABLE IF NOT EXISTS `fraisforfait` (
  `id` char(3) NOT NULL,
  `libelle` char(20) DEFAULT NULL,
  `montant` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fraisforfait`
--

INSERT INTO `fraisforfait` (`id`, `libelle`, `montant`) VALUES
('ETP', 'Forfait Etape', '110.00'),
('KM', 'Frais Kilométrique', '0.62'),
('NUI', 'Nuitée Hôtel', '80.00'),
('REP', 'Repas Restaurant', '25.00');

-- --------------------------------------------------------

--
-- Structure de la table `histoetat`
--

DROP TABLE IF EXISTS `histoetat`;
CREATE TABLE IF NOT EXISTS `histoetat` (
  `idutilisateur` int(4) NOT NULL,
  `mois` char(6) NOT NULL,
  `idetat` char(2) NOT NULL,
  PRIMARY KEY (`idutilisateur`,`mois`,`idetat`),
  KEY `idetat` (`idetat`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `lignefraisforfait`
--

DROP TABLE IF EXISTS `lignefraisforfait`;
CREATE TABLE IF NOT EXISTS `lignefraisforfait` (
  `idutilisateur` int(4) NOT NULL,
  `mois` char(6) NOT NULL,
  `idfraisforfait` char(3) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `idvehicule` int(3) DEFAULT NULL,
  PRIMARY KEY (`idutilisateur`,`mois`,`idfraisforfait`),
  KEY `idfraisforfait` (`idfraisforfait`),
  KEY `vehicule` (`idvehicule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lignefraisforfait`
--

INSERT INTO `lignefraisforfait` (`idutilisateur`, `mois`, `idfraisforfait`, `quantite`, `idvehicule`) VALUES
(1, '3-2021', 'ETP', 1, NULL),
(1, '3-2021', 'KM', 4, NULL),
(1, '3-2021', 'NUI', 2, NULL),
(1, '3-2021', 'REP', 3, NULL),
(4, '2-2021', 'ETP', 1, NULL),
(4, '2-2021', 'KM', 1, NULL),
(4, '2-2021', 'NUI', 1, NULL),
(4, '2-2021', 'REP', 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `lignefraishorsforfait`
--

DROP TABLE IF EXISTS `lignefraishorsforfait`;
CREATE TABLE IF NOT EXISTS `lignefraishorsforfait` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idutilisateur` int(4) NOT NULL,
  `mois` char(6) NOT NULL,
  `libelle` varchar(100) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `montant` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idutilisateur` (`idutilisateur`,`mois`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lignefraishorsforfait`
--

INSERT INTO `lignefraishorsforfait` (`id`, `idutilisateur`, `mois`, `libelle`, `date`, `montant`) VALUES
(20, 1, '3-2021', 'opera', '2021-02-28', '25.00'),
(21, 1, '3-2021', 'opera', '2021-02-28', '25.00'),
(22, 1, '3-2021', 'opera', '2021-02-28', '25.00'),
(23, 1, '3-2021', 'opera', '2021-02-28', '25.00'),
(24, 1, '3-2021', 'opera', '2021-02-28', '25.00'),
(25, 1, '3-2021', 'opera', '2021-02-28', '25.00'),
(26, 1, '3-2021', 'opera', '2021-02-28', '25.00'),
(27, 1, '3-2021', 'opera', '2021-02-28', '25.00');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `login` char(20) DEFAULT NULL,
  `profile` char(3) DEFAULT NULL,
  `mdp` char(64) DEFAULT NULL,
  `adresse` char(30) DEFAULT NULL,
  `cp` int(5) DEFAULT NULL,
  `ville` char(30) DEFAULT NULL,
  `date_embauche` date DEFAULT NULL,
  `datenaissance` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `login`, `profile`, `mdp`, `adresse`, `cp`, `ville`, `date_embauche`, `datenaissance`) VALUES
(1, 'penot', 'keltoum', 'keltoum', '1', 'aa09d188c6ea8184b152e0d06ee7555467875c63', '35 chemin des crêts', 42410, 'chapelle villars', '2021-01-20', '1996-03-23'),
(2, 'Zadvat', 'Hassib', 'Hassib', '3', 'aa09d188c6ea8184b152e0d06ee7555467875c63', '35 chemin des crêts', 42410, 'chapelle villars', '2021-01-20', '1996-03-23'),
(4, 'megharba', 'bruno', 'bruno', '2', 'aa09d188c6ea8184b152e0d06ee7555467875c63', 'qqpart à paris', 75000, 'paris', '2021-01-27', '2021-01-27'),
(5, 'admin', 'admin', 'admin', '3', 'aa09d188c6ea8184b152e0d06ee7555467875c63', '35 chemin des crêts', 42410, 'chapelle villars', '2021-01-20', '1996-03-23');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
CREATE TABLE IF NOT EXISTS `vehicule` (
  `idvehicule` int(3) NOT NULL,
  `libelle` char(20) DEFAULT NULL,
  `matricule` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`idvehicule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `fichefrais`
--
ALTER TABLE `fichefrais`
  ADD CONSTRAINT `fichefrais_ibfk_1` FOREIGN KEY (`idetat`) REFERENCES `etat` (`id`),
  ADD CONSTRAINT `fichefrais_ibfk_2` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `lignefraisforfait`
--
ALTER TABLE `lignefraisforfait`
  ADD CONSTRAINT `lignefraisforfait_ibfk_1` FOREIGN KEY (`idutilisateur`,`mois`) REFERENCES `fichefrais` (`idutilisateur`, `mois`),
  ADD CONSTRAINT `lignefraisforfait_ibfk_2` FOREIGN KEY (`idfraisforfait`) REFERENCES `fraisforfait` (`id`),
  ADD CONSTRAINT `lignefraisforfait_ibfk_3` FOREIGN KEY (`idvehicule`) REFERENCES `vehicule` (`idvehicule`);

--
-- Contraintes pour la table `lignefraishorsforfait`
--
ALTER TABLE `lignefraishorsforfait`
  ADD CONSTRAINT `lignefraishorsforfait_ibfk_1` FOREIGN KEY (`idutilisateur`,`mois`) REFERENCES `fichefrais` (`idutilisateur`, `mois`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
