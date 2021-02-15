package cz.rimu.ilovememes.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import cz.rimu.ilovememes.R

const val DETAIL_AUTHOR = "author"
const val DETAIL_DATE = "date"
const val DETAIL_LINK = "link"

class DetailFragment : Fragment() {

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.detail_fragment, container, false)
        arguments?.let {
            val url = it.getString(DETAIL_LINK)
            view.findViewById<TextView>(R.id.author).text = it.getString(DETAIL_AUTHOR)
            val sdf = java.text.SimpleDateFormat(getString(R.string.post_date))
            val date = java.util.Date(it.getInt(DETAIL_DATE) * 1000L)
            view.findViewById<TextView>(R.id.date).text = sdf.format(date)
            view.findViewById<MaterialButton>(R.id.open_in_web).setOnClickListener {
                val browserIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://www.reddit.com$url"))
                startActivity(browserIntent)
            }
        }
        return view
    }

}