# TICKETMASTER - Eventi in America ed Europa 
<h4>Repository creata per l'appello di Marzo 2022 per il corso di programmazione ad oggetti.</h4>

# Applicazione

<p>Lo scopo dell'applicazione permette all'utente di confrontare le statistiche degli eventi che avranno luogo in USA e in Europa. Inoltre, il sistema dovrà generare delle 
statistiche dai risultati ottenuti. I risultati delle ricerche e le statistiche potranno essere filtrati tramite filtri opportuni.
Per facilitare l'utente, l'applicazione suggerisce la scelta tra eventi, attrazioni e sedi.</p>

# Rotte Applicazione

chiamate di tipo GET:
<li>"events/attractions/venues": (rappresentano il numero totale di eventi,attrazioni o sedi)</li>
<li>"ShowEvents": (suggerimento dato all'utente)</li>
<br></br>
Per le chiamate di tipo Post i parametri vengono passati attraverso un <b>Request Body</b>. I parametri che dovranno essere passati sono:
<br></br>
 <li>"luogo": (rappresenta il nome della città dove è situato l'evento)</li>
 <li>"genere": (indica il genere dell'evento (Sports,Music...))</li>
 <li>"data": (indica tutti gli eventi dalla dalla data selezionata)</li>
<h3>Regole scrittura Body:</h3>
 <li>"luogo": l'unica regola per questo parametro c'è nel caso in cui vengono inserite più di una città, ovvero i nomi delle città devono essere separate da uno slash (/):</br>
              es. "America/Los_Angeles" (attenzione, l'inserimento in questo campo è case-sensitive).</li>
<li>"genere": l'unica regola per questo parametro c'è nel caso in cui vengono inserite più di un genere, ovvero i nomi dei generi devono essere alternati da una virgola e uno spazio:</br>
              es. "Sports, Basketball, NBA" (attenzione, l'inserimento in questo campo è case-sensitive).</li>
 <li>"data": in questo campo la data deve essere fornita nel formato "yyyy-mm-dd" </li>
<br></br>
<b>Nota:</b> L'inserimento nei campi è case-sensitive
<h2>1. Lista Eventi, Attrazioni o Sedi</h2>
<table>
<tr><td>Tipo</td><td>Path</td></tr>
<tr><td>GET</td><td>localhost:8080/events</td></tr>
</table>
Fornisce all'utente tutti gli eventi che si situano in USA ed EUROPA.
<br></br>
<p><b>Esempio:</b> di seguito vengono riportati alcuni di tutti gli eventi generati<p>
<h3>Chiamata : localhost:8080/events</h3>

![Immagine 2022-03-14 192046](https://user-images.githubusercontent.com/64266699/158635943-d6d92307-3f77-4de1-9872-c63ad1a668a6.png)

<h3>risposta:</h3>

![Immagine 2022-03-15 153131](https://user-images.githubusercontent.com/64266699/158636505-95945c6f-11c9-4370-8be0-b7e04ee9d272.png)
![Immagine 2022-03-15 153154](https://user-images.githubusercontent.com/64266699/158636510-082c72fe-8886-4c38-b975-a9cbb499d8dc.png)
![Immagine 2022-03-14 192254](https://user-images.githubusercontent.com/64266699/158636512-e9eeede9-463d-4338-a4b4-5b68ceaced8b.png)


<br></br>
<h3>Chiamata : localhost:8080/attractions</h3>
<table>
<tr><td>Tipo</td><td>Path</td></tr>
<tr><td>GET</td><td>localhost:8080/attractions</td></tr>
</table>
Fornisce all'utente tutte le attrazioni che si situano in USA ed EUROPA.
<br></br>

![Immagine 2022-03-16 171833](https://user-images.githubusercontent.com/64266699/158637941-15d543f7-4c83-44c7-bc73-41828be8006a.png)

  <p><b>Esempio:</b> di seguito vengono riportati alcuni di tutte le attrazioni generate<p>
<h3>risposta:</h3>

![Immagine 2022-03-16 171904](https://user-images.githubusercontent.com/64266699/158638029-69242e19-8eda-4ce6-a151-944793f50f83.png)

<br></br>
<h3>Chiamata : localhost:8080/venues</h3>
<table>
<tr><td>Tipo</td><td>Path</td></tr>
<tr><td>GET</td><td>localhost:8080/venues</td></tr>
</table>
Fornisce all'utente tutte le sedi che si situano in USA ed EUROPA.
<br></br>

![Immagine 2022-03-16 171709](https://user-images.githubusercontent.com/64266699/158638078-357f546c-85a4-482f-bb3a-0b12c1312752.png)

<p><b>Esempio:</b> di seguito vengono riportati alcuni di tutte le sedi generate<p>
<h3>risposta:</h3>

![Immagine 2022-03-16 171800](https://user-images.githubusercontent.com/64266699/158638128-fa5e3c04-cede-4da1-a132-15ac74eba714.png)

<br></br>
<h2>2. Suggerimenti Eventi</h2>






<table>
  <tr><td>Tipo</td><td>Path</td></tr>
  <tr><td>GET</td><td>localhost:8080/ShowEvents</td></tr>
</table>
Fornisce all'utente dei suggerimenti per poter chiamare eventi,attrazioni e sedi.
<br><b>Esempio: </b></br>
<h3>Chiamata : localhost:8080/ShowEvents </h3>    

![Immagine 2022-03-15 155416](https://user-images.githubusercontent.com/64266699/158638340-3781ab10-ca41-4aa6-a742-cd13e391c890.png)

<h3>Risposta :</h3>

![Immagine 2022-03-15 155437](https://user-images.githubusercontent.com/64266699/158638392-a48febad-ed0b-42d6-a1c3-f77c53764798.png)

<h2>3. <b>Filtri</b></h2>
<table>
  <tr><td>Tipo</td><td>Path</td></tr>
  <tr><td>POST</td><td>localhost:8080/filters</td></tr>
</table>
Fornisce all'utente gli eventi filtrati per i vari parametri forniti dall'utente.
<br>I parametri da inserire nel <b>Body</b> sono: "luogo", "genere" e "data".
<br>E' possibile inserire più filtri contemporaneamente.
<br>Inoltre è possibile inserire più città per richiesta nel parametro luogo.
<br>Se non viene fornito nessun parametro dall'utente si otterà la lista completa degli eventi.
<br><b>Esempio: </b></br>
<h3>Chiamata : localhost:8080/filters </h3>

![Immagine 2022-03-15 154826](https://user-images.githubusercontent.com/64266699/158638469-bf6379f0-9771-4b87-8adc-1a6ae8979012.png)

<h3>Body : </h3>
{ </br>
 "luogo" : "America", </br>
 "genere" : "Sports", </br>
 "data" : "2022-04-08" </br>
} </br>
<br></br>

![Immagine 2022-03-15 154845](https://user-images.githubusercontent.com/64266699/158638664-b0941306-314d-4319-b967-7c2a2495996b.png)

<h3>Risposta :</h3>

![Immagine 2022-03-15 154933](https://user-images.githubusercontent.com/64266699/158638731-cd035258-52cb-468a-bf66-3b7d4df8254b.png)
![Immagine 2022-03-15 154911](https://user-images.githubusercontent.com/64266699/158638737-7ceb6eff-73f7-4f39-99fd-5727bac7582f.png)

In questo caso vengono restituiti all'utente solamente gli eventi in cui :
<br>
- il luogo è America; 
- il genere è Sports;
- la data è dal 2022-04-08 in poi;

<h2>4. <b>Statistiche</b></h2>
<table>
  <tr><td>Tipo</td><td>Path</td></tr>
  <tr><td>POST</td><td>localhost:8080/stats</td></tr>
</table>
<br>Questa rotta fornisce le statistiche sugli eventi.</br>
Gli eventi vengono prima filtrati in base ai parametri inseriti nel body dall'utente e poi ne vengono effettuate le statistiche.<br>
Per effettuare statistiche su tutti gli eventi basta non inserire nulla nel <b> Body</b> : { }.<br>
E' possibile effettuare statistiche su più luoghi e su più parametri contemporaneamente. 
<br><b>Esempio: </b></br>
<h3>Chiamata : localhost:8080/stats</h3> 

![Immagine 2022-03-15 153350](https://user-images.githubusercontent.com/64266699/158639140-1acf22e1-f44b-47c5-8da0-706775ca3bb3.png)


<h3>Body :</h3>
{ </br>
 "luogo" : "America" </br>
} </br>

![Immagine 2022-03-16 173000](https://user-images.githubusercontent.com/64266699/158642614-c6fd0a21-a5fb-4162-bc96-e2a671a9939e.png)

<ul>
  <li>il luogo è America; </li>
  <li> essendo specificato solo il luogo verranno filtrati gli eventi per quel luogo ed effettuate le statistiche indipendemente da data e genere. </li>
</ul>
<h3>Risposta :</h3>

![Immagine 2022-03-16 173137](https://user-images.githubusercontent.com/64266699/158642678-586e4dba-4db9-4119-a469-6ce5a99f688e.png)

Nella risposta saranno indicati : </br>
il numero totale degli eventi su cui sono state effettuate le statistiche ; </br>
il numero di eventi per ogni mese ; </br>
la media degli eventi che si svolgono ogni mese ; </br>
il numero totale di eventi per luogo ; </br>
nel caso in cui venga aggiunto nel <b> Body</b> il genere e la data vedremo il numero totale di eventi per genere e data; </br>
</p>
# UML
<ul><li><h2><b>CASO D'USO</b></h2></li></ul>

![Immagine 2022-03-14 182428](https://user-images.githubusercontent.com/64266699/158640367-55889a01-6786-4012-9c4d-2c4cc4bb53ab.png)

<ul><li><h2><b>CLASSI</b></h2></li></ul>

![Immagine 2022-03-15 161650](https://user-images.githubusercontent.com/64266699/158640980-a867d8c1-ef2e-4446-bbb1-2a23061c54aa.png)
![Immagine 2022-03-14 190536](https://user-images.githubusercontent.com/64266699/158641103-af9ab71b-67ba-41da-af1f-a6e0bb27838f.png)
![Immagine 2022-03-14 190600](https://user-images.githubusercontent.com/64266699/158641118-d0d652dc-1d9a-4dbb-893a-b6fb697848c8.png)
![Immagine 2022-03-14 190639](https://user-images.githubusercontent.com/64266699/158641127-81719aad-78e8-41fb-b96c-11a508035db7.png)
![Immagine 2022-03-14 190657](https://user-images.githubusercontent.com/64266699/158641137-e7bcec33-40da-49f6-8d03-3e2877a7be23.png)
![Immagine 2022-03-14 190708](https://user-images.githubusercontent.com/64266699/158641144-e2b12caa-eda6-41a8-83e8-f059242149c5.png)
![Immagine 2022-03-14 190720](https://user-images.githubusercontent.com/64266699/158641162-072ddf92-8454-4afb-be14-29d4a692d5d9.png)
![Immagine 2022-03-16 173840](https://user-images.githubusercontent.com/64266699/158642545-ec6f1987-a419-4575-84cc-19f5f3d534cf.png)


<ul><li><h2><b>SEQUENZE</b></h2></li></ul>
<ul><li><b>Lista Eventi</b></li></ul>

![Immagine 2022-03-14 191310](https://user-images.githubusercontent.com/64266699/158642827-ee41f9bb-3363-4b94-8dbb-ec54476b6608.png)

<ul><li><b>Filtri</b></li></ul>

![Immagine 2022-03-14 191323](https://user-images.githubusercontent.com/64266699/158642885-daa58e08-19ca-4651-a0a9-509831e3a157.png)

<ul><li><b>Statistiche</b></li></ul>

![Immagine 2022-03-14 191352](https://user-images.githubusercontent.com/64266699/158642935-07ff2904-870f-4e47-9dcc-3ccadb21cb79.png)

<ul><li><b>Suggerimenti</b></li></ul>

![Immagine 2022-03-14 191410](https://user-images.githubusercontent.com/64266699/158642989-1c2c65df-0c32-47c6-9bab-e8b12179c04b.png)

<h1>Test</h1>
Nel codice sono presenti anche alcuni Test che vanno a testare le classi, cioè verificano se effettivamente svolgono le loro funzioni. </br>
Sono state affettuati Test sulle classi : EsameOopApplicationTests, EventTest, FilterBodyClass, FiltersTest e inoltre una classe aggiuntiva che effettua tutti i test contemporaneamente (AllTest).

# Note

Tra i file presenti nella repository c'è una cartella "txtdocs" che contiene alcuni file txt tra cui un file contenente il Token necessario per effettuare la chiamata API. </br>
Il token è gia presente, se si vuole un proprio Token bisogna inserirlo nel file  "token.txt".


# Autori

<table>
<tr><td>Nome e Cognome</td><td>Contributo</td><td>Email</td></tr>
<tr><td>Gianmarco Di Renzo</td><td>50%</td><td><a href="S1089859@studenti.univpm.it">S1089859@studenti.univpm.it</a></td></tr>
<tr><td>Gianluca Ciarlariello</td><td>50%</td><td><a href="S1089858@studenti.univpm.it">S1089858@studenti.univpm.it</a></td></tr>
</table>

