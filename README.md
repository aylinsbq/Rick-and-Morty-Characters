# Rick and Morty Characters - Android Challenge

This project is a technical demonstration of an Android application that consumes the Rick and Morty API. The main objective was to build a solid, scalable, and maintainable codebase, leveraging **Clean Architecture**, **MVVM**, and **Jetpack Compose**.

## 🚀 Tech Stack

* **UI:** Jetpack Compose + Material 3 for a modern, declarative, and reactive user interface.
* **Architecture:** MVVM structured with a **multi-module** approach (`:domain`, `:data`, `:app`) to ensure a strict separation of concerns.
* **Dependency Injection:** Dagger Hilt for decoupling and scalability.
* **Networking & Serialization:** Retrofit + OkHttp combined with Kotlinx Serialization for native and efficient JSON parsing.
* **Images:** Coil for optimized image loading.
* **State Management:** StateFlow and Sealed Classes for a secure, predictable Unidirectional Data Flow (UDF).
* **Testing:** MockK and Coroutines Test for unit testing ViewModels and Use Cases.

---

## 🏗️ Project Structure (Multi-module)

To ensure modularization and prevent coupling, the project is split into three layers:
1. **`:domain`:** Contains the business entities, repository contracts, and Use Cases. This is a pure Kotlin module, completely free of Android framework dependencies.
2. **`:data`:** Implements the repositories, defines network DTOs, the Retrofit service, and mappers responsible for transforming network data to domain models.
3. **`:app`:** The presentation layer. It contains ViewModels, Compose screens and components, navigation, and the global Hilt configuration.

---

## 🛠️ Technical & Design Decisions

* **Immutable UI States with Sealed Classes:** I implemented `CharacterListUiState` to model `Loading`, `Success`, and `Error` states. This prevents inconsistent UI states (such as showing loading and error indicators simultaneously) and enforces exhaustive state handling in the UI.
* **Use Cases:** Business logic was encapsulated within `GetCharactersUseCase`. This keeps the ViewModel clean, lean, and agnostic of the data source, adhering to the Single Responsibility Principle.
* **List Performance (LazyColumn):** Configured unique `keys` for list items. This optimizes the recomposition process in Compose, ensuring smooth scrolling.
* **Targeted Testing:** Prioritized unit tests on the business (`Domain`) and presentation (`ViewModel`) layers, ensuring that state transitions and data handling behave exactly as expected under both success and network failure scenarios.

---

## 🤖 AI Usage

For this challenge, I integrated AI tools (Claude and Gemini) with a **Senior-level Productivity** mindset. AI was leveraged as an accelerator for repetitive tasks and boilerplate code, allowing me to focus the time constraint on architecture and overall code quality:

* **Planning & Boilerplate:** Used to speed up the initial environment setup, multi-module structure, and automated dependency declarations.
* **Data Modeling:** Rapid generation of DTOs and models within the `data` and `domain` layers based on the raw JSON response from the API.
* **UI Prototyping:** Supported the visual layout and initial styling for the Compose Cards, applying Material 3 best practices that were subsequently refined by hand.
* **Dependency Injection:** Streamlined the boilerplate code required for Hilt modules and providers.

---

## 📈 Future Enhancements

The next steps would be:
1. **Pagination** Replace the basic list loading to handle infinite scrolling efficiently.
2. **Offline Caching with Room:** Implement a local database to make the app fully functional without an internet connection.
3. **Filters and Search:** Add a search bar by name and filters by status (Alive/Dead) or species, leveraging the API's query parameters.
4. **Navigation & Interactivity:** Integrate Jetpack Compose Navigation to connect the list with a rich detail screen for each character.

---
Developed as part of the technical challenge for Arkano.
**Developer:** Aylin Botelo