package com.glacialware.r15k.view.views.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.R

/**
* Created by Guille on 06/07/2017.
*/
class TestActivity : AppCompatActivity() {

    // ---- Companion ----

    companion object {
        private const val TITLE_KEY = "title"
        private const val AUTHOR_KEY = "author"
        private const val TAG = "InspiringTitle"
    }

    // ---- END Companion ----

    // ---- Attributes ----

//    private val mDocRef = FirebaseFirestore.getInstance().document("sampleData/inspiration")
//    private val db = FirebaseFirestore.getInstance()

    // ---- END Attributes ----

    // ---- Activity ----

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(R.layout.activity_test)

        this.initMissions()
    }

    // ---- END Activity ----

    // ---- Private ----

    private fun initMissions() {
//        this.db.collection("missions").get().addOnCompleteListener(this,  {
//            task ->
//            if (task.isSuccessful) {
//                var text = ""
//                val lDocuments = task.result.documents
//                for (document : DocumentSnapshot in lDocuments) {
//                    text += String.format("id = %s :: title = %s :: description = %s \n", document.id, document.data?.get("title"), document.data?.get("description"))
//                }
//                this.textViewTitles.text = text
//            }
//            else {
//                Log.w(TAG, task.exception)
//            }
//        })
    }

    private fun initSampledata() {
//        this.buttonSave.setOnClickListener { _ ->
//            val titleText = this.editTextTitle.text.toString()
//            val authorText = this.editTextAuthor.text.toString()
//            if (!titleText.isNullOrEmpty() && !authorText.isNullOrEmpty()) {
//                val dataToSave = mutableMapOf<String, Any>()
//                dataToSave.put(TITLE_KEY, titleText)
//                dataToSave.put(AUTHOR_KEY, authorText)
//                // option 1
////                this.mDocRef.set(dataToSave as Map<String, Any>).addOnSuccessListener {
////                    Log.d(TAG, "Document has been saved!")
////                }.addOnFailureListener {
////                    error ->
////                    Log.w(TAG, "Document was not saved!", error)
////                }
//                // option 2
//                this.mDocRef.set(dataToSave as Map<String, Any>).addOnCompleteListener {
//                    task ->
//                    if (task.isSuccessful) {
//                        Log.d(TAG, "Hooray! Document was saved!")
//                    }
//                    else {
//                        Log.w(TAG, "Oh no!", task.exception)
//                    }
//                }
//            }
//        }
//
//        this.buttonFetch.setOnClickListener { _ ->
//            this.mDocRef.get().addOnSuccessListener { documentSnapshot ->
//                if (documentSnapshot.exists()) {
//                    val titleText = documentSnapshot.getString(TITLE_KEY)
//                    val authorText = documentSnapshot.getString(AUTHOR_KEY)
//
//                    this.textViewTitles.text = String.format("title = %s :: author = %s", titleText, authorText)
//                }
//            }
//        }
    }

    private fun addSnapshotSampledata() {
//        this.mDocRef.addSnapshotListener(this, { documentSnapshot, e ->
//            if (documentSnapshot != null && documentSnapshot.exists()) {
//                val titleText = documentSnapshot.getString(TITLE_KEY)
//                val authorText = documentSnapshot.getString(AUTHOR_KEY)
//
//                this.textViewTitles.text = String.format("title = %s :: author = %s", titleText, authorText)
//            }
//            else if (e != null) {
//                Log.w(TAG, "Got an exception!", e)
//            }
//        })
    }

    // ---- END Private ----

}