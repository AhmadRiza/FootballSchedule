package com.riza.footballschedule.ui.main

import com.google.gson.Gson
import com.riza.footballschedule.data.ApiRepository
import com.riza.footballschedule.data.TheSportDBApi
import com.riza.footballschedule.data.model.TeamResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(
        private val view: MainView,
        private val apiRepository: ApiRepository,
        private val gson: Gson
) {

    fun getTeamList(league: String?) {
        view.showLoading()

        doAsync {
            val data = gson.fromJson(
                    apiRepository.doRequest(TheSportDBApi.getTeams(league)),
                    TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }


        }

    }

}