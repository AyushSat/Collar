package com.hhsfbla.hhs_fbla_mad_2021.recyclerviews.education;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hhsfbla.hhs_fbla_mad_2021.R;
import com.hhsfbla.hhs_fbla_mad_2021.classes.Education;

import java.util.ArrayList;
import java.util.List;

public class EducationRVAdapter extends RecyclerView.Adapter<EducationRVAdapter.StaticRVViewHolder> {
    private ArrayList<EducationRVModel> education;
    int row_index = -1;

    /**
     * Constructor: takes in the education models to be displayed and initializes field
     * @param items education items to be displayed
     */
    public EducationRVAdapter(ArrayList<EducationRVModel> items) {
        this.education = items;
    }


    /**
     *
     * Creates the  View holder to be used. The ViewHolder will be used to display items of the adapter using onBindViewHolder.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType  The view type of the new View.
     * @return the view holder to be used
     */
    @NonNull
    @Override
    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.education, parent,false);
        StaticRVViewHolder staticRVViewHolder = new StaticRVViewHolder(view);
        return staticRVViewHolder;
    }

    /**
     *Called by RecyclerView to display the data at the specified position.
     *This method should update the contents of the RecyclerView.ViewHolder.itemView to reflect the item at the given position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, int position) {
        EducationRVModel currentItem = education.get(position);
        holder.schoolName.setText(currentItem.getSchool());
        holder.period.setText(currentItem.getPeriod());
        holder.degree.setText(currentItem.getDegree());

    }

    /**
     *
     * @return the size of the education in the list to be displayed.
     */
    @Override
    public int getItemCount() {
        return education.size();
    }

    /**
     * Updates the list of educations using a new list
     *
     * @param edus new list to replace the old list
     */
    public void setEducations(List<Education> edus) {
        education.clear();

        for (Education e : edus)
            education.add(new EducationRVModel(e));
    }
    /**
     *
     * The ViewHolder will be used to display items of the adapter using onBindViewHolder.
     *
     */
    public static class StaticRVViewHolder extends RecyclerView.ViewHolder{
        TextView schoolName;
        TextView period;
        TextView degree;
        LinearLayout educationLayout;

        /**
         * Connects the fields to the XML of the education item. Initializes variables for display.
         *
         * @param educationView the education xml layout reference
         */
        public StaticRVViewHolder(@NonNull View educationView) {
            super(educationView);
            schoolName = educationView.findViewById(R.id.education_school_name);
            period = educationView.findViewById(R.id.education_period);
            degree = educationView.findViewById(R.id.education_degree);
            educationLayout =  educationView.findViewById(R.id.education_layout);
        }
    }
}

