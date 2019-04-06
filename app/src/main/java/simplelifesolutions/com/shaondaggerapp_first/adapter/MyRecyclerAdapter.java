package simplelifesolutions.com.shaondaggerapp_first.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import simplelifesolutions.com.shaondaggerapp_first.R;
import simplelifesolutions.com.shaondaggerapp_first.models.Result;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.StarWarsViewHolder> {

    final String LOG_TAG = "testLogTag";
    private List<Result> resultList ;

    private MyRecyclerAdapter.ClickListener clickListener;


    public MyRecyclerAdapter(ClickListener clickListener) {
        resultList = new ArrayList<>();
         this.clickListener = clickListener;
    }

    @Override
    public StarWarsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_row, parent, false);
        return new StarWarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StarWarsViewHolder holder, int position) {
        Result result = resultList.get(position);

        Log.d("LOG_TAG", "Inside Adapter--" + "Name is: " + result.getName().getFirst()
                + "--"
                + "Age is: " + result.getDob().getAge() );

        holder.txtVwName.setText("Name: " + result.getName().getFirst().toString() );
        holder.txtVwBirth.setText("DOB: " + result.getDob().getAge() );
        holder.txtVwGender.setText("DOB: " + result.getGender().toString() );
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void setItems(List<Result> results) {
        resultList = results;
        notifyDataSetChanged();
    }

    public class StarWarsViewHolder extends RecyclerView.ViewHolder {
        public TextView txtVwName;
        public TextView txtVwBirth;
        public TextView txtVwGender;
        public LinearLayout myLayout;

        public StarWarsViewHolder(View itemView) {
            super(itemView);

            txtVwName = itemView.findViewById(R.id.txtName);
            txtVwBirth = itemView.findViewById(R.id.txtBirthYear);
            txtVwGender = itemView.findViewById(R.id.txtGender);
            myLayout = itemView.findViewById(R.id.MyListRowLayout);

            myLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.funcLaunchIntent(resultList.get(getAdapterPosition()).getGender().toString());
                }
            });
        }
    }


    public interface ClickListener {
        void funcLaunchIntent(String strGender);
    }
}