package cz.rimu.ilovememes.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import cz.rimu.ilovememes.repositories.MainRepository
import cz.rimu.ilovememes.rest.model.Hot

class MainViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {
    val hot: LiveData<Hot> = liveData {
        emit(mainRepository.getAllFunny())
    }
}