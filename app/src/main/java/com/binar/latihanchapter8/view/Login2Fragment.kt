package com.binar.latihanchapter8.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.binar.latihanchapter8.R
import com.binar.latihanchapter8.datastore.UserManager
import com.binar.latihanchapter8.room.UserDatabase
import com.binar.latihanchapter8.viewmodel.ViewModelUser
import kotlinx.android.synthetic.main.fragment_login2.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Login2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Login2Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var userManager: UserManager


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
        return inflater.inflate(R.layout.fragment_login2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userManager = UserManager(requireContext())

        txtBlmPunyaAkun.setOnClickListener {
            view.findNavController().navigate(R.id.action_login2Fragment_to_registerFragment)
        }

        btnLogin.setOnClickListener {
            var email = editUsername.text.toString()
            var password = editPassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()){
                login(email, password)
            }else{
                Toast.makeText(requireContext(), "Email dan Password harus diisi", Toast.LENGTH_LONG).show()

            }
        }


    }
    fun login(email : String, password : String){
        val viewModel = ViewModelProvider(requireActivity()).get(ViewModelUser::class.java)


            viewModel.userLiveData.observe(viewLifecycleOwner) {
                if (it != 0){

                        Toast.makeText(requireContext(), "Berhasil Login", Toast.LENGTH_LONG).show()
                        view?.findNavController()?.navigate(R.id.action_login2Fragment_to_homeFragment)

                    loginDataStore(email, password)
                }else{

                        Toast.makeText(requireContext(), "Gagal Login", Toast.LENGTH_LONG).show()

                }
            }


        viewModel.cekLoginLive(email, password)

    }
    fun loginDataStore(username : String, password : String){
        GlobalScope.launch {
            userManager.login(username, password)
            userManager.setStatus("yes")
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Login2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Login2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}