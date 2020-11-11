package com.kyawt.mycollection.view.utils

import android.content.Context
import androidx.core.content.ContextCompat
import com.facebook.shimmer.Shimmer
import com.kyawt.mycollection.R

object ShimmerUtils {
    fun getGrayShimmer(context: Context) : Shimmer{
      return Shimmer.ColorHighlightBuilder()
          .setBaseColor(ContextCompat.getColor(context, R.color.shimmerBase0))
          .setHighlightColor(ContextCompat.getColor(context,R.color.shimmerHighlight0))
          .setBaseAlpha(0.8f)
          .setHighlightAlpha(0.8f)
          .build()
    }
}