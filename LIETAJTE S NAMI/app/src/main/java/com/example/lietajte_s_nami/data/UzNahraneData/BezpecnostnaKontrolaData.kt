package com.example.lietajte_s_nami.data.UzNahraneData

import android.os.Build
import androidx.annotation.RequiresApi


object BezpecnostnaKontrolaData {

    @RequiresApi(Build.VERSION_CODES.O)
    val BezpecnostnaKontrolaData = listOf(
        PrvokBezpecnostnejKontroly(1, "Sleduj smer a silu vetra", "Pomocou veterného rukávu zisti smer vetra a jeho silu. Nikdy nevzlietaj proti veľmi silnému alebo nestabilnému vetru."),
        PrvokBezpecnostnejKontroly(2, "Presvedč sa, že krídlo je správne rozložené", "Krídlo musí byť rovnomerne rozprestreté bez záhybov alebo zauzlení, aby nedošlo k nebezpečnému rozbaleniu počas štartu."),
        PrvokBezpecnostnejKontroly(3, "Skontroluj spojenie cez vysielačku", "Over si, že máš spojenie s inštruktorom alebo tímom cez vysielačku. Komunikácia je zásadná pri koordinácii počas letu."),
        PrvokBezpecnostnejKontroly(4, "Nasaď prilbu a výstroj", "Správne nasadená prilba a pevne upevnená výstroj sú kľúčové pre bezpečnosť pri vzlete a počas letu."),
        PrvokBezpecnostnejKontroly(5, "Skontroluj brzdy a popruhy", "Uisti sa, že brzdy sú voľné, nie sú zauzlené a správne fungujú. Rovnako skontroluj všetky popruhy a ich upevnenie pred štartom.")
    )

}