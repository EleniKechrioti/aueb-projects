# Applied Machine Learning

This repository showcases a collection of machine learning projects focusing on predictive modeling, natural language processing (NLP), and large-scale data analysis. These projects leverage a variety of techniques ranging from traditional regression to advanced deep learning architectures.


## Featured Projects

### 1. Airbnb Price Prediction & Market Analysis
This project focuses on the exploratory data analysis (EDA) and predictive modeling of Airbnb listing data to understand market trends and estimate rental prices.
* **Data Cleaning**: Handled missing values in columns like `reviews_per_month` and performed outlier filtering for price stability.
* **Exploratory Data Analysis (EDA)**: Visualized geospatial distributions across neighborhoods and analyzed price fluctuations based on room types.
* **Modeling**: Implemented regression models, including **Linear Regression** and **Random Forests**, to predict prices based on features like location and availability.
* **Evaluation**: Assessed performance using Mean Squared Error (MSE) and $R^2$ scores.

### 2. Linguistic Analysis of Misinformation
A computational study of text data aimed at identifying structural and linguistic differences between reliable information and misinformation.
* **NLP Preprocessing**: Utilized tokenization, stop-word removal, and text normalization to prepare raw datasets.
* **Linguistic Profiling**: Compared word frequencies, sentiment scores, and polarizing language patterns across different news categories.
* **Classification**: Trained machine learning models to identify "red flags" and distinguish between information classes based on textual features.
* **Feature Engineering**: Applied numerical representations such as **TF-IDF** to capture significant linguistic markers.

### 3. Food Hazard Detection (SemEval 2025)
Developed for the SemEval 2025 competition, this project utilizes deep learning to detect and categorize food safety hazards from text reports.
* **Task Complexity**: Focuses on multi-class classification of incidents involving chemical contaminants, allergens, and biological hazards.
* **Advanced NLP**: Leverages **Transformer-based models** and dense word embeddings to capture the technical semantics of food safety terminology.
* **Deep Learning Pipeline**: Includes label encoding, loss optimization for imbalanced classes, and rigorous validation to prevent overfitting.
* **Performance Metrics**: Evaluated through Precision, Recall, and F1-score to ensure high reliability in hazard detection.
