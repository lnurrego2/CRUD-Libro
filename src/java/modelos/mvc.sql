-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-09-2019 a las 00:38:01
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mvc`
--
CREATE DATABASE IF NOT EXISTS `mvc` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `mvc`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `cedula` bigint(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `rol` enum('admin','supervisor','user') DEFAULT NULL,
  `estado` tinyint(1) NOT NULL,
  `clave` varchar(200) NOT NULL,
  `f_creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `f_actualizacion` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`cedula`, `nombre`, `apellido`, `correo`, `telefono`, `rol`, `estado`, `clave`, `f_creacion`, `f_actualizacion`) VALUES
(1111, 'Santiago', 'Neira', 'sn@sn.co', 256345634, 'user', 1, '6a204bd89f3c8348afd5c77c717a097a', '2019-09-19 20:47:56', '2019-09-19 20:47:56'),
(2222, 'Felipe', 'Aguilera', 'fa@fa.co', 0, 'user', 1, '', '2019-09-19 20:52:31', '2019-09-19 19:56:59'),
(3333, 'Danilo', 'Montero', 'dm@dm.co', 300300300, 'admin', 1, 'e10adc3949ba59abbe56e057f20f883e', '2019-09-19 20:52:35', '2019-09-19 19:57:03'),
(4444, 'Laura', 'Urrego', 'lu@lu.co', 256345634, 'user', 1, '6a204bd89f3c8348afd5c77c717a097a', '2019-09-19 20:53:05', '2019-09-19 20:53:05'),
(5555, 'David', 'Duque', 'dd@dd.co', 8008000, 'user', 1, '', '2019-09-19 19:56:23', '2019-09-19 19:52:55'),
(6666, 'Leonardo', 'Bermúdez', 'lb@lb.co', 3003003000, 'admin', 1, '123456', '2019-09-19 19:56:23', '2019-09-19 19:53:11'),
(7777, 'Narem', 'Manrique', 'nm@nm.co', 256345634, 'supervisor', 1, '80d54c40a5a38e39ff066b9e88e45e46', '2019-09-19 19:56:23', '2019-09-19 19:53:56'),
(8888, 'Michael', 'GÃ³mez', 'mc@mc.co', 245245, 'supervisor', 1, 'dd31639f2bddf8f3330516fc60887a00', '2019-09-19 19:56:23', '2019-09-19 19:54:38'),
(1231231, 'Santiago', 'Neira', 'sn@sn.co', 12312312, 'admin', 1, 'c31e41940cd12cf9b24b0e528ab955bc', '2019-09-19 20:41:02', '2019-09-19 20:41:02');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
