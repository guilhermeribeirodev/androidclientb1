package com.example.androidclientb1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 11/17/13
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserActivity extends Activity {

    ListView gridView;

    static final String[] MOBILE_OS = new String[] {
            "Items", "Compras","Processados", "Produtos" };

    TextView txtDebug;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        txtDebug = (TextView) findViewById(R.id.txtDebug);

        gridView = (ListView) findViewById(R.id.gridView1);

        gridView.setAdapter(new ImageAdapter(this, MOBILE_OS));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        ((TextView) v.findViewById(R.id.grid_item_label))
                                .getText(), Toast.LENGTH_SHORT).show();

                CharSequence text =  ((TextView) v.findViewById(R.id.grid_item_label)).getText();


                Log.v("texto", text.toString());

                if(text.toString() == "Items"){

                    //PathToList<Item> path = new PathToList<Item>();

                    try {

                        /*List<Item> listItem = path.ret("items");

                        String ret = "";

                        Iterator it = listItem.iterator();

                        while(it.hasNext()){

                            Item item = (Item) it.next();
                            ret += "\n nome: "+item.getNome();

                        }*/



                        txtDebug.setText(HttpUtil.getInputStreamFromUrl("http://app-bares.herokuapp.com/items"));

                    } catch (Exception e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }

                if(text.toString() == "Compras"){
                    txtDebug.setText(HttpUtil.getInputStreamFromUrl("http://app-bares.herokuapp.com/compras"));
                }

                if(text.toString() == "Processados"){

                    txtDebug.setText(HttpUtil.getInputStreamFromUrl("http://app-bares.herokuapp.com/processados"));
                }

                if(text.toString() == "Produtos"){
                    txtDebug.setText(HttpUtil.getInputStreamFromUrl("http://app-bares.herokuapp.com/produtos"));

                }

            }
        });


    }
}
