# SportsBookApp

SportsBookApp is a sports listing Android application built with a modular architecture using Jetpack Compose and Kotlin.

## Features

- Toggle favorite matches per sport
- Filter to show only favorite events
- Countdown timer for each event
- SharedPreferences storage for favorites

## Modules 

- `core_api`: Network service and api calls
- `core_common`: Contains common useful functtions and extensions
- `core_data`: Retrofit network access and data repositories
- `core_design_system`:Theme and colors
- `core_domain`: Domain models, controller interfaces, mappers
- `core_model`: Network response models
- `core_ui`: Base viewModel and common componens.
- `feature_main_screen`: Main screen with listing logic
- `core_resources`: Shared strings, colors, and styles
- `navigation`: Handles app navigation

## Architecture 🏗

This project follows a clean architecture structure and implements MVI with the following structure:

- **ViewModel**: Handles events, updates state, and emits side-effects.
- **Interactor**: Bridges repository and controller logic.
- **Controller**: Manages SharedPreferences logic for saving/loading favorites.
- **Mapper**: Maps DTOs to domain models .

## Usage 

1. Clone the repository:

```bash
git clone git@github.com:GeoCoo/SportsBookApp.git
