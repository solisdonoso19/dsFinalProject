-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 23-07-2022 a las 20:27:00
-- Versión del servidor: 5.7.36
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ds3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
CREATE TABLE IF NOT EXISTS `especialidad` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(2) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id`, `codigo`, `descripcion`) VALUES
(1, '01', 'Medico General'),
(2, '02', 'Interno'),
(3, '03', 'Cirujano'),
(4, '04', 'Pediatra'),
(5, '05', 'Psiquiatra'),
(6, '06', 'Dermatólogo'),
(7, '07', 'Dentista'),
(8, '08', 'Reumatólogo'),
(9, '09', 'Oftalmólogo'),
(10, '10', 'Ginecólogo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicos`
--

DROP TABLE IF EXISTS `medicos`;
CREATE TABLE IF NOT EXISTS `medicos` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `codigo` int(4) NOT NULL,
  `cedula` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(7) COLLATE utf8_spanish_ci NOT NULL,
  `especialidad` varchar(2) COLLATE utf8_spanish_ci NOT NULL,
  `pacienteMes` int(3) NOT NULL,
  `pacienteAnual` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `medicos`
--

INSERT INTO `medicos` (`id`, `codigo`, `cedula`, `nombre`, `apellido`, `direccion`, `telefono`, `especialidad`, `pacienteMes`, `pacienteAnual`) VALUES
(1, 1, '6-723-1380', 'Carlos', 'solis', 'Chitre', '6279069', '06', 8, 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
CREATE TABLE IF NOT EXISTS `pacientes` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(7) COLLATE utf8_spanish_ci NOT NULL,
  `provincia` varchar(2) COLLATE utf8_spanish_ci NOT NULL,
  `edad` int(2) NOT NULL,
  `sexo` varchar(1) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`id`, `cedula`, `nombre`, `apellido`, `direccion`, `telefono`, `provincia`, `edad`, `sexo`) VALUES
(11, '99', '99', '9', '99', '9', '01', 9, '9'),
(12, '76', '7', '7', '7', '77', '01', 7, ''),
(2, '7-723-1380', 'Natha', 'Lange', 'Los Santos', '996996', '07', 22, 'F');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

DROP TABLE IF EXISTS `provincia`;
CREATE TABLE IF NOT EXISTS `provincia` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(2) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`id`, `codigo`, `descripcion`) VALUES
(1, '01', 'Bocas Del Toro'),
(2, '02', 'Chiriquí'),
(3, '03', 'Colon'),
(4, '04', 'Coclé'),
(5, '05', 'Darién'),
(6, '06', 'Herrera'),
(7, '07', 'Los Santos'),
(8, '08', 'Panamá'),
(9, '09', 'Veraguas'),
(10, '10', 'Panamá Oeste');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
