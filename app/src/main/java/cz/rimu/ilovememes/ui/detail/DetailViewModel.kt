package cz.rimu.ilovememes.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cz.rimu.ilovememes.rest.model.HotChildren

class DetailViewModel(item: HotChildren) : ViewModel() {
    val selectedItem = MutableLiveData(item)
}