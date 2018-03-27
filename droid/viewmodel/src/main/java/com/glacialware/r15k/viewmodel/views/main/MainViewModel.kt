package com.glacialware.r15k.viewmodel.views.main

import android.app.Application
import android.arch.lifecycle.*
import com.glacialware.r15k.model.retrofit.GenericGetAllResponse
import com.glacialware.r15k.model.retrofit.PlayerController
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.viewmodel.views.GenericDatabaseViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
* Created by Guille on 13/11/2017.
*/
class MainViewModel(app : Application) : GenericDatabaseViewModel(app), PlayerController.IPlayerResponse {
    // ---- Attributes ----

    private var shouldFetch = true
    private val playerController = PlayerController(this)
    private var mPlayersView: PlayersView? = null

    // ---- END Attributes ----

    // ---- Properties ----

    val lPlayers : MutableLiveData<List<Player>> = MutableLiveData()

    // ---- END Properties ----

    // ---- Lifecycle ----

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun checkPlayers() {
        /*
        1. Observe disk.
        if (!is_null) {
            2. Dispatch value.
        }
        if (!should_fetch)
        {
            3. Do nothing.
        } else {
            4. Fetch data.
            if (!is_successful) {
                5. Dispatch error.
            } else {
                6. Save to disk.
                7. Reload data.
            }
        }
         */

        doAsync {
            // Observe disk && dispatch value.
            val lItems = database.playerDao().getAll()
            uiThread {
                lPlayers.value = lItems
            }
            // Fetch.
            if (shouldFetch) {
                shouldFetch = false
                fetch()
            }
        }
    }

    // ---- END Lifecycle ----

    // ---- Public ----

    fun setPlayersView(view: PlayersView) {
        mPlayersView = view
    }

    // ---- END Public ----

    // ---- Private ----

    private fun fetch() {
        this.playerController.start()
    }

    // ---- END Private ----

    // ---- Events ----

    fun onPlayerClick(player: Player) {
        mPlayersView?.showPlayerDetail(player)
    }

    // ---- END Events ----

    // ---- PlayerController.IPlayerResponse ----

    override fun errorResponse(error: String) {
        // Dispatch error.
    }

    override fun successResponse(response: GenericGetAllResponse<com.glacialware.r15k.model.retrofit.Player>) {
        doAsync {
            // Clear local table.
            database.playerDao().clear()
            // Save to disk.
            val lMissions = response.values
            lMissions.forEach { item ->
                val player = item.exportRoom()
                database.playerDao().insert(player)
            }
            // Reload.
            checkPlayers()
        }
    }

    // ---- END PlayerController.IPlayerResponse ----
}