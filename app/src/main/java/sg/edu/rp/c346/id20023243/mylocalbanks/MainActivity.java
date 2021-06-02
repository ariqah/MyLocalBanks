package sg.edu.rp.c346.id20023243.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
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
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg/index/default.page")); //universal resource i //have tel, http etc.
                startActivity(intentCall);

            }
            else if (wordClicked.equalsIgnoreCase("ocbc")) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway")); //universal resource i //have tel, http etc.
                startActivity(intentCall);
            }
            else if (wordClicked.equalsIgnoreCase("uob")) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/default.page")); //universal resource i //have tel, http etc.
                startActivity(intentCall);
            }
            return true; //menu item successfully handled
        }

        else if (item.getItemId() == 1) {

            if (wordClicked.equalsIgnoreCase("dbs")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+65" + 63272265)); //universal resource i //have tel, http etc.
                startActivity(intentCall);

            }
            else if (wordClicked.equalsIgnoreCase("ocbc")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+65" + 63633333 )); //universal resource i //have tel, http etc.
                startActivity(intentCall);

            }
            else if (wordClicked.equalsIgnoreCase("uob")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+65" + 62222121)); //universal resource i //have tel, http etc.
                startActivity(intentCall);

            }
            return true; //menu item successfully handled
        }

        return super.onContextItemSelected(item);
    }
}