package com.colisa.tetris.logic


import androidx.compose.ui.geometry.Offset


data class Brick(val location: Offset = Offset(0, 0)) {
    companion object {

        private fun of(list: List<Offset>) = list.map { Brick(it) }

        fun of(spirit: Spirit) = of(spirit.location)

        fun of(xRange: IntRange, yRange: IntRange) =
            of(mutableListOf<Offset>().apply {
                xRange.forEach { x ->
                    yRange.forEach { y ->
                        this += Offset(x, y)
                    }
                }
            })

    }

    fun offsetBy(step: Pair<Int, Int>) =
        copy(location = Offset(location.x + step.first, location.y + step.second))
}
