package co.edu.udea.studyapp;

import android.content.Context;
import android.graphics.Typeface;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FontManager extends AppCompatActivity {

    public void changeFont2(TextView textView, String font, Context context){
        try{
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + font + ".ttf");
            textView.setTypeface(typeface);
        } catch(Exception e){
            Log.e("ERROR", e.toString());
        }
    }

    public void changeFont2(EditText editText, String font, Context context){
        try{
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + font + ".ttf");
            editText.setTypeface(typeface);
        } catch(Exception e){
            Log.e("ERROR", e.toString());
        }
    }

    public void changeFont2(ActionBar actionBar, String actionBarText, String font, Context context){
        try{
            SpannableString actionBarTitle = new SpannableString(actionBarText);
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + font + ".ttf");
            actionBarTitle.setSpan(typeface, 0, actionBarTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            actionBar.setTitle(actionBarTitle);
        } catch(Exception e){
            Log.e("ERROR", e.toString());
        }
    }

}
