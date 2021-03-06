

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

package com.dimowner.apptemplate;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Handler;

//import com.crashlytics.android.Crashlytics;
//
//import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

public class TemplateApplication extends Application {

	@SuppressLint("StaticFieldLeak")
	public static volatile Context applicationContext;
	public static volatile Handler applicationHandler;

	@Override
	public void onCreate() {
		if (BuildConfig.DEBUG) {
			//Timber initialization
			Timber.plant(new Timber.DebugTree() {
				@Override
				protected String createStackElementTag(StackTraceElement element) {
					return super.createStackElementTag(element) + ":" + element.getLineNumber();
				}
			});
		}
		super.onCreate();
//		Fabric.with(this, new Crashlytics());

		applicationContext = getApplicationContext();
		applicationHandler = new Handler(applicationContext.getMainLooper());
	}


}
