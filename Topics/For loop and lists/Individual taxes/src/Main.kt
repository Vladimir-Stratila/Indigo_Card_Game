fun main() {
    val companiesIncome = mutableListOf<Int>()
    val companiesTax = mutableListOf<Int>()
    val listSize = readLine()!!.toInt()
    for (i in 1..listSize) {
        companiesIncome.add(readLine()!!.toInt())
    }
    for (i in 1..listSize) {
        companiesTax.add(readLine()!!.toInt())
    }
    var maxTax = -1.0
    var curTax = 0.0
    var highCompany = -1
    for (i in 0 until listSize) {
        curTax = companiesIncome[i].toDouble() * companiesTax[i] / 100
        if (curTax > maxTax) {
            maxTax = curTax
            highCompany = i + 1
        }
    }
    println(highCompany)
}
