package ru.m0kita.profnotes.data.model

import ru.m0kita.profnotes.R

enum class Status(val icon: Int, val color: Int, val statusName: String, val desctiption: String) {
    New(R.drawable.ic_status_new, R.color.blue, "Новое", "Только что созданная задача"),
    InWork(
        R.drawable.ic_status_in_work,
        R.color.light_green,
        "В работе",
        "Активный этап выполнения"
    ),
    Performed(
        R.drawable.ic_status_performed,
        R.color.yellow,
        "Выполнено",
        "Задача полностью выполнена"
    ),
    HoldOver(
        R.drawable.ic_status_hold_over,
        R.color.red,
        "Отложено",
        "Задача требует задержки в работе"
    )
}