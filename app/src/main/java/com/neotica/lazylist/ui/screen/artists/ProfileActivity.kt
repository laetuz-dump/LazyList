package com.neotica.lazylist.ui.screen.artists

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.neotica.lazylist.data.model.PersonEntity
import com.neotica.dicoding2.ui.theme.MyTheme

class ProfileActivity : ComponentActivity() {

    private val entity: PersonEntity by lazy {
        intent?.getSerializableExtra(SINGER_ID) as PersonEntity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                ArtistDetail(entity)
            }
        }
    }

    companion object {
        private const val SINGER_ID = "singer_id"
        fun newIntent(context: Context, personEntity: PersonEntity) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(SINGER_ID, personEntity)
            }
    }
}

