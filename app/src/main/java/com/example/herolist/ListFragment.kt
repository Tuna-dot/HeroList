package com.example.herolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.herolist.Adapter.HeroAdapter
import com.example.herolist.databinding.FragmentListBinding


class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    lateinit var heroList: ArrayList<Hero>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        initialize()
    }

    private fun loadData() {
    heroList.add(
        Hero(
            name = "Доктор Стрендж",
            imageUrl = "https://static.kinoafisha.info/upload/news/666313086653.jpg"
        ))

    heroList.add(
        Hero(
            name = "Кратос",
            imageUrl = "https://static.wikia.nocookie.net/deadliestfiction/images/e/ea/Kratos_God_of_War.jpg/revision/latest?cb=20110724174328"
        ))

    heroList.add(
        Hero(
            name = "Алекс Мерсер",
            imageUrl = "https://comicvine.gamespot.com/a/uploads/scale_super/11156/111569405/9210133-alexmercer.jpg"
        ))

    heroList.add(
        Hero(
            name = "Спаун",
            imageUrl = "https://sun9-48.userapi.com/impg/PXw6c2N7Y518LaYqIn_JIkw3mUW62oqH_VOtfg/BFHUhf2AHOM.jpg?size=1080x1080&quality=96&sign=134e53ae365a2014ae694c06f2837153&c_uniq_tag=0sqjlmzJf6ZDuqu48Pf1HMRjcz5ThEraFR7xuhZba4g&type=album"
        ))

    heroList.add(
        Hero(
            name = "Тор",
            imageUrl = "https://i.pinimg.com/736x/ab/dd/8d/abdd8d3374f7b924c0323fc742b3f279.jpg"
        ))

    heroList.add(
        Hero(
            name = "Москов",
            imageUrl = "https://m.media-amazon.com/images/M/MV5BNGIzNjMyOGMtMzAzNi00MTY1LTgxNTMtN2FhOTk0NjVkZGRkXkEyXkFqcGdeQXVyMTA2MjIzMDM0._V1_.jpg"
        ))

    heroList.add(
        Hero(
            name = "Солдатик",
            imageUrl = "https://s0.rbk.ru/v6_top_pics/media/img/1/05/347030907809051.webp"
        ))
    }

    private fun initialize() {
    var heroAdapter = HeroAdapter(heroList){ position ->
        var bundle = Bundle()
        bundle.putSerializable("key", heroList[position])
        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, detailFragment)
            .addToBackStack(null)
            .commit()
        }
        binding.recyclerView.adapter = heroAdapter
    }
}
