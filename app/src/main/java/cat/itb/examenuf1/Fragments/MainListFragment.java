package cat.itb.examenuf1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cat.itb.examenuf1.Data.GradesViewModel;
import cat.itb.examenuf1.R;
import cat.itb.examenuf1.RecyclerViewAdapter;

public class MainListFragment extends Fragment {
    RecyclerView recyclerView;
    GradesViewModel gradingsViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gradingsViewModel = new ViewModelProvider(requireActivity()).get(GradesViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_list_fragment, container, false);

        recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        System.out.println("antews hay " + gradingsViewModel.gradings.toString());
        RecyclerViewAdapter adapter= new RecyclerViewAdapter(gradingsViewModel.gradings);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        return v;
    }
}
