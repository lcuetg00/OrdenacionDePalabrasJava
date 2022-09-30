# OrdenacionDePalabrasJava

Trabajo realizado para la ordenación de palabras en orden alfabético.
Ordena las palabras creando un árbol de nodos. Cada nodo representa un caracter de la palabra.
Al insertar una lista de palabras, se crea este árbol de nodos.
Cada nodo está compuesto de una lista de nodos hijo (uno por cada letra del alfabeto), de su nodo padre y de una variable (terminaPalabra) que determina si la palabra insertada termina en esa letra.
Para dar la lista de palabras ordenada, se recorre el árbol de izquierda a derecha. Cada vez que se encuentre la variable terminaPalabra con valor true, recoge esa palabra y sigue buscando el resto.

Input: una lista de palabras que no lleguen tilde (caracter '`').
Output: lista ordenada de las palabras en mayúscula.