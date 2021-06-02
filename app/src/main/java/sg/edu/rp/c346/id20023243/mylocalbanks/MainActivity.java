package sg.edu.rp.c346.id20023243.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView bankDbs, bankOcbc, bankUob;
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bankDbs = findViewById(R.id.textViewDbs);
        bankOcbc = findViewById(R.id.textViewOcbc);
        bankUob = findViewById(R.id.textViewUob);

        registerForContextMenu(bankDbs);
        registerForContextMenu(bankOcbc);
        registerForContextMenu(bankUob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 1, "Website"); //group_id (to change all elements in this group to x)
        menu.add(0, 1, 2, "Contact the bank"); //the smaller order number appear first
        menu.add(0,2,3,"Toggle Favourite");

        if (v == bankDbs) {
            wordClicked = "DBS";
        } else if (v == bankOcbc) {
            wordClicked = "OCBC";
        } else {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == 0) {

            if (wordClicked.equalsIgnoreCase("dbs")) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg")); //universal resource i //have tel, http etc.
                startActivity(intentCall);

            }
            else if (wordClicked.equalsIgnoreCase("ocbc")) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com")); //universal resource i //have tel, http etc.
                startActivity(intentCall);
            }
            else if (wordClicked.equalsIgnoreCase("uob")) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg")); //universal resource i //have tel, http etc.
                startActivity(intentCall);
            }
            return true; //menu item successfully handled
        }

        else if (item.getItemId() == 1) {

            if (wordClicked.equalsIgnoreCase("dbs")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111")); //universal resource i //have tel, http etc.
                startActivity(intentCall);

            }
            else if (wordClicked.equalsIgnoreCase("ocbc")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333" ));
                startActivity(intentCall);

            }
            else if (wordClicked.equalsIgnoreCase("uob")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+18002222121"));
                startActivity(intentCall);

            }
            return true; //menu item successfully handled
        }

        else if (item.getItemId() == 2) {

            if (wordClicked.equalsIgnoreCase("dbs")) {
               bankDbs.setTextColor(Color.parseColor("#E80002"));
            }
            else if (wordClicked.equalsIgnoreCase("ocbc")) {
                bankOcbc.setTextColor(Color.parseColor("#E80002"));
            }
            else if (wordClicked.equalsIgnoreCase("uob")) {
                bankUob.setTextColor(Color.parseColor("#E80002"));
            }
            return true; //menu item successfully handled
        }


        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu); // expand menu from xml to this menu; otherwise menu empty
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // to handle the menu items being selected/clicked
        //for this if u change language to italian; all contents will be changed to italian
        if(item.getItemId()== R.id.englishSelection) {
            bankDbs.setText("DBS");
            bankOcbc.setText("OCBC");
            bankUob.setText("UOB");
        }

        else if(item.getItemId()== R.id.chineseSelection) {
            bankDbs.setText("星展银行");
            bankOcbc.setText("华侨银行");
            bankUob.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);
    }
}