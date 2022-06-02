package com.anotherteam.kisahnabi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.anotherteam.kisahnabi.R
import com.anotherteam.kisahnabi.ResponseRasulNabiItem
import com.anotherteam.kisahnabi.adapter.AdapterNabiRasul
import com.anotherteam.kisahnabi.databinding.ActivityMainBinding
import com.anotherteam.kisahnabi.databinding.FragmentNabiBinding
import com.anotherteam.kisahnabi.retrofit.RetrofitBuild
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class NabiFragment : Fragment() {

    private lateinit var binding : FragmentNabiBinding
    val adapterNabi = AdapterNabiRasul()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNabiBinding.inflate(inflater, container, false)

        with(binding) {
            recyclerviewNabi.setHasFixedSize(true)
            recyclerviewNabi.adapter = adapterNabi
            recyclerviewNabi.layoutManager = LinearLayoutManager(context)
        }
        val call = RetrofitBuild.getData().getDataNabi()
        call.enqueue(object : retrofit2.Callback<List<ResponseRasulNabiItem>>{
            override fun onResponse(
                call: Call<List<ResponseRasulNabiItem>>,
                response: Response<List<ResponseRasulNabiItem>>
            ) {
                val listData = response.body()!!
                listData.let { it.let { it1 -> adapterNabi.addDataNabi(it1) } }
            }

            override fun onFailure(call: Call<List<ResponseRasulNabiItem>>, t: Throwable) {
                Toast.makeText(context, "GAGAL!", Toast.LENGTH_SHORT).show()
            }

        })

        return binding.root
    }
}