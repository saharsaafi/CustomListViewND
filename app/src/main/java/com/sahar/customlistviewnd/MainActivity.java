package com.sahar.customlistviewnd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ListView malisteviawperso;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        malisteviawperso=findViewById(R.id.listviewperso);
        ArrayList<HashMap<String,String>> listItem=new ArrayList<>();
        HashMap<String, String>map;

        // word
        map=new HashMap<>();
        map.put("titre","word");
        map.put("description","editeur de text");
        map.put("img",String.valueOf(R.drawable.word));
        listItem.add(map);
        SimpleAdapter adapter =new SimpleAdapter(this.getBaseContext(),listItem,
                R.layout.activity_list_item,new String[] {"img", "titre", "description"},
                new int[] {R.id.img, R.id.titre, R.id.description});
        malisteviawperso.setAdapter(adapter);
        //éxcle
        map=new HashMap<>();
        map.put("titre","excle");
        map.put("description","editeur de text");
        map.put("img",String.valueOf(R.drawable.excel));
        listItem.add(map);
        SimpleAdapter adapter2 =new SimpleAdapter(this.getBaseContext(),listItem,
                R.layout.activity_list_item,new String[] {"img", "titre", "description"},
                new int[] {R.id.img, R.id.titre, R.id.description});
        malisteviawperso.setAdapter(adapter2);

        map=new HashMap<>();
        map.put("titre","powerpoint");
        map.put("description","editeur de text");
        map.put("img",String.valueOf(R.drawable.powerpoint));
        listItem.add(map);
        SimpleAdapter adapter3 =new SimpleAdapter(this.getBaseContext(),listItem,
                R.layout.activity_list_item,new String[] {"img", "titre", "description"},
                new int[] {R.id.img, R.id.titre, R.id.description});
        malisteviawperso.setAdapter(adapter3);


        map=new HashMap<>();
        map.put("titre","outlook");
        map.put("description","editeur de text");
        map.put("img",String.valueOf(R.drawable.outlook));
        listItem.add(map);
        SimpleAdapter adapter4 =new SimpleAdapter(this.getBaseContext(),listItem,
                R.layout.activity_list_item,new String[] {"img", "titre", "description"},
                new int[] {R.id.img, R.id.titre, R.id.description});
        malisteviawperso.setAdapter(adapter4);

        malisteviawperso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> map = (HashMap<String, String>) malisteviawperso.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, map.get("titre"), Toast.LENGTH_SHORT).show();
            }
        });

        malisteviawperso.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                HashMap<String, String> map =(HashMap)malisteviawperso.getItemAtPosition(position);
                AlertDialog.Builder add=new AlertDialog.Builder(MainActivity.this);
                add.setTitle("selection item");
                add.setMessage("votre choix: "+ map.get(position)+ add.setPositiveButton("OK",null));
                add.show();
                return true;
            }
        });


    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }

