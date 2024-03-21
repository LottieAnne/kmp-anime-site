package jp.co.yumemi.app

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var splashScreen: SplashScreen? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        // Android12以降でシステムのスプラッシュを長く表示する対応
        if (Build.VERSION.SDK_INT >= 31) {
            splashScreen = installSplashScreen()
        }

        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)
        findNavController(R.id.nav_host_fragment).setGraph(jp.co.yumemi.navigation.R.navigation.app_nav_graph)
    }
}
