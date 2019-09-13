package edu.wmdd.cards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> deck;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillDeck();
        showNumberCardsLeft();

        Button card_button = this.findViewById(R.id.card_button);
        card_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                TextView cardPicked = findViewById(R.id.cardPicked);

                if(deck.size() == 0) {
                    fillDeck();
                    cardPicked.setText("Draw the next Card!");
                }
                else {
                    int randomInteger;
//                    switch (deck.size()) {
//                        case 1:
//                            randomInteger = 0;
//                            break;
//                        case 2:
//                            randomInteger = rand.nextInt(deck.size()-2)+1;
//                            break;
//                        default:
//                            randomInteger = rand.nextInt(deck.size()-2)+1;
//                    }
                    randomInteger = rand.nextInt(deck.size());

                    cardPicked.setText(deck.get(randomInteger));
                    deck.remove(randomInteger);
                }

                showNumberCardsLeft();

                if(deck.size() == 0) {
                    Toast.makeText(MainActivity.this, "No more cards! Click the button to restart", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    protected void showNumberCardsLeft() {
        TextView cards_left = findViewById(R.id.cards_left);
        Integer deckSize = deck.size();
        cards_left.setText("Cards Remaining: " + deckSize.toString());
    }

    private void fillDeck() {

        deck = new ArrayList<String>();

        String [] groups = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String [] cards = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

        for (String group: groups)
        {
            for (String card: cards)
            {
                deck.add(card + " of " + group);
            }
        }

    }
}
