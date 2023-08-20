package kim.com.example.gdscappdtask;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView imageName, authorName, dateSubmit;

    public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.imageview);
        imageName = itemView.findViewById(R.id.imageName);
        authorName = itemView.findViewById(R.id.authorName);
        dateSubmit = itemView.findViewById(R.id.dateSubmit);
    }
}
