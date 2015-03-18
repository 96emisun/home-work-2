home-work-2
===========

Skelett och instruktioner för nästa inlämningsuppgift

Register
===

Inlämningsuppgift 2 kommer att ske i olika delsteg.

1. Skriv ett program som fungerar som ett register. Registret skall kunna:
    - hantera minst två olika typer av saker (En super-klass och två sub-klasser). 
    - skriva och läsa till en fil som användaren anger. Formatteringen av filen skall vara i CSV-format.
    - någon typ av interaktion med biblioteket. Ex sortera på något sätt(implementera comparable).
2. Programmet skall innehålla ett lämpligt GUI.
3. Krav för högre betyg (desto fler funktioner desto högre betyg)
    - Exportering/importering av xml-filer
    - Hämtning av information via URL
    - Implementering av någon form av klient/server

Specifiktioner

Namnbyte av filerna får förekomma men minst de antal filer som existerar måste finnas i inlämningen.

- **RegisterGUI** är den klass som innehåller GUI och main-metoden, enligt de exempel vi skrivit tidigare.
- **Library** är den klass som innehåller modellen för programmet och håller reda på de saker som lagras i biblioteket.(Lägga till objekt)
- **AbsrtactItem** är den klass som beskriver en abstrakt sak som kan lagras i bibliteket. 
- **SubItem1/2** är de klasser som beskriver de objekt som kan lagras i biblioteket.

**Grundläggande krav**

- Programmet har ett lämpligt GUI för att lösa angivna uppgifter. Handkodat eller mha NetBeans design-läge. 
- Programmet skall skriva och läsa hela filen som ni skapar. Ni skriver endast när ni vill spara alla objekt i biblioteket.
- Programmet skall kunna sortera objekten efter namn i biblioteket.
- Objekten lagras i en ArrayList
- Objekten har minst två egenskaper (ex artist och titel) och lämpliga metoder(toString, compareTo).
- Ni lämnar in ett klassdiagram över programmet. 

**Högre krav**

- OBjekten har minst tre egenskaper(typ,namn m.m. ) och lämpliga metoder.
- Objekten sorteras först med avseende på typ sedan namn osv.
- Användaren skall kunna ta bort objekt från biblioteket.
- Objekten skall kunna märkas (exempel utifrån skadade/utlånade) och kunna listas utifrån detta kriterium.
- Det finns minst tre typer av objekt.
- Egna förslag på utökad funktionalitet av programmet.
