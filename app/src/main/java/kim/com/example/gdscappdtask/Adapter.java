package kim.com.example.gdscappdtask;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private final AdapterItemClickListener cLickListener = null;

    public static final String EXTRA_IMAGE_RESOURCE = "imageResource";
    public static final String EXTRA_IMAGE_NAME = "imageName";
    public static final String EXTRA_AUTHOR_NAME = "authorName";
    public static final String EXTRA_DATE_SUBMIT = "dateSubmit";
    public static final String EXTRA_STORY = "story";

    private final RecyclerViewInterface clickListener;

    Context context;
    List<Recycler> items;

    public Adapter(Context context, List<Recycler> items, RecyclerViewInterface clickListener) {
        this.context = context;
        this.items = items;
        this.clickListener = clickListener;
    }

    public interface AdapterItemClickListener {
        void onItemClick(Recycler clickedItem);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final int itemposition = position;
        holder.imageName.setText(items.get(position).getImageName());
        holder.authorName.setText(items.get(position).getAuthorName());
        holder.dateSubmit.setText(items.get(position).getDateSubmit());
        holder.img.setImageResource(items.get(position).getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recycler clickedItem = items.get(itemposition);
                clickListener.onItemClick(itemposition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
