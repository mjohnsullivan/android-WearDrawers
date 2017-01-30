/*
Copyright 2016 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.example.android.wearable.wear.weardrawers;

        import android.os.Bundle;
        import android.support.wearable.activity.WearableActivity;
        import android.support.wearable.view.DefaultOffsettingHelper;
        import android.support.wearable.view.WearableRecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.Arrays;
        import java.util.List;

public class RecyclerActivity extends WearableActivity {

    private static final String TAG = RecyclerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        WearableRecyclerView rv = (WearableRecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        rv.setCenterEdgeItems(true);
        rv.setOffsettingHelper(new DefaultOffsettingHelper());

        List<String> planets = Arrays.asList(getResources().getStringArray(R.array.planets_array_names));

        rv.setAdapter(new RVAdapter(planets));
    }

    private class RVAdapter extends WearableRecyclerView.Adapter<RVAdapter.ItemViewHolder> {

        List<String> items;

        RVAdapter(List<String> items){
            this.items = items;
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_simple, viewGroup, false);
            return new ItemViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
            itemViewHolder.item.setText(items.get(i));
        }

        class ItemViewHolder extends WearableRecyclerView.ViewHolder {

            private TextView item;

            ItemViewHolder(View itemView) {
                super(itemView);
                item = (TextView) itemView.findViewById(R.id.item_string);
            }
        }

    }

}
