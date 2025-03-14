@file:Suppress("UNUSED_PARAMETER")

package lesson1.task1

import kotlin.math.*

/**
 * Оставляем цифры после запятой
 */

fun Double.format(digits: Int) = "%.${digits}f".format(this)

/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double, b: Double, c: Double) =
    (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции
 */
fun main() {
    val iSeconds = seconds(8, 20, 35)
    println("Секунд с начала суток = $iSeconds")
    val metr = lengthInMeters(8, 2 , 11)
    println("8 саженей 2 аршина 11 вершков в метрах = ${metr.format(2)}")
    val rad = angleInRadian(36, 14, 35)
    println("36 градусов 14 минут 35 секунд в радианах = ${rad.format(5)}")
    val rast = trackLength(3.0, 0.0, 0.0, 4.0)
    println("расстояние между (3, 0) и (0, 4) равно $rast")
    val third = thirdDigit(3801)
    println("3801 третья цифра = $third")
    val times = travelMinutes(9, 25, 13,1)
    println("выехал в 9:25 приехал в 13:01 время в минутах = $times")
    val money = accountInThreeYears(100, 10)
    println("100 рублей под 10% годовых превратятся в ${money.format(2)}")
    val revers = numberRevert(478)
    println("478 наборот будет $revers")
}

/**
 * Тривиальная
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int) = seconds + 60 * (minutes + 60 * hours)

/**
 * Тривиальная
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int) = (vershoks + 16 * arshins + 48 * sagenes) * 4.445 / 100

/**
 * Тривиальная
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
fun angleInRadian(deg: Int, min: Int, sec: Int) = ((deg * PI) / 180) + ((min * PI) / (180 * 60)) + ((sec * PI) / (180 * 60 * 60))

/**
 * Тривиальная
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double) = sqrt(((sqr((x2 - x1)) + sqr((y2 - y1)))))

/**
 * Простая
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int) = (number / 100) % 10

/**
 * Простая
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int) = 60 * (hoursArrive - hoursDepart) + minutesArrive - minutesDepart

/**
 * Простая
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */

fun stepen3(x: Double) = x * x * x

fun accountInThreeYears(initial: Int, percent: Int) = initial * stepen3((1 + percent / 100.0))

/**
 * Простая
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int {
    val c3 = (number / 100) % 10
    val c2 = ((number / 10 ) % 10) * 10
    val c1 = (number % 10) * 100
    return c1 + c2 + c3
}
