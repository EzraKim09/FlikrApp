package kim.com.example.gdscappdtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    FirebaseAuth auth;
    FirebaseUser user;
    List<Recycler> items = new ArrayList<>();
    Map<Integer, Integer> positionToRawMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        if(user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }

        positionToRawMap.put(0, R.raw.story1);
        positionToRawMap.put(1, R.raw.story2);
        positionToRawMap.put(2, R.raw.story3);
        positionToRawMap.put(3, R.raw.story4);
        positionToRawMap.put(4, R.raw.story5);
        positionToRawMap.put(5, R.raw.story6);
        positionToRawMap.put(6, R.raw.story7);
        positionToRawMap.put(7, R.raw.story8);
        positionToRawMap.put(8, R.raw.story9);
        positionToRawMap.put(9, R.raw.story10);
        positionToRawMap.put(10, R.raw.story11);
        positionToRawMap.put(11, R.raw.story12);
        positionToRawMap.put(12, R.raw.story13);
        positionToRawMap.put(13, R.raw.story14);
        positionToRawMap.put(14, R.raw.story15);
        positionToRawMap.put(15, R.raw.story16);
        positionToRawMap.put(16, R.raw.story17);
        positionToRawMap.put(17, R.raw.story18);
        positionToRawMap.put(18, R.raw.story19);
        positionToRawMap.put(19, R.raw.story20);
//
//        List<Recycler> items = new ArrayList<Recycler>();
        items.add(new Recycler("The Beauty of India", "Harshit Chopra", "19.8.23",R.drawable.asia));
        items.add(new Recycler("Musical Madness", "John Smith", "19.8.23",R.drawable.artist));
        items.add(new Recycler("Daylight Street Symphony", "Karolina Tucker", "19.8.23",R.drawable.buildings));
        items.add(new Recycler("Lost in the Melodies", "Adela Delma", "19.8.23",R.drawable.concert));
        items.add(new Recycler("Sea of Sound", "Arsen Ruben", "19.8.23",R.drawable.crowd));
        items.add(new Recycler("Depths of the Hands", "Alexis Deziree", "19.8.23",R.drawable.hands));
        items.add(new Recycler("The Colour of India", "Harshit Chopra", "19.8.23",R.drawable.holi));
        items.add(new Recycler("Paradise", "Derrick Darin", "19.8.23",R.drawable.indianadunestatepark));
        items.add(new Recycler("The Beauty of the Ganges", "Harshit Chopra", "19.8.23",R.drawable.india));
        items.add(new Recycler("8 PM", "Ryuunosuke Yutaka", "19.8.23",R.drawable.japan));
        items.add(new Recycler("Indian Road", "Nitin Dipak", "19.8.23",R.drawable.mumbai));
        items.add(new Recycler("Monoliths", "Derrick Darin", "19.8.23",R.drawable.pedestrians));
        items.add(new Recycler("Serene Autumn", "John Smith", "19.8.23",R.drawable.road));
        items.add(new Recycler("Dwelling in Heaven", "Arsen Ruben", "19.8.23",R.drawable.skyline));
        items.add(new Recycler("Destination", "Derrick Darin", "19.8.23",R.drawable.sunset));
        items.add(new Recycler("Lost in the City Lights", "Kurou Kyo", "19.8.23",R.drawable.japanosaka));
        items.add(new Recycler("The Marble of Love", "Harshit Chopra", "19.8.23",R.drawable.tajmahal));
        items.add(new Recycler("Calming Green", "John Smith", "19.8.23",R.drawable.trees));
        items.add(new Recycler("Joy in the Memories", "Adela Delma", "19.8.23",R.drawable.woman));
        items.add(new Recycler("Gateway of India", "Nitin Dipak", "19.8.23",R.drawable.gateofindia));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(getApplicationContext(), items, this));

    }

    @Override
    public void onItemClick(int position) {
        Recycler clickedItem = items.get(position);
        Intent intent = new Intent(getApplicationContext(), ImagePage.class);
        intent.putExtra(Adapter.EXTRA_IMAGE_RESOURCE, clickedItem.getImg());
        intent.putExtra(Adapter.EXTRA_IMAGE_NAME, clickedItem.getImageName());
        intent.putExtra(Adapter.EXTRA_AUTHOR_NAME, clickedItem.getAuthorName());
        intent.putExtra(Adapter.EXTRA_DATE_SUBMIT, clickedItem.getDateSubmit());

        if (positionToRawMap.containsKey(position)) {
            int rawResourceId = positionToRawMap.get(position);
            intent.putExtra(Adapter.EXTRA_STORY, loadStoryFromRawResource(rawResourceId));
        }

        startActivity(intent);
    }

    private String loadStoryFromRawResource(int rawResourceId) {
        try {
            InputStream inputStream = getResources().openRawResource(rawResourceId);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i;
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write((byte)i);
                i = inputStream.read();
            }
            inputStream.close();
            return byteArrayOutputStream.toString();
        }catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}