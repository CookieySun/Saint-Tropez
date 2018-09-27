package com.example.sunsh.sainttropez

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.email
import org.jetbrains.anko.sendSMS
import org.jetbrains.anko.share

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(imageView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.top -> {
                imageView.setImageResource(R.mipmap.toppage)
                return true
            }
            R.id.lunch01 -> {
                imageView.setImageResource(R.mipmap.lunch01)
                return true
            }
            R.id.lunch02 -> {
                imageView.setImageResource(R.mipmap.lunch02)
                return true
            }
            R.id.dinner01 -> {
                imageView.setImageResource(R.mipmap.dinner01)
                return true
            }
            R.id.dinner02 -> {
                imageView.setImageResource(R.mipmap.dinner02)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context, menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.sms -> sendSMS("999-9999-9999", "予約をしたいです")
            /*{
            val number = "999-9999-9999"
            val uri = Uri.parse("sms:$number")
            var intent = Intent(Intent.ACTION_VIEW)
            intent.apply {
                data = uri
                putExtra("sms_body", "予約をしたいです")
            }
            startActivity(intent)
            return true
        }*/
            R.id.mail -> email("nobody@example.com", "予約の問い合わせ",
                    "以下の通り予約希望します。")
            /*{
            val email = "nobody@example.com"
            val subject = "予約の問い合わせ"
            val text = "以下の通り予約希望します。"
            val uri = Uri.parse("mailto:")
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.apply {
                data = uri
                putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, text)
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
            return true
        }*/
            R.id.share -> share("美味しいレストランを紹介します。")
            /*{
                val text = "美味しいレストランを紹介します。"
                val intent = Intent(Intent.ACTION_SEND)
                intent.apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, text)
                }
                val chooser = Intent.createChooser(intent, null)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(chooser)
                }
                return true
            }*/
            R.id.brows -> browse("https://google.com")
            /*{
                val url = "https://google.com"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }*/
            else -> super.onContextItemSelected(item)
        }
    }
}
