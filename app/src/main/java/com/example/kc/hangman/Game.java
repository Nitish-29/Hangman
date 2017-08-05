package com.example.kc.hangman;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Random;
import com.example.kc.hangman.questions;

/**
 * Created by KC on 24-Jul-17.
 */

public class Game extends Activity {
    public static String KEY_Level;
    public static final String PREFS_NAME = "Hangman_pref";
    TextView hiddenText;
    TextView hintText;
    TextView enteredText,textView;
    EditText input;
    LinearLayout background;
    String text;
    String hint;
    String entered = "";
    String texthint;
    int count;
    int diff;
    int level;
    public int flag=0;
    private ImageView[] bodyParts;
    private Button q, w, e, r, t, y, u, i, o, p, a, s, d, f, g, h, j, k, l, z, x, c, v, b, n, m;
    questions qu= new questions();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        textView = (TextView) findViewById(R.id.textView);
        diff = getIntent().getIntExtra(KEY_Level, -1);
        count = setDifficulty(diff);
        if (level == 1){
            texthint = qu.getText1();
            textView.setText("Random");}
        else if (level == 2){
            texthint = qu.getText2();
            textView.setText("Kids");
        }
        else if (level == 3){
            texthint = qu.getText3();
            textView.setText("Movies");
        }
        else if (level == 4){
            texthint = qu.getText4();
            textView.setText("TV Series");
        }
        else if (level == 5){
            texthint = qu.getText5();
            textView.setText("Places");
        }
        else if (level == 6){
            texthint = qu.getText6();
            textView.setText("Dictionery");
        }
        else if (level == 7){
            texthint = qu.getText7();
            textView.setText("Personality");
        }
        else if (level == 8){
            texthint = qu.getText8();
            textView.setText("Harry Potter");
        }
        else if (level == 9){
            texthint = qu.getText9();
            textView.setText("Food");
        }
        else if (level == 10){
            texthint = qu.getText10();
            textView.setText("Animals");
        }
        else if (level == 11){
            texthint = qu.getText11();
            textView.setText("Music");
        }
        else {
            texthint = qu.getText1();
            textView.setText("Random");
        }
        String[] pair = texthint.split("#");
        text = pair[0];
        hint = pair[1];
        hintText = (TextView) findViewById(R.id.hint_txt);
        hintText.setText(hint);
        hiddenText = (TextView) findViewById(R.id.hidden_txt);
        hiddenText.setText(encodeString(text, "*"));
        enteredText = (TextView) findViewById(R.id.entered_txt);
        background = (LinearLayout) findViewById(R.id.background);
        enteredText.setText(entered);
        input = (EditText) findViewById(R.id.input_txt);
        input.setFocusable(true);
//        newGameBtn = (Button) findViewById(R.id.new_game_button);

        bodyParts = new ImageView[7];
        bodyParts[0] = (ImageView) findViewById(R.id.imageView1);
        bodyParts[1] = (ImageView) findViewById(R.id.head);
        bodyParts[2] = (ImageView) findViewById(R.id.body);
        bodyParts[3] = (ImageView) findViewById(R.id.arm1);
        bodyParts[4] = (ImageView) findViewById(R.id.arm2);
        bodyParts[5] = (ImageView) findViewById(R.id.leg1);
        bodyParts[6] = (ImageView) findViewById(R.id.leg2);

        for (int p = 0; p < 7; p++) {
            bodyParts[p].setVisibility(View.INVISIBLE);
        }

        input.setText(" ");
        check();
        flag=0;

        q = (Button) findViewById(R.id.q);
        w = (Button) findViewById(R.id.w);
        e = (Button) findViewById(R.id.e);
        r = (Button) findViewById(R.id.r);
        t = (Button) findViewById(R.id.t);
        y = (Button) findViewById(R.id.y);
        u = (Button) findViewById(R.id.u);
        i = (Button) findViewById(R.id.i);
        o = (Button) findViewById(R.id.o);
        p = (Button) findViewById(R.id.p);
        a = (Button) findViewById(R.id.a);
        s = (Button) findViewById(R.id.s);
        d = (Button) findViewById(R.id.d);
        f = (Button) findViewById(R.id.f);
        g = (Button) findViewById(R.id.g);
        h = (Button) findViewById(R.id.h);
        j = (Button) findViewById(R.id.j);
        k = (Button) findViewById(R.id.k);
        l = (Button) findViewById(R.id.l);
        z = (Button) findViewById(R.id.z);
        x = (Button) findViewById(R.id.x);
        c = (Button) findViewById(R.id.c);
        v = (Button) findViewById(R.id.v);
        b = (Button) findViewById(R.id.b);
        n = (Button) findViewById(R.id.n);
        m = (Button) findViewById(R.id.m);

