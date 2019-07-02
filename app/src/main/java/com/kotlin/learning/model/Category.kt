package com.kotlin.learning.model

class Category{

    var id = ""
    var title = ""
    var description = ""
    var imagePath = ""


    constructor(id: String, title: String, description: String, imagePath: String) {
        this.id = id
        this.title = title
        this.description = description
        this.imagePath = imagePath
    }


}