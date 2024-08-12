package com.example.pyi

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pyi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        layoutManager.stackFromEnd = true
        binding.folderRecyclerview.layoutManager = layoutManager

        val folderAdapter = MyAdapter {
            // 폴더 버튼 클릭 처리, 예를 들어 다른 페이지로 이동
            val intent = Intent(this, clickfolderActivity::class.java)
            startActivity(intent)
        }

        binding.folderRecyclerview.adapter = folderAdapter






        val layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        layoutManager2.stackFromEnd = true
        binding.memoRecyclerview.layoutManager = layoutManager2

        val memoAdapter = MyAdapter2 {
            // 메모 버튼 클릭 처리, 예를 들어 다른 페이지로 이동
            val intent = Intent(this, QuickMemoActivity::class.java)
            startActivity(intent)
        }

        binding.memoRecyclerview.adapter = memoAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun navigateToOtherActivity() {
        val intent = Intent(this, QuickMemoActivity::class.java)
        startActivity(intent)
    }
}
