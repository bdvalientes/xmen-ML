# API REST X-MEN

Exposicion de servicio **API REST**. Permite validar una cadena ADN, si es mutante o humana.
- Solo se permiten las siguientes letras (A,T,C,G)
- La matriz debe ser de (NxN)
- Es mutante, si encuentra mas de una secuencua de cuatro letras iguales, de forma oblicua, horizontal o vertical.

**Requerimientos**
 - Se debe instalar **[Lombok](https://projectlombok.org/)**
 - Se debe crear la base de datos **(xmen)** en **MYSQL**

**Documentacion Swagger** 
```
 http://localhost:7010/xmen/swagger-ui.html
```
**Ejemplos**
```
{
	"dna": [
		"TTGCTT",
		"CAGTTC",
		"TTATTA",
		"AGAAGC",
		"TTATGC",
		"AGGAGA"
	]
}
```
