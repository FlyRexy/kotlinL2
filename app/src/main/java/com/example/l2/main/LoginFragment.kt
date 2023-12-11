import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.l2.R


class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val buttonLogin = view.findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val usernameEditText = view?.findViewById<EditText>(R.id.editTextUsername)
            val passwordEditText = view?.findViewById<EditText>(R.id.editTextPassword)
            val errorTextView = view.findViewById<TextView>(R.id.textViewError)


            val username = usernameEditText?.text.toString()
            val password = passwordEditText?.text.toString()

            if (isValidCredentials(username, password)) {
                performLogin(username, password)
            } else {
                errorTextView.text = "Не заполнено поле логин и/или пароль"
            }
        }

        return view
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        return username.isNotBlank() && password.isNotBlank()
    }

    private fun performLogin(username: String, password: String) {
        val bundle = bundleOf("username" to username)
        findNavController().navigate(R.id.welcomeFragment, bundle)
    }
}