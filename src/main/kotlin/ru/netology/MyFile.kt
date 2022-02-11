package ru.netology

/** ЗАДАЧА
 * Используя when, напишите функцию agoToText (скорее всего, вам понадобится не одна функция),
 * которая переводит количество секунд, которые человек был назад в сети в соответствующий текст (String).
 * Нас будет интересовать вся фраза, например, был(а) только что или был(а) в сети 3 часа назад.
 */


fun main() {
    val timeAgo = 3600 //*sec

    agoToText(timeAgo)
}

fun timeText(time: Int): String {
    return when {
        time < 60 -> "только что"
        time < 3600 -> "" + timeConverter(time) + " " + minSpell(timeConverter(time)) + " назад"
        time < 24 * 3600 -> "" + timeConverter(time) + " " + hourSpell(timeConverter(time)) + " назад"
        time < 48 * 3600 -> "сегодня"
        time < 72 * 3600 -> "вчера"
        //time >= 72 *3600 -> "давно"
        else -> "давно"
    }
}

fun agoToText(time: Int) {
    println("Пользователь был(а) " + timeText(time))
}

fun timeConverter(time: Int): Int {
    return when {
        time < 3600 -> time / 60
        time < 24 * 3600 -> time / 3600
        else -> 0
    }
}

fun minSpell(time: Int): String {
    return when (time) {
        1, 21, 31, 41, 51 -> "минуту"
        in 2..4 -> "минуты"
        in 5..20, in 22..30, in 32..40, in 42..50, in 52..59 -> "минут"
        else -> ""
    }
}

fun hourSpell(time: Int): String {
    return when (time) {
        1, 21, 31, 41, 51 -> "час"
        in 2..4 -> "часа"
        in 5..20, in 22..30, in 32..40, in 42..50 -> "часов"
        else -> ""
    }
}
