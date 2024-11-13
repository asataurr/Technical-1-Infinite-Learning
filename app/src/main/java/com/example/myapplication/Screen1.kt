// Screen1.kt
package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen1(navController: NavController) {
    // Daftar nama mata kuliah dan deskripsiNYA
    val namaMatkulHariini = listOf("Bahasa Inggris Lanjut", "Matematika Diskrit", "Pemrograman Web", "Jaringan Komputer", "Analisis Dan Perancangan Sistem")
    val deskripsiMatkulHariini = listOf("Bahasa Inggris Lanjut mengasah keterampilan bahasa di tingkat tinggi, termasuk tata bahasa kompleks dan komunikasi akademik.", "Matematika Diskrit mempelajari struktur diskrit seperti logika, himpunan, graf, dan kombinatorika, yang penting dalam ilmu komputer dan pemodelan sistem.", "Pemrograman Web mempelajari cara membangun dan mengembangkan aplikasi web, mencakup HTML, CSS, JavaScript, serta penggunaan framework dan database untuk membuat situs interaktif dan responsif.", "Jaringan Komputer mempelajari cara menghubungkan perangkat untuk saling bertukar data, mencakup topologi, protokol, IP addressing, dan keamanan jaringan." , "Jaringan Komputer mempelajari konsep, teknologi, dan protokol untuk menghubungkan perangkat agar dapat bertukar data. Mata kuliah ini mencakup topologi jaringan, IP addressing, keamanan, serta model OSI dan TCP/IP.", "Analisis dan Perancangan Sistem mempelajari proses mengidentifikasi kebutuhan dan merancang solusi sistem yang efektif. Mata kuliah ini mencakup analisis kebutuhan, pembuatan diagram, pemodelan data, dan perancangan sistem untuk mendukung pengembangan perangkat lunak yang sesuai dengan kebutuhan bisnis.")

    val namaMatkulBerikutnya = listOf("Pemrograman Mobile", "Pemrograman Visual", "Basis Data", "Struktur Data", "Pengembangan Bahan Ajar")
    val deskripsiMatkulBerikutnya = listOf("\n" +
            "Analisis dan Perancangan Sistem mempelajari proses mengidentifikasi kebutuhan dan merancang solusi sistem yang efektif. Mata kuliah ini mencakup analisis kebutuhan, pembuatan diagram, pemodelan data, dan perancangan sistem untuk mendukung pengembangan perangkat lunak yang sesuai dengan kebutuhan bisnis.", "Pemrograman Visual mengajarkan pembuatan aplikasi dengan antarmuka grafis menggunakan alat dan bahasa pemrograman visual.", "Basis Data mempelajari cara menyimpan, mengelola, dan mengakses data menggunakan sistem manajemen basis data (DBMS), termasuk konsep tabel, query, dan normalisasi.", "Struktur Data mempelajari cara mengorganisasi dan menyimpan data secara efisien, mencakup array, linked list, stack, queue, dan pohon.", "Pengembangan Bahan Ajar mempelajari cara merancang, membuat, dan mengevaluasi materi pembelajaran yang efektif untuk mendukung proses pengajaran dan pembelajaran.")

    Scaffold(topBar = { TopAppBar(title = { Text("Data Mata Kuliah") }) }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Bulan ini:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn {
                items(namaMatkulHariini.size) { index ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable {
                                navController.navigate("detail/${namaMatkulHariini[index]}/${deskripsiMatkulHariini[index]}")
                            },
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
                    ) {
                        Text(
                            text = namaMatkulHariini[index],
                            modifier = Modifier.padding(16.dp),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text("Bulan Berikutnya:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(namaMatkulBerikutnya.size) { index ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(width = 150.dp, height = 100.dp)
                            .clickable {
                                navController.navigate("detail/${namaMatkulBerikutnya[index]}/${deskripsiMatkulBerikutnya[index]}")
                            },
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9C4))
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = namaMatkulBerikutnya[index],
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}
