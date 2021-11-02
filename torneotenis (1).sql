-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-11-2021 a las 04:02:29
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `torneotenis`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuentros`
--

CREATE TABLE `encuentros` (
  `id_encuentro` int(11) NOT NULL,
  `fechaEnc` date NOT NULL,
  `estadoEnCurso` int(11) NOT NULL,
  `ganador` int(11) DEFAULT NULL,
  `id_jugador1` int(11) NOT NULL,
  `id_jugador2` int(11) NOT NULL,
  `id_estadio` int(11) NOT NULL,
  `id_torneo` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `encuentros`
--

INSERT INTO `encuentros` (`id_encuentro`, `fechaEnc`, `estadoEnCurso`, `ganador`, `id_jugador1`, `id_jugador2`, `id_estadio`, `id_torneo`, `activo`) VALUES
(1, '2021-10-12', 1, 16, 17, 16, 2, 2, 1),
(2, '2021-11-09', 3, NULL, 16, 17, 1, 1, 1),
(3, '2021-11-02', 0, 18, 18, 20, 3, 1, 1),
(4, '2021-11-04', 0, 21, 17, 21, 2, 1, 1),
(5, '2021-11-15', 3, NULL, 23, 24, 2, 3, 1),
(6, '2021-11-16', 3, NULL, 22, 25, 1, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadio`
--

