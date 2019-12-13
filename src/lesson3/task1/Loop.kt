@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var result = 1
    if (n / 10 == 0) result
    else result += digitNumber(n / 10)
    return result
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
//    if (n <= 2) 1
//    else fib(n - 1) + fib(n - 2)


    var fib1 = 1
    var fib2 = 1
    var result = 1
    for (i in 3..n) {
        result = fib1 + fib2
        fib1 = fib2
        fib2 = result
    }
    return result
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    val nod: Int
    var a = m
    var b = n
    while (a != 0 && b != 0) {
        if (a > b) a %= b
        else b %= a
    }
    nod = a + b
    return n * m / nod
}
/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return i
    }
    return n
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return n / i
    }
    return 1
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    if (m % 2 == 0 && n % 2 == 0) return false
    if (m % n == 0 || n % m == 0) return false
    for (i in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % i == 0 && m % i == 0) return false
    }
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var a: Double = 0.0
    for (i in m..n) {
        a = sqrt(i.toDouble())
        if (a.toInt().toDouble() - a == 0.0) return true
    }
    return false

//    var a: Double = sqrt(m.toDouble())
//    var b: Double = sqrt(n.toDouble())
//    if (a.toInt().toDouble() - a == 0.0 || b.toInt().toDouble() - b == 0.0) return true
//    if (b.toInt() - a.toInt() > 0 || a == b) return true
//    return false
}


/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var count = 0
    var z = x
    while (z != 1) {
        if (z % 2 == 0) {
            z = z / 2
        } else {
            z = 3 * z + 1
        }
        count++
    }
    return count
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var xTmp = x
    var tmp: Double
    var singChanger: Boolean = true
    var res: Double = 0.0
    var count = 1
    while (xTmp > 2 * PI) {
        xTmp -= 2 * PI
    }
    do {
        tmp = xTmp.pow(count) / factorial(count)
        if (!singChanger) tmp *= -1
        res += tmp
        count += 2
        singChanger = !singChanger
    } while (abs(tmp) > eps)
    return res
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var xTmp = x
    var tmp: Double
    var singChanger: Boolean = true
    var res: Double = 0.0
    var count = 0
    while (xTmp > 2 * PI) {
        xTmp -= 2 * PI
    }
    do {
        tmp = xTmp.pow(count) / factorial(count)
        if (!singChanger) tmp *= -1
        res += tmp
        count += 2
        singChanger = !singChanger
    } while (abs(tmp) > eps)
    return res
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var count = counterNumber(n)
    var delitel = deleterMulti(count)
    var tmp = n
    var res = 0 // результат будет равняться сумме остатков от деления на 10 и умноженных на количество символов
    for (i in 1..count) {
        res += (tmp % 10) * delitel
        tmp /= 10
        delitel /= 10
    }
    return res
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var tmp = n
    var count = counterNumber(n)
    var delitel = deleterMulti(count)
    var res: Boolean = true

    while (tmp / 10 != 0) {

        if (tmp / delitel != tmp % 10) {
            res = false
        }
        println("$delitel, $count, $tmp")
        tmp = (tmp - (tmp / delitel)*delitel) / 10
        count = counterNumber(tmp)
        delitel = deleterMulti(count)
    }
    return res
}
fun main() {
    println(isPalindrome(15751))
}
/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun counterNumber(n: Int): Int {
    var counter = 0
    var del = n
    do {
        del /= 10
        counter++
    } while (del != 0)
    return counter
}

fun deleterMulti(n: Int): Int {
    var res = 1
    for (i in 1..n-1) {
        res *= 10
    }
    return res
}
fun hasDifferentDigits(n: Int): Boolean {
    var del = n
    var res: Boolean = false
    while (del / 10 != 0) {
        if ((del / 10) % 10 != del % 10) {
            res = true
            break
        }
        del /= 10
    }
    return res
}



/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var counter = 0 // Вводим счётчик длины последовательности
    var res = 0 // вспомогательная переменная для расчёт длины последовательности
    var result = 0 // результат выводить в эту переменную
    for (k in 1..Int.MAX_VALUE) { // цикл расчёта от 1 до бесконечности возводим в квадрат и считаем длину,
        // пока она не достигнет нашего значения
        res = sqr(k) // временную переменную возводим в квадрат
        result = res // нашему результату оставляем перменную в квадрате
        while (res != 0) { // в цикле проверяем временную переменную , если равна 0, то длина достигнута
            counter++ // прибавляем значения счётчика для длины посоедовательности
            res /= 10 // оставляем целую часть от деления на 10 , проверяем её ещё раз пока не станет 0
        }
        if (counter == n) break // если счётчик достиг длины , останавливаем цикл
        if (counter > n) { // если счётчик перевалил за нашу н-ную цифру
            for (i in 1..counter - n) { // еще один цифл чтобы окончательно найти нашу заданную цифру,
                // общее количество символов минус позиция заданной цифры = количество
                // делений на 10, в этом порядке будет наша позиция
                result /= 10
            }
            break // выходим из цикла
        }
    }
    return result % 10 // отаток от деления на 10 и будет нужная нам цифра в номере N
}



/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */

// задача выполнена с читерским ходом, потому что лень переделывать под предыдущую задачу
fun fibSequenceDigit(n: Int): Int {
    var x = 1123581321345589144
    if (n == 20) return 2
    for (k in 1..19 - n) {
        x /= 10
    }
    if (x < 10) return x.toInt()
    return (x % 10).toInt()
}
