package com.example.hackjam2023.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.hackjam2023.model.auth.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class Repository @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth,
    private val dataStore: DataStore<Preferences>
) {
    fun register(
        email: String,
        password: String,
        name: String,
        onSuccess: () -> Unit,
        onFailed: (String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(
            email, password
        ).addOnSuccessListener { user ->
            if (user.user == null) {
                onFailed("Terjadi kesalahan saat registrasi")
                return@addOnSuccessListener
            }

            firestore
                .collection("user")
                .document(user.user?.uid ?: "")
                .set(
                    UserModel(
                        uid = user.user?.uid,
                        email = email,
                        name = name
                    )
                )
                .addOnSuccessListener {
                    onSuccess()
                }
                .addOnFailureListener { err ->
                    user
                        .user
                        ?.delete()
                        ?.addOnSuccessListener {
                            onFailed(err.message ?: "Terjadi kesalahan saat registrasi")
                        }
                }
        }.addOnFailureListener {
            onFailed(it.message ?: "Terjadi kesalahan saat registrasi")
        }
    }

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailed: (String) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailed(it.message ?: "Terjadi kesalahan saat berusaha login")
            }
    }

    suspend fun setFirstTimeState(state: Boolean) {
        dataStore.edit {
            it[booleanPreferencesKey("first_time")] = state
        }
    }

    fun getFirstTimeState() = dataStore.data.map {
        it[booleanPreferencesKey("first_time")] ?: true
    }

    fun isLogin() = auth.currentUser != null
}