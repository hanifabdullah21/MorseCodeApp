package com.hanifabdullah21.morsecodeapp

//TODO 4. Buat Sebuah Data Class atau Kelas Model

/**
 * Data Class atau sering disebut Kelas Model adalah sebuah kelas untuk menangkap/membungkus data
 * agar lebih mudah untuk dikirim, digunakan atau dipindahkan
 *
 * @link https://kotlinlang.org/docs/data-classes.html
 *
 * */
data class MorseModel(

    val name: String? = null,

    val code: String? = null,

    val sound: Int? = null

)
