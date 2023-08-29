package com.example.hackjam2023.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class Repository @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth:FirebaseAuth,
    private val dataStore:DataStore<Preferences>
) {
}