# Joystick

A Java-based Android project demonstrating the implementation of two on-screen joysticks to control X and Y movements.

## Features

- **Dual Joysticks**: Two independent joysticks to control and capture X and Y axis movements.
- **Graphical Feedback**: Real-time graphical updates when interacting with the joysticks.
- **Directional Output**: Direction detection for joystick movements (e.g., up, down, left, right, diagonal directions).
- **Shared Preferences**: Save joystick direction for persistent access.

## Requirements

- Android Studio (Latest stable version recommended)
- A device or emulator running Android 5.0 (API level 21) or higher
- Java Development Kit (JDK)

## How to Run the Project

1. Clone the repository or download the source code:
   ```bash
   git clone https://github.com/Jayanth-J-19/joystick.git
   ```
2. Open the project in **Android Studio**.
3. Sync the Gradle files.
4. Build and run the project on a connected Android device or an emulator.

## File Structure

```
Joystick
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/example/joystick
│   │   │   │   ├── MainActivity.java        # Main activity handling the joystick logic
│   │   │   │   ├── JoyStickClass.java       # Utility class for joystick functionality
│   │   │   ├── res
│   │   │   │   ├── layout
│   │   │   │   │   ├── activity_main.xml    # UI layout with two joysticks
│   │   │   │   ├── values
│   │   │   │   │   ├── strings.xml          # String resources
│   │   │   │   │   ├── colors.xml           # Color resources
├── README.md
```

## Usage

- Drag the joysticks to see the X and Y coordinates update in real-time.
- Observe the graphical joystick movement feedback on the screen.
- Directions (e.g., up, down, left, right) are saved in **SharedPreferences** for retrieval.

## Troubleshooting

- Ensure that the **textView3** and **textView4** are correctly initialized in `MainActivity.java` to avoid `NullPointerException`.
- Check that both joysticks are properly linked to their graphical components.
- Verify that the latest version of Android Studio and required SDKs are installed.

## Contribution

Feel free to fork the repository and contribute via pull requests. Suggestions and improvements are welcome!

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Contact

For any questions or feedback, reach out to [Jayanth J](https://github.com/Jayanth-J-19).
