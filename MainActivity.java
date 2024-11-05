package com.example.hashdash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hashdash.databinding.ActivityMainBinding;
import com.example.hashdash.fragments.HomeFragment;
import com.example.hashdash.fragments.OrderFragment;
import com.example.hashdash.fragments.PointsFragment;
import com.example.hashdash.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    LinearLayout ll_home, ll_points, ll_order, ll_profile;
    ImageView home, point, order, profile;
    TextView h_tv, p_tv, o_tv, pr_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ll_home=binding.homeLl;
        ll_points=binding.pointsLl;
        ll_order=binding.ordersLl;
        ll_profile=binding.profileLl;

        home=binding.homeIv;
        point=binding.pointsIv;
        order=binding.orderIv;
        profile=binding.profileIv;

        h_tv =binding.homeTv;
        p_tv=binding.pointsTv;
        o_tv=binding.orderTv;
        pr_tv=binding.profileTv;

        ll_home.setOnClickListener(this);
        ll_points.setOnClickListener(this);
        ll_order.setOnClickListener(this);
        ll_profile.setOnClickListener(this);

        //default selected
        updateColors(ll_home, home, h_tv);
    }

    @Override
    public void onClick(View view) {
        resetColors();
        Fragment fragment;
        if (view.getId() == R.id.home_ll) {
            fragment = new HomeFragment();
            updateColors(ll_home, home, h_tv);
            loadFragment(fragment);
        } else if (view.getId() == R.id.points_ll) {
            fragment = new PointsFragment();
            updateColors(ll_points, point, p_tv);
            loadFragment(fragment);
        } else if (view.getId() == R.id.orders_ll) {
            fragment = new OrderFragment();
            updateColors(ll_order, order, o_tv);
            loadFragment(fragment);
        } else if (view.getId() == R.id.profile_ll) {
            fragment = new ProfileFragment();
            updateColors(ll_profile, profile, pr_tv);
            loadFragment(fragment);
        }
    }

    private void resetColors() {
        home.setColorFilter(Color.WHITE); // Reset icon color to white
        point.setColorFilter(Color.WHITE);
        order.setColorFilter(Color.WHITE);
        profile.setColorFilter(Color.WHITE);

        h_tv.setTextColor(Color.WHITE); // Reset text color to white
        p_tv.setTextColor(Color.WHITE);
        o_tv.setTextColor(Color.WHITE);
        pr_tv.setTextColor(Color.WHITE);

        ll_home.setBackgroundResource(0);// Reset background color to transparent
        ll_points.setBackgroundResource(0);
        ll_order.setBackgroundResource(0);
        ll_profile.setBackgroundResource(0);
    }
    private void updateColors(LinearLayout layout, ImageView icon, TextView text) {
        icon.setColorFilter(Color.BLACK);
        text.setTextColor(Color.BLACK);
        layout.setBackgroundResource(R.drawable.rectangle_background);
    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
    }
}