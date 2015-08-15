package com.example.sridhar.listviewenhanced;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;


public class StartScreen extends Activity {

    List<Bean> dramaList = new ArrayList<>();
    //List<Characters> castList = new ArrayList<>();

    String pk[] = {"Jung So Min","Kim Hyun Joong","Lee Tae Sung"};
    String heirs[] = {"Park Shin Hye","Lee Min Ho","Kim Woo Bin"};
    String bof[] ={"Lee Min Ho","Kim Hyun Joong","Ku Hye Sun","Kim Bum","Kim Joon"};
    String yb[] = {"Park Shin Hye","Jang Geun Suk","Jung Yong Hwa","Lee Hong Ki"};
    String ttby[] = {"Choi Min Ho","Sulli","Lee Hyun Woo"};
    String sg[] = {"Hyun Bin","Ha Ji Won"};
    String mgiag[] = {"Shin Min Ah","Lee Seung Gi","No Min Woo"};
    String cp[] = {"Gong Yoo","Yoon Eun Hye","Lee Sun Gyun","Chae Jung An"};
    String mlfas[] = {"Kim Soo Hyun","Jun Ji Hyun","Park Hae Jin"};
    String hs[] = {"Jung Yong Hwa","Park Shin Hye"};
    String pinnocchio[] = {"Park Shin Hye","Lee Jong Suk","Kim Young Kwang","Lee Yu Bi"};
    //String castArray[] = {"Oh Ha Ni","Hellow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);



        populateArrayList();
        populateListView();

    }



    private void populateArrayList() {

        dramaList.add(new Bean("Playful Kiss",R.drawable.playful_kiss,9.4,"Romance,School",pk));
        dramaList.add(new Bean("The Heirs",R.drawable.the_heirs,9.2,"Romance,School",heirs));
        dramaList.add(new Bean("Boys Over Flowers",R.drawable.boys_over_flowers,9.0,"School",bof));
        dramaList.add(new Bean("You're Beautiful",R.drawable.you_are_beautiful,9.4,"Romance,Comedy",yb));
        dramaList.add(new Bean("To The Beautiful You",R.drawable.to_the_beautiful_you,9.0,"School,Comedy",ttby));
        dramaList.add(new Bean("Secret Garden",R.drawable.secret_garden,9.4,"Fantasy,Action,Romance,Comedy",sg));
        dramaList.add(new Bean("My GirlFriend is a Gumiho",R.drawable.my_girlfriend_is_a_gumiho,9.4,"Romance,Comedy,Fantasy",mgiag));
        dramaList.add(new Bean("Coffee Prince", R.drawable.coffee_prince, 9.3, "Comedy,Romance", cp));
        dramaList.add(new Bean("My Love From Another Stars", R.drawable.my_love_from_another_star, 9.3, "Comedy,Romance,Sci-fic", mlfas));
        dramaList.add(new Bean("Heart Strings", R.drawable.heart_strings, 9.2, "Romance,School,Comedy", hs));
        dramaList.add(new Bean("Pinnocchio", R.drawable.pinocchio, 9.4, "Romance,Comedy,Family", pinnocchio));
    }


    private void populateListView() {
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<Bean> adapter = (new MyCustomAdapter());
        listView.setAdapter(adapter);
    }

    public static class viewHolder{
        ImageButton imgButton;
        TextView Name,Rating,Genre;
    }
    private class MyCustomAdapter extends ArrayAdapter<Bean> {
        MyCustomAdapter(){
            super(StartScreen.this, R.layout.custom_layout, dramaList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final viewHolder holder ;
            if(convertView==null)
            {
                convertView=getLayoutInflater().inflate(R.layout.custom_layout,parent,false);
                holder = new viewHolder();
                holder.imgButton =(ImageButton) convertView.findViewById(R.id.imagebutton);
                holder.Name = (TextView) convertView.findViewById(R.id.name);
                holder.Rating = (TextView) convertView.findViewById(R.id.rating);
                holder.Genre = (TextView) convertView.findViewById(R.id.genre);
                convertView.setTag(holder);
            }
            else {
            holder =(viewHolder) convertView.getTag(); }

            final Bean currentDrama = dramaList.get(position);
            holder.imgButton.setImageResource(currentDrama.getIcon_id());
            holder.Name.setText(currentDrama.getName());
            holder.Rating.setText(currentDrama.getRatings()+"");
            holder.Genre.setText(currentDrama.getGenre());

            holder.imgButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent castActivity = new Intent(StartScreen.this,Cast.class);
                    castActivity.putExtra("CAST",currentDrama.getCast());
                    castActivity.putExtra("Name",currentDrama.getName());
                    startActivity(castActivity);
                }
            });

            return convertView;
        }
        


    }


}
