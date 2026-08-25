# Android Alarm Application using Service & BroadcastReceiver

## Aim

Create an Android Alarm application using **Service** and **BroadcastReceiver**.

## Description

This practical demonstrates how to create an alarm application in Android using `AlarmManager`, `PendingIntent`, `BroadcastReceiver`, and `Service`.

The application allows the user to select an alarm time, create the alarm, and cancel the alarm when required. When the selected time is reached, the `BroadcastReceiver` receives the alarm event and starts the `AlarmService`, which plays the alarm sound using `MediaPlayer`.

## Features

- Display current date and time using TextClock
- Select alarm time using TimePickerDialog
- Create an alarm
- Display the selected alarm time
- Cancel the alarm
- Use AlarmManager to schedule the alarm
- Use PendingIntent to trigger the alarm
- Use BroadcastReceiver to receive the alarm event
- Use Service to play the alarm sound
- Use MediaPlayer to play the alarm sound
- MaterialCardView-based user interface

## Components Used

### MainActivity

`MainActivity` provides the user interface of the alarm application.

It allows the user to:

- View the current time
- Select an alarm time
- Create an alarm
- View the selected alarm time
- Cancel the alarm

### AlarmBroadcastReceiver

`AlarmBroadcastReceiver` receives the alarm broadcast when the scheduled alarm time is reached.

It checks whether the alarm should be started or stopped and accordingly starts or stops `AlarmService`.

### AlarmService

`AlarmService` is responsible for playing the alarm sound.

When the service starts, `MediaPlayer` plays the alarm audio file. When the service is destroyed, the media player is stopped.

## Alarm Working

The working of the application is as follows:

1. The application starts with `MainActivity`.
2. The current date and time are displayed using `TextClock`.
3. The user clicks the **Create Alarm** button.
4. A `TimePickerDialog` is displayed.
5. The user selects the required alarm time.
6. The selected time is displayed on the screen.
7. `AlarmManager` schedules the alarm using `PendingIntent`.
8. When the selected time is reached, the `AlarmBroadcastReceiver` receives the broadcast.
9. `AlarmBroadcastReceiver` starts `AlarmService`.
10. `AlarmService` uses `MediaPlayer` to play the alarm sound.
11. The user can cancel the scheduled alarm using the **Cancel Alarm** button.

## Android Concepts Studied

- BroadcastReceiver
- Service
- TextClock
- TimePickerDialog
- Calendar
- SimpleDateFormat
- PendingIntent
- AlarmManager
- getSystemService()
- sendBroadcast()
- MediaPlayer
- startService()
- stopService()
- Intent.getStringExtra()
- Intent.putStringExtra()
- MaterialCardView
- Android Permissions

## Permission

The application uses the following permission in the `AndroidManifest.xml` file:

**SCHEDULE_EXACT_ALARM**

This permission is used for scheduling exact alarms.

## UI Components

The application interface contains:

- MaterialCardView
- ImageView
- TextView
- TextClock
- Button
- NestedScrollView
- ConstraintLayout
- TimePickerDialog

## Project Structure

The main components of the project are:

- `MainActivity.kt`
- `AlarmBroadcastReceiver.kt`
- `AlarmService.kt`
- `activity_main.xml`
- Alarm sound resource
- `AndroidManifest.xml`

## Conclusion

This practical demonstrates how to create an Android alarm application using **AlarmManager, PendingIntent, BroadcastReceiver, and Service**. It also demonstrates how `MediaPlayer` can be used to play an alarm sound when the scheduled time is reached.
