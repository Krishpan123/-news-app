package com.krishpan.abcnews.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.krishpan.abcnews.R
import com.krishpan.abcnews.databinding.FragmentArticleBinding
import com.krishpan.abcnews.ui.NewsActivity
import com.krishpan.abcnews.ui.NewsViewModel


class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var newsViewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()
    lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentArticleBinding.bind(view)


        newsViewModel = (activity as NewsActivity).newsViewModel
        val  article = args.article
        binding.webView.apply {
            webViewClient = WebViewClient()
            url?.let{
                loadUrl(it)
            }
        }



        binding.fab.setOnClickListener {
            newsViewModel.addToFavourites(article)
            Snackbar.make(view, "Added to favourites", Snackbar.LENGTH_LONG).show()
        }
    }

}