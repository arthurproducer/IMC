package com.example.imc

fun Double.toFixed(digits: Int) = String.format("%.${digits}f",this)