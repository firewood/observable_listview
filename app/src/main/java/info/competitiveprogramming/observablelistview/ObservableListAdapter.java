package info.competitiveprogramming.observablelistview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import info.competitiveprogramming.observablelistview.databinding.ListSimpleMessageBinding;

public class ObservableListAdapter extends ArrayAdapter<SimpleMessage> {

    public ObservableListAdapter(Context context, ObservableArrayList<SimpleMessage> data) {
        super(context, R.layout.list_simple_message, data);
        data.addOnListChangedCallback(new ObservableArrayList.OnListChangedCallback<ObservableArrayList<SimpleMessage>>() {
            @Override
            public void onChanged(ObservableArrayList<SimpleMessage> simpleMessages) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableArrayList<SimpleMessage> simpleMessages, int i, int i1) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeInserted(ObservableArrayList<SimpleMessage> simpleMessages, int i, int i1) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeMoved(ObservableArrayList<SimpleMessage> simpleMessages, int i, int i1, int i2) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeRemoved(ObservableArrayList<SimpleMessage> simpleMessages, int i, int i1) {
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListSimpleMessageBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.list_simple_message, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ListSimpleMessageBinding) convertView.getTag();
        }
        binding.setMessage(getItem(position));
        return convertView;
    }
}
