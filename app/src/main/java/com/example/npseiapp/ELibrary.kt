package com.example.npseiapp

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class ELibrary : AppCompatActivity() {
    lateinit var eLibraryWebView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elibrary)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "e-Library"
        eLibraryWebView = findViewById<View>(R.id.eLibraryWebView) as WebView
        eLibraryWebView!!.webViewClient = WebViewClient()
        eLibraryWebView!!.loadUrl("https://ndl.iitkgp.ac.in/")
        val webSettings = eLibraryWebView!!.settings
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

    override fun onBackPressed() {
        if (eLibraryWebView.canGoBack()) {
            eLibraryWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}