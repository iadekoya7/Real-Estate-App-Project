package com.mad.real_estate_app.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HouseViewModel: ViewModel() {
    val response: MutableState<DataState> = mutableStateOf(DataState.Empty)
    init {
        fetchHouseDetails()
    }

    private fun fetchHouseDetails() {
        val tempList = mutableListOf<House>()
        response.value = DataState.Loading
        FirebaseDatabase.getInstance().getReference("House")
            .addListenerForSingleValueEvent(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (DataSnap in snapshot.children){
                        val houseItem = DataSnap.getValue(House::class.java)
                        if(houseItem != null)
                            tempList.add(houseItem)
                    }
                    response.value = DataState.Success(tempList)
                }

                override fun onCancelled(error: DatabaseError) {
                    response.value = DataState.Failure(error.message)
                }
            })
    }
}