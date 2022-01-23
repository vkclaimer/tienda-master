package com.app.daintybox.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.app.daintybox.R
import com.app.daintybox.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : DaintyBoxBaseActivity() {

    var bottom_navigation: BottomNavigationView? = null
    var header_home: LinearLayoutCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        /** Creacion de objectos genericos para cualquier actividad daintybox **/
        baseCreate(savedInstanceState)

        if (supportActionBar != null) supportActionBar!!.title = ""
        offActionbarTitle()
    }

    override fun onResume() {
        super.onResume()

        if (bottom_navigation == null) {

            bottom_navigation = findViewById(R.id.bottom_navigation)
            header_home = findViewById(R.id.header_home)

            bottom_navigation!!.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
                val fm = supportFragmentManager
                when (item.itemId) {
                    R.id.btn_tienda -> {
                        val frag_tienda: Fragment = TiendaFragment()
                        fm.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.content_frame, frag_tienda, TiendaFragment.TAG)
                            .addToBackStack(TiendaFragment.TAG).commitAllowingStateLoss()

                        header_home!!.visibility = View.VISIBLE
                    }
                    R.id.btn_explorar -> {
                        val frag_explorar: Fragment = ExplorarFragment()
                        fm.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.content_frame, frag_explorar, ExplorarFragment.TAG)
                            .addToBackStack(ExplorarFragment.TAG).commitAllowingStateLoss()

                        header_home!!.visibility = View.VISIBLE
                    }
                    R.id.btn_carrito -> {
                        val frag_carrito: Fragment = CarritoFragment()
                        fm.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.content_frame, frag_carrito, CarritoFragment.TAG)
                            .addToBackStack(CarritoFragment.TAG).commitAllowingStateLoss()

                        header_home!!.visibility = View.VISIBLE
                    }
                    R.id.btn_favoritos -> {
                        val frag_favoritos: Fragment = FavoritosFragment()
                        fm.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.content_frame, frag_favoritos, FavoritosFragment.TAG)
                            .addToBackStack(FavoritosFragment.TAG).commitAllowingStateLoss()

                        header_home!!.visibility = View.VISIBLE
                    }
                    R.id.btn_perfil -> {
                        val frag_perfil: Fragment = PerfilFragment()
                        fm.beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.content_frame, frag_perfil, PerfilFragment.TAG)
                            .addToBackStack(PerfilFragment.TAG).commitAllowingStateLoss()

                        header_home!!.visibility = View.GONE
                    }
                }
                true
            })

            bottom_navigation!!.setSelectedItemId(R.id.btn_tienda)
        }
    }

}