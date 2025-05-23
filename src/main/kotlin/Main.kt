package com.kmc

fun main(){
    var loopCount = 0
    var success = false
    while (!success) {
        try {
            val inputList = inputCar()
            makeCar(inputList)
            success = true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    success = false
    while (!success) {
        try {
            loopCount = inputLoopCount()
            success = true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    runMainLoop(loopCount)

    Car.printWinner()
}

fun runMainLoop(loopCount: Int){
    for(i in 1..loopCount){
        Car.runStep()
    }
}

fun makeCar(carList: List<String>) {
    Car.clearCar()
    Car.createCar(carList)
}

fun inputCar(): List<String> {
    println("자동차 이름을 입력해 주세요(,로 구분)")
    return readLine()?.split(",") ?: throw IllegalArgumentException("[ERROR] 입력을 넣어주세요")
}

fun inputLoopCount(): Int {
    println("시도할 횟수를 알려 주세요")
    try {
        return readLine()?.toInt() ?: throw IllegalArgumentException("[ERROR] 숫자로 입력해 주세요")
    }catch (_: NumberFormatException){
        throw IllegalArgumentException("[ERROR] 숫자로 입력해 주세요")
    }
}