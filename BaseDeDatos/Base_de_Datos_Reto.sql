CREATE DATABASE IF NOT EXISTS `taller_informatica`; 

USE `taller_informatica`; 

CREATE TABLE IF NOT EXISTS Categorias ( 
id_categoria INT AUTO_INCREMENT PRIMARY KEY, 
nombre VARCHAR(50) NOT NULL, 
descripcion VARCHAR(255) 
); 
  
  
CREATE TABLE IF NOT EXISTS Ubicacion ( 
id_ubicacion INT AUTO_INCREMENT PRIMARY KEY, 
armario VARCHAR(20), 
balda VARCHAR(20), 
cajon VARCHAR(20), 
descripcion VARCHAR(255) 
); 


CREATE TABLE IF NOT EXISTS Usuarios ( 
id_usuario INT AUTO_INCREMENT PRIMARY KEY, 
nombre VARCHAR(99), 
email VARCHAR(99), 
password VARCHAR(255), 
rol ENUM("admin","profesor") 
); 

  
CREATE TABLE IF NOT EXISTS Material ( 
id_material INT AUTO_INCREMENT PRIMARY KEY, 
nombre VARCHAR(99) NOT NULL, 
descripcion TEXT, 
cantidad INT NOT NULL, 
stock_minimo INT DEFAULT 1, 
estado ENUM("disponible","prestado","reparacion","Baja"), 
id_categoria INT, 
id_ubicacion INT,
FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria), 
FOREIGN KEY (id_ubicacion) REFERENCES ubicacion(id_ubicacion) 
); 

  
CREATE TABLE IF NOT EXISTS Prestamos ( 
id_prestamo INT AUTO_INCREMENT PRIMARY KEY, 
id_material INT, 
id_usuario INT, 
fecha_prestamo DATE, 
fecha_devolucion DATE, 
cantidad INT, 
estado ENUM("activo", "devuelto"), 
FOREIGN KEY (id_material) REFERENCES material(id_material), 
FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) 
); 


CREATE TABLE IF NOT EXISTS Movimientos ( 
id_movimiento INT AUTO_INCREMENT PRIMARY KEY, 
id_material INT, 
fecha DATETIME, 
tipo VARCHAR(50), 
cantidad INT, 
descripcion TEXT, 
FOREIGN KEY (id_material) REFERENCES material(id_material) 
);


CREATE TABLE IF NOT EXISTS Alertas_Stock (
id_alerta INT AUTO_INCREMENT PRIMARY KEY,
id_material INT NOT NULL,
mensaje VARCHAR(255),
fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DROP TRIGGER IF EXISTS trg_registrar_movimiento;

DELIMITER //
CREATE TRIGGER trg_registrar_movimiento
AFTER UPDATE ON Material
FOR EACH ROW
BEGIN
IF OLD.Estado <> NEW.Estado THEN
INSERT INTO Movimientos (
ID_MATERIAL,
Fecha,
Tipo,
Cantidad,
Descripcion
)
VALUES (
NEW.ID_MATERIAL,
NOW(),
'Cambio de estado',
NEW.Cantidad,
CONCAT('Estado cambiado de ', OLD.Estado, ' a ', NEW.Estado)
);
END IF;
END//

DELIMITER ;

DROP TRIGGER IF EXISTS trg_stock_minimo;

DELIMITER //
CREATE TRIGGER trg_stock_minimo
AFTER UPDATE ON Material
FOR EACH ROW
BEGIN
IF NEW.Cantidad < 3 THEN
INSERT INTO Alertas_Stock (
ID_MATERIAL,
Mensaje
)
VALUES (
NEW.ID_MATERIAL,
CONCAT('Stock bajo: quedan ', NEW.Cantidad, ' unidades')
);
END IF;
END//

DELIMITER ;

