package ru.m0kita.profnotes.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import ru.m0kita.profnotes.R
import ru.m0kita.profnotes.databinding.ActivityMainBinding
import ru.m0kita.profnotes.core.gone
import ru.m0kita.profnotes.core.visible


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.navHost)

        navController.addOnDestinationChangedListener {_, destination, _ ->
            when(destination.id) {
                R.id.homeFragment -> {
                    binding.bottomNavigationView.visible()
                    binding.fab.visible()
                    binding.bottomAppBar.visible()
                }

                else -> {
                    binding.bottomNavigationView.gone()
                    binding.fab.gone()
                    binding.bottomAppBar.gone()
                }
            }
        }

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.loginFragment,
                R.id.registrationFragment,
                R.id.homeFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigationView.setupWithNavController(navController)

        val radius = resources.getDimension(R.dimen.default_corner_radius)
        val bottomAppBar = binding.bottomAppBar

        val bottomBarBackground = bottomAppBar.background as MaterialShapeDrawable
        bottomBarBackground.shapeAppearanceModel = bottomBarBackground.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, radius)
            .build()

        binding.fab.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_newNoteFragment)
        }


    }


}