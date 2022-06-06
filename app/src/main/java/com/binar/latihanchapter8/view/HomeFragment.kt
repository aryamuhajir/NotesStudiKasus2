package com.binar.latihanchapter8.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.latihanchapter8.R
import com.binar.latihanchapter8.adapter.RvAdapter
import com.binar.latihanchapter8.viewmodel.ViewModelNotes
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var noteAdapter : RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        getFav()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddb.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }


    }
    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    private fun getFav(){
        val viewModel = ViewModelProvider(requireActivity())[ViewModelNotes::class.java]
        viewModel.noteLiveData.observe(viewLifecycleOwner){

            if (it.isNotEmpty()){
                rv_note.layoutManager = LinearLayoutManager(requireContext())
                noteAdapter= RvAdapter {

                }
                rv_note.adapter = noteAdapter
                noteAdapter.setDataFilm(it!!)
                noteAdapter.notifyDataSetChanged()
                rv_note.visibility = View.VISIBLE
            }else{
                rv_note.visibility = View.INVISIBLE
                statusTxt.text = "BELUM ADA FILM FAVORITE"
            }

        }

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}