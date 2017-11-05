    package library.madhushree;

            import library.madhushree.constant.SQLCommand;
            import library.madhushree.view.TableView;
            import library.madhushree.util.DBOperator;
            import android.support.v7.app.AppCompatActivity;
            import android.database.Cursor;
            import android.os.Bundle;
            import android.widget.ScrollView;
            import android.view.View;
            import android.view.View.OnClickListener;
            import android.widget.Button;
            import android.content.Intent;


    public class MadhushreeActivity extends AppCompatActivity implements OnClickListener
        {
            /** Called when the activity is first created. */
            public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_madhushree_layout);
            Button checkoutBtn=(Button)this.findViewById(R.id.goCheckOut_btn);
            checkoutBtn.setOnClickListener(this);
            Button queryBtn=(Button)this.findViewById(R.id.goDoQuery_btn);
            queryBtn.setOnClickListener(this);

            try{
                DBOperator.copyDB(getBaseContext());
            }catch(Exception e){
                e.printStackTrace();
            }
            //implement SQL query and get cursor of resultset
            Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.QUERY_1);
            TableView tableView = new TableView(this, cursor);
            //show data in tableview
            //ScrollView scrollView = (ScrollView)this.findViewById(R.id.scrollView);
            //scrollView.addView(tableView);
        }


        public void onClick(View v)
        {
            int id=v.getId();
            if (id==R.id.goCheckOut_btn){
                Intent intent = new Intent(this, CheckoutActivity.class);
                this.startActivity(intent);

            }else if (id==R.id.goDoQuery_btn){
                Intent intent = new Intent(this, QueryActivity.class);
                this.startActivity(intent);
            }
        }

    }


