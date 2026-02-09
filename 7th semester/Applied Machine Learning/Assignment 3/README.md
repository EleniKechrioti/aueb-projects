# Food Hazard Detection - SemEval 2025

This project focuses on the development of a machine learning system to detect and categorize food hazards from textual data. It was developed as part of the **SemEval 2025** competition, specifically focusing on identifying incidents related to food safety. The implementation is described more analytically inside the jupyter notebook.

## Project Overview

The objective is to analyze reports or descriptions and accurately classify food-related risks, such as chemical contaminants, allergens, or biological hazards.

### 1. Data Preparation
* **Dataset Loading**: Importing competition-specific datasets for training and validation.
* **Text Preprocessing**: Cleaning the text data by removing noise and standardizing formats to improve model performance.
* **Label Encoding**: Converting hazard categories into numerical labels for multi-class classification.

### 2. Model Architecture
* **Natural Language Processing (NLP)**: Utilizing advanced embedding techniques to capture the semantics of food safety terminology.
* **Deep Learning Models**: Implementing neural network architectures (such as Transformers or LSTMs) to handle complex language patterns in hazard reports.



### 3. Training & Evaluation
* **Loss Optimization**: Training the model with loss functions suitable for multi-label or multi-class classification tasks.
* **Evaluation Metrics**: Measuring success using Precision, Recall, and F1-score to ensure reliable detection of critical food hazards.
* **Validation**: Monitoring model performance on a development set to prevent overfitting.


## Libraries Used
* **Pandas & NumPy**: For efficient data handling and numerical operations.
* **PyTorch / TensorFlow**: For building and training deep learning models.
* **Scikit-learn**: For metric calculation and data splitting.
* **Hugging Face / Transformers**: For utilizing pre-trained language models.