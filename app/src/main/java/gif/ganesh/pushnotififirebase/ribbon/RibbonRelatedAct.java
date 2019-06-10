package gif.ganesh.pushnotififirebase.ribbon;

import android.content.ClipData;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import gif.ganesh.pushnotififirebase.R;

public class RibbonRelatedAct extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener
{
    RecyclerView recycler_view;
    LinearLayoutManager llm;
    List<RegModel> rmodel;
    RibbinAdapter rr;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ribbon_related);

        recycler_view=findViewById(R.id.recycler_view);
        llm=new LinearLayoutManager(this);
        rmodel=new ArrayList<>();

        rmodel.add(new RegModel("ganesh","132456","hello@gmail.com"));
        rmodel.add(new RegModel("ramesh","132456","hello@gmail.com"));
        rmodel.add(new RegModel("suresh","132456","hippo@gmail.com"));
        rmodel.add(new RegModel("suresh","132456","suraj@gmail.com"));

         rr=new RibbinAdapter(this,rmodel);
        recycler_view.setAdapter(rr);
        recycler_view.setLayoutManager(llm);




        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recycler_view);

    }


    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position)
    {

        if (viewHolder instanceof RibbinAdapter.Viewhs) {
            // get the removed item name to display it in snack bar
            String name = rmodel.get(viewHolder.getAdapterPosition()).getName();

            // backup of removed item for undo purpose
            //final Item deletedItem = rmodel.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            // remove the item from recycler view
            rr.removeItem(viewHolder.getAdapterPosition());

            // showing snack bar with Undo option

        }

    }
}
