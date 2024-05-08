package com.example.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private LinearLayout teamListLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamListLayout = findViewById(R.id.teamListLayout);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<TeamResponse> call = apiService.getTeams();
        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Team> teams = response.body().getTeams();
                    showTeams(teams);
                } else {
                    Log.e(TAG, "Response not successful. Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Log.e(TAG, "Failed to fetch teams: " + t.getMessage());
            }
        });
    }

    private void showTeams(List<Team> teams) {
        for (Team team : teams) {
            // Membuat LinearLayout baru untuk setiap item tim
            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);

            // Menambahkan ImageView ke dalam itemLayout
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                    130,
                    130 

            );
            imageParams.setMargins(0,0,13,0);
            imageView.setLayoutParams(imageParams);
            Picasso.get().load(team.getStrTeamBadge()).into(imageView);
            itemLayout.addView(imageView);

            // Menambahkan TextView ke dalam itemLayout
            TextView textView = new TextView(this);
            textView.setText("Team Name: " + team.getStrTeam() + "\n");
            textView.append("Alternate Name: " + team.getStrAlternate() + "\n");
            textView.append("Stadium: " + team.getStrStadium() + "\n\n");
            itemLayout.addView(textView);

            // Menambahkan itemLayout ke dalam teamListLayout
            teamListLayout.addView(itemLayout);
        }
    }
}
