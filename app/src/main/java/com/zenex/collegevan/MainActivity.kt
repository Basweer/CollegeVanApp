package com.zenex.collegevan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.zenex.collegevan.database.AppDatabase
import com.zenex.collegevan.database.DatabaseSeeder
import com.zenex.collegevan.navigation.AppNavigation
import com.zenex.collegevan.ui.theme.ZenexTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AppDatabase.getDatabase(applicationContext)

        lifecycleScope.launch {
            DatabaseSeeder.seed(database)
        }

        setContent {

            ZenexTheme {

                AppNavigation()

            }
        }
    }
}