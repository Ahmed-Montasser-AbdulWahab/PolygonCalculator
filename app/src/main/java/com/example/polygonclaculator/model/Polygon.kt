package com.example.polygonclaculator.model

import kotlin.math.PI
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

open class Polygon(protected val sideLength: Double, private val numberOfSides : Int = 3) {

    fun calculatePerimeter() : Double{
        return sideLength * numberOfSides
    }

    open fun calculateArea() :Double{
        return ((sideLength*sideLength)/4)*(1/ tan(Math.PI/numberOfSides))*numberOfSides
    }

    fun calculateInteriorAngle() : Double{
        return (((numberOfSides-2)*180.0)/numberOfSides)
    }


}

class EquilateralTriangle(sideLength: Double) : Polygon(sideLength, 3){
    override fun calculateArea():Double{
        return 0.5 * (sideLength)*(sideLength)* sin(PI/3)
    }

    fun calculateArea2():Double{
        val S = calculatePerimeter() * 0.5
        return sqrt(S * (S-sideLength)*(S-sideLength)*(S-sideLength))
    }
}