        q.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("Q");
                check();
                q.setBackgroundColor(Color.RED);
                q.setClickable(false);
                if(flag == 1 )
                {
                    q.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        w.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("W");
                check();
                w.setBackgroundColor(Color.RED);
                w.setClickable(false);
                if(flag==1 )
                {
                    w.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        e.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("E");
                check();
                e.setBackgroundColor(Color.RED);
                e.setClickable(false);
                if(flag==1 )
                {
                    e.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        r.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("R");
                check();
                r.setBackgroundColor(Color.RED);
                r.setClickable(false);
                if(flag==1 )
                {
                    r.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        t.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("T");
                t.setBackgroundColor(Color.RED);
                check();
                t.setClickable(false);
                if(flag==1 )
                {
                    t.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        y.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                y.setBackgroundColor(Color.RED);
                input.setText("Y");
                check();
                y.setClickable(false);
                if(flag==1 )
                {
                    y.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        u.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("U");
                u.setBackgroundColor(Color.RED);
                check();
                u.setClickable(false);
                if(flag==1 )
                {
                    u.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        i.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setBackgroundColor(Color.RED);
                input.setText("I");
                check();
                i.setClickable(false);
                if(flag==1 )
                {
                    i.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        o.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                o.setBackgroundColor(Color.RED);
                input.setText("O");
                check();
                o.setClickable(false);
                if(flag==1 )
                {
                    o.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        p.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("P");
                p.setBackgroundColor(Color.RED);
                check();
                p.setClickable(false);
                if(flag==1 )
                {
                    p.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        a.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                a.setBackgroundColor(Color.RED);
                input.setText("A");
                check();
                a.setClickable(false);
                if(flag==1 )
                {
                    a.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        s.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                s.setBackgroundColor(Color.RED);
                input.setText("S");
                check();
                s.setClickable(false);
                if(flag==1 )
                {
                    s.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        d.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                d.setBackgroundColor(Color.RED);
                input.setText("D");
                check();
                d.setClickable(false);
                if(flag==1 )
                {
                    d.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        f.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                f.setBackgroundColor(Color.RED);
                input.setText("F");
                check();
                f.setClickable(false);
                if(flag==1 )
                {
                    f.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        g.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                g.setBackgroundColor(Color.RED);
                input.setText("G");
                check();
                g.setClickable(false);
                if(flag==1 )
                {
                    g.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        h.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                h.setBackgroundColor(Color.RED);
                input.setText("H");
                check();
                h.setClickable(false);
                if(flag==1 )
                {
                    h.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        j.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                j.setBackgroundColor(Color.RED);
                input.setText("J");
                check();
                j.setClickable(false);
                if(flag==1 )
                {
                    j.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        k.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                k.setBackgroundColor(Color.RED);
                input.setText("K");
                check();
                k.setClickable(false);
                if(flag==1 )
                {
                    k.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        l.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                l.setBackgroundColor(Color.RED);
                input.setText("L");
                check();
                l.setClickable(false);
                if(flag==1 )
                {
                    l.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        z.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                z.setBackgroundColor(Color.RED);
                input.setText("Z");
                check();
                z.setClickable(false);
                if(flag==1 )
                {
                    z.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        x.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                x.setBackgroundColor(Color.RED);
                input.setText("X");
                check();
                x.setClickable(false);
                if(flag==1 )
                {
                    x.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        c.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                c.setBackgroundColor(Color.RED);
                input.setText("C");
                check();
                c.setClickable(false);
                if(flag==1 )
                {
                    c.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        v.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.RED);
                input.setText("V");
                check();
                v.setClickable(false);
                if(flag==1 )
                {
                    v.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setBackgroundColor(Color.RED);
                input.setText("B");
                check();
                b.setClickable(false);
                if(flag==1 )
                {
                    b.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        n.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                n.setBackgroundColor(Color.RED);
                input.setText("N");
                check();
                n.setClickable(false);
                if(flag==1 )
                {
                    n.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
        m.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                m.setBackgroundColor(Color.RED);
                input.setText("M");
                check();
                m.setClickable(false);
                if(flag==1 )
                {
                    m.setBackgroundColor(Color.blue(2));
                    flag=0;
                }
            }
        });
    }

    public void check(){
        String temp;
        String newLetter = input.getText().toString();
        temp = (String) enteredText.getText();
        if (temp.indexOf(newLetter.toUpperCase()) >= 0) {
            input.setText("");
        }
        input.setText("");
        entered += newLetter.toUpperCase();
        enteredText.setText(temp + newLetter.toUpperCase());
        hiddenText.setText(encodeString(text, newLetter.toUpperCase()));
        if (win(text)) {
            Toast.makeText(getApplicationContext(), "Congratulations!\n\tYou won!", Toast.LENGTH_LONG).show();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            input.setFocusable(false);
            int again=level-1;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            startGame(again);
        }
        if (text.indexOf(newLetter.toUpperCase()) == -1) {
            count--;
            changeImage(count);
        }
        if (count == 0) {
            Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_LONG).show();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            hiddenText.setText(encodeString(text, "#"));
            input.setFocusable(false);
            int again=level-1;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            startGame(again);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
/*    @Override
    protected void onPause() {
        super.onPause();
        String old_entered = this.entered;
        String old_text = this.text;
        String old_hint = this.hint;
        int old_count = this.count;
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("old_text", old_text);
        editor.putString("old_entered", old_entered);
        editor.putString("old_hint", old_hint);
        editor.putInt("old_count", old_count);
        editor.commit();
        getIntent().putExtra(KEY_Level, -1);
    }
*/
    private String encodeString(String target, String letter) {
        String result = "";
        if (letter.contains("*")) {
            char[] ch = target.toCharArray();
            for (int i = 0; i <= target.length(); i++) {
                if (target.equals(" "))
                    result += "   ";
                else
                    result += "_ ";
            }
            return result;
        } else if (letter.contains("#")) {
            for (int i = 0; i < target.length(); i++) {
                result += target.charAt(i) + " ";
            }
            return result;
        } else {

            for (int i = 0; i < target.length(); i++)
            {
                if (target.charAt(i) == letter.charAt(0))
                {
                    flag=1;
                    result += target.charAt(i) + " ";
                }
                else if (entered.indexOf(target.charAt(i)) != -1)
                {
                    result += target.charAt(i) + " ";
                }
                else
                {
                    result += "_ ";
                }
            }
            return result;
        }
    }

    private boolean win(String text) {
        if (text.length() > 0 && entered.length() > 0) {
            for (int i = 0; i < text.length(); i++) {
                if (entered.indexOf(text.charAt(i)) == -1) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void changeImage(int count) {
        switch (count) {
            case 6:
                bodyParts[0].setVisibility(View.VISIBLE);
                break;
            case 5:
                bodyParts[1].setVisibility(View.VISIBLE);
                break;
            case 4:
                bodyParts[2].setVisibility(View.VISIBLE);
                break;
            case 3:
                bodyParts[3].setVisibility(View.VISIBLE);
                break;
            case 2:
                bodyParts[4].setVisibility(View.VISIBLE);
                break;
            case 1:
                bodyParts[5].setVisibility(View.VISIBLE);
                break;
            case 0:
                bodyParts[6].setVisibility(View.VISIBLE);
                break;
        }
    }

    private int setDifficulty(int dif) {
        switch (dif) {
            case -1:
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                level = 1;
                return 7;

            case 0:
                level = 1;
                return 7;

            case 1:
                level = 2;
                return 7;

            case 2:
                level = 3;
                return 7;

            case 3:
                level = 4;
                return 7;

            case 4:
                level = 5;
                return 7;

            case 5:
                level = 6;
                return 7;

            case 6:
                level = 7;
                return 7;

            case 7:
                level = 8;
                return 7;

            case 8:
                level = 9;
                return 7;

            case 9:
                level = 10;
                return 7;

            case 10:
                level = 11;
                return 7;

            default:
                level = 1;
                return 7;
        }
    }


    private void startGame(int i) {
        Intent intent = new Intent(Game.this, Game.class);
        intent.putExtra(Game.KEY_Level, i);
        startActivity(intent);
    }

}
