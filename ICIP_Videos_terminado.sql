-- CREACION DE LAS TABLAS
CREATE TABLE ADMINISTRATOR
(
    USER_ADMIN     	  VARCHAR(20)       NOT NULL,
    PASSWORD          VARCHAR(255)      NOT NULL,
  	NAME 			  VARCHAR(255)      NOT NULL,
    LAST_NAME         VARCHAR(255)      NOT NULL,
    PHONE             VARCHAR(9)        NOT NULL,
    EMAIL             VARCHAR(255)      NOT NULL,
    PRIMARY KEY(USER)
);

CREATE TABLE TUTOR
(
    USER_TUT          VARCHAR(8),		
    USER_ADMIN        VARCHAR(20)       NOT NULL,
    PASSWORD          VARCHAR(255)      NOT NULL,	
    LAST_NAME         VARCHAR(255)		NOT NULL,
    NAME              VARCHAR(255)     	NOT NULL,
    EMAIL             VARCHAR(255)      NOT NULL,
    PRIMARY KEY(USER),
    FOREIGN KEY(USER_ADMIN) REFERENCES ADMINISTRATOR(USER_ADMIN)
);

CREATE TABLE AREA_COURSE
(
    ID_AREA_COURSE    SMALLINT          AUTO_INCREMENT,
    NAME              VARCHAR(255)      NOT NULL,
    PRIMARY KEY(ID_AREA_COURSE)
);

CREATE TABLE COURSE
(
    ID_COURSE         BIGINT			AUTO_INCREMENT,
    ID_AREA_COURSE    SMALLINT          NOT NULL,
    NAME              VARCHAR(255)		NOT NULL,
    FOREIGN KEY(ID_AREA_COURSE) REFERENCES AREA_COURSE(ID_AREA_COURSE),
    PRIMARY KEY(ID_COURSE)
);

CREATE TABLE TUTOR_COURSE
(
    USER			  VARCHAR(8)		NOT NULL,
    ID_COURSE		  BIGINT			NOT NULL,
    FOREIGN KEY(USER) REFERENCES TUTOR(USER),
    FOREIGN KEY(ID_COURSE) REFERENCES COURSE(ID_COURSE),
    PRIMARY KEY(USER, ID_COURSE)
);

CREATE TABLE NIVEL
(
    ID_NIVEL          SMALLINT			AUTO_INCREMENT,
    NAME              VARCHAR(100)		NOT NULL,
    PRIMARY KEY(ID_NIVEL)
);

CREATE TABLE THEME
(
    ID_THEME          BIGINT			AUTO_INCREMENT,
    ID_NIVEL		  SMALLINT			NOT NULL,
    ID_COURSE         BIGINT            NOT NULL,
    NAME         	  VARCHAR(255)		NOT NULL,
    FOREIGN KEY(ID_NIVEL) REFERENCES NIVEL(ID_NIVEL),
    FOREIGN KEY(ID_COURSE) REFERENCES COURSE(ID_COURSE),
    PRIMARY KEY(ID_THEME)
);

CREATE TABLE REPORT
(
    ID_REPORT         BIGINT			AUTO_INCREMENT,
    ID_THEME          BIGINT			NOT NULL,
    USER	          VARCHAR(8)		NOT NULL,
    DATE_REGISTRY	  DATE				NOT NULL,
    DATE_SUBMIT       DATE				DEFAULT NULL,
    VAR_SUBMIT        BIT               DEFAULT 0,
    FOREIGN KEY(ID_THEME) REFERENCES THEME(ID_THEME),
    FOREIGN KEY(USER) REFERENCES TUTOR(USER),
    PRIMARY KEY(ID_REPORT)
);

CREATE TABLE FILE
(
    ID_FILE           SMALLINT			AUTO_INCREMENT,
    NAME              VARCHAR(20)		NOT NULL,
    PRIMARY KEY(ID_FILE)
);

CREATE TABLE REPORT_AUX
(
	ID_REPORT_AUX	  BIGINT			AUTO_INCREMENT,
	ID_REPORT 		  BIGINT			NOT NULL,
	PRIMARY KEY(ID_REPORT_AUX),
	FOREIGN KEY(ID_REPORT) REFERENCES REPORT(ID_REPORT)
);

CREATE TABLE FILE_AUX
(
	ID_FILE_AUX		  BIGINT			AUTO_INCREMENT,
	ID_FILE 		  SMALLINT			NOT NULL,
	ID_REPORT_AUX	  BIGINT			NOT NULL,
	URL_UBI			  VARCHAR(255)		NOT NULL,
	DATE_SUBMIT		  DATE 				NOT NULL,
	PRIMARY KEY(ID_FILE_AUX),
	FOREIGN KEY(ID_FILE) REFERENCES FILE(ID_FILE),
	FOREIGN KEY(ID_REPORT_AUX) REFERENCES REPORT_AUX(ID_REPORT_AUX)
);
-- INSERCION DE DATOS
INSERT INTO FILE(NAME) VALUES('DOCUMENTO'),('IMAGEN'),('VIDEO');
INSERT INTO NIVEL(NAME) VALUES('BASICO'),('INTERMEDIO'),('AVANZADO');
INSERT INTO AREA_COURSE(NAME) VALUES('ARQUITECTURA'),('ESTADISTICA'),('GESTION'), ('GESTION DE PROYECTOS'),('GOBERNABILIDAD Y POLITICAS PUBLICAS'),('INGENIERIA'),('OFIMATICA'),('PLANIFICACION Y GESTION TERRITORIAL'),('SIG Y TELEDETECCION');

-- INGRESO DEL ADMNISTRADOR DE LA APLICACION
INSERT INTO ADMINISTRATOR VALUES('72723948', '8da922c3d3e66da22ae37c141928c701214f4dafc60e87c90089be44556b4e9c', 'BRAYAN CHRISTIAN', 'REYES GAMARRA', '991370374', 'BCRG.1993@GMAIL.COM');