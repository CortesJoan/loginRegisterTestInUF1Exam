package cat.itb.examenuf1.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import cat.itb.examenuf1.R;


public class registerFragment extends Fragment {
    Button loginButton;
    Button registerButton;
    TextInputLayout layoutUsername;
    TextInputLayout layoutPassword;
    @Nullable

    public static boolean hasError = false;

    public static void checkIfError(TextInputLayout layout, boolean condition, String errorMessage) {
        if (checkIfLayoutTextIsEmpty(layout)) {
            layout.setError("required field");
            hasError = true;
        } else if (condition) {
            layout.setError(errorMessage);

        } else {
            hasError = false;

        }
    }
    public static boolean checkIfLayoutTextIsEmpty(TextInputLayout layout) {

        return layout.getEditText().getText().toString().isEmpty();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        layoutUsername = v.findViewById(R.id.usernameLayout);
        layoutPassword = v.findViewById(R.id.passwordLayout);
        loginButton = v.findViewById(R.id.button);
        System.out.println(layoutUsername.getEditText());
        System.out.println(layoutUsername.getEditText());
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfError(layoutUsername, false, "");
                checkIfError(layoutPassword, layoutPassword.getEditText().getText().length()<8, "The password length must be 8 or more");
                if (!hasError) {
                    NavDirections directions = loginFragmentDirections.loginToMain();
                    Navigation.findNavController(v).navigate(directions);

                    getParentFragmentManager().beginTransaction().commit();
                }
            }
        });
        return v;
    }
}