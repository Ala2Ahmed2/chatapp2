package com.mis.route.chatapp.ui.database

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.Firebase
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.firestore

object MyDatabase {
    const val usersCollection = "users"

    fun createUser(user: User, onComplete: OnCompleteListener<Void>){
        Firebase.firestore.collection(usersCollection)
            .document(user.uid?:"")
            .set(user)
            .addOnCompleteListener (onComplete)
    }

    fun getUserFromDB(uid: String, onComplete: OnCompleteListener<DocumentSnapshot>) {
        Firebase.firestore.collection(usersCollection)
            .document(uid)
            .get()
            .addOnCompleteListener (onComplete)
    }
}