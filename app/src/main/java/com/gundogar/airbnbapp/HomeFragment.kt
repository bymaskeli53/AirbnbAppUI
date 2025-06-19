package com.gundogar.airbnbapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gundogar.airbnbapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabTitles = listOf("Homes", "Experiences", "Services")
        val tabIcons = listOf(R.drawable.ic_home, R.drawable.ic_experiences, R.drawable.ic_services)


        tabTitles.forEachIndexed { index, title ->
            val tab = binding.tabLayout.newTab()
            tab.customView = createCustomTabView(title, tabIcons[index], isNew = (index != 0))
            binding.tabLayout.addTab(tab)
        }
//        val popularPlacesList = listOf(Place(R.drawable.ic_place_1, "New York", "New York City"),
//            Place(R.drawable.ic_place_2, "Paris", "Paris"), Place(R.drawable.ic_place_3, "London", "London"),)
//        val adapter = PopularPlacesAdapter(popularPlacesList)
//        binding.rvFavorites.adapter = adapter

        binding.rvFavorites.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.rvFavorites.adapter = ParentAdapter(ParentDataFactory.getParents(4))
    }

    private fun createCustomTabView(title: String, iconRes: Int, isNew: Boolean): View {
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab, null)
        val icon = view.findViewById<ImageView>(R.id.tabIcon)
        val text = view.findViewById<TextView>(R.id.tabText)
        val badge = view.findViewById<TextView>(R.id.tabBadge)

        icon.setImageResource(iconRes)
        text.text = title

        badge.visibility = if (isNew) View.VISIBLE else View.GONE
        return view
    }

}