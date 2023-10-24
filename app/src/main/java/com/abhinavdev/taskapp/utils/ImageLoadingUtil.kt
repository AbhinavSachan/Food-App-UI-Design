package com.abhinavdev.taskapp.utils

import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageLoadingUtil {
    fun loadFromApiUrl(
        apiUrl: String?,
        placeholderImage: Int,
        errorHolderImage: Int = placeholderImage,
        imageView: ImageView?,
        image_measure: Int = 512
    ) {
        Picasso.get().load(apiUrl).resize(image_measure, image_measure)
            .centerCrop()
            .placeholder(placeholderImage).error(errorHolderImage)
            .into(imageView)
    }

    fun loadFromUri(
        uri: Uri?,
        placeholderImage: Int,
        errorHolderImage: Int,
        imageView: ImageView?,
        image_measure: Int = 512
    ) {
        Picasso.get().load(uri).resize(image_measure, image_measure)
            .placeholder(placeholderImage).error(errorHolderImage)
            .into(imageView)
    }

    fun loadFromUri(
        uri: String?,
        placeholderImage: Int,
        errorHolderImage: Int,
        imageView: ImageView?,
        image_measure: Int = 512
    ) {
        Picasso.get().load(uri).resize(image_measure, image_measure)
            .placeholder(placeholderImage).error(errorHolderImage)
            .into(imageView)
    }

    fun loadFromRes(res: Int, imageView: ImageView?) {
        Picasso.get().load(res).resize(512, 512)
            .into(imageView)
    }
}