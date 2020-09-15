package com.firmfreez.android.spidergrouptest.ui.viewModels

import android.util.Log
import androidx.lifecycle.*
import com.firmfreez.android.spidergrouptest.di.App
import com.firmfreez.android.spidergrouptest.models.ImageComments
import com.firmfreez.android.spidergrouptest.models.ImageComments.DataItem
import com.firmfreez.android.spidergrouptest.services.GalleryService
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel, необходимая для загрузки данных об изображении
 * При успешной загрузке данные попадают в LiveData, откуда биндятся на xml или обсервятся во фрагменте
 */
class SelectedImageViewModel(id: String) : ViewModel() {
    @Inject lateinit var galleryService: GalleryService

    private val _titleLiveData: MutableLiveData<String?> = MutableLiveData()
    val titleLiveData: LiveData<String?> = _titleLiveData

    private val _descriptionLiveData: MutableLiveData<String?> = MutableLiveData()
    val descriptionLiveData: LiveData<String?> = _descriptionLiveData

    private val _commentsLiveData: MutableLiveData<List<DataItem?>> = MutableLiveData()
    val commentsLiveData: LiveData<List<DataItem?>> = _commentsLiveData

    init {
        App.instance.component?.inject(this)
        loadData(id)
    }

    fun loadData(id: String) {
        viewModelScope.launch {
            val imageInfo = galleryService.getImageInfoOrNull(id)
            _titleLiveData.value = imageInfo?.data?.title ?: "Название отсутствует"
            _descriptionLiveData.value = imageInfo?.data?.description ?: "Описание остутствует"

            if(imageInfo?.data?.commentCount != 0) {
                val commentsInfo = galleryService.getCommentsOrNull(id)
                _commentsLiveData.value = commentsInfo?.data
            }
        }
    }


    class Factory(val id: String): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SelectedImageViewModel(id) as T
        }
    }
}