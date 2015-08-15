package com.example.sridhar.listviewenhanced;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sridhar on 8/15/2015.
 */
public class Cast extends Activity {

    HashMap<String,Integer> castMap = new HashMap<>();
    HashMap<String,String> plotMap = new HashMap<>();
    ArrayList<String> castArray = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.castscreen);
        populateCastMap();
        populatePlotMap();

        Bundle received = getIntent().getExtras();
        String [] Cast = received.getStringArray("CAST");
        String Name = received.getString("Name");
        for(int i=0;i<Cast.length;i++){
            castArray.add(i,Cast[i]);
        }
        TextView plot = (TextView) findViewById(R.id.plot);
       plot.setText(plotMap.get(Name));
        populateListView();




    }

    private void populateCastMap() {
        castMap.put("Chae Jung An",R.mipmap.chae_jung_an);
        castMap.put("Choi Min Ho",R.mipmap.choi_min_ho);
        castMap.put("Gong Yoo",R.mipmap.gong_yoo);
        castMap.put("Ha Ji Won",R.mipmap.ha_ji_won);
        castMap.put("Hyun Bin",R.mipmap.hyun_bin);
        castMap.put("Jang Geun Suk",R.mipmap.jang_geun_suk);
        castMap.put("Jun Ji Hyun",R.mipmap.jun_ji_hyun);
        castMap.put("Jung So Min",R.mipmap.jung_so_min);
        castMap.put("Jung Yong Hwa",R.mipmap.jung_yong_hwa);
        castMap.put("Kim Bum",R.mipmap.kim_bum);
        castMap.put("Kim Hyun Joong",R.mipmap.kim_hyun_joong);
        castMap.put("Kim Joon",R.mipmap.kim_joon);
        castMap.put("Kim Soo Hyun",R.mipmap.kim_soo_hyun);
        castMap.put("Kim Woo Bin",R.mipmap.kim_woo_bin);
        castMap.put("Kim Young Kwang",R.mipmap.kim_young_kwang);
        castMap.put("Ku Hye Sun",R.mipmap.ku_hye_sun);
        castMap.put("Lee Hong Ki",R.mipmap.lee_hong_ki);
        castMap.put("Lee Hyun Woo",R.mipmap.lee_hyun_woo);
        castMap.put("Lee Jong Suk",R.mipmap.lee_jong_suk);
        castMap.put("Lee Min Ho",R.mipmap.lee_min_ho);
        castMap.put("Lee Seung Gi",R.mipmap.lee_seung_gi);
        castMap.put("Lee Sun Gyun",R.mipmap.lee_sun_gyun);
        castMap.put("Lee Tae Sung",R.mipmap.lee_tae_sung);
        castMap.put("Lee Yu Bi",R.mipmap.lee_yu_bi);
        castMap.put("No Min Woo",R.mipmap.no_min_woo);
        castMap.put("Park Hae Jin",R.mipmap.park_hae_jin);
        castMap.put("Park Shin Hye",R.mipmap.park_shin_hye);
        castMap.put("Shin Min Ah",R.mipmap.shin_min_ah);
        castMap.put("Sulli",R.mipmap.sulli);
        castMap.put("Yoon Eun Hye",R.mipmap.yoon_eun_hye);
    }


    public static class ViewHolder{

        ImageView CastImage;
        TextView CastName;
    }
    private void populateListView() {
        ListView castView = (ListView) findViewById(R.id.castview);
        ArrayAdapter<String> adapter = new MyOwnCustomAdapter();
        castView.setAdapter(adapter);
    }
    private class MyOwnCustomAdapter extends ArrayAdapter<String> {


        MyOwnCustomAdapter(){
            super(Cast.this, R.layout.cast_custom_layout, castArray);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                convertView=getLayoutInflater().inflate(R.layout.cast_custom_layout,parent,false);
                holder = new ViewHolder();
                holder.CastImage =(ImageView) convertView.findViewById(R.id.castImage);
                holder.CastName =(TextView) convertView.findViewById(R.id.castName);
                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.CastImage.setImageResource(castMap.get(castArray.get(position)));
            holder.CastName.setText(castArray.get(position));
            return convertView;
        }



    }

    private void populatePlotMap() {
        plotMap.put("Playful Kiss","\"Mischievous Kiss\" is a romantic-comedy covering the romance between Baek Seung-Jo" +
                " (Kim Hyun-Joong), an arrogant young man with a genius IQ, and Oh Ha-Ni (Jung So-Min)," +
                " a ditzy young woman who gets poor grades, but whose heart is as powerful as Seung-Jo's " +
                "mind.The series is based off from a Taiwanese drama and a Japanese manga book. It is call \"" +
                "It Started With a Kiss.\" It is about a girl in F class that falls in love with an A class boy." +
                " She liked him since the first year of high school. Once, she decided to tell him she likes him but" +
                " was rejected. So the story continues about the girl who keeps chasing after the boy she loves.");

        plotMap.put("The Heirs","\"The Heirs\" depicts the friendships, rivalries and love lives of young, rich heirs " +
                "led by Kim Tan (Lee Min-Ho) and a girl named Cha Eun-Sang (Park Shin-Hye). Unlike the others, " +
                "Cha Eun-Sang is considered ordinary and comes from a poor background. 18-year-old Cha Eun-Sang" +
                " lives with her mother who is mute. Her mother works as a housekeeper and Eun-Sang also works" +
                " part-time jobs to help out. One day, Eun-Sang's older sister (Yoon Jin-Seo) calls from the U.S. " +
                "and informs them that she will marry. Eun-Sang's mother then asks Eun-Sang to send her older sister " +
                "some money from her savings account. Eun-Sang isn't happy with her situation and decides to go to the " +
                "U.S. herself to see if she can start a better life with her sister When Eun-Sang arrives in California she " +
                "is in for a shock. Her older sister lives in a filthy home with a deadbeat boyfriend who seems violent." +
                " Her sister is also not getting married or going to school and works full-time as a waitress. When Eun-Sang" +
                " finally tracks down her sister working at a beach front restaurant, she takes the money Eun-Sang brought for " +
                "her wedding and leaves without even saying goodbye. Eun-Sang's dreams of starting a better life in America" +
                " quickly vanishes and she crumbles to the ground in tears.Meanwhile, Kim Tan is not your typical high school" +
                " student, but a handsome and wealthy Korean heir to a large conglomeration. He is sitting out on the patio of '" +
                "the beach front restaurant, watching everything unfold between Eun-Sang and her sister. Kim Tan's American " +
                "friend then sees a ziplock bag with a powdery substance fall out of Eun-Sang's suitcase and runs over to scoop " +
                "it up. Kim Tan knows immediately that the ziplock bag doesn't contain drugs, but rather powder grain to make " +
                "traditional Korean drinks. Soon, Eun-Sang runs off after Kim Tan's friend and Kim Tan goes to help Eun-Sang." +
                " When the dust is settled, Eun-Sang walks out of a police station and her passport is temporarily confiscated." +
                " With nowhere to go for Eun-Sang, Kim Tan offers to let her stay at his home. Although they seem to come from " +
                "different worlds, they quickly develop a rapport for each other. But, when Kim Tan is at school, Eun-Sang meets" +
                " a girl named Rachel (Kim Ji-Won). Rachel informs Eun-Sang that she is Kim Tan's fiance and she demands that" +
                " Eun-Sang leaves his home immediately. Eventually, Eun-Sang returns to South Korea.\n Kim Tan now feels nothing " +
                "but emptiness after Eun-Sang's departure. He decides to go back to Korea even though his older stepbrother Won " +
                "(Choi Jin-Hyuk) strongly opposes his return. When Kim Tan gets back to his luxurious mansion like home, he sees" +
                " someone briefly that resembles Eun-Sang. Kim Tan goes to his mother Ki-Ae (Kim Sung-Ryoung) and asks about the" +
                " unfamiliar, but familiar girl that he briefly saw. His mother tells him that the girl is their housekeeper's " +
                "daughter and her name is Cha Eun-Sang. She's also staying in their home.\n");

        plotMap.put("Boys Over Flowers","“Hana Yori Dango” is about a poor, but bright high school student named Makino" +
                " Tsukushi (Mao Inoue) who attends an exclusive high school where only the rich go. She ends up having " +
                "encounters with the bachelor F4 and experiences love and friendship.");

        plotMap.put("You're Beautiful","Ko Mi-Nyeo & Ko Mi-Nam (both played by Park Shin-Hye) are twin brother and " +
                "sisters. They grew up in an orphanage and never knew their parents.As a young adult, Ko Mi-Nyeo is" +
                " set to become a nun. On her way to pick up a ticket for Rome a strange man catches up to her." +
                " The man's name is Ma Hoon-Lee (Kim In-Kwon) and he explains that he's the manager for popular " +
                "boy band \"A.N.JELL\". He also explains that her twin brother Ko Min-Nam, who just joined the band," +
                " was seriously injured and sent to America to recover. Ma Hoon-Lee then pleads to Ko Mi-Nyeo to" +
                " impersonate her brother until he recovers. For her brother's sake, Ko Mi-Nyeo reluctantly agrees to" +
                " play her brother.\n" +"A.N.JELL band member Kang Shin-Woo (Jeong Yong-Hwa) first discovers Ko Mi-Nyeo's secret," +
                " but he keeps it to himself. Kang Shin-Woo also tries to help her out without Ko Mi-Nyeo knowing. He also starts" +
                " to develop feelings for her.Meanwhile, A.N.JELL's singer/songwriter/vocalist Hwang Tae-Kyeong (Jang Keun-Suk)" +
                " discovers Ko Mi-Nyeo's secret. Hwang Tae-Kyeong is an extremely gifted musician, but his personality is cold " +
                "and he is a control freak. At first Hwang Tae-Kyeong tries to kick Ko Mi-Nyeo out of the band, but he becomes" +
                " sympathetic to her plight when he discovers that she hoped to find her mother by appearing on television with" +
                " the band.Ko Mi-Nyeo's secret is then discovered by pop singer Yu Hee-Yi (Uee) by chance. When the media " +
                "falsely reports that Yu Hee-Yi and A.N.JELL band member Hwang Tae-Kyeong are dating she uses Ko Mi-Nyeo's " +
                "secret to make Hwang Tae-Kyeong pretend they are dating in front of the press. At the right moment Yu Hee-Yi " +
                "will announce to the press that they have broken up and that she dumped Hwang Tae-Kyeong. In return Yu Hee-Yi" +
                " will keep Ko Mi-Nyeo's secret. Hwang Tae-Kyeong agrees to this arrangement to protect Ko Mi-Nyeo. Meanwhile Yu Hee-Yi starts to develops" +
                " feelings for Hwang Tae-Kyeong ...");
        plotMap.put("To The Beautiful You","Kang Tae-Joon (Minho) is a gold medalist in the high jump, but he has been mired in a slump due to an injury. " +
                "In order to help her idol, a girl named Koo Jae-Hee (Sulli) disguises herself as a boy and enrolls at the same all male high school.When" +
                " Tae-Joon (Minho) is competiting at the World Junior Competition, Jae-Hee (Sulli) watches him on TV in America and becomes very touched\n" +
                "Despite her friends telling her otherwise, Jae-Hee cuts her long hair by herself. She then flies to South Korea, with a plan to stay with" +
                " Tae-Joon who is now injured. Jae-Hee disguises herself as a boy and enrolls at the all boys Genie Physical Education High School. On her" +
                " first day at school, Jae-Hee goes up the stairs with her suitcase, but her suitcase bursts open and all her clothes fall out. A boy comes" +
                " by and helps her pick up her stuff. Jae-Hee realizes that the boy helping her is none other than her idol Tae-Joon. In her excitement, " +
                "Jae-Hee sits on her suitcase, which proceeds to slide down the stairs.Jae-Hee gets to her first class and introduces herself. One of her " +
                "classmaste, Jong-Min (Hwang Kwang-Hee), tells her that if she wants to become their classmate she will have to go pickup a ball that sits " +
                "inside a doghouse located on campus. Jae-Hee goes to the doghouse and sees a warning sign about the dog. Nevertheless, the dog seems friendly" +
                " to Jae-Hee and she goes inside to take out the ball. At that moment, Jae-Hee hears Tae-Joon voices and she hides in the doghouse." +
                " Tae-Joon starts to talk to the dog and tells the dog that he doesn't want to perform the high jump at tomorrow's commercial shooting." +
                " Tomorrow will be the first time Tae-Joon does the high jump after suffering from his injury. Jae-Hee comes out of the doghouse and asks" +
                " Tae-Joon if he is ok after his injury. Tae-Joon becomes angry and leaves.\n" +"She goes back to the classroom and gives the ball to Jong-Min, " +
                "who is very surprised. The dog is normally hostile to guys that come by. Eun-Gyeol (Lee Hyun-Woo), who is a soccer player, looks at her with a " +
                "smile.Later, Jae-Hee goes to her dorm room and learns that she is sharing her room with one other student. When she gets out of the shower, " +
                "Jae-Hee sees her new roommate, who is Tae-Joon! Tae-Joon immediately kicks her out of the room, but with the help of Seung-Ri (Seo Jun-Young)," +
                " the student dorm monitor, she is able to get back into the room.The next day, students at Genie High School gather to play soccer." +
                " Tae-Joon tells Jae-Hee that if she makes a goal he will let her stay in his room. Jae-Hee tries hard to score a goal, but collides with " +
                "Jong-Min and gets knocked out. Tae-Joon carries her to the school infirmary. Before she wakes up, Tae-Joon runs to the school gym where the" +
                " high jump commercial will be filmed. Meanwhile, Tae-Hee wakes up and she knows that the school doctor knows that she is a girl.");
        plotMap.put("Secret Garden","Kim Joo-Won (Hyun-Bin) is from a wealthy family, smart and good looking. He runs the luxurious Roel Department store," +
                " which his family owns. Oska (Yoon Sang-Hyun) is a popular singer around Asia, but he doesn't have musical talent. He is also a womanizer." +
                " Joo-Won and Oska are also cousins and highly competitive towards each other.On a request by Oska, Joo-Won goes to pick up actress" +
                " Park Chae-Rin from a shooting set. Joo-Won mistakes stunt woman Gil Ra-Im (Ha Ji-Won) for Park Chae-Rin and takes stunt woman Ra-Im " +
                "to a hotel. Oska made the request in an attempt to prevent Park Chae-Rin from revealing their relationship to the press. At the hotel," +
                " Joo-Won discovers that the woman he picked is not actress Park Chae-Rim but a stunt woman. During this time, Joo-Won starts to " +
                "experience strong feelings for the feisty stunt woman, even though she isn't his type. Joo-Won tried getting Ra-Im out of his mind " +
                "for Ra-Im does not own a high status life nor is even rich. Nevertheless, Joo-Won can't stop thinking about Ra-Im.Later, Joo-Won " +
                "sneaks into an action school to watch Ra-Im. Meanwhile, Ra-Im tries her best to ignore Joo-Won because she knows Joo-Wan belongs to " +
                "another higher social level compared to her. Nevertheless, Ra-Im can't help her blooming feelings towards Joo-Won.Yeun-Sul (Kim Sa-Rang)" +
                " and Oska are ex-lovers, but they can't seem to forget each other. Because Yeun-Sul had a high-living status, she was arranged to " +
                "attend a blind date with Joo-Won. Even though Joo-Wan made it clear that he doesn't have interest in her, Yeun-Sul keeps pursuing " +
                "Joo-Won. Yeun-Sul knows Joo-Wan is Oska's cousin and wants to use him to get under Oska's skin. Yeun-Sul then manages to become the" +
                " director for Oska's next music video, which is scheduled to be shot on Jeju Island.Meanwhile, stunt woman Ra-Im is a fan of Oska's " +
                "music and wins a contest to go to Jeju Island with Oska himself. Ra-Im also wanted to take part in Oska's music video. Joo-Won learns" +
                " that Ra-Im won the contest to spend time with Oska and decides to follow them to Jeju Island.On Jeju Island, the main participants all" +
                " gather. While they were mountain biking, Ra-Im gets separated from Joo-Won and Oska. Joo-Won searched frantically to find Ra-Im." +
                " Eventually, Joo-Won was able to find Ra-Im but ended up stranded in a mysterious restaurant in the middle of the woods called " +
                "'Secret Garden'. Even more mysteriously, the owner of 'Secret Garden' seems to know both Joo-Won and Ra-Lim very well. The owner" +
                " presented two bottles of homemade floral wine to Joo-Won and Ra-Im. They manage to find their way back to the hotel before night" +
                " and went their separate ways. At night, neither Joo-Won nor Ra-Im find themselves able to sleep and each takes this time to clear" +
                " their mind while drinking their individual gifted wine. A twist of intrigue takes place in the plot when both Ra-Im and Joo-Won wake" +
                " up in the morning to find that their souls have switched to the other's body!");
        plotMap.put("My GirlFriend is a Gumiho","Cha Tae-Woong (Lee Seung-Ki) is a spoiled young man with no interest in staying in college. Instead," +
                " Cha Tae-Woong wants to become an action actor. His wealthy grandfather Cha Poong (Byun Hee-Bong) though wants Tae-Woong to take his" +
                " studies seriously & change his major from acting. When Cha Poong learns that Tae-Woong spent his next semester's tuition fees on an" +
                " expensive motorcycle, he calls the police and reports the motorcycle as stolen. Cha Poong then picks up Tae-Woong up from the" +
                " police station and attempts to drive him to a remote boarding school in hopes that he would change his major. At a rests area along the way" +
                ", Tae-Woong is able to slip away from his grandfather and hide in the back of a delivery truck. The delivery truck then drives off.Eventually" +
                " Tae-Woong gets out of the delivery truck, but finds himself in the middle of nowhere on a late rainy evening. He then gets a ride from a " +
                "buddhist monk, who also gives him shelter at a Buddhist Temple.Late in the evening at the Buddhist Temple, Tae-Woong wonders off hoping to " +
                "catch a signal for his cellphone. Suddenly he hears a woman's voice from a woman his cellphone. The woman instructs Tae-Woong to enter the " +
                "temple and draw nine tails onto a painting of a fox. Once Tae-Woong draws the nine tails on the fox, he unknowingly frees the legendary " +
                "nine tailed fox known as \"Gumiho\" (Shin Min-A). Tae-Woong fears for his life, but Gumiho just wants to be loved (and eat lots of beef!).");
        plotMap.put("Coffee Prince","Coffee Prince’s Flagship Store is a TV series that revolves around the love life and dreams of four young people who meet" +
                " together at a cafe.Han-gyeol (Gong Yoo) is a smart young man who hates to be tied down to one career in his life. Abhorring the idea of joining" +
                " the family business, he is ordered by his grandmother to manage a cafe. Unable to disobey his grandmother, he reluctantly takes over the " +
                "responsibility of running a cafe and begins to immerse himself in the gourmet coffee business. One day, he meets Eun-chan, a cheerful girl who" +
                " has an unpredictable personality, and learns the meaning of true love...");
        plotMap.put("My Love From Another Stars","Do Min-Joon is an alien who landed on Earth 400 years ago during the Joseon Dynasty period. Do Min-Joon possesses a near perfect appearance and enhanced physical abilities involving his vision, hearing and speed\n" +
                "\n" +"Do Min-Joon holds a cynical view to human beings, but he falls in love with actress Cheon Song-Yi.\n");
        plotMap.put("Heart Strings","Set at an art university, the youth romance drama \"Festival\" depicts the sweat and tears of students who run towards their dreams of love and friendship.\n" +
                "\n" +
                "Kyu-Won (Park Shin-Hye) is a bright girl and a highly skilled gayageum player. She is in the Korean traditional music department." +
                " Kyu-Won also comes from a family who has one of the three best pansori singers in the world. Shin (Jung Yong-Hwa)" +
                " is a cold and refined young man, while being a highly skilled guitarist. He is in the applied music department." +
                " They come from different family backgrounds and have an argument, but then start to like other.");
        plotMap.put("Pinnocchio","As a child, Ha-Myeong (Lee Jong-Suk) grew up in a family with his firefighter father, mother and older brother. Ha-Myeong and his older brother" +
                " (Yoon Gyun-Sang) both possess higher than normal intellect and are proud of their father. A fire at a waste facility though destroys " +
                "his family. His mother dies a short time later and Ha-Myeong ends up being scooped out of the ocean by an unknown man (Byun Hee-Bong)." +
                "The man that pulls Ha-Myeong out of the ocean is the grandfather of In-Ha (Park Shin-Hye). In-Ha's grandfather believes Ha-Myeong is his " +
                "eldest son Dal-Po, who died 30 years ago. Ha-Myeong is then adopted by In-Ha's grandfather and his name is changed to Dal-Po. In-Ha and " +
                "Dal-Po now live together as uncle and niece, although they are in the same age range. In-Ha has a Pinocchio Syndrome. Whenever she lies " +
                "she gets the hiccups. In-Ha and Dal-Po get along well until Dal-Po learns that In-Ha's mother (Jin Kyung) is the reporter that covered " +
                "the waste facility fire that destroyed his family. Dal-Po tries to distance himself from In-Ha, but he also develops feelings for her." +
                "Years later, Dal-Po and In-Ha's family are now living in Seoul. In-Ha attempts to become a reporter like her mother. In-Ha meets her mother " +
                "for the first time in years at a job interview for MSC Broadcasting Station. Her mother is the person giving her the job interview. In-Ha " +
                "though fails the job interview. Her mother rejects her because of her Pinocchio Syndrome.Dal-Po is now driving a taxi to support their family" +
                ". One day, Dal-Po meets In-Ha's mother and decides to become a reporter.");

    }
}
