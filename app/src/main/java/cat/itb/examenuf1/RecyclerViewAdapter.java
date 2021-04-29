package cat.itb.examenuf1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.itb.examenuf1.Data.Grade;
import cat.itb.examenuf1.Fragments.MainListFragmentDirections;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.GradesViewHolder> {
    static List<Grade> gradings;

    public RecyclerViewAdapter(List<Grade> gradings) {
        this.gradings = gradings;

        System.out.println("initial grading are " + gradings.toString());
    }

    @NonNull
    @Override
    public GradesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);

        return new GradesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GradesViewHolder holder, int position) {
        holder.bindData(gradings.get(position));
    }

    @Override
    public int getItemCount() {
        return gradings.size();
    }

    public static class GradesViewHolder extends RecyclerView.ViewHolder {
        TextView studentName;
        TextView module;
        TextView grading;
        ImageView attended;

        public GradesViewHolder(@NonNull final View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name_item);
            module = itemView.findViewById(R.id.module_item);
            grading = itemView.findViewById(R.id.grade_item);
            attended = itemView.findViewById(R.id.attended);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavDirections directions = MainListFragmentDirections.mainToDetail(gradings.get(getAdapterPosition()));
                    Navigation.findNavController(v).navigate(directions);
                }
            });
        }

        public void bindData(Grade grade) {
            System.out.println("gradle in bind data is" + grade.toString());
            studentName.setText(grade.getStudentName());
            module.setText(grade.getModule());
            grading.setText(Double.toString(grade.getGrade()));

            if (grade.isAssistance()) {
                attended.setImageResource(R.drawable.ic_baseline_attended_24);
            } else {
                attended.setImageResource(R.drawable.ic_baseline_not_attended_24);

            }

        }
    }
}
