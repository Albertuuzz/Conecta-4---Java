# Conecta-4---Java
Programa Conecta4.

•	Jerarquías
o	En nuestro código se puede apreciar jerarquía de clases entre la clase Player que es la clase padre donde tiene variables private y tiene métodos creados, pero no implementados ya que dichos métodos los implementamos en las clases hijas que heredan los métodos del padre, que en este caso son PlayerH y PlayerIA. Para representar la jerarquía en java se dice que la clase PlayerH extiende a la clase Player o que la clase PlayerIA extiende a la clase Player.

•	Clases interfaz
o	Hemos utilizado una interfaz IComando y la interfaz Modo para proporcionar un mecanismo de encapsulación de los protocolos de los métodos sin tener que forzar al código a tener que utilizar herencia. Dentro de estas interfaces hemos podido crear constantes que van a estar disponibles para todas las clases que hayan implementado esa interfaz y esas clases que implementan la interfaz están obligadas a utilizar los mismos métodos.

•	Principios de diseño orientado a objetos
o	(S) Principio de responsabilidad única
	Para este principio de responsabilidad única hemos creado la cantidad de clases necesarias para que cada clase cumpla su requisito necesario para ser funcional.
o	(O) Principio abierto/cerrado
	Este principio lo hemos aplicado por ejemplo mediante la creación de una interfaz IComando que está abierto para añadir nuevos tipos de comandos y cerrado para cambiar la componente Gestor al añadir nuevos tipos de comandos. Dentro de la clase Gestor y de las diferentes clases que representan los tipos de comandos tenemos las propiedades privadas para cumplir con el principio.








o	(L) Principio de sustitución de Liskov
	Para la aplicación de este principio tenemos por ejemplo la clase Player que es la clase padre de PlayerH y PlayerIA por lo que estas dos clases extienden la clase Player y tienen como métodos el método put() de la clase padre y sus propios métodos si son necesarios como por ejemplo el método eleccionMaquina de la clase PlayerIA.

o	(I) Principio de segregación de interfaces
	Para cumplir con este principio hemos decidido crear 4 interfaces. En cada una de ellas hemos incluido una de los métodos que buscan en diferentes direcciones 4 fichas consecutivas del mismo color, y que la clase ComprobanteJuego implementara a través de las interfaces.
o	(D) Principio de inversión de dependencias
	Para este principio hemos hecho la clase Player abstracta ayudando a mantener nuestro código desacoplado para que todas las clases de módulos de alto nivel que dependen de ella.
•	Patrones de diseño
o	En nuestro código hemos utilizado el Patrón Fachada donde tenemos que la clase Partida es la principal con el main(), tenemos la clase menú que es la que diferencia la selección entre los modos y hace que se delegue la petición del cliente a las clases MBasico, MEntrenamiento y MDemo que son las clases del subsistema responsables ante una petición del cliente para jugar al Conecta 4



Codigo realizado por: @Albertuuzz, @nicocla, @CTangente
