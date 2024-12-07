# Health Diet Management
## Overview

This application is a multi-platform solution designed for food recognition, nutritional analysis, and personalized dietary recommendations. It leverages advanced machine learning models to provide users with accurate and insightful information about their dietary choices.

## Features

- **Food Recognition**: Identify food items using YOLOv8 and ResNet-50 models.
- **Nutritional Analysis**: Retrieve detailed nutritional information.
- **Dietary Recommendations**: Suggest personalized dietary options using collaborative filtering.

## Repository Structure

- **client/**: Android app source code.
- **backend/**: Server-side scripts and APIs.
- **models/**: Machine learning models and training scripts.

## Technologies

- **Frontend**: Android
- **Backend**: Flask
- **Machine Learning**: TensorFlow
- **Cloud/Database**: Firebase, MySQL, AWS SageMaker

## Setup Instructions

### Python Environment

1. Install Python from [python.org](https://www.python.org/downloads/).
2. Set up a virtual environment:
   ```bash
   python -m virtualenv venv
   .\venv\Scripts\activate
   pip install -r requirements.txt
   ```

### Android Studio

1. Download and install from [developer.android.com/studio](https://developer.android.com/studio).
2. Open the project and configure the SDK and AVD.

## Contribution

Please follow the branching strategy: `main`, `development`, and `feature/` branches. Use pull requests for code reviews.

## License

This project is licensed under the MIT License.
