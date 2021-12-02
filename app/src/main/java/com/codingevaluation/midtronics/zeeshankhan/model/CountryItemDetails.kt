package com.codingevaluation.midtronics.zeeshankhan.model


data class ItemViewModel(
    val name: String?,
    val area: String?,
    val capital: String?,
    val population: String?,
    val region: String?,
    val subregion: String?
) {}


class CountryItemDetails(
    name: String?,
    area: String?,
    capital: String?,
    population: String?,
    region: String?,
    subregion: String?
) {
    var name: String?
        get() {
            return name
        }
        set(value) {
            this.name = value
        }
    var area: String?
        get() {
            return area
        }
        set(value) {
            this.area = value
        }
    var capital: String?
        get() {
            return capital
        }
        set(value) {
            this.capital = value
        }
    var population: String?
        get() {
            return population
        }
        set(value) {
            this.population = value
        }
    var region: String?
        get() {
            return region
        }
        set(value) {
            this.region = value
        }
    var subregion: String?
        get() {
            return subregion
        }
        set(value) {
            this.subregion = value
        }
}

