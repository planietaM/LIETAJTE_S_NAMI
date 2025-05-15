package com.example.lietajte_s_nami.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

object Kurzy {

    @RequiresApi(Build.VERSION_CODES.O)
    val kurzy = listOf(
        Kurz(
            id = 1,
            nazovKurzu = "Základný kurz paraglidingu – Liptovský Mikuláš",
            cenaKurzu = 450.0,
            miestoKonaniaPSC = "031 01",
            miestoKonania = "Liptovský Mikuláš",
            datumZaciatok = LocalDate.of(2025, 5, 10),
            datumKoniec = LocalDate.of(2025, 5, 15),
            typKurzu = "Základný kurz",
            mail = "sejkfslkfgnl@gmail.com",
            telefon = "0950338316",
            popisKurzu1 = "Základný kurz paraglidingu (PL-A) je pre každého, kto sa chce naučiť ovládať pravidlá, predpisy a samostatné lietanie s padákovým klzákom.",
            popisKurzu2 =  "Po absolvovaní všetkých potrebných úloh je kurz zakončený záverečnými skúškami z praktickej a teoretickej časti a vydaním pilotnej licencie od LAA SR (Letecká Amatérska Asociácia SR), ktorá ho oprávňuje samostatne lietať s padákovým klzákom kategórie PK – A.",
            popisKurzu3 =  "Pri nástupe do kurzu nie sú nutné žiadne predchádzajúce znalosti o paraglidingu, ani o inom druhu bezmotorového lietania."

        ),
        Kurz(
            id = 2,
            nazovKurzu = "Individuálny kurz – Donovaly",
            cenaKurzu = 500.0,
            miestoKonaniaPSC = "976 39",
            miestoKonania = "Donovaly",
            datumZaciatok = LocalDate.of(2025, 6, 5),
            datumKoniec = LocalDate.of(2025, 6, 10),
            typKurzu = "Individuálny kurz",
            mail = "sejkfslkfgnl@gmail.com",
            telefon = "0950338316",
            popisKurzu1 = "Individuálny kurz paraglidingu je pre náročnejších klientov, ktorí sú pracovne vyťažení, nevyhovuje im pevne stanovený termín kurzov a preferujú kvalitný individuálny prístup.",
            popisKurzu2 =  "Intenzívna výučba zabezpečuje kvalitne vyškoleného pilota padakového klzáku. Obsah a priebeh individuálneho kurzu je rovnaký ako pri základnom kurze.",
            popisKurzu3 =  "Po absolvovaní všetkých potrebných úloh je kurz zakončený záverečnými skúškami z praktickej a teoretickej časti a vydaním pilotnej licencie od LAA SR (Letecká Amatérska Asociácia SR), ktorá ho oprávňuje samostatne lietať s padákovým klzákom kategórie PK – A."
        ),
        Kurz(
            id = 3,
            nazovKurzu = "Termicky kurz paraglidingu – Straník (Žilina)",
            cenaKurzu = 89.99,
            miestoKonaniaPSC = "010 01",
            miestoKonania = "Žilina – Straník",
            datumZaciatok = LocalDate.of(2025, 5, 1),
            datumKoniec = LocalDate.of(2025, 9, 30),
            typKurzu = "Termicky kurz",
            mail = "sejkfslkfgnl@gmail.com",
            telefon = "0950338316",
            popisKurzu1 = "Termický kurz paraglidingu (PL-B) je určený pre pilotov, ktorí sa chcú zdokonaliť v technike lietania termiky, svahovania a taktike lietania preletov. Predpokladom pre pilota je mať zvládnuté štarty, pristátia do vymedzeného miesta a mať odlietané lety z kopcov s prevýšením viac ako 100 metrov.",
            popisKurzu2 =  "Inštruktori Vám odovzdajú praktické skúsenosti z lietania preletov, závodného lietania a vyklesávacích režimov.",
            popisKurzu3 =  "Po úspešnom ukončení kurzu získava pilot licenciu PL -B, ktorá ho oprávňuje lietať na padákoch vyššej kategórie."
        )

    )
}