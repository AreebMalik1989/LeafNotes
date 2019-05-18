package github.areebmalik1989.leafnotes

import android.app.Application

class LeafNotes : Application() {

    companion object {

        private lateinit var app : LeafNotes
    }

    override fun onCreate() {

        super.onCreate()

        app = this
    }

    fun getApp() : LeafNotes{
        return app
    }
}