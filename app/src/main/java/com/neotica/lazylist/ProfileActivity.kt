package com.neotica.lazylist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.neotica.lazylist.data.model.PersonEntity
import com.neotica.dicoding2.ui.theme.MyTheme

class ProfileActivity : ComponentActivity() {

    private val puppy: PersonEntity by lazy {
        intent?.getSerializableExtra(PUPPY_ID) as PersonEntity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                ProfileScreen(puppy)
            }
        }
    }

    companion object {
        private const val PUPPY_ID = "puppy_id"
        fun newIntent(context: Context, personEntity: PersonEntity) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(PUPPY_ID, personEntity)
            }
    }
}

