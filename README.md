# WeatherApp

A modern Android weather application built with **Jetpack Compose**, **Kotlin**, and **Clean Architecture**, integrating with the [OpenWeatherMap API](https://openweathermap.org/current).

---

## ✨ Features

- 🌍 Get current weather by:
  - City and Country
  - Latitude and Longitude
- 📊 Displays:
  - Temperature
  - Description
  - Humidity
  - Pressure
  - Wind Speed
- 🧱 Built with Clean Architecture:
  - `domain` – Use cases & models
  - `data` – DTOs, Retrofit API, repository implementations
  - `presentation` – Composable UI, ViewModel, state management
- 💉 Dependency Injection using **Hilt**
- 🎨 Jetpack Compose UI
- 🌦️ Uses [OpenWeatherMap API](https://openweathermap.org/current)

---

## 📁 Project Structure

```
WeatherApp/
├── app/
│   ├── src/main/java/io/michaelavoyan/weatherapp/
│   │   ├── di/                  # Hilt modules
│   │   ├── data/                # DTOs, API, repository impl
│   │   ├── domain/              # Use cases & interfaces
│   │   ├── presentation/        # ViewModel & UiState
│   │   ├── ui/                  # Composable screens & themes
│   │   └── MainActivity.kt
│   └── build.gradle.kts
├── .editorconfig                # Ktlint configuration
├── build.gradle.kts
└── settings.gradle.kts
```

---

## 🔧 Setup Instructions

1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/WeatherApp.git
   cd WeatherApp
   ```

2. Open in Android Studio Arctic Fox or newer.

3. Add your OpenWeatherMap API key:

   Replace the API key in `AppModule.kt`:
   ```kotlin
   private const val API_KEY = "YOUR_API_KEY"
   ```

4. Run the app on emulator or physical device.

---

## 🧪 Linting

Project uses **Ktlint** via `.editorconfig`.  
To check style:
```bash
./gradlew ktlintCheck
```

---

## 📦 Dependencies

- Jetpack Compose
- Hilt
- Retrofit
- Kotlinx Serialization
- OkHttp
- OpenWeatherMap API

---

## 🧠 TODO / Improvements

- Add unit & UI tests
- Support dark theme
- Add forecast support (next 5 days)
- UI loading/error state polish

---

## 🛡 License

MIT © [Michael Avoyan](https://github.com/michaelavoyan)
