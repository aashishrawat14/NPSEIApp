package com.example.npseiapp

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class Website : AppCompatActivity() {
    private var mywebView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Website"
        mywebView = findViewById<View>(R.id.webview) as WebView
        mywebView!!.webViewClient = WebViewClient()
        mywebView!!.loadUrl("https://sitp.ac.in/")
        val webSettings = mywebView!!.settings
        webSettings.javaScriptEnabled = true
    }

    class mywebClient : WebViewClient() {
        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
            super.onPageStarted(view, url, favicon)
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (mywebView!!.canGoBack()) {
            mywebView!!.goBack()
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}