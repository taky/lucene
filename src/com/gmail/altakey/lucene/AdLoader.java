/**
 * Copyright (C) 2011-2012 Takahiro Yoshimura
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * In addition, as a special exception, the copyright holders give
 * permission to link the code of portions of this program with the
 * AdMob library under certain conditions as described in each
 * individual source file, and distribute linked combinations
 * including the two.
 *
 * You must obey the GNU General Public License in all respects for
 * all of the code used other than AdMob.  If you modify file(s) with
 * this exception, you may extend this exception to your version of
 * the file(s), but you are not obligated to do so.  If you do not
 * wish to do so, delete this exception statement from your version.
 * If you delete this exception statement from all source files in the
 * program, then also delete it here.
 */

package com.gmail.altakey.lucene;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.view.View;
import com.google.ads.AdView;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;

public class AdLoader
{
	private static final int AD_VIEW_ID = 0xdeadbeef;
	private static final String AD_UNIT_ID = "a14ebe7748e6551";

	private Activity activity;

	public AdLoader(Activity activity)
	{
		this.activity = activity;
	}

	public static AdLoader create(Activity activity)
	{
		return new AdLoader(activity);
	}

	public void load()
	{
		this.load(false);
	}

	public void load(boolean locked)
	{
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this.activity);

		if (pref.getBoolean("show_ad", true))
		{
			if (locked && pref.getBoolean("hide_ad_on_lock", true))
				this.hide();
			else
				this.show();
		}
		else
		{
			this.hide();
		}
	}

	public void show()
	{
		AdView adView = (AdView)this.activity.findViewById(R.id.adView);
		adView.setVisibility(View.VISIBLE);

		AdRequest req = new AdRequest();
		req.addTestDevice(AdRequest.TEST_EMULATOR);
		req.addTestDevice(this.activity.getString(R.string.test_device));
		adView.loadAd(req);
	}

	public void hide()
	{
		AdView adView = (AdView)this.activity.findViewById(R.id.adView);
		adView.stopLoading();
		adView.setVisibility(View.INVISIBLE);
	}
}
