package cz.rimu.ilovememes.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cz.rimu.ilovememes.R
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var list: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        list = view.findViewById(R.id.list)
        list.layoutManager = LinearLayoutManager(context)
        val allFunnyAdapter = AllFunnyAdapter()
        list.adapter = allFunnyAdapter
        mainViewModel.hot.observe(viewLifecycleOwner) {
            allFunnyAdapter.updateHotChildren(it.data?.children)
            allFunnyAdapter.notifyDataSetChanged()
        }
        return view
    }
}