package subtask2

/*  Моя младшая сестра вернулась домой из школы со следующей задачей: получив квадратный лист бумаги, она должна
разрезать его на части, которые при сборке дают квадраты, стороны которых образуют возрастающую последовательность
чисел. Вначале это было очень весело, но мало-помалу мы устали видеть груду разорванной бумаги. Поэтому мы решили
написать программу, которая могла бы помочь нам и защитить деревья.

Задача
Дано положительное целое число n, вернуть строго возрастающую последовательность (массив) чисел, чтобы сумма
квадратов была равна n².
Если существует несколько решений (а их будет), верните, насколько это возможно, результат с максимально возможными
значениями:

Примеры

разложить 11 должен вернуть [1, 2, 4, 10]. Обратите внимание, что на самом деле есть два способа разложить
 11², 11² = 121 = 1 + 4 + 16 + 100 = 1² + 2² + 4² + 10², но не возвращайте [2, 6, 9], поскольку 9 меньше 10.

Для разложения 50 не возвращайте [1, 1, 4, 9, 49], но [1, 3, 5, 8, 49], поскольку [1, 1, 4, 9, 49] не формируют
 строго возрастающую последовательность. .

Примечание

Ни [n], ни [1, 1, 1,…, 1] не являются допустимыми решениями. Если действительного решения не существует, верните ноль.

Функция «разложить» примет положительное значение Int n и вернет разложение N = n² как [x1 ... xk]

Если n отрицательное, также верните null.

Примеры:

разложить 50 результатов [1, 3, 5, 8, 49]

разложить 4 возвращает ноль*/

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        val n = number.toLong()
        val array = ArrayList<Int>()
        decompose(n * n, n - 1, array)

        return if (array.isEmpty()) null else array.toTypedArray()
    }

    private fun decompose(square: Long, number: Long, array: ArrayList<Int>): Boolean {
        for (i in number downTo 1) {
            val difSquare = square - (i * i)
            if (difSquare == 0L) {
                array.add(i.toInt())
                return true
            }
            if (difSquare > 0 && decompose(difSquare, i - 1, array)) {
                array.add(i.toInt())
                return true
            }
        }
        return false
    }
}

/*  return if (number < 3) null else {
            val array = ArrayList<Int>()
            val array1 = ArrayList<Int>()

            val dif = (number * number - ((number - 1) * (number - 1))).toLong()
            var difSquare = dif
            var sumSqrNum = 0L

            println(difSquare)
            while (sumSqrNum < dif) {
                for (i in difSquare downTo 1) {
                     if (i * i <= difSquare) {
                        difSquare = dif - i * i - sumSqrNum
                        sumSqrNum += i * i
                        array1.add(i.toInt())
                    }
                    if (sumSqrNum + sumSqrArray(array) == dif) {
                        array.add(i.toInt())
                        difSquare = (array1[0] * array1[0]).toLong()
                        sumSqrNum = 0
                        array1.clear()
                        if (sumSqrArray(array) == dif) {
                            sumSqrNum = dif
                        }
                        break
                    } else if (sumSqrNum != dif && i == 1L) {
                        difSquare = (array1[0] * array1[0]) - i
                        array1.clear()
                        sumSqrNum = 0
                    }
                }
            }
            array.add((number - 1))
            println(array)
            println()
            return array.toTypedArray()
        }

        private fun sumSqrArray(array: ArrayList<Int>): Long {
        var sum = 0L
        for (i in array.indices) {
            sum += array[i] * array[i]
        }
        return sum
    }
        */