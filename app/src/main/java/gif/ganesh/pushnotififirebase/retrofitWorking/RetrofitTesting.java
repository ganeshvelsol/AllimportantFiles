package gif.ganesh.pushnotififirebase.retrofitWorking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import gif.ganesh.pushnotififirebase.R;
import gif.ganesh.pushnotififirebase.retrofitWorking.helpers.ApiClient;
import gif.ganesh.pushnotififirebase.retrofitWorking.helpers.ApiServices;
import gif.ganesh.pushnotififirebase.retrofitWorking.response.AttendenceLIstResponse;
import gif.ganesh.pushnotififirebase.retrofitWorking.response.Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitTesting extends AppCompatActivity
{

    RecyclerView attend_list_recycler_view;
    LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_testing);
        initParams();
    }
    public void initParams()
    {
        attend_list_recycler_view = findViewById(R.id.customer_list_recyler);
        llm = new LinearLayoutManager(this);
        ApiServices services= ApiClient.getClient().create(ApiServices.class);
        Call<AttendenceLIstResponse>  resp= services.AttendenceList(1,1,1);
        resp.enqueue(new Callback<AttendenceLIstResponse>()
        {
            @Override
            public void onResponse(Call<AttendenceLIstResponse> call, Response<AttendenceLIstResponse> response)
            {

               // Toast.makeText(RetrofitTesting.this, ""+response.body().getData().size(), Toast.LENGTH_SHORT).show();
                    AttendAdaper aa=new AttendAdaper(RetrofitTesting.this,response.body().getData());
                    attend_list_recycler_view.setAdapter(aa);
                    attend_list_recycler_view.setLayoutManager(llm);

            }
            @Override
            public void onFailure(Call<AttendenceLIstResponse> call, Throwable t)
            {
                Toast.makeText(RetrofitTesting.this, "from excepotion "+t, Toast.LENGTH_SHORT).show();
            }
        });
    }

}

     class AttendAdaper extends RecyclerView.Adapter<AttendAdaper.ViewHold>
    {

        Context context;
        List<Data> mlist;

        public AttendAdaper(Context context, List<Data> mlist)
        {
            this.context = context;
            this.mlist = mlist;
        }

        @NonNull
        @Override
        public AttendAdaper.ViewHold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
        {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_list_details, viewGroup, false);
            return new ViewHold(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AttendAdaper.ViewHold viewHold, int i)
        {

            viewHold.mtext_view1.setText(""+mlist.get(i).getStudentId());
            viewHold.mtext_view2.setText(""+mlist.get(i).getStudentRollNo());
        }

        @Override
        public int getItemCount()
        {
            return mlist.size();
        }


         class ViewHold extends RecyclerView.ViewHolder
         {
             TextView mtext_view1,mtext_view2;
            public ViewHold(@NonNull View itemView)
            {
                super(itemView);

                mtext_view1=(TextView)itemView.findViewById(R.id.mtext_view1);
                mtext_view2=(TextView)itemView.findViewById(R.id.mtext_view2);

            }
        }

    }

