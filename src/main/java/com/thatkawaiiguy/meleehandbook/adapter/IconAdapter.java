/*
    This file is part of Handbook for Melee.

    Handbook for Melee is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Handbook for Melee is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Handbook for Melee.  If not, see <http://www.gnu.org/licenses/>
 */

package com.thatkawaiiguy.meleehandbook.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.activity.CharacterActivity;
import com.thatkawaiiguy.meleehandbook.activity.CharacterFrameActivity;
import com.thatkawaiiguy.meleehandbook.activity.StageActivity;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    private final String[] mDataSet;
    private final Context mContext;

    private final boolean isCharacter;
    boolean canStart = true;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView menuText;
        private final ImageView menuImage;
        public final View view;

        public ViewHolder(View v) {
            super(v);
            menuText = (TextView) v.findViewById(R.id.menuTitle);
            menuImage = (ImageView) v.findViewById(R.id.menuImage);
            view = v;
        }

        public TextView getTextView() {
            return menuText;
        }

        public ImageView getImageView() {
            return menuImage;
        }
    }

    public IconAdapter(String[] mDataSet, Context context, boolean character) {
        this.mDataSet = mDataSet;
        mContext = context;
        isCharacter = character;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_image_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        final int pos = position;
        viewHolder.getTextView().setText(mDataSet[position]);
        if(isCharacter) {
            viewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(canStart) {
                        Intent mIntent;
                        if(hasFrame(pos))
                            mIntent = new Intent(mContext, CharacterFrameActivity.class);
                        else
                            mIntent = new Intent(mContext, CharacterActivity.class);
                        mIntent.putExtra("option", mDataSet[pos]);
                        mContext.startActivity(mIntent);
                        canStart = false;
                    }
                }
            });
        } else {
            viewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(canStart) {
                        mContext.startActivity(new Intent(mContext,
                                StageActivity.class).putExtra("option", mDataSet[pos]));
                        canStart = false;
                    }
                }
            });
        }

        switch(mDataSet[position]) {
            case "Bowser":
                viewHolder.getImageView().setImageResource(R.drawable.marioicon);
                break;
            case "Captain Falcon":
                viewHolder.getImageView().setImageResource(R.drawable.fzeroicon);
                break;
            case "Donkey Kong":
                viewHolder.getImageView().setImageResource(R.drawable.dkicon);
                break;
            case "Dr. Mario":
                viewHolder.getImageView().setImageResource(R.drawable.marioicon);
                break;
            case "Falco":
                viewHolder.getImageView().setImageResource(R.drawable.falcoicon);
                break;
            case "Fox":
                viewHolder.getImageView().setImageResource(R.drawable.foxicon);
                break;
            case "Ganondorf":
                viewHolder.getImageView().setImageResource(R.drawable.zeldaicon);
                break;
            case "Ice Climbers":
                viewHolder.getImageView().setImageResource(R.drawable.icicon);
                break;
            case "Jigglypuff":
                viewHolder.getImageView().setImageResource(R.drawable.jiggsicon);
                break;
            case "Kirby":
                viewHolder.getImageView().setImageResource(R.drawable.kirbyicon);
                break;
            case "Link":
                viewHolder.getImageView().setImageResource(R.drawable.linkicon);
                break;
            case "Mario":
                viewHolder.getImageView().setImageResource(R.drawable.marioicon);
                break;
            case "Luigi":
                viewHolder.getImageView().setImageResource(R.drawable.luigiicon);
                break;
            case "Marth":
                viewHolder.getImageView().setImageResource(R.drawable.marthicon);
                break;
            case "Mewtwo":
                viewHolder.getImageView().setImageResource(R.drawable.pokemonicon);
                break;
            case "Mr. Game & Watch":
                viewHolder.getImageView().setImageResource(R.drawable.gandwicon);
                break;
            case "Ness":
                viewHolder.getImageView().setImageResource(R.drawable.ebicon);
                break;
            case "Pichu":
                viewHolder.getImageView().setImageResource(R.drawable.pikaicon);
                break;
            case "Pikachu":
                viewHolder.getImageView().setImageResource(R.drawable.pikaicon);
                break;
            case "Princess Peach":
                viewHolder.getImageView().setImageResource(R.drawable.peachicon);
                break;
            case "Princess Zelda":
                viewHolder.getImageView().setImageResource(R.drawable.zeldaicon);
                break;
            case "Roy":
                viewHolder.getImageView().setImageResource(R.drawable.royicon);
                break;
            case "Samus Aran":
                viewHolder.getImageView().setImageResource(R.drawable.metroidicon);
                break;
            case "Sheik":
                viewHolder.getImageView().setImageResource(R.drawable.zeldaicon);
                break;
            case "Yoshi":
                viewHolder.getImageView().setImageResource(R.drawable.yoshiicon);
                break;
            case "Young Link":
                viewHolder.getImageView().setImageResource(R.drawable.linkicon);
                break;

            //STAGEs
            case "Battlefield":
                viewHolder.getImageView().setImageResource(R.drawable.smashicon);
                break;
            case "Dream Land":
                viewHolder.getImageView().setImageResource(R.drawable.kirbyicon);
                break;
            case "Final Destination":
                viewHolder.getImageView().setImageResource(R.drawable.smashicon);
                break;
            case "Fountain of Dreams":
                viewHolder.getImageView().setImageResource(R.drawable.kirbyicon);
                break;
            case "Kongo Jungle (SSB)":
                viewHolder.getImageView().setImageResource(R.drawable.dkicon);
                break;
            case "Pokemon Stadium":
                viewHolder.getImageView().setImageResource(R.drawable.pokemonicon);
                break;
            case "Yoshi's Story":
                viewHolder.getImageView().setImageResource(R.drawable.yoshiicon);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    private boolean hasFrame(int position) {
        switch(mDataSet[position]) {
            case "Captain Falcon":
                return true;
            case "Ganondorf":
                return true;
            case "Falco":
                return true;
            case "Fox":
                return true;
            case "Ice Climbers":
                return true;
            case "Jigglypuff":
                return true;
            case "Marth":
                return true;
            case "Pikachu":
                return true;
            case "Samus Aran":
                return true;
            case "Sheik":
                return true;
            case "Yoshi":
                return true;
            case "Dr. Mario":
                return true;
            case "Princess Peach":
                return true;
            case "Luigi":
                return true;
            default:
                return false;
        }
    }

    public void setCanStart(boolean start) {
        canStart = start;
    }
}