CREATE TABLE `estadio` (
  `id_estadio` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `ciudad` varchar(30) NOT NULL,
  `ancho` float NOT NULL,
  `largo` float NOT NULL,
  `categoria` varchar(30) NOT NULL,
  `habilitado` tinyint(1) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estadio`
--

INSERT INTO `estadio` (`id_estadio`, `nombre`, `ciudad`, `ancho`, `largo`, `categoria`, `habilitado`, `direccion`, `capacidad`, `activo`) VALUES
(1, 'La Pedrera', 'Villa Mercedes', 8.23, 24, 'cesped', 1, 'La Ribera', 15000, 1),
(2, 'Juan Gilberto Funes', 'La Punta', 8.23, 24, 'ladrillo', 1, 'La Punta', 18000, 1),
(3, 'Jockey Club', 'San Luis', 8.23, 23.77, 'cemento', 1, 'Justo Daract 1005', 2000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `id_jugador` int(11) NOT NULL,
  `nombreApellido` varchar(45) NOT NULL,
  `dni` int(11) NOT NULL,
  `fechaNac` date NOT NULL,
  `altura` float NOT NULL,
  `peso` float NOT NULL,
  `estilo` varchar(30) NOT NULL,
  `manoHabil` varchar(30) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`id_jugador`, `nombreApellido`, `dni`, `fechaNac`, `altura`, `peso`, `estilo`, `manoHabil`, `activo`) VALUES
(16, 'Roger Federer', 21548765, '1981-08-08', 1.9, 90, 'Agresivo', 'diestro', 0),
(17, 'Rafael Nadal', 32548265, '1986-07-21', 1.85, 95, 'Defensivo', 'zurdo', 0),
(18, 'Rama Alaniz', 28547569, '1980-04-25', 1.8, 90, 'TodaLaCancha', 'diestro', 0),
(19, 'Novak Djockovic', 30546852, '1987-05-22', 1.88, 87, 'Atacante', 'zurdo', 0),
(20, 'Juan Martin Del Potro', 32658741, '1988-09-23', 1.98, 90, 'TodaLaCancha', 'diestro', 0),
(21, 'Andy Murray', 29564852, '1987-05-15', 1.9, 87, 'Defensivo', 'zurdo', 0),
(22, 'Serena Williams', 2548632, '1981-09-26', 1.75, 70, 'Agresivo', 'diestro', 0),
(23, 'Maria Sharapova', 28548965, '1987-04-19', 1.88, 73, 'Atacante', 'zurdo', 0),
(24, 'Vic Alaniz', 31542776, '1985-10-11', 1.63, 57, 'Agresivo', 'diestro', 0),
(25, 'Pato Baigorria', 27548965, '1978-12-01', 1.7, 60, 'Voleadora', 'diestra', 0),
(26, 'Vicky Alaniz', 34951362, '1985-10-11', 1.65, 63.7, 'voleadora', 'diestra', 1),
(28, 'Pato Baigorria', 27632541, '1985-10-11', 179, 67, 'jugadora de toda la cancha', 'zurda', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patrocinio`
--

CREATE TABLE `patrocinio` (
  `id_patrocinio` int(11) NOT NULL,
  `id_sponsor` int(11) NOT NULL,
  `id_jugador` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `patrocinio`
--

INSERT INTO `patrocinio` (`id_patrocinio`, `id_sponsor`, `id_jugador`, `activo`) VALUES
(1, 1, 16, 1),
(2, 4, 19, 1),
(3, 3, 16, 1),
(4, 2, 21, 1),
(5, 5, 23, 1),
(6, 1, 22, 1),
(7, 4, 24, 1),
(8, 3, 25, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sponsor`
--

CREATE TABLE `sponsor` (
  `id_sponsor` int(11) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `indumentaria` varchar(30) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sponsor`
--

INSERT INTO `sponsor` (`id_sponsor`, `marca`, `indumentaria`, `activo`) VALUES
(1, 'Nike', 'zapatillas', 1),
(2, 'Wilson', 'raquetas', 1),
(3, 'Adidas', 'indumentaria', 1),
(4, 'LaCoste', 'indumentaria', 1),
(5, 'Caro Cuore', 'Ropa interior', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneos`
--

CREATE TABLE `torneos` (
  `id_torneo` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `fecha_ini` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `torneos`
--

INSERT INTO `torneos` (`id_torneo`, `nombre`, `fecha_ini`, `fecha_fin`, `activo`) VALUES
(1, 'Master 1000', '2021-11-01', '2021-11-30', 1),
(2, 'Roland Garros', '2021-10-01', '2021-10-31', 1),
(3, 'San Luis Open', '2021-11-15', '2021-11-30', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `encuentros`
--
ALTER TABLE `encuentros`
  ADD PRIMARY KEY (`id_encuentro`),
  ADD KEY `id_estadio` (`id_estadio`),
  ADD KEY `id_jugadorL` (`id_jugador1`),
  ADD KEY `id_jugadorV` (`id_jugador2`),
  ADD KEY `id_torneo` (`id_torneo`),
  ADD KEY `ganador` (`ganador`);

--
-- Indices de la tabla `estadio`
--
ALTER TABLE `estadio`
  ADD PRIMARY KEY (`id_estadio`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`id_jugador`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  ADD PRIMARY KEY (`id_patrocinio`),
  ADD KEY `id_jugador` (`id_jugador`),
  ADD KEY `id_sponsor` (`id_sponsor`);

--
-- Indices de la tabla `sponsor`
--
ALTER TABLE `sponsor`
  ADD PRIMARY KEY (`id_sponsor`);

--
-- Indices de la tabla `torneos`
--
ALTER TABLE `torneos`
  ADD PRIMARY KEY (`id_torneo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `encuentros`
--
ALTER TABLE `encuentros`
  MODIFY `id_encuentro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `estadio`
--
ALTER TABLE `estadio`
  MODIFY `id_estadio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `id_jugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  MODIFY `id_patrocinio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `sponsor`
--
ALTER TABLE `sponsor`
  MODIFY `id_sponsor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `torneos`
--
ALTER TABLE `torneos`
  MODIFY `id_torneo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `encuentros`
--
ALTER TABLE `encuentros`
  ADD CONSTRAINT `encuentros_ibfk_1` FOREIGN KEY (`id_estadio`) REFERENCES `estadio` (`id_estadio`),
  ADD CONSTRAINT `encuentros_ibfk_2` FOREIGN KEY (`id_jugador1`) REFERENCES `jugador` (`id_jugador`),
  ADD CONSTRAINT `encuentros_ibfk_3` FOREIGN KEY (`id_jugador2`) REFERENCES `jugador` (`id_jugador`),
  ADD CONSTRAINT `encuentros_ibfk_4` FOREIGN KEY (`id_torneo`) REFERENCES `torneos` (`id_torneo`),
  ADD CONSTRAINT `encuentros_ibfk_5` FOREIGN KEY (`ganador`) REFERENCES `jugador` (`id_jugador`);

--
-- Filtros para la tabla `patrocinio`
--
ALTER TABLE `patrocinio`
  ADD CONSTRAINT `patrocinio_ibfk_1` FOREIGN KEY (`id_jugador`) REFERENCES `jugador` (`id_jugador`),
  ADD CONSTRAINT `patrocinio_ibfk_2` FOREIGN KEY (`id_sponsor`) REFERENCES `sponsor` (`id_sponsor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
