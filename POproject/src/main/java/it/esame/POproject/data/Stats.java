package it.esame.POproject.data;

/** Interfaccia che descrive statistiche generiche
 *  da applicare ai dati
 *
 */

public interface Stats {

/** Il metodo CalcStats() è stato pensato per richiamare tutti gli altri, 
 *  ovvero i metodi che calcolano le statistiche (min, max)
 * 
 */
		
void CalcStats();


/** Il metodo CalcMin() calcola il minimo del dato selezionato.
 *  
 */


String CalcMin();


/** Il metodo CalcMax() calcola il massimo del dato selezionato.
 * 
 * 
 */


String CalcMax();

}
