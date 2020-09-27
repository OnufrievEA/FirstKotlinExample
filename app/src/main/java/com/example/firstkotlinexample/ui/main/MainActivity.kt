package com.example.firstkotlinexample.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstkotlinexample.R
import com.example.firstkotlinexample.data.entity.Note
import com.example.firstkotlinexample.ui.base.BaseActivity
import com.example.firstkotlinexample.ui.base.BaseViewModel
import com.example.firstkotlinexample.ui.note.NoteActivity
import com.example.firstkotlinexample.ui.splash.SplashActivity
import com.firebase.ui.auth.AuthUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<List<Note>?, MainViewState>() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override val viewModel: BaseViewModel<List<Note>?, MainViewState> by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override val layoutRes = R.layout.activity_main

    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        mainRecycler.layoutManager = GridLayoutManager(this, 2)
        adapter = MainAdapter {
            NoteActivity.start(this, it.id)
        }
        mainRecycler.adapter = adapter
        fab.setOnClickListener {
            NoteActivity.start(this)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean =
        MenuInflater(this).inflate(R.menu.main, menu).let { true }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.logout -> showLogoutDialog().let { true }
        else -> false
    }

    fun showLogoutDialog() {
        supportFragmentManager.findFragmentByTag(LogoutDialog.TAG) ?: LogoutDialog.createInstance {
            onLogout()
        }.show(supportFragmentManager, LogoutDialog.TAG)
    }

    fun onLogout() {
        AuthUI.getInstance()
            .signOut(this)
            .addOnCompleteListener {
                startActivity(Intent(this, SplashActivity::class.java))
                finish()
            }
    }

    override fun renderData(data: List<Note>?) {
        data?.let {
            adapter.notes = it
        }
    }
}