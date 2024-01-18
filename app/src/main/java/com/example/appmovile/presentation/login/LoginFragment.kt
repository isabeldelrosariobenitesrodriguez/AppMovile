package com.example.appmovile.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.appmovile.databinding.FragmentLoginBinding
import com.example.appmovile.R
import com.example.appmovile.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {


    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        initListeners()
    }

    private fun initObservers() {
        viewModel.loginState.observe(viewLifecycleOwner) { state ->
            when(state) {
                is Resource.Success -> {
                    handleLoading(isLoading = false)
                    findNavController().navigate(R.id.action_loginFragment_to_inicio)
                }
                is Resource.Error -> {
                    handleLoading(isLoading = false)
                    Toast.makeText(
                        requireContext(),
                        state.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is Resource.Loading -> handleLoading(isLoading = true)
                else -> Unit
            }
        }
    }

    private fun initListeners() {
        with(binding) {
            bLogin.setOnClickListener { handleLogin() }
           // bSignUp.setOnClickListener { findNavController().navigate(R.id.action_loginFragment_to_inicio) }
        }
    }

    private fun handleLogin() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        viewModel.login(email, password)
    }

    private fun handleLoading(isLoading: Boolean) {
        with(binding) {
            if (isLoading) {
                bLogin.text = ""
                bLogin.isEnabled = false
                pbLogin.visibility = View.VISIBLE
            } else {
                pbLogin.visibility = View.GONE
                bLogin.text = getString(R.string.login__login_button)
                bLogin.isEnabled = true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}