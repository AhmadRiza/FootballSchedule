package com.riza.footballschedule.ui.main

import com.riza.footballschedule.data.model.Team

interface MainView{

    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)

}