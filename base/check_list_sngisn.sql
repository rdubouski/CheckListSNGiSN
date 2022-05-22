-- phpMyAdmin SQL Dump
-- version 4.9.10
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Май 23 2022 г., 05:21
-- Версия сервера: 5.5.57-MariaDB
-- Версия PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `check_list_sngisn`
--

-- --------------------------------------------------------

--
-- Структура таблицы `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `id_position` int(11) NOT NULL,
  `login` text NOT NULL,
  `password` text NOT NULL,
  `fio` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `login`
--

INSERT INTO `login` (`id`, `id_position`, `login`, `password`, `fio`) VALUES
(1, 1, 'kluibik', '123', 'Клыбик'),
(2, 2, 'shuk', 'qwe', 'Шук'),
(3, 1, 'laht', '321', 'Лахт'),
(4, 2, 'batov', '123', 'Батов');

-- --------------------------------------------------------

--
-- Структура таблицы `objects`
--

CREATE TABLE `objects` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `address` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `objects`
--

INSERT INTO `objects` (`id`, `name`, `address`) VALUES
(1, 'ГРП-1', 'Новополоцк'),
(2, 'ГРП-1П', 'Полоцк'),
(3, 'ШРП-1', 'Новополоцк'),
(4, 'ШРП-1П', 'Полоцк');

-- --------------------------------------------------------

--
-- Структура таблицы `position`
--

CREATE TABLE `position` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `position`
--

INSERT INTO `position` (`id`, `name`) VALUES
(1, 'Мастер'),
(2, 'Слечарь по обслуживанию газопроводов');

-- --------------------------------------------------------

--
-- Структура таблицы `questions`
--

CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `questions`
--

INSERT INTO `questions` (`id`, `name`) VALUES
(1, 'Перед открытием двери убедиться в отсутствии открытого огня, посторонних людей в радиусе 10 метров от ГРП, ШРП.'),
(2, 'Известить оператора АДС об открытии дверей.'),
(3, 'Проверить прибором на загазованность всех помещений ГРП.'),
(4, 'Проверить по приборам давление газа до и после регулятора(ов)'),
(5, 'Проверить по приборам перепад давления на фильтре (фильтрах)'),
(6, 'Проверить по приборам температуру воздуха в помещении (если предусмотрено отопление)'),
(7, 'Проконтролировать правильность положения рукояток взвода всех ПЗУ'),
(8, 'Проверить отсутствие утечек газа с помощью приборов или мыльной эмульсии'),
(9, 'Проверить исправность манометров путем кратковременного их отключения и посадки на \"ноль\"'),
(10, 'Проверить состояние и работу электроосвещения'),
(11, 'Проверить состояние и работу вентиляции'),
(12, 'Проверить состояние и работу системы отопления'),
(13, 'Визуально выявить трещины и неплотности стен, отделяющих основное и вспомогательное помещения'),
(14, 'Осмотреть видимую часть заземляющего устройства'),
(15, 'Проверить наличие и исправность первичных средств пожаротушения'),
(16, 'Произвести внешний и внутренний осмотр здания'),
(17, 'Произвести уборку помещения'),
(18, 'После закрытия дверей сообщить оператору АДС об окончании работ');

-- --------------------------------------------------------

--
-- Структура таблицы `tasks`
--

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL,
  `object` text,
  `master` text,
  `locksmith_one` text,
  `locksmith_two` text,
  `date_start` text,
  `date_end` text,
  `q1` text,
  `q2` text,
  `q3` text,
  `q4` text,
  `q5` text,
  `q6` text,
  `q7` text,
  `q8` text,
  `q9` text,
  `q10` text,
  `q11` text,
  `q12` text,
  `q13` text,
  `q14` text,
  `q15` text,
  `q16` text,
  `q17` text,
  `q18` text,
  `completed` tinyint(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tasks`
--

INSERT INTO `tasks` (`id`, `object`, `master`, `locksmith_one`, `locksmith_two`, `date_start`, `date_end`, `q1`, `q2`, `q3`, `q4`, `q5`, `q6`, `q7`, `q8`, `q9`, `q10`, `q11`, `q12`, `q13`, `q14`, `q15`, `q16`, `q17`, `q18`, `completed`) VALUES
(1, 'ГРП-1', 'Клыбик', 'Шук', NULL, '23.05.2022', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `objects`
--
ALTER TABLE `objects`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `objects`
--
ALTER TABLE `objects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `position`
--
ALTER TABLE `position`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT для таблицы `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
