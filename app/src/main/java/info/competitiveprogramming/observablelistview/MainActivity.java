package info.competitiveprogramming.observablelistview;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import info.competitiveprogramming.observablelistview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ObservableArrayList<SimpleMessage> data;
    ObservableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        data = new ObservableArrayList<>();

        adapter = new ObservableListAdapter(this, data);
        binding.list.setAdapter(adapter);

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleMessage a = new SimpleMessage();
                a.setTitle("" + adapter.getCount() + " " + System.currentTimeMillis());
                a.setBody("" + (int)(Math.random() * 1000000));
                data.add(a);
            }
        });

        binding.buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapter.getCount() > 0) {
                    int position = (int)(Math.random() * adapter.getCount());
                    SimpleMessage a = adapter.getItem(position);
                    a.setTitle("" + position + " " + System.currentTimeMillis());
                    a.setBody("" + (int)(Math.random() * 1000000));
                }
            }
        });

        SimpleMessage a;
        a = new SimpleMessage();
        a.title = "hoge";
        data.add(a);
        a = new SimpleMessage();
        a.title = "fuga";
        data.add(a);
        a = new SimpleMessage();
        a.title = "piyo";
        data.add(a);
    }
}
