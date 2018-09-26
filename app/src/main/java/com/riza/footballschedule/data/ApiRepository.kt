package com.riza.footballschedule.data

import java.net.URL

class ApiRepository{

    //do equest from url
    fun doRequest(url: String):String{
        return URL(url).readText()
    }

}