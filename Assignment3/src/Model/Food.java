/* Author: <Anna Selstam>  
 * Id: <am3963>  
 * Study program: <DT>*/

package Model;

/*Abstrakta klasser kan inte instansieras, men dess subklasser kan. 
* Abstrakta metoder deklareras utan en implementation.  
* De kan användas som en modifier till en klass vi inte vill kunna skapa objekt av, ex. en klass som är för bred. I detta fallet Food.
* Istället kan då en subklass - med mer specifik typ, skapas som vi kan instansiera. I detta fallet Pizza.
* 
* I mitt fall av kodande är användandet av abstrakta klasser inte lika användbart som i andra. Hade jag haft fler
* typer subklasser ex. sallad, hamburgare etc, hade man kunnat implementera mer betydelsefulla metoder via denna klass. */


public abstract class Food {
    abstract String getCategory();
}