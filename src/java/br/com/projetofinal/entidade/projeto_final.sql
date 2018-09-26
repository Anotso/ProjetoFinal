-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 27-Set-2018 às 00:41
-- Versão do servidor: 8.0.12
-- versão do PHP: 7.2.10-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projeto_final`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientepf`
--

CREATE TABLE `clientepf` (
  `idpf` int(11) NOT NULL,
  `nomepf` varchar(20) DEFAULT NULL,
  `snomepf` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sexopf` varchar(1) DEFAULT NULL,
  `cpfpf` varchar(11) DEFAULT NULL,
  `rgpf` varchar(10) DEFAULT NULL,
  `dtnascpf` varchar(10) DEFAULT NULL,
  `emailpf` varchar(30) DEFAULT NULL,
  `senhapf` varchar(15) DEFAULT NULL,
  `telpf` varchar(13) DEFAULT NULL,
  `celpf` varchar(14) DEFAULT NULL,
  `ceppf` varchar(8) DEFAULT NULL,
  `ruapf` varchar(30) DEFAULT NULL,
  `bairropf` varchar(15) DEFAULT NULL,
  `cidadepf` varchar(25) DEFAULT NULL,
  `estadopf` varchar(25) DEFAULT NULL,
  `complpf` varchar(40) DEFAULT NULL,
  `refpf` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `idfor` int(11) NOT NULL,
  `nomefor` varchar(40) DEFAULT NULL,
  `emailfor` varchar(35) DEFAULT NULL,
  `sitefor` varchar(30) DEFAULT NULL,
  `telfor` varchar(13) DEFAULT NULL,
  `cnpjfor` varchar(14) DEFAULT NULL,
  `cepfor` varchar(8) DEFAULT NULL,
  `ruafor` varchar(30) DEFAULT NULL,
  `numfor` varchar(6) DEFAULT NULL,
  `complfor` varchar(40) DEFAULT NULL,
  `bairrofor` varchar(15) DEFAULT NULL,
  `cidadefor` varchar(25) DEFAULT NULL,
  `estadofor` varchar(25) DEFAULT NULL,
  `ativofor` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientepf`
--
ALTER TABLE `clientepf`
  ADD PRIMARY KEY (`idpf`),
  ADD UNIQUE KEY `emailpf` (`emailpf`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`idfor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientepf`
--
ALTER TABLE `clientepf`
  MODIFY `idpf` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `idfor` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
