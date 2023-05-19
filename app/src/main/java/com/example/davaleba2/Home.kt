package com.example.davaleba2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import java.util.Objects

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var homeNameET: EditText
    private lateinit var homeLastNameET: EditText
    private lateinit var homeGpaET: EditText
    private lateinit var homeBtn1: Button
    private lateinit var homeBtn2: Button

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
        val view = inflater.inflate(R.layout.fragment_home, container, false)
       
        homeNameET = view.findViewById(R.id.homeNameET)
        homeLastNameET = view.findViewById(R.id.homeLastNameET)
        homeGpaET = view.findViewById(R.id.homeGpaET)
        homeBtn1 = view.findViewById(R.id.homeBtn1)

        homeBtn1.setOnClickListener {
            val bundle = bundleOf("lastName" to homeLastNameET.text.toString(), "name" to homeNameET.text.toString() , "gpa" to homeGpaET.text.toString())
            view.findNavController().navigate(R.id.action_home_to_profile, bundle)

        }

        homeBtn1.setOnLongClickListener {
            homeNameET.text.clear()
            homeLastNameET.text.clear()
            homeGpaET.text.clear()
            true
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}