package kim.com.example.gdscappdtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ImagePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_page);

        int imageResource = getIntent().getIntExtra(Adapter.EXTRA_IMAGE_RESOURCE, 0);
        String imageName = getIntent().getStringExtra(Adapter.EXTRA_IMAGE_NAME);
        String authorName = getIntent().getStringExtra(Adapter.EXTRA_AUTHOR_NAME);
        String dateSubmit = getIntent().getStringExtra(Adapter.EXTRA_DATE_SUBMIT);
        String story = getIntent().getStringExtra(Adapter.EXTRA_STORY);


        // Find views in the layout
        ImageView imageView = findViewById(R.id.bigImageView);
        TextView imageNameView = findViewById(R.id.imageNameView);
        TextView storyTextView = findViewById(R.id.storyView);
        TextView authorTextView = findViewById(R.id.authorNameView); // Add TextView for authorName
        TextView dateTextView = findViewById(R.id.dateSubmitView); // Add TextView for dateSubmit

        // Set data to views
        imageView.setImageResource(imageResource);
        imageNameView.setText(imageName);
        storyTextView.setText(story);
        authorTextView.setText(authorName); // Set authorName
        dateTextView.setText(dateSubmit); // Set dateSubmit
    }
}