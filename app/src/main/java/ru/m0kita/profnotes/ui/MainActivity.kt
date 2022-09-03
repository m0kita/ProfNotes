package ru.m0kita.profnotes.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import ru.m0kita.profnotes.R
import ru.m0kita.profnotes.core.gone
import ru.m0kita.profnotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navView.background = null
        binding.bottomAppBar.gone()
        binding.fab.gone()


        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.loginFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        val radius = resources.getDimension(R.dimen.default_corner_radius)
        val shapeAppearanceModel = ShapeAppearanceModel()
            .toBuilder()
            .setTopRightCorner(CornerFamily.ROUNDED, radius)
            .setTopLeftCorner(CornerFamily.ROUNDED, radius)
            .setBottomRightCorner(CornerFamily.ROUNDED, radius)
            .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
            .build()

        ViewCompat.setBackground(binding.bottomAppBar, MaterialShapeDrawable(shapeAppearanceModel))

    }
}