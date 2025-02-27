package hacc2018.planthawaii;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

import hacc2018.planthawaii.ML.ClassifierActivity;
import io.fotoapparat.Fotoapparat;
import io.fotoapparat.view.CameraView;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    CameraView cameraView;
    Fotoapparat fotoapparat;
    ListView LV_Country;
    SimpleAdapter ADAhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("create the oncreate tired");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//database connection
        List<Map<String,String>> MyData = null;
        GetData mydata =new GetData();
        MyData= mydata.doInBackground();
        //String[] fromwhere = { "ID","Country","Capital" };

        //int[] viewswhere = {R.id.lblID , R.id.lblcountryname,R.id.lblCapitalCity};

        //ADAhere = new SimpleAdapter(MainActivity.this, MyData,R.layout.listtemplate, fromwhere, viewswhere);

       // LV_Country.setAdapter(ADAhere);


        //   cameraView = findViewById(R.id.camera_view);
        // fotoapparat= createFotoapparat(); //creates for camera
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*for email floating
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, ClassifierActivity.class);
            startActivity(intent);
            // Intent menuIntent = new Intent(this, CameraActivity.class);
            //   startActivity(menuIntent);


       /*     Fragment mFragment = null;
            mFragment = new CameraFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentFrame, mFragment).commit();*/
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.flower1) {
            // Handle the camera action
          //  setContentView(R.layout.content_camera);

            Intent intent = new Intent(this, ClassifierActivity.class);
            //    EditText editText = (EditText) findViewById(R.id.editText);
            //  String message = editText.getText().toString();
            //intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } else if (id == R.id.flower2) {/*
            Fragment mFragment = null;
            mFragment = new DownloadDBFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentFrame, mFragment).commit();
                    */
            return true;
        } else if (id == R.id.flower3) {
            Intent intent = new Intent(this, MainActivity2.class);
         //   EditText editText = (EditText) findViewById(R.id.editText);
           // String message = editText.getText().toString();
           // intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);

        } else if (id == R.id.flower4) {
            Fragment mFragment = null;
            mFragment = new CameraFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentFrame, mFragment).commit();

        } else if (id == R.id.plant1) {

        } else if (id == R.id.plant2) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onStart() {

        super.onStart();
        //  fotoapparat.start();

    }

}