package br.com.aluno.usingsomeapis.view.activitiy

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.aluno.usingsomeapis.R
import br.com.aluno.usingsomeapis.presenter.GlobalPresenter
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val ID_HOME = 101
        const val ID_NOTI = 102
        const val ID_SETTINGS = 103
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setupUI()
        this.setupTabBar()
        this.preSetupFragment()
    }

    private fun setupUI() {
        this.window.statusBarColor = ContextCompat.getColor(this, R.color.colorMain)
        this.toolbar.visibility = View.GONE
    }

    private fun preSetupFragment() {
        this.mainTabBar.show(ID_HOME)
        this.supportFragmentManager.beginTransaction()
            .replace(R.id.mainMenuFragment, GlobalPresenter.sharedInstance.navHostFragment)
            .setPrimaryNavigationFragment(GlobalPresenter.sharedInstance.navHostFragment).commit()
        this.supportActionBar?.hide()
    }

    private fun setupTabBar() {
        mainTabBar.add(MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home))
        mainTabBar.add(MeowBottomNavigation.Model(ID_SETTINGS, R.drawable.ic_settings))
    }
}