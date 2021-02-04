-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Feb 04, 2021 at 10:51 AM
-- Server version: 5.7.26
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `geocache`
--

-- --------------------------------------------------------

--
-- Table structure for table `cache`
--

CREATE TABLE `cache` (
  `idCache` bigint(20) NOT NULL,
  `coordonnees` varchar(20) NOT NULL,
  `description` varchar(20) NOT NULL,
  `etat` varchar(20) NOT NULL,
  `nature` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `lieuId` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `lieu`
--

CREATE TABLE `lieu` (
  `idLieu` bigint(20) NOT NULL,
  `nomLieu` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lieu`
--

INSERT INTO `lieu` (`idLieu`, `nomLieu`) VALUES
(1, 'Lens');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUtilisateur` bigint(20) NOT NULL,
  `description` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `pseudo` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `visite`
--

CREATE TABLE `visite` (
  `idVisite` bigint(20) NOT NULL,
  `commentaire` varchar(20) DEFAULT NULL,
  `nomLieu` datetime NOT NULL,
  `logCache` varchar(20) DEFAULT NULL,
  `cacheID` bigint(20) DEFAULT NULL,
  `utilsateurId` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cache`
--
ALTER TABLE `cache`
  ADD PRIMARY KEY (`idCache`),
  ADD KEY `FK3ktecht12g53gv9cptm8ylh30` (`lieuId`);

--
-- Indexes for table `lieu`
--
ALTER TABLE `lieu`
  ADD PRIMARY KEY (`idLieu`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`);

--
-- Indexes for table `visite`
--
ALTER TABLE `visite`
  ADD PRIMARY KEY (`idVisite`),
  ADD KEY `FKkm4t00d2t7s0hh1n4ywummrlb` (`cacheID`),
  ADD KEY `FKayls98egt1xsjfln6qilgac4q` (`utilsateurId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cache`
--
ALTER TABLE `cache`
  MODIFY `idCache` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lieu`
--
ALTER TABLE `lieu`
  MODIFY `idLieu` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `visite`
--
ALTER TABLE `visite`
  MODIFY `idVisite` bigint(20) NOT NULL AUTO_INCREMENT;
