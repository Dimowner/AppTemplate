/*
 * Copyright 2018 Dmitriy Ponomarenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dimowner.apptemplate.util;

import android.content.res.Resources;

import com.dimowner.apptemplate.TemplateApplication;

import timber.log.Timber;

/**
 * Android related utilities methods.
 */
public class AndroidUtils {

	//Prevent object instantiation
	private AndroidUtils() {}

	/**
	 * Convert density independent pixels value (dip) into pixels value (px).
	 * @param dp Value needed to convert
	 * @return Converted value in pixels.
	 */
	public static float dpToPx(int dp) {
		return (dp * Resources.getSystem().getDisplayMetrics().density);
	}

	/**
	 * Convert pixels value (px) into density independent pixels (dip).
	 * @param px Value needed to convert
	 * @return Converted value in pixels.
	 */
	public static float pxToDp(int px) {
		return (px / Resources.getSystem().getDisplayMetrics().density);
	}

	public static int screenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

	public static int screenHeight() {
   	return Resources.getSystem().getDisplayMetrics().heightPixels;
	}

	public static void runOnUIThread(Runnable runnable) {
		runOnUIThread(runnable, 0);
	}

	public static void runOnUIThread(Runnable runnable, long delay) {
		Timber.v("runOnUIThread");
		if (delay == 0) {
			TemplateApplication.applicationHandler.post(runnable);
		} else {
			TemplateApplication.applicationHandler.postDelayed(runnable, delay);
		}
	}

	public static void cancelRunOnUIThread(Runnable runnable) {
		TemplateApplication.applicationHandler.removeCallbacks(runnable);
	}
}
