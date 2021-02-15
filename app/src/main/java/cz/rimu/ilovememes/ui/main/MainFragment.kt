package cz.rimu.ilovememes.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cz.rimu.ilovememes.R
import cz.rimu.ilovememes.rest.model.HotChildren
import cz.rimu.ilovememes.ui.detail.DETAIL_AUTHOR
import cz.rimu.ilovememes.ui.detail.DETAIL_DATE
import cz.rimu.ilovememes.ui.detail.DETAIL_LINK
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var list: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        list = view.findViewById(R.id.list)
        list.layoutManager = LinearLayoutManager(context)
        val allFunnyAdapter = AllFunnyAdapter(::onItemClicked)
        list.adapter = allFunnyAdapter
        mainViewModel.hot.observe(viewLifecycleOwner) {
            allFunnyAdapter.updateHotChildren(it.data?.children)
            allFunnyAdapter.notifyDataSetChanged()
        }
        return view
    }

    private fun onItemClicked(item: HotChildren) {
        findNavController().navigate(
            R.id.detailFragment,
            bundleOf(
                DETAIL_AUTHOR to item.data.author_fullname,
                DETAIL_DATE to item.data.created,
                DETAIL_LINK to item.data.permalink
            )
        )
    }
}