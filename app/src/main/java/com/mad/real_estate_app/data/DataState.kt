package com.mad.real_estate_app.data

sealed class DataState{
    class Success(val data: MutableList<House>): DataState()
    class Failure(val message: String): DataState()
    object Loading: DataState()
    object Empty: DataState()
}
