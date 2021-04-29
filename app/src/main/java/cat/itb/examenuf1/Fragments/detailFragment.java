package cat.itb.examenuf1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import cat.itb.examenuf1.Data.Grade;
import cat.itb.examenuf1.R;

public class detailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_fragment, container, false);

       Grade recover =  detailFragmentArgs.fromBundle(getArguments()).getGrade();

        assert recover != null;

        return v;
    }
}
