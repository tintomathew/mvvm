package com.kotlin.learning.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.net.Uri
import android.util.Log
import android.widget.ImageView

import com.kotlin.learning.model.Category
import com.squareup.picasso.Picasso
import java.net.URL

class CategoryViewModel : ViewModel {

    constructor() : super()
    var id = ""
    var title = ""
    var description = ""
    var imagePath = ""

    constructor(category: Category) : super() {
        this.id = category.id
        this.title = category.title
        this.description = category.description
        this.imagePath = category.imagePath
    }



    var arraylistMurableLiveData = MutableLiveData<ArrayList<CategoryViewModel>>()


    var arrayList = ArrayList<CategoryViewModel>()

    fun getImageUrl(): String{
        return imagePath
    }

    fun getArrayList() : MutableLiveData<ArrayList<CategoryViewModel>>{

        val category1 = Category("1", "Tinto", "testing", "https://imagesvc.meredithcorp.io/v3/mm/gif?url=https%3A%2F%2Fimg3.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2Fstyles%2F4_3_horizontal_-_1200x900%2Fpublic%2Fimage%2Fgettyimages-548008537.gif%3Fitok%3D_Skeo2B9&w=400&c=sc&poi=face&q=85")
        val category2 = Category("2", "Mathew", "testing2", "http://images6.fanpop.com/image/photos/34500000/Orange-Fruit-orange-34512881-2260-2175.jpg")

        val categoryViewModel : CategoryViewModel = CategoryViewModel(category1)
        val categoryViewMode2 : CategoryViewModel = CategoryViewModel(category2)

        arrayList.add(categoryViewModel)
        arrayList.add(categoryViewMode2)

        arraylistMurableLiveData.value = arrayList

        return arraylistMurableLiveData
    }
}

object ImageBindingAdapter{

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view:ImageView, url: String){
        val myUrl = URL(url)
        Log.d("*******",":::"+url)
        Picasso.with(view.context).load(url).into(view);}
}