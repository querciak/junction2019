package com.example.junction2019.model

class NuScoModel {

    companion object {
        // DUMMY RESPONSES
        var nuScoRatios = listOf<Float>(0.2f, 0.3f, 0.1f, 0.3f, 0.1f)
        var nuSco : Char = 'D'
        var dummyQuery = arrayOf(Products("danone yoghurt"), Products("oatly yoghurt"))

        fun parseNuScoHistoryData(): List<Float> {
            //TODO request data from back-end

            // returning dummy data for now
            return nuScoRatios
        }

        fun getNuScoAverage(): Char {
            //TODO request data from back-end

            // returning dummy data for now
            return nuSco
        }

        fun queryProductsByKeyWord(queryProduct: String): Array<Products> {
            //TODO request data from back-end

            // returning dummy data for now
            return dummyQuery
        }


    }

}