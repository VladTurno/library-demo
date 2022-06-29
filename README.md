# library-demo
[Giugno PERSONALE 2022] Turno 535396

MALFUNZIONAMENTI NOTI:

SpringSecurity) non so perchè e percome ma dopo acer implementato con successo l'autenticazione di utenti del tipo user e admin il template resolver dà errore quando provo ad accedere a qualsiasi risorsa nella cartella /admin che non sia la homepage (quest'ultima  risolta correttamente dal template resolver e le autorizzazioni in authConfiguration sembrano essere corrette.
Ho messo una pezza mettendo tutte le risorse nella cartella templates e prendendo vari accorgimenti per fare in modo che le risorse riservate agli admin fossero accessibili solo dal menu admin (correttamente risolto dal template resolver e situato nella cartella menu/admin/**)

SPECIFICHE DEL MODELLO DI DOMINIO:

La webapp è un semplice tool per la gestione di una libreria digitale. Nel modello sono presenti tre classi: Libri, autori ed editori. 
Per ogni libro sono di interesse il titolo, la trama, l'autore e l'editore.
Per ogni autore sono di interesse il nome e il cognome, l'anno e la città di nascita e la lista delle opere scritte.
Per ogni editore sono di interesse il nome e l'anno e il paese di fondazione.

CASI D'USO IMPLEMENTATI:

a) un utente generico può registrarsi ed accedere alla piattaforma come utente. Gli utenti che sono amministratori sono decisi da me medesimo che posso mettere le mani sul DB, non dall'esterno.
b) un utente, previa registrazione può loggarsi ed accedere a un menù da cui può visualizzare la lista dei libri, degli autori e degli editori.
c) per ogni lista di libri/autori/editori un utente generico può visualizzarne il dettaglio e navigare tra le varie schede: ad esempio, dal dettaglio di un libro può visitare la pagina dell'autore o dell'editore, e per ogni autore può visualizzare e visitare i libri scritti, e così via.
d) un admin, previa registrazione, può accedere a un menu dal quale è possibile visualizzare la lista degli autori/editori/libri inseriti oppure inserire un  nuovo libro/autore/editore.
e) un admin che inserisce un nuovo autore o editore non ha vincoli particolari, ma quando un admin inserisce un libro può scegliere autore ed editore da un menu a tendina che mostra solo autori ed editori precedentemente inseriti.
f) un admin che visualizza la lista dei libri/autori/editori non visualizza la lista che visualizza un utente generico, ma ne visualizza una arricchita da pulsanti per effettuare operazioni di modifica e cancellazione
