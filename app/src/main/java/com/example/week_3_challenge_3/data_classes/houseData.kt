package com.example.week_3_challenge_3.data_classes

data class houseData(
    var id:Int,
    var images:List<String>,
    var price:Int,
    var title:String,
    var address:String,
    var area:String,
    var bedRooms: Int,
    var bathRooms:Int,
    var added:Int,
    var views:Int
)