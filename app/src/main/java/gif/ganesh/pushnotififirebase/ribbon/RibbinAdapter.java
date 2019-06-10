package gif.ganesh.pushnotififirebase.ribbon;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import gif.ganesh.pushnotififirebase.R;

public class RibbinAdapter extends RecyclerView.Adapter<RibbinAdapter.Viewhs>
{
    Context context;
    List<RegModel> rmodel;

    public RibbinAdapter(Context context, List<RegModel> rmodel) {
        this.context = context;
        this.rmodel = rmodel;
    }

    @NonNull
    @Override
    public RibbinAdapter.Viewhs onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        return new Viewhs(LayoutInflater.from(context).inflate(R.layout.adapter_academic_fee,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RibbinAdapter.Viewhs viewhs, int i)
    {
        viewhs.names.setText(""+rmodel.get(i).getName());
        viewhs.mobile.setText(""+rmodel.get(i).getMobile());
        viewhs.email.setText(""+rmodel.get(i).getEmail());
    }

    @Override
    public int getItemCount()
    {
        return rmodel.size();
    }

    public class Viewhs extends RecyclerView.ViewHolder
    {
        TextView names,mobile,email;
        CardView viewForeground;
        public Viewhs(@NonNull View itemView)
        {
            super(itemView);
            names=itemView.findViewById(R.id.names);
            mobile=itemView.findViewById(R.id.mobile);
            email=itemView.findViewById(R.id.email);
            viewForeground=itemView.findViewById(R.id.viewForeground);
        }
    }



    public void removeItem(int position) {
        rmodel.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }


}
