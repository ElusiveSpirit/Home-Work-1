package adv.android_11.solleks.homework1;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageText[] imageTexts = new ImageText[1000];
        boolean t = true;
        IntInText intInText = new IntInText(this);
       for (int i = 0; i < 1000; i++) {
            imageTexts[i] = new ImageText(intInText.convert(i + 1), 0, ((t = !t) ? R.color.white : R.color.gray));
        }
        setListAdapter(new ImageArrayAdapter(getBaseContext(), R.layout.item, getLayoutInflater(), imageTexts));
    }

    class ImageArrayAdapter extends ArrayAdapter<ImageText> {

        private LayoutInflater mInflater;

        ImageArrayAdapter(Context context, int layout, LayoutInflater inflater, ImageText[] imageTexts) {
            super(context, layout, imageTexts);
            mInflater = inflater;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView)convertView.findViewById(R.id.text);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder)convertView.getTag();
            }
            ImageText imageText = getItem(position);

            viewHolder.textView.setText(imageText.getText());

            convertView.setBackgroundColor(imageText.getBackgroundColor());

            return convertView;
        }

        class ViewHolder {
            public TextView textView;
        }
    }

    class ImageText {
        private String mText;
        private int mImage;
        private int mBackgroundColor;

        ImageText(String text, int image, int backgroundColor) {
            this.mText = text;
            this.mImage = image;
            this.mBackgroundColor = backgroundColor;
        }

        public String getText() {
            return mText;
        }

        public int getImage() {
            return mImage;
        }

        public int getBackgroundColor() {
            return mBackgroundColor;
        }
    }
}
