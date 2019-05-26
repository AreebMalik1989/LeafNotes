package github.areebmalik1989.leafnotes

import android.app.Application

class LeafNotes : Application() {

    companion object {

        private lateinit var app : LeafNotes

        fun getApp() : LeafNotes{
            return app
        }
    }

    override fun onCreate() {

        super.onCreate()

        app = this
    }
}