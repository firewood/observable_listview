package info.competitiveprogramming.observablelistview;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import info.competitiveprogramming.observablelistview.BR;

public class SimpleMessage extends BaseObservable {

    String title;
    String body;

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public void setBody(String body) {
        this.body = body;
        notifyPropertyChanged(BR.body);
    }
}
