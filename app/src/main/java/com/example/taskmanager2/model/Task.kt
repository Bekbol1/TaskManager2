package com.example.taskmanager2.model

import java.io.Serializable

data class Task(
    val title: String? = null,
    val desc: String? = null
): Serializable
