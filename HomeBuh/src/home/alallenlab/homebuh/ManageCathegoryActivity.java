package home.alallenlab.homebuh;

import java.util.List;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import home.alallenlab.homebuh.TCathegoryDataSource;

public class ManageCathegoryActivity extends ListActivity {

	private TCathegoryDataSource datasource;
	//ArrayAdapter<String> adapter;
	ArrayAdapter<TCathegory> adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_cathegory);
        
        datasource = new TCathegoryDataSource(this);
        datasource.open();

        List<TCathegory> values = datasource.getAllCathegories();

        // Use the SimpleCursorAdapter to show the
        // elements in a ListView
        /*ArrayAdapter<String> */adapter = new ArrayAdapter<TCathegory>(this, android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
        
        registerForContextMenu(getListView());
    }

    public void addCathegory(View view) {
        //@SuppressWarnings("unchecked")
        //ArrayAdapter<String> adapter = (ArrayAdapter<String>) getListAdapter();
        TCathegory cathegory = null;
        EditText tvCathegory = (EditText) findViewById(R.id.txtInput);
        cathegory = datasource.createCathegory(tvCathegory.getText().toString());
        //adapter.add(cathegory.getCathegoryName());
        adapter.add(cathegory);
        adapter.notifyDataSetChanged();
      }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cathegories_context_menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
    	TCathegory cathegory=adapter.getItem(info.position);
        switch (item.getItemId()) {
        case R.id.remove_cathegory:
            datasource.deleteCathegory(cathegory.getCathegoryName());
            adapter.remove(cathegory);
            adapter.notifyDataSetChanged();
            return true;
        case R.id.select_cathegory:
        	Intent intent = new Intent();
            intent.putExtra("exCathegoryName", cathegory.getCathegoryName());
            intent.putExtra("exCathegoryId",cathegory.getId());
            setResult(RESULT_OK, intent);
            finish();
            return true;
        }
        return false;
    }
}
